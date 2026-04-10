package ca.bcit.comp2522.termproject.wordgame;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.time.LocalDateTime;

/**
 * Represents the WordGame trivia application.
 * Manages the gameplay loop, scoring, and high-score checking.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public final class WordGame
{
    private static final int QUESTIONS_PER_GAME = 10;
    private static final int MAX_ATTEMPTS = 2;
    private static final int FIRST_ATTEMPT = 1;
    
    private static final int TYPE_CAPITAL_TO_COUNTRY = 0;
    private static final int TYPE_COUNTRY_TO_CAPITAL = 1;
    private static final int TOTAL_QUESTION_TYPES = 3;
    private static final int RANDOM_FACT_BOUND = 3;
    
    private static final String SCORE_FILENAME = "score.txt";
    private static final String YES_INPUT = "Yes";
    private static final String NO_INPUT = "No";

    private final World   world;
    private final Scanner scanner;
    private final Random random;

    private int totalGamesPlayed;
    private int totalFirstAttempts;
    private int totalSecondAttempts;
    private int totalIncorrect;

    /**
     * Constructs and initializes the WordGame trivia engine.
     */
    public WordGame()
    {
        this.world = new World();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        
        this.totalGamesPlayed = 0;
        this.totalFirstAttempts = 0;
        this.totalSecondAttempts = 0;
        this.totalIncorrect = 0;
    }

    /**
     * Enters the main gameplay loop until the user chooses to quit.
     */
    public void play()
    {
        boolean playing;
        playing = true;

        while (playing)
        {
            playSingleGame();
            playing = promptPlayAgain();
        }

        recordAndCheckScore();
    }

    /*
     * Orchestrates exactly 10 questions for a single game session.
     */
    private void playSingleGame()
    {
        totalGamesPlayed++;

        for (int i = 0; i < QUESTIONS_PER_GAME; i++)
        {
            final Country randomCountry;
            final int questionType;

            randomCountry = world.getRandomCountry();
            questionType = random.nextInt(TOTAL_QUESTION_TYPES);

            askQuestion(randomCountry, questionType);
        }

        printSessionResults();
    }

    /*
     * Manages the lifecycle of a single trivia question.
     *
     * @param country the country data
     * @param type the random question variant
     */
    private void askQuestion(final Country country, 
                             final int type)
    {
        final String prompt;
        final String correctAnswer;
        int attempts;
        boolean answeredCorrectly;

        prompt = generatePrompt(country, type);
        correctAnswer = determineCorrectAnswer(country, type);
        attempts = 0;
        answeredCorrectly = false;

        System.out.println(prompt);

        while (attempts < MAX_ATTEMPTS && !answeredCorrectly)
        {
            final String guess;
            
            System.out.print("Your guess: ");
            guess = scanner.nextLine().trim();
            attempts++;

            if (guess.equalsIgnoreCase(correctAnswer))
            {
                System.out.println("CORRECT");
                answeredCorrectly = true;
                
                if (attempts == FIRST_ATTEMPT)
                {
                    totalFirstAttempts++;
                }
                else
                {
                    totalSecondAttempts++;
                }
            }
            else
            {
                System.out.println("INCORRECT");
            }
        }

        if (!answeredCorrectly)
        {
            totalIncorrect++;
            System.out.println("The correct answer was " + correctAnswer);
        }
    }

    /*
     * Builds the question text based on the random type.
     */
    private String generatePrompt(final Country country, 
                                  final int type)
    {
        final String promptString;

        if (type == TYPE_CAPITAL_TO_COUNTRY)
        {
            promptString = "What country is " + country.getCapitalCityName() + " the capital of?";
        }
        else if (type == TYPE_COUNTRY_TO_CAPITAL)
        {
            promptString = "What is the capital city of " + country.getName() + "?";
        }
        else
        {
            final int randomFactIndex;
            randomFactIndex = random.nextInt(RANDOM_FACT_BOUND);
            promptString = "Fact: " + country.getFact(randomFactIndex) + "\nWhich country is being described?";
        }

        return promptString;
    }

    /*
     * Extracts the specific answer needed for the question type.
     */
    private String determineCorrectAnswer(final Country country, 
                                          final int type)
    {
        if (type == TYPE_COUNTRY_TO_CAPITAL)
        {
            return country.getCapitalCityName();
        }
        return country.getName();
    }

    /*
     * Outputs cumulative results after 10 questions.
     */
    private void printSessionResults()
    {
        System.out.println("- " + totalGamesPlayed + " word game(s) played");
        System.out.println("- " + totalFirstAttempts + " correct answers on the first attempt");
        System.out.println("- " + totalSecondAttempts + " correct answers on the second attempt");
        System.out.println("- " + totalIncorrect + " incorrect answers on two attempts each");
    }

    /*
     * Forces user to provide a valid Yes/No response.
     */
    private boolean promptPlayAgain()
    {
        boolean validResponse;
        validResponse = false;

        while (!validResponse)
        {
            final String input;
            
            System.out.println("Do you want to play again? (Yes/No)");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase(YES_INPUT))
            {
                return true;
            }
            else if (input.equalsIgnoreCase(NO_INPUT))
            {
                return false;
            }
            else
            {
                System.out.println("ERROR: Please enter exactly 'Yes' or 'No'.");
            }
        }
        return false;
    }

    /*
     * Finalizes the session by checking history, informing the user, and saving results.
     */
    private void recordAndCheckScore()
    {
        final Score currentScore;
        final List<Score> historicalScores;
        final double currentAverage;
        boolean isHighScore;

        currentScore = new Score(LocalDateTime.now(), totalGamesPlayed, totalFirstAttempts, totalSecondAttempts, totalIncorrect);
        
        try
        {
            historicalScores = Score.readScoresFromFile(SCORE_FILENAME);
            currentAverage = (double) currentScore.getScore() / totalGamesPlayed;
            isHighScore = true;

            for (final Score pastScore : historicalScores)
            {
                final double pastAverage;
                pastAverage = (double) pastScore.getScore() / pastScore.getNumGamesPlayed();

                if (pastAverage >= currentAverage)
                {
                    isHighScore = false;
                    System.out.println("You did not beat the high score of " + 
                                       String.format("%.2f", pastAverage) + 
                                       " points per game from " + 
                                       pastScore.getDateTimePlayedFormatted() + ".");
                    break;
                }
            }

            if (isHighScore && !historicalScores.isEmpty())
            {
                System.out.println("CONGRATULATIONS! You are the new high score with an average of " + 
                                   String.format("%.2f", currentAverage) + " points per game!");
            }

            Score.appendScoreToFile(currentScore, SCORE_FILENAME);
        }
        catch (final IOException e)
        {
            System.out.println("ERROR: Could not process scores. " + e.getMessage());
        }
    }
}
