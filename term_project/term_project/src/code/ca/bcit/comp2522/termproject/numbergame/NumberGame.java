package ca.bcit.comp2522.termproject.numbergame;

import ca.bcit.comp2522.termproject.Game;
import ca.bcit.comp2522.termproject.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;

/**
 * The logical execution wrapper for the Number Game.
 * Extends the abstract Game class and manages the JavaFX thread lifecycle.
 *
 * @author Aika Manalo - Set 2C
 * @version 5.0
 */
public final class NumberGame
        extends Game
{
    private static final int INITIAL_LATCH_COUNT = 1;

    /**
     * Constructs the Number Game instance.
     */
    public NumberGame()
    {
        super("Number Game: Test Your RNG");
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

            javaFxThread = new Thread(() -> Application.launch(NumberGameGUI.class));
            javaFxThread.start();
        }
        else
        {
            Platform.runLater(() ->
                              {
                                  final NumberGameGUI myGameGui;
                                  final Stage stage;

                                  myGameGui = new NumberGameGUI();
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