package ca.bcit.comp2522.lab10.quiz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Main class for the JavaFX Quiz Application.
 * Manages the UI, statically reads the file, and runs the game loop.
 *
 * @author Aika Manalo - Set 2C
 * @author Quinn Callander - Set 2C
 * @version 1.3
 */
public final class QuizApp
        extends Application
{
    private static final String QUESTION_DELIMITER = "\\|";
    private static final String PATH_CSS           = "/styles.css";

    private static final int MAX_NUM_QUESTIONS = 10;
    private static final int EXPECTED_PARTS    = 2;
    private static final int INDEX_QUESTION    = 0;
    private static final int INDEX_ANSWER      = 1;
    private static final int WINDOW_WIDTH_PX   = 600;
    private static final int WINDOW_HEIGHT_PX  = 600;
    private static final int SPACING_VBOX_PX   = 15;
    private static final int SCORE_START       = 0;
    private static final int SCORE_INCREMENT   = 1;

    private static final List<Question> ALL_QUESTIONS;
    private static final List<Question> activeQuizQuestions;
    private static final List<Question> missedQuestions;

    private int currentQuestionIndex;
    private int currentScore;

    static
    {
        final Path quizFilePath;
        quizFilePath  = Paths.get("src",
                                  "res",
                                  "data",
                                  "quiz.txt");
        ALL_QUESTIONS = loadAllQuestions(quizFilePath);

        activeQuizQuestions = new ArrayList<>();
        missedQuestions     = new ArrayList<>();
    }

    /*
     * Helper method to read the .txt file.
     *
     * @param quizFilePath the path to the text file
     * @return list of all Question objects loaded from the file
     */
    private static List<Question> loadAllQuestions(final Path quizFilePath)
    {
        final List<Question> loadedQuestions;

        loadedQuestions = new ArrayList<>();

        if (Files.exists(quizFilePath))
        {
            try (final BufferedReader reader = Files.newBufferedReader(quizFilePath))
            {
                String line;
                line = reader.readLine();

                while (line != null)
                {
                    final String trimmedLine;
                    trimmedLine = line.trim();

                    if (!trimmedLine.isEmpty())
                    {
                        final String[] parts;
                        parts = trimmedLine.split(QUESTION_DELIMITER);

                        if (parts.length == EXPECTED_PARTS)
                        {
                            loadedQuestions.add(new Question(parts[INDEX_QUESTION].trim(),
                                                             parts[INDEX_ANSWER].trim()));
                        }
                    }

                    line = reader.readLine();
                }
            }
            catch (final IOException e)
            {
                System.out.println("Error reading .txt file: " + e.getMessage());
            }
        }

        return loadedQuestions;
    }

    /**
     * Creates and acts as the main entry point for all JavaFX applications.
     *
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(final Stage primaryStage)
    {
        final VBox layout;
        final Scene scene;

        currentQuestionIndex = SCORE_START;
        currentScore         = SCORE_START;

        layout = createLayout();
        scene  = new Scene(layout,
                           WINDOW_WIDTH_PX,
                           WINDOW_HEIGHT_PX);

        scene.getStylesheets()
             .add(Objects.requireNonNull(getClass().getResource(PATH_CSS))
                         .toExternalForm());

        primaryStage.setTitle("JavaFX Quiz App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
     * Helper method to initialize layout components, style them and attach events.
     *
     * @return the VBox layout container
     */
    private VBox createLayout()
    {
        final Label questionLabel;
        final Label scoreLabel;
        final TextField answerField;
        final Button submitButton;
        final Button startButton;
        final TextArea summaryArea;

        final VBox root;

        questionLabel = new Label("Press 'Start Quiz' to begin!");
        scoreLabel    = new Label("Score: 0");
        answerField   = new TextField();
        submitButton  = new Button("Submit");
        startButton   = new Button("Start Quiz");
        summaryArea   = new TextArea();

        questionLabel.getStyleClass()
                     .add("label");
        scoreLabel.getStyleClass()
                  .add("label");
        answerField.getStyleClass()
                   .add("text-field");
        submitButton.getStyleClass()
                    .add("button");
        startButton.getStyleClass()
                   .add("button");

        answerField.setPromptText("Enter answer: ");
        answerField.setVisible(false);
        submitButton.setVisible(false);

        summaryArea.setEditable(false);
        summaryArea.setVisible(false);
        summaryArea.setWrapText(true);
        summaryArea.setPrefRowCount(10);

        startButton.setOnAction(event -> startNewQuiz(startButton,
                                                      answerField,
                                                      scoreLabel,
                                                      summaryArea,
                                                      submitButton,
                                                      questionLabel));
        submitButton.setOnAction(event -> submitAnswer(startButton,
                                                       answerField,
                                                       summaryArea,
                                                       submitButton,
                                                       questionLabel,
                                                       scoreLabel));

        answerField.setOnAction(event -> submitAnswer(startButton,
                                                      answerField,
                                                      summaryArea,
                                                      submitButton,
                                                      questionLabel,
                                                      scoreLabel));

        if (ALL_QUESTIONS.isEmpty())
        {
            questionLabel.setText("Error: No questions loaded.");
            startButton.setDisable(true);
        }

        root = new VBox(SPACING_VBOX_PX,
                        scoreLabel,
                        questionLabel,
                        answerField,
                        submitButton,
                        startButton,
                        summaryArea);
        root.getStyleClass()
            .add("vbox");

        return root;
    }

    /*
     * Shuffles the questions and resets the UI to begin the quiz.
     */
    private void startNewQuiz(final Button startButton,
                              final TextField answerField,
                              final Label scoreLabel,
                              final TextArea summaryArea,
                              final Button submitButton,
                              final Label questionLabel)
    {
        final List<Question> shuffledPool;

        currentScore         = SCORE_START;
        currentQuestionIndex = SCORE_START;

        activeQuizQuestions.clear();
        missedQuestions.clear();

        shuffledPool = new ArrayList<>(ALL_QUESTIONS);
        Collections.shuffle(shuffledPool);

        for (int i = SCORE_START; i < MAX_NUM_QUESTIONS && i < shuffledPool.size(); i++)
        {
            activeQuizQuestions.add(shuffledPool.get(i));
        }

        scoreLabel.setText("Score: " + currentScore);
        summaryArea.setVisible(false);
        startButton.setDisable(true);
        answerField.setVisible(true);
        submitButton.setVisible(true);

        showNextQuestion(startButton,
                         answerField,
                         summaryArea,
                         submitButton,
                         questionLabel);
    }

    /*
     * Updates the UI with the next question or ends the quiz.
     */
    private void showNextQuestion(final Button startButton,
                                  final TextField answerField,
                                  final TextArea summaryArea,
                                  final Button submitButton,
                                  final Label questionLabel)
    {
        if (currentQuestionIndex >= activeQuizQuestions.size())
        {
            endQuiz(questionLabel,
                    answerField,
                    submitButton,
                    startButton,
                    summaryArea);
        }
        else
        {
            final Question currentQuestion;
            final String prompt;

            currentQuestion = activeQuizQuestions.get(currentQuestionIndex);
            prompt          = currentQuestion.getQuestion();

            questionLabel.setText("Q" + (currentQuestionIndex + SCORE_INCREMENT) + ": " + prompt);
            answerField.setText("");
            answerField.requestFocus();
        }
    }

    /*
     * Validates the answer provided by the user and advances the quiz.
     */
    private void submitAnswer(final Button startButton,
                              final TextField answerField,
                              final TextArea summaryArea,
                              final Button submitButton,
                              final Label questionLabel,
                              final Label scoreLabel)
    {
        final Question currentQuestion;
        final String userAnswer;
        final boolean isCorrect;

        currentQuestion = activeQuizQuestions.get(currentQuestionIndex);
        userAnswer      = answerField.getText();
        isCorrect       = currentQuestion.isCorrect(userAnswer);

        if (isCorrect)
        {
            currentScore += SCORE_INCREMENT;
            scoreLabel.setText("Score: " + currentScore);
        }
        else
        {
            missedQuestions.add(currentQuestion);
        }

        currentQuestionIndex++;
        showNextQuestion(startButton,
                         answerField,
                         summaryArea,
                         submitButton,
                         questionLabel);
    }

    /*
     * Completes the quiz and updates the UI with the final score summary.
     */
    private void endQuiz(final Label questionLabel,
                         final TextField answerField,
                         final Button submitButton,
                         final Button startButton,
                         final TextArea summaryArea)
    {
        final StringBuilder summaryBuilder;

        summaryBuilder = new StringBuilder();

        questionLabel.setText("Game Over! Final Score: " + currentScore + " / " + activeQuizQuestions.size());

        if (missedQuestions.isEmpty())
        {
            summaryBuilder.append("Perfect score! Great job.");
        }
        else
        {
            summaryBuilder.append("Missed Questions:\n\n");

            for (final Question missed : missedQuestions)
            {
                summaryBuilder.append("Q: ");
                summaryBuilder.append(missed.getQuestion());
                summaryBuilder.append("\nA: ");
                summaryBuilder.append(missed.getCorrectAnswer());
                summaryBuilder.append("\n\n");
            }
        }

        summaryArea.setText(summaryBuilder.toString());
        summaryArea.setVisible(true);

        answerField.setVisible(false);
        submitButton.setVisible(false);
        startButton.setDisable(false);
    }

    /**
     * Drives the JavaFX App.
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        launch(args);
    }
}