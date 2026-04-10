package ca.bcit.comp2522.termproject.wordgame;

import java.util.Scanner;

/**
 * The main entry point for the Term Project application.
 * Manages the top-level menu system.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public final class Main
{
    private static final String OPTION_WORD_GAME = "W";
    private static final String OPTION_NUMBER_GAME = "N";
    private static final String OPTION_MY_GAME = "M";
    private static final String OPTION_QUIT = "Q";

    private final Scanner scanner;

    /**
     * Constructs and initializes the Main application.
     */
    public Main()
    {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the main program loop.
     */
    public void run()
    {
        boolean quit;
        quit = false;

        while (!quit)
        {
            final String choice;
            
            displayMenu();
            choice = scanner.nextLine().trim().toUpperCase();

            switch (choice)
            {
                case OPTION_WORD_GAME ->
                {
                    final WordGame wordGame;
                    wordGame = new WordGame();
                    wordGame.play();
                }
                case OPTION_NUMBER_GAME -> System.out.println("Starting Number Game... (Not implemented yet)");
                case OPTION_MY_GAME -> System.out.println("Starting My Game... (Not implemented yet)");
                case OPTION_QUIT ->
                {
                    System.out.println("Goodbye!");
                    quit = true;
                }
                default -> System.out.println("ERROR: Invalid input. Please enter W, N, M, or Q.");
            }
        }
    }

    /*
     * Prints the menu options to the terminal.
     */
    private static void displayMenu()
    {
        System.out.println("\n--- COMP 2522 TERM PROJECT ---");
        System.out.println("Press W to play the Word game.");
        System.out.println("Press N to play the Number game.");
        System.out.println("Press M to play My game.");
        System.out.println("Press Q to quit.");
        System.out.print("> ");
    }

    /**
     * Drives the main program.
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        final Main app;
        app = new Main();
        app.run();
    }
}
