package ca.bcit.comp2522.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents a Game.
 *
 * @author Aika Manalo - Set 2C
 * @author Mayvee Tan - Set 2C
 *
 * @version 1.0
 */
abstract class Game
{
    private static final String EXIT_CHAR = "x";

    private static int nextId = 0; // Changed to 0 to start ID at 0

    protected final Scanner input;
    private final int gameId;
    private final String gameName;
    private int playCount;
    private int computerScore;
    private final Player player;

    // Initializes game play count and computer score
    {
        this.playCount = 0;
        this.computerScore = 0;
    }

    /**
     * Initializes and instantiates a Game that takes in keyboard input
     * from the user.
     */
    private Game(final String gameName,
                final Player player,
                final Scanner input) { // Accepts scanner from Console
        this.gameName = gameName;
        this.player = player;
        this.input = input;
        this.gameId = nextId++; // Assigns current value (0), then increments
    }

    /**
     * Initializes and instantiates a Game that takes in a file for
     * input.
     *
     * @param fileName the name of the file
     * @throws FileNotFoundException if file is not found
     */
    private Game(final String gameName,
                final File fileName,
                final Player player) throws FileNotFoundException
    {
        this.gameName = gameName;
        this.player = player;
        this.input = new Scanner(fileName);
        this.gameId = nextId++;
    }

    /**
     * Gets the total number of times a game was played.
     *
     * @return total play count
     */
    private int getPlayCount()
    {
        return playCount;
    }

    private int getGameId()
    {
        return gameId;
    }

    /**
     * Gets the NPC computer score of a game.
     *
     * @return the computer score
     */
    private int getComputerScore()
    {
        return computerScore;
    }

    /**
     * Sets and/or updates computer score.
     *
     * @param computerScore the computer score
     */
    private void setComputerScore(int computerScore)
    {
        this.computerScore = computerScore;
    }

    /**
     * Sets and/or updates the total play count of game.
     *
     * @param playCount the play count
     */
    private void setPlayCount(int playCount)
    {
        this.playCount = playCount;
    }

    /**
     * Starts the Game.
     */
    abstract void start();

    /**
     * Exits the game.
     */
    private void exit()
    {
        // Removed input.close() so Console stays alive
        System.out.println("Game Over.");
    }

    @Override
    public String toString()
    {
        return gameName;
    }

    /* TODO: USER
     * - get user input
     * - validate user input
     * - cannot be null, empty
     * - must be [1 - 5] or 'x'
     * - user input can be a text file?
     */

    /* TODO: NPC
     * - NPC choice is randomly generated [1 - 5]
     */

    /* TODO: GAME
     * - NPC choice is randomly generated [1 - 5]
     * - All games have an exit character
     * - All games have a name
     * - All games can have a play count
     * - All games can be started and closed
     * - All games have a score
     */

    /* TODO: GUESSING GAME
     * - if you start the program, you get a welcome screen
     * - prompt user with input and choices
     * - if user guess is wrong, incorrect choice -> keep guessing
     * - if user guess is right, they get congrats and prompt them to play again
     * - print the amount of guesses it took
     */
}