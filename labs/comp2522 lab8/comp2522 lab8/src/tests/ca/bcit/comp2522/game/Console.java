package ca.bcit.comp2522.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class Console
{
    private static final String EXIT_CHAR = "x";

    private final Map<Integer, Game> games;
    private final Set<Integer>       gameIds;
    private final Scanner            keyboardScanner;

    public Console()
    {
        this.games = new HashMap<>();
        this.gameIds = games.keySet();
        this.keyboardScanner = new Scanner(System.in);
    }

    public void addGame(final Game game)
    {
        games.put(game.getGameId(), game);
    }

    public void selectGame(final int gameNumber)
    {
        final Game activeGame;
        activeGame = games.get(gameNumber);

        if (activeGame != null) {
            activeGame.start();
        }
    }

    private void printGames()
    {
        for (final Integer id : gameIds)
        {
            System.out.printf("%d - %s\n", id, games.get(id));
        }
    }

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

        System.out.println("== Welcome ==");
        System.out.println("Select a Game: ");

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nSelect a Game (or type '" + EXIT_CHAR + "' to quit):");
            printGames();

            final String userInput = keyboardScanner.next();

            if (userInput.equalsIgnoreCase(EXIT_CHAR)) {
                System.out.println("Goodbye.");
                isRunning = false;
            } else {
                try {
                    int userChoice = Integer.parseInt(userInput);

                    if (games.containsKey(userChoice)) {
                        selectGame(userChoice);
                    } else {
                        System.out.println("Error: No game found with ID " + userChoice);
                    }
                } catch (final NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number or '" + EXIT_CHAR + "'.");
                }
            }
        }
    }

    public static void main(String[] args)
    {
        final Console console = new Console();
        final Player player = new Player("Lano");

        // Pass the console's scanner to the games
        final Game guessingGame = new GuessingGame("Guessing Game", player, console.keyboardScanner);
        final Game guessingGame2 = new GuessingGame("Guessing Game2", player, console.keyboardScanner);
        final Game guessingGame3 = new GuessingGame("Guessing Game3", player, console.keyboardScanner);

        console.addGame(guessingGame);
        console.addGame(guessingGame2);
        console.addGame(guessingGame3);

        console.start();
    }
}