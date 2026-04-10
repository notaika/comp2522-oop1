package ca.bcit.comp2522.lab10.quiz;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Path;

public class Main
        extends Application
{
    private static final int TIME_PER_QUESTION = 15;

    private QuizApp app;

    private Label     questionLabel;
    private Label     timerLabel;
    private TextField answerField;
    private Button    submitButton;
    private Button    startButton;
    private Label     scoreLabel;

    private Timeline timeline;
    private int secondsRemaining;

    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        app = new QuizApp();

        // Load data
        final Path path = Path.of("src", "data", "quiz.txt");

        try
        {
            app.loadQuestions(path);

            System.out.println("Questions were successfully loaded.");
        }
        catch (final IOException e)
        {
            System.out.println("Error loading file: " + e.getMessage());
            return;
        }

        // Initialize Components
        questionLabel = new Label("Press Start Quiz to begin!");
        questionLabel.getStyleClass().add("label"); // Links to styles.css

        timerLabel = new Label("Time: --");
        timerLabel.getStyleClass().add("label");

        answerField = new TextField();
        answerField.setPromptText("Type answer here...");
        answerField.setDisable(true);
        answerField.getStyleClass().add("text-field");

        submitButton = new Button("Submit");
        submitButton.setDisable(true);
        submitButton.getStyleClass().add("button");

        startButton = new Button("Start Quiz");
        startButton.getStyleClass().add("button");

        scoreLabel = new Label("");
        scoreLabel.getStyleClass().add("label");

        // 3. Setup Events
        startButton.setOnAction(e -> startApp());

        // Handle Button Click for submission
        submitButton.setOnAction(e -> processAnswer());

        // Handle ENTER key for submission
        answerField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                processAnswer();
            }
        });

        // 4. Setup Timer (JavaFX Timeline)
        setupTimer();


        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.getStyleClass().add("vbox");
        root.getChildren().addAll(startButton, timerLabel, questionLabel, answerField, submitButton, scoreLabel);

        Scene scene = new Scene(root, 500, 500);

        // Load CSS?
        try {
            scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        } catch (NullPointerException e) {
            System.out.println("Warning: styles.css not found.");
        }

        primaryStage.setTitle("Quizzurp");
        primaryStage.show();
    }

    private void setupTimer() {
        // Creates a timer that ticks once every 1 second
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            secondsRemaining--;
            timerLabel.setText("Time: " + secondsRemaining + "s");

            if (secondsRemaining <= 0) {
                timeline.stop();
                // If time runs out, submit a blank answer to force it wrong
                app.submitAnswer("");
                displayNextQuestion();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    private void startApp() {
        app.startGame();

        // Toggle UI states
        startButton.setDisable(true);
        answerField.setDisable(false);
        submitButton.setDisable(false);
        scoreLabel.setText("");

        displayNextQuestion();
    }

    private void displayNextQuestion() {
        timeline.stop(); // Stop previous timer

        if (app.getCurrQuestionCount() < app.getTotalSessionQuestions()) {
            Question current = app.getCurrQuestion();

            // +1 because array indexes start at 0, but humans count from 1
            questionLabel.setText("Q" + (app.getCurrQuestionCount() + 1) + ": " + current.getQuestion());

            answerField.clear();
            answerField.requestFocus(); // Puts the blinking cursor back in the box

            // Reset and start timer
            secondsRemaining = TIME_PER_QUESTION;
            timerLabel.setText("Time: " + secondsRemaining + "s");
            timeline.play();
        } else {
            endGame();
        }
    }

    private void processAnswer() {
        timeline.stop(); // Pause timer while processing
        String userGuess = answerField.getText();
        app.submitAnswer(userGuess);
        displayNextQuestion();
    }

    private void endGame() {
        answerField.setDisable(true);
        submitButton.setDisable(true);
        startButton.setDisable(false); // Let them restart
        timerLabel.setText("Time: --");

        StringBuilder results = new StringBuilder();
        results.append("Final Score: ").append(app.getScore()).append(" / ").append(app.getTotalSessionQuestions()).append("\n\n");

        if (app.getQuestionsWrong().isEmpty()) {
            results.append("Perfect Score! Amazing job.");
        } else {
            results.append("Missed Questions:\n");
            for (Question q : app.getQuestionsWrong()) {
                results.append("- ").append(q.getQuestion())
                       .append("\n  (Correct: ").append(q.getAnswer()).append(")\n");
            }
        }

        questionLabel.setText("Quiz Complete!");
        scoreLabel.setText(results.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
