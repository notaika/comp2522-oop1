package ca.bcit.comp2522.termproject.wordgame;

import ca.bcit.comp2522.termproject.Game;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents the WordGame trivia application.
 * Manages the gameplay loop, scoring, and high-score checking.
 * Extends the abstract Game class.
 *
 * @author Aika Manalo - Set 2C
 * @version 3.0
 */
public final class WordGame
        extends Game
{
    private static final int QUESTIONS_PER_GAME = 10;
    private static final int MAX_ATTEMPTS       = 2;
    private static final int FIRST_ATTEMPT      = 1;
    private static final int PLURAL_THRESHOLD   = 1;

    private static final int TYPE_CAPITAL_TO_COUNTRY = 0;
    private static final int TYPE_COUNTRY_TO_CAPITAL = 1;
    private static final int TOTAL_QUESTION_TYPES    = 3;
    private static final int RANDOM_FACT_BOUND       = 3;

    private static final double MINIMUM_SCORE_AVERAGE = 0.0;

    private static final String SCORE_FILENAME                  = "score.txt";
    private static final String YES_INPUT                       = "Yes";
    private static final String NO_INPUT                        = "No";
    private static final String DATE_TIME_SEPARATOR_ORIGINAL    = " ";
    private static final String DATE_TIME_SEPARATOR_REPLACEMENT = " at ";
    private static final String NO_SCORE                        = "";

    private final World   world;
    private final Scanner scanner;
    private final Random  random;

    private int totalGamesPlayed;
    private int totalFirstAttempts;
    private int totalSecondAttempts;
    private int totalIncorrect;

    /**
     * Constructs and initializes the WordGame trivia engine.
     */
    public WordGame()
    {
        super("Word Game: Geography Trivia");

        this.world               = new World();
        this.scanner             = new Scanner(System.in);
        this.random              = new Random();
        this.totalGamesPlayed    = 0;
        this.totalFirstAttempts  = 0;
        this.totalSecondAttempts = 0;
        this.totalIncorrect      = 0;
    }

    /**
     * Enters the main gameplay loop until the user chooses to quit.
     * Blocks the terminal thread while playing.
     */
    @Override
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
     * Shuffles and generates questions for a single game session.
     */
    private void playSingleGame()
    {
        totalGamesPlayed++;

        for (int i = 0; i < QUESTIONS_PER_GAME; i++)
        {
            final Country randomCountry;
            final int questionType;

            randomCountry = world.getRandomCountry();
            questionType  = random.nextInt(TOTAL_QUESTION_TYPES);

            askQuestion(randomCountry,
                        questionType);
        }

        printSessionResults();
    }

    /*
     * Trivia game question loop logic.
     * Generates the prompt and checks if user answer is correct.
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

        prompt        = generatePrompt(country,
                                       type);
        correctAnswer = determineCorrectAnswer(country,
                                               type);

        attempts          = 0;
        answeredCorrectly = false;

        System.out.println(prompt);

        while (attempts < MAX_ATTEMPTS && !answeredCorrectly)
        {
            final String guess;

            System.out.print("Your guess: ");
            guess = scanner.nextLine()
                           .trim();

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
     * Builds the question text based on the randomly picked question type.
     *
     * @param country the country data
     * @param type the question type
     * @return the formulated question prompt
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
            promptString    = "Fact: " + country.getFact(randomFactIndex) + "\nWhich country is being described?";
        }

        return promptString;
    }

    /*
     * Extracts the specific answer needed for the question type.
     *
     * @param country the country data
     * @param type the question type
     * @return the correct answer string
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
     * Outputs cumulative results after a Word Game session.
     * Evaluates singular/plural grammar.
     */
    private void printSessionResults()
    {
        final String gameWord;

        if (totalGamesPlayed == PLURAL_THRESHOLD)
        {
            gameWord = "word game";
        }
        else
        {
            gameWord = "word games";
        }

        System.out.println("- " + totalGamesPlayed + " " + gameWord + " played");
        System.out.println("- " + totalFirstAttempts + " correct answers on the first attempt");
        System.out.println("- " + totalSecondAttempts + " correct answers on the second attempt");
        System.out.println("- " + totalIncorrect + " incorrect answers on two attempts each");
    }

    /*
     * Forces user to provide a valid Yes/No response.
     *
     * @return true if playing again, false if quitting
     */
    private boolean promptPlayAgain()
    {
        boolean validResponse;
        validResponse = false;

        while (!validResponse)
        {
            final String input;

            System.out.println("Do you want to play again? (Yes/No)");
            input = scanner.nextLine()
                           .trim();

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

        currentScore = new Score(LocalDateTime.now(),
                                 totalGamesPlayed,
                                 totalFirstAttempts,
                                 totalSecondAttempts,
                                 totalIncorrect);

        try
        {
            historicalScores = Score.readScoresFromFile(SCORE_FILENAME);
            currentAverage   = (double) currentScore.getScore() / totalGamesPlayed;

            if (historicalScores.isEmpty())
            {
                System.out.println("CONGRATULATIONS! You are the new high score with an average of " +
                                   String.format("%.2f",
                                                 currentAverage) + " points per game!");
            }
            else
            {
                double highestPastAverage;
                String highestPastDate;

                highestPastAverage = MINIMUM_SCORE_AVERAGE;
                highestPastDate    = NO_SCORE;

                for (final Score pastScore : historicalScores)
                {
                    final double pastAverage;
                    pastAverage = (double) pastScore.getScore() / pastScore.getNumGamesPlayed();

                    if (pastAverage > highestPastAverage)
                    {
                        highestPastAverage = pastAverage;
                        highestPastDate    = pastScore.getDateTimePlayedFormatted()
                                                      .replace(DATE_TIME_SEPARATOR_ORIGINAL,
                                                               DATE_TIME_SEPARATOR_REPLACEMENT);
                    }
                }

                if (currentAverage > highestPastAverage)
                {
                    System.out.println("CONGRATULATIONS! You are the new high score with an average of " +
                                       String.format("%.2f",
                                                     currentAverage) + " points per game; the previous record was " +
                                       String.format("%.2f",
                                                     highestPastAverage) + " points per game on " + highestPastDate);
                }
                else
                {
                    System.out.println("You did not beat the high score of " +
                                       String.format("%.2f",
                                                     highestPastAverage) + " points per game from " + highestPastDate);
                }
            }

            Score.appendScoreToFile(currentScore,
                                    SCORE_FILENAME);
        }
        catch (final IOException e)
        {
            System.out.println("ERROR: Could not process scores. " + e.getMessage());
        }
    }
}