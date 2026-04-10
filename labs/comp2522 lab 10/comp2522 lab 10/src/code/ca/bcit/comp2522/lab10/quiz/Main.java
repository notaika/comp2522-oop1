package ca.bcit.comp2522.lab10.quiz;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main
        extends Application
{
    private static final int TIME_PER_QUESTION = 15;

    @Override
    public void start(final Stage stage)
    {
        // 1. Stage stage = new Stage(); - window
        VBox layout = createRoot();
        Scene scene = new Scene(layout, 300, 200); // 2. Content within the window

        stage.setTitle("COMP2522 Quiz App");
        stage.setScene(scene); // 3. Adds a scene to the stage
        stage.show();
    }

    private VBox createRoot()
    {
        Label label = new Label("Welcome to COMP2522 Quiz App!");
        Button button = new Button("Click me");
        return new VBox(label, button);
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}

/*
 * - Define Scene content and layout first, then add it to the Stage
 * using setScene() for better organization
 */