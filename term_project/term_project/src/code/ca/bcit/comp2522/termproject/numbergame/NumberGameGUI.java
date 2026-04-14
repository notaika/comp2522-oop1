package ca.bcit.comp2522.termproject.numbergame;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ca.bcit.comp2522.termproject.Main;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

/**
 * Represents the JavaFX concrete implementation of the Number Game GUI.
 * Manages the UI, random number generation, and strict ascending order logic.
 * Extends AbstractNumberGame to utilize its scoring logic.
 *
 * @author Aika Manalo - Set 2C
 * @version 5.1
 */
public final class NumberGameGUI
        extends AbstractNumberGame
{
    private static final int NUM_COLS               = 5;
    private static final int TOTAL_SQUARES          = 20;
    private static final int MIN_RANDOM_VALUE       = 1;
    private static final int MAX_RANDOM_VALUE       = 1000;
    private static final int EMPTY_SLOT_SENTINEL    = 0;
    private static final int INITIAL_PLACEMENTS     = 0;
    private static final int INITIAL_PREVIOUS_VALUE = -1;

    private static final int WINDOW_WIDTH_PIXELS  = 700;
    private static final int WINDOW_HEIGHT_PIXELS = 600;

    public static final String NUMBERGAME_CSS_PATH = "/numbergame/numbergame.css";

    private final int[]    placedNumbers;
    private final Button[] gridButtons;
    private final Label    nextNumberLabel;
    private final Random   random;

    private int currentNumber;
    private int successfulPlacements;

    /**
     * Constructs and initializes the NumberGameGUI components and data structures.
     */
    public NumberGameGUI()
    {
        super();

        this.placedNumbers   = new int[TOTAL_SQUARES];
        this.gridButtons     = new Button[TOTAL_SQUARES];
        this.nextNumberLabel = new Label();
        this.random          = new Random();

        for (int i = 0; i < TOTAL_SQUARES; i++)
        {
            this.gridButtons[i] = new Button("");
            this.gridButtons[i].getStyleClass()
                               .add("grid-button");
        }

        this.nextNumberLabel.getStyleClass()
                            .add("number-label");
        this.currentNumber        = EMPTY_SLOT_SENTINEL;
        this.successfulPlacements = INITIAL_PLACEMENTS;
    }

    /**
     * Starts the JavaFX application, setting up the layout and showing the stage.
     *
     * @param primaryStage the main stage for the application
     */
    @Override
    public void start(final Stage primaryStage)
    {
        Platform.setImplicitExit(false);

        final BorderPane root;
        final GridPane grid;
        final VBox topBanner;
        final Scene scene;

        root      = new BorderPane();
        grid      = createGridPane();
        topBanner = createTopBanner();
        scene     = new Scene(root,
                              WINDOW_WIDTH_PIXELS,
                              WINDOW_HEIGHT_PIXELS);

        root.getStyleClass()
            .add("number-root");
        scene.getStylesheets()
             .add(Objects.requireNonNull(getClass().getResource(NUMBERGAME_CSS_PATH))
                         .toExternalForm());

        root.setTop(topBanner);
        root.setCenter(grid);

        setupButtonActions(primaryStage);
        startNewRound(primaryStage);

        primaryStage.setTitle("Number Game: " + TOTAL_SQUARES + " Number Challenge");
        primaryStage.setScene(scene);

        primaryStage.setOnHidden(event ->
                                 {
                                     if (Main.activeGameLatch != null)
                                     {
                                         Main.activeGameLatch.countDown();
                                     }
                                 });

        primaryStage.show();
    }

    /*
     * Creates the top banner containing the game title and the next number prompt.
     *
     * @return the configured VBox banner
     */
    private VBox createTopBanner()
    {
        final VBox banner;
        final Label mainTitle;

        banner    = new VBox();
        mainTitle = new Label("NUMBER GAME - " + TOTAL_SQUARES + " CHALLENGE");

        banner.getStyleClass()
              .add("top-banner");
        mainTitle.getStyleClass()
                 .add("game-title");

        banner.setAlignment(Pos.CENTER);
        banner.getChildren()
              .addAll(mainTitle,
                      nextNumberLabel);

        return banner;
    }

    /*
     * Creates and configures the GridPane for the game board.
     *
     * @return the configured GridPane
     */
    private GridPane createGridPane()
    {
        final GridPane grid;
        grid = new GridPane();

        grid.getStyleClass()
            .add("game-grid");

        for (int i = 0; i < TOTAL_SQUARES; i++)
        {
            final int row;
            final int col;

            row = i / NUM_COLS;
            col = i % NUM_COLS;

            grid.add(gridButtons[i],
                     col,
                     row);
        }

        return grid;
    }

    /*
     * Attaches action event listeners to all buttons in the grid using lambdas.
     *
     * @param stage the primary stage used to display alerts
     */
    private void setupButtonActions(final Stage stage)
    {
        for (int i = 0; i < TOTAL_SQUARES; i++)
        {
            final int index;
            index = i;
            gridButtons[index].setOnAction(event -> handleButtonClick(index,
                                                                      stage));
        }
    }

    /*
     * Resets the game board state and starts a new round.
     *
     * @param stage the primary stage used to display alerts
     */
    private void startNewRound(final Stage stage)
    {
        successfulPlacements = INITIAL_PLACEMENTS;

        for (int i = 0; i < TOTAL_SQUARES; i++)
        {
            placedNumbers[i] = EMPTY_SLOT_SENTINEL;
            gridButtons[i].setText("");
            gridButtons[i].getStyleClass()
                          .remove("grid-button-lose");
            gridButtons[i].setDisable(false);
        }

        generateNextNumber(stage);
    }

    /*
     * Generates a new random number, updates the UI label, and checks for validity.
     * Ends the game automatically if no valid placements remain.
     *
     * @param stage the primary stage used to display alerts
     */
    private void generateNextNumber(final Stage stage)
    {
        final boolean possibleToPlace;

        currentNumber = random.nextInt(MAX_RANDOM_VALUE) + MIN_RANDOM_VALUE;
        nextNumberLabel.setText("INCOMING NUMBER: " + currentNumber);

        possibleToPlace = canPlaceNumber(currentNumber);

        if (!possibleToPlace)
        {
            recordLoss(successfulPlacements);
            disableAllButtons();
            highlightEmptyBoxesRed();
            showEndGameAlert("Impossible to place the next number: " + currentNumber,
                             stage);
        }
    }

    /*
     * Temporarily tests if there is any empty slot where placing the given number
     * maintains strictly ascending order.
     *
     * @param numberToPlace the number to test for valid placement
     * @return true if there is at least one valid slot, false otherwise
     */
    private boolean canPlaceNumber(final int numberToPlace)
    {
        for (int i = 0; i < TOTAL_SQUARES; i++)
        {
            if (placedNumbers[i] == EMPTY_SLOT_SENTINEL)
            {
                placedNumbers[i] = numberToPlace;

                final boolean valid;
                valid = checkAscendingOrder();

                placedNumbers[i] = EMPTY_SLOT_SENTINEL;

                if (valid)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Handles the logic when a grid button is clicked by the user.
     * Validates if the placement maintains ascending order.
     *
     * @param index the index of the clicked button
     * @param stage the primary stage used to display alerts
     */
    private void handleButtonClick(final int index,
                                   final Stage stage)
    {
        final boolean ascending;

        if (placedNumbers[index] != EMPTY_SLOT_SENTINEL)
        {
            return;
        }

        placedNumbers[index] = currentNumber;
                               ascending = checkAscendingOrder();

        if (ascending)
        {
            gridButtons[index].setText(String.valueOf(currentNumber));
            gridButtons[index].setDisable(true);
            successfulPlacements++;

            if (successfulPlacements == TOTAL_SQUARES)
            {
                recordWin(successfulPlacements);
                disableAllButtons();
                showEndGameAlert("SEQUENCE CRACKED! YOU WIN!",
                                 stage);
            }
            else
            {
                generateNextNumber(stage);
            }
        }
        else
        {
            recordLoss(successfulPlacements);
            disableAllButtons();
            highlightEmptyBoxesRed();
            showEndGameAlert("SEQUENCE BROKEN! YOU LOSE!",
                             stage);
        }
    }

    /*
     * Checks if the non-zero numbers in the array are in strictly ascending order.
     *
     * @return true if strictly ascending, false otherwise
     */
    private boolean checkAscendingOrder()
    {
        int previousValue;
        previousValue = INITIAL_PREVIOUS_VALUE;

        for (final int number : placedNumbers)
        {
            if (number != EMPTY_SLOT_SENTINEL)
            {
                if (number <= previousValue)
                {
                    return false;
                }
                previousValue = number;
            }
        }
        return true;
    }

    /*
     * Disables all buttons on the grid to prevent further interaction.
     */
    private void disableAllButtons()
    {
        for (final Button button : gridButtons)
        {
            button.setDisable(true);
        }
    }

    /*
     * Highlights all remaining empty buttons red to indicate a game loss.
     */
    private void highlightEmptyBoxesRed()
    {
        for (final Button button : gridButtons)
        {
            final String buttonText;
            buttonText = button.getText();

            if (buttonText.isEmpty())
            {
                button.getStyleClass()
                      .add("grid-button-lose");
            }
        }
    }

    /*
     * Displays the initial end game alert showing ONLY win/loss/impossible feedback.
     * Then displays a secondary alert with the session stats before acting on the user's choice.
     *
     * @param feedbackText the feedback text to display
     * @param stage the primary stage to close if the user selects quit
     */
    private void showEndGameAlert(final String feedbackText,
                                  final Stage stage)
    {
        final Alert feedbackAlert;
        final ButtonType tryAgainButton;
        final ButtonType quitButton;
        final Optional<ButtonType> result;

        feedbackAlert  = new Alert(Alert.AlertType.INFORMATION);
        tryAgainButton = new ButtonType("Try Again");
        quitButton     = new ButtonType("Quit");

        feedbackAlert.setTitle("Game Over!");
        feedbackAlert.setHeaderText(null);
        feedbackAlert.setContentText(feedbackText);
        feedbackAlert.getButtonTypes()
                     .setAll(tryAgainButton,
                             quitButton);

        result = feedbackAlert.showAndWait();

        showScoreStatsAlert();

        if (result.isPresent() && result.get() == tryAgainButton)
        {
            startNewRound(stage);
        }
        else
        {
            stage.close();
        }
    }

    /*
     * Displays a secondary alert to overall session score statistics.
     */
    private void showScoreStatsAlert()
    {
        final Alert statsAlert;
        final String summaryText;

        statsAlert  = new Alert(Alert.AlertType.INFORMATION);
        summaryText = getScoreSummary();

        statsAlert.setTitle("Session Statistics");
        statsAlert.setHeaderText(null);
        statsAlert.setContentText(summaryText);

        statsAlert.showAndWait();
    }
}