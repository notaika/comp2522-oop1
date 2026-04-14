package ca.bcit.comp2622.lab8.countrygame;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Represents a Game.
 * Manages the main gameplay mechanics (game loop, rules, and user interactions).
 *
 * @author Aika Manalo - Set 2C
 * @version 2.0
 */
public class Game
{
    private static final Charset CHARSET              = StandardCharsets.UTF_8;
    private static final String  EXIT_SENTINEL        = "QUIT";
    private static final int     INITIAL_NUM_ATTEMPTS = 0;

    private final WordList         wordList;
    private final HighScoreService highScoreService;
    private final LoggerService    logger;

    private final String secretCountry;
    private final int    targetLength;
    private final int    bestScore;


    /**
     * Constructs and initializes the Game and all required services.
     */
    public Game()
    {
        this.wordList      = new WordList();
        this.secretCountry = this.wordList.getRandomWord();
        this.targetLength  = this.secretCountry.length();

        this.highScoreService = new HighScoreService();
        this.bestScore        = this.highScoreService.getHighScore();

        this.logger = new LoggerService(this.secretCountry);

        System.out.println(secretCountry);
    }

    /**
     * Begins the main game loop and manages the gameplay.
     */
    public void play()
    {
        boolean playing;
        int attemptsCount;

        playing       = true;
        attemptsCount = INITIAL_NUM_ATTEMPTS;

        System.out.println("LUCKY VAULT — COUNTRY MODE. Type QUIT to exit.");
        System.out.println("Secret word length: " + targetLength);

        if (bestScore == HighScoreService.NO_BEST)
        {
            System.out.println("Current best: —");
        }
        else
        {
            System.out.println("Current best: " + bestScore + " attempts");
        }

        try (final Scanner scanner = new Scanner(System.in,
                                                 CHARSET))
        {
            while (playing)
            {
                final String rawInput;
                final String guess;

                System.out.print("Your guess: ");

                rawInput = scanner.nextLine();
                guess    = rawInput.trim();

                if (guess.equalsIgnoreCase(EXIT_SENTINEL))
                {
                    System.out.println("Bye!");
                    playing = false;
                }
                else if (guess.isEmpty())
                {
                    System.out.println("Empty guess. Try again.");
                }
                else
                {
                    final int guessLength;

                    attemptsCount++;
                    guessLength = guess.length();

                    if (guessLength != targetLength)
                    {
                        System.out.println("Wrong length (" + guessLength + "). Need " + targetLength + ".");
                        logger.logGuess(guess,
                                        "wrong_length");
                    }
                    else if (guess.equalsIgnoreCase(secretCountry))
                    {
                        System.out.println("Correct in " + attemptsCount + " attempts! Word was: " + secretCountry);
                        logger.logGuess(guess,
                                        "CORRECT in " + attemptsCount);

                        if (attemptsCount < bestScore || bestScore == HighScoreService.NO_BEST)
                        {
                            System.out.println("NEW BEST for COUNTRY mode!");
                            highScoreService.saveHighScore(attemptsCount);
                        }

                        playing = false;
                    }
                    else
                    {
                        final int matchCount;

                        matchCount = countCorrectLetters(guess,
                                                         secretCountry);
                        System.out.println("Not it. " + matchCount + " letter(s) correct (right position).");
                        logger.logGuess(guess,
                                        "matches=" + matchCount);
                    }
                }
            }
        }
    }

    /*
     * Compares the guess to the target country and counts letters in the exact right position.
     * Case-insensitive.
     *
     * @param guess the country guess
     * @param targetCountry the target country
     * @return the number of matching letters as an int
     */
    private static int countCorrectLetters(final String guess,
                                           final String targetCountry)
    {
        int matchCount;

        matchCount = 0;

        for (int i = 0; i < guess.length(); i++)
        {
            final char guessChar;
            final char secretChar;

            guessChar  = Character.toLowerCase(guess.charAt(i));
            secretChar = Character.toLowerCase(targetCountry.charAt(i));

            if (guessChar == secretChar)
            {
                matchCount++;
            }
        }

        return matchCount;
    }

    /**
     * Drives the Country Game program.
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        final Game game;

        game = new Game();
        game.play();
    }
}