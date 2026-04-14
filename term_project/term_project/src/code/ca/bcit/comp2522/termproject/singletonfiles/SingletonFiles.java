package ca.bcit.comp2522.termproject.singletonfiles;

import ca.bcit.comp2522.termproject.Game;
import ca.bcit.comp2522.termproject.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;

/**
 * The logical execution wrapper for the Singleton Files game.
 * Extends the abstract Game class and manages the JavaFX thread lifecycle.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public final class SingletonFiles
        extends Game
{
    private static final int INITIAL_LATCH_COUNT = 1;

    /**
     * Constructs the Singleton Files game instance.
     */
    public SingletonFiles()
    {
        super("Singleton Files: Who Did It?");
    }

    /**
     * Executes the game by launching or calling the JavaFX application thread.
     * Blocks the terminal until the JavaFX window is closed.
     */
    @Override
    public void play()
    {
        Main.activeGameLatch = new CountDownLatch(INITIAL_LATCH_COUNT);

        if (!Main.javaFxRunning)
        {
            Main.javaFxRunning = true;
            final Thread javaFxThread;

            javaFxThread = new Thread(() -> Application.launch(SingletonFilesGUI.class));
            javaFxThread.start();
        }
        else
        {
            Platform.runLater(() ->
                              {
                                  final SingletonFilesGUI myGameGui;
                                  final Stage stage;

                                  myGameGui = new SingletonFilesGUI();
                                  stage     = new Stage();
                                  myGameGui.start(stage);
                              });
        }

        try
        {
            Main.activeGameLatch.await();
        }
        catch (final InterruptedException exception)
        {
            System.out.println("ERROR: The game thread was interrupted.");
        }
    }
}