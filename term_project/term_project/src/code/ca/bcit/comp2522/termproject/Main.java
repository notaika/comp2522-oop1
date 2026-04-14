package ca.bcit.comp2522.termproject;

import ca.bcit.comp2522.termproject.numbergame.NumberGame;
import ca.bcit.comp2522.termproject.singletonfiles.SingletonFiles;
import ca.bcit.comp2522.termproject.wordgame.WordGame;
import javafx.application.Platform;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * The main entry point for the Term Project application.
 * Manages the top-level menu system to manage and launch games.
 *
 * @author Aika Manalo - Set 2C
 * @version 3.0
 */
public final class Main
{
    private static final String OPTION_WORD_GAME       = "W";
    private static final String OPTION_NUMBER_GAME     = "N";
    private static final String OPTION_SINGLETON_FILES = "S";
    private static final String OPTION_QUIT            = "Q";

    public static boolean        javaFxRunning = false;
    public static CountDownLatch activeGameLatch;

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
            choice = scanner.nextLine()
                            .trim()
                            .toUpperCase();

            switch (choice)
            {
                case OPTION_WORD_GAME ->
                {
                    final Game wordGame;
                    wordGame = new WordGame();
                    wordGame.play();
                }
                case OPTION_NUMBER_GAME ->
                {
                    final Game numberGame;
                    numberGame = new NumberGame();
                    numberGame.play();
                }
                case OPTION_SINGLETON_FILES ->
                {
                    final Game myGame;
                    myGame = new SingletonFiles();
                    myGame.play();
                }
                case OPTION_QUIT ->
                {
                    System.out.println("Goodbye!");
                    quit = true;

                    if (javaFxRunning)
                    {
                        Platform.exit();
                    }
                }
                default -> System.out.println("ERROR: Invalid input. Please enter W, N, S, or Q.");
            }
        }
    }

    /*
     * Displays the main menu to the terminal.
     */
    private static void displayMenu()
    {
        System.out.println("\n--- COMP 2522 TERM PROJECT ---");
        System.out.println("Press W to play the Word game.");
        System.out.println("Press N to play the Number game.");
        System.out.println("Press S to play Singleton Files.");
        System.out.println("Press Q to quit.");
        System.out.print("> ");
    }

    /**
     * Drives the main program.
     *
     * @param arguments command line arguments
     */
    public static void main(final String[] arguments)
    {
        final Main mainApplication;
        mainApplication = new Main();
        mainApplication.run();
    }
}