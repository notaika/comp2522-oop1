package ca.bcit.comp2522.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents a Guessing Game.
 * A guessing game against a computer.
 *
 * @author Aika Manalo - Set 2C
 * @author Mayvee Tan - Set 2C
 *
 * @version 1.0
 */
public class GuessingGame extends Game
{
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 6;

    private static Random computerChoiceGenerator;

    private int playerGuessCount;
    private int npcChoice;

    {
        this.playerGuessCount = 0;
        this.npcChoice = 0;
        computerChoiceGenerator = new Random();

    }

    public GuessingGame(final String gameName,
                        final Player player,
                        final Scanner input) // Added to match updated Game constructor
    {
        super(gameName, player, input);
    }

    public GuessingGame(final String gameName,
                        final Player player,
                        final File fileName) throws FileNotFoundException
    {
        super(gameName, fileName, player);
    }

    private char getUserChoice()
    {

        return 'a';
    }

    /**
     * Generates a random number between [LOWER_BOUND, UPPER_BOUND).
     */
    private void getComputerChoice()
    {
        npcChoice = computerChoiceGenerator.nextInt(LOWER_BOUND,
                                                    UPPER_BOUND);
    }

    private boolean compareChoices(final int userChoice,
                                   final int computerChoice)
    {
        return false;
    }

    @Override
    public void start()
    {
        // welcome screen
        // select a game
        // loop here
        // computer generates a number
        // get user input
        // compare
        // loop here again
        // if user input != game input
        // keep getting user input until right
        // user input = game input
        // prompt to play again or exit

        System.out.println("game started :)");
    }

    /**
     * Drives the GuessingGame program.
     *
     * @param args unused
     */
    public static void main(String[] args)
    {

    }
}