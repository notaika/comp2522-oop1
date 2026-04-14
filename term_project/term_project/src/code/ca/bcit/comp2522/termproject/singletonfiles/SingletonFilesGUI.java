package ca.bcit.comp2522.termproject.singletonfiles;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ca.bcit.comp2522.termproject.Main;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Main JavaFX GUI for Singleton Files Game.
 *
 * @author Aika Manalo - Set 2C
 * @version 3.1
 */
public final class SingletonFilesGUI
        extends Application
{
    private static final double WINDOW_WIDTH_PIXELS     = 1300.0;
    private static final double WINDOW_HEIGHT_PIXELS    = 900.0;
    private static final double SIDE_PANEL_WIDTH_PIXELS = 300.0;

    private static final int REGION_SIZE                 = 3;
    private static final int MAXIMUM_ACCUSATION_ATTEMPTS = 2;
    private static final int WARNING_ACCUSATION_ATTEMPT  = 1;

    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE  = 1;
    private static final int INDEX_TWO  = 2;

    private static final int SPACING_STANDARD_PIXELS = 10;
    private static final int SPACING_NONE_PIXELS     = 0;

    private static final String[] SUSPECT_ICON_PATHS;
    private static final String[] WEAPON_ICON_PATHS;
    private static final String[] LOCATION_ICON_PATHS;

    static
    {
        SUSPECT_ICON_PATHS  = new String[REGION_SIZE];
        WEAPON_ICON_PATHS   = new String[REGION_SIZE];
        LOCATION_ICON_PATHS = new String[REGION_SIZE];

        SUSPECT_ICON_PATHS[INDEX_ZERO] = "/singletonfiles/assets/suspect-icon-1.png";
        SUSPECT_ICON_PATHS[INDEX_ONE]  = "/singletonfiles/assets/suspect-icon-2.png";
        SUSPECT_ICON_PATHS[INDEX_TWO]  = "/singletonfiles/assets/suspect-icon-3.png";

        WEAPON_ICON_PATHS[INDEX_ZERO] = "/singletonfiles/assets/weapon-icon-1.png";
        WEAPON_ICON_PATHS[INDEX_ONE]  = "/singletonfiles/assets/weapon-icon-2.png";
        WEAPON_ICON_PATHS[INDEX_TWO]  = "/singletonfiles/assets/weapon-icon-3.png";

        LOCATION_ICON_PATHS[INDEX_ZERO] = "/singletonfiles/assets/location-icon-1.png";
        LOCATION_ICON_PATHS[INDEX_ONE]  = "/singletonfiles/assets/location-icon-2.png";
        LOCATION_ICON_PATHS[INDEX_TWO]  = "/singletonfiles/assets/location-icon-3.png";
    }

    private final Player   activePlayer;
    private       CaseFile activeCase;
    private       int      accusationAttemptsRemaining;

    private StatsPanel     statsPanel;
    private DeductionPanel deductionPanel;
    private LogicGridBoard logicGridBoard;

    /**
     * Constructs the SingletonFilesGUI and initializes player data.
     */
    public SingletonFilesGUI()
    {
        this.activePlayer                = new Player("Detective Singleton");
        this.accusationAttemptsRemaining = MAXIMUM_ACCUSATION_ATTEMPTS;
    }

    /**
     * Builds the UI programmatically and shows the stage.
     *
     * @param primaryStage the main stage
     */
    @Override
    public void start(final Stage primaryStage)
    {
        Platform.setImplicitExit(false);

        final GameManager manager;
        final BorderPane rootLayout;
        final ScrollPane mainScrollPane;
        final Scene mainScene;

        manager = GameManager.getInstance();
        manager.loadAllEntities();
        SaveManager.loadPlayerStats(this.activePlayer);

        this.activeCase                  = manager.getNextUnseenCase(this.activePlayer);
        this.accusationAttemptsRemaining = MAXIMUM_ACCUSATION_ATTEMPTS;

        rootLayout = new BorderPane();
        rootLayout.getStyleClass()
                  .add("root-pane");

        if (this.activeCase == null)
        {
            final Label noCasesLabel;
            final Button exitButton;
            final VBox noCasesBox;

            noCasesLabel = new Label("NO CASES HAVE BEEN FILED. PLEASE TRY AGAIN LATER.");
            exitButton   = new Button("EXIT TO MENU");
            noCasesBox   = new VBox();

            noCasesLabel.getStyleClass()
                        .add("panel-heading");
            exitButton.getStyleClass()
                      .add("button");

            exitButton.setOnAction(event ->
                                   {
                                       SaveManager.savePlayerStats(activePlayer);
                                       primaryStage.close();
                                   });

            noCasesBox.setAlignment(Pos.CENTER);
            noCasesBox.getChildren()
                      .addAll(noCasesLabel,
                              exitButton);
            rootLayout.setCenter(noCasesBox);
        }
        else
        {
            final CategoryPanel<Suspect> suspectsBox;
            final CategoryPanel<Weapon> weaponsBox;
            final CategoryPanel<Location> locationsBox;
            final CluesPanel cluesBox;

            final VBox leftMiddle;
            final VBox centerMiddle;
            final HBox middleRow;
            final HBox bottomRow;
            final VBox mainContentLayout;

            suspectsBox  = new CategoryPanel<>("SUSPECTS",
                                               activeCase.getSuspectList(),
                                               SUSPECT_ICON_PATHS);
            weaponsBox   = new CategoryPanel<>("WEAPONS",
                                               activeCase.getWeaponList(),
                                               WEAPON_ICON_PATHS);
            locationsBox = new CategoryPanel<>("LOCATIONS",
                                               activeCase.getLocationList(),
                                               LOCATION_ICON_PATHS);

            statsPanel     = new StatsPanel(activePlayer);
            cluesBox       = new CluesPanel(activeCase,
                                            activePlayer,
                                            statsPanel);
            logicGridBoard = new LogicGridBoard(activeCase,
                                                SUSPECT_ICON_PATHS,
                                                WEAPON_ICON_PATHS,
                                                LOCATION_ICON_PATHS);
            deductionPanel = new DeductionPanel(() -> handleAccuseAction(primaryStage));

            logicGridBoard.addObserver(deductionPanel);

            leftMiddle = new VBox(SPACING_STANDARD_PIXELS);
            leftMiddle.getChildren()
                      .addAll(suspectsBox,
                              weaponsBox);
            leftMiddle.setPrefWidth(SIDE_PANEL_WIDTH_PIXELS);
            leftMiddle.setMinWidth(SIDE_PANEL_WIDTH_PIXELS);
            leftMiddle.setMaxHeight(Double.MAX_VALUE);

            deductionPanel.setPrefWidth(SIDE_PANEL_WIDTH_PIXELS);
            deductionPanel.setMinWidth(SIDE_PANEL_WIDTH_PIXELS);
            deductionPanel.setMaxHeight(Double.MAX_VALUE);

            centerMiddle = new VBox(SPACING_NONE_PIXELS);
            centerMiddle.setAlignment(Pos.CENTER);
            centerMiddle.getChildren()
                        .add(logicGridBoard);
            HBox.setHgrow(centerMiddle,
                          Priority.ALWAYS);

            middleRow = new HBox();
            middleRow.getStyleClass()
                     .add("content-row");
            middleRow.getChildren()
                     .addAll(leftMiddle,
                             centerMiddle,
                             deductionPanel);

            locationsBox.setPrefWidth(SIDE_PANEL_WIDTH_PIXELS);
            locationsBox.setMinWidth(SIDE_PANEL_WIDTH_PIXELS);
            locationsBox.setMaxHeight(Double.MAX_VALUE);

            statsPanel.setPrefWidth(SIDE_PANEL_WIDTH_PIXELS);
            statsPanel.setMinWidth(SIDE_PANEL_WIDTH_PIXELS);
            statsPanel.setMaxHeight(Double.MAX_VALUE);

            cluesBox.setMaxHeight(Double.MAX_VALUE);
            HBox.setHgrow(cluesBox,
                          Priority.ALWAYS);

            bottomRow = new HBox();
            bottomRow.getStyleClass()
                     .add("content-row");
            bottomRow.getChildren()
                     .addAll(locationsBox,
                             cluesBox,
                             statsPanel);

            mainContentLayout = new VBox();
            mainContentLayout.getStyleClass()
                             .add("main-content");
            mainContentLayout.getChildren()
                             .addAll(middleRow,
                                     bottomRow);

            rootLayout.setTop(createTopBanner());
            rootLayout.setCenter(mainContentLayout);
            rootLayout.setBottom(createBottomPanel(primaryStage));

            statsPanel.refreshStats();
        }

        mainScrollPane = new ScrollPane(rootLayout);
        mainScrollPane.getStyleClass()
                      .add("scroll-pane");
        mainScrollPane.setFitToWidth(true);
        mainScrollPane.setFitToHeight(true);
        mainScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        mainScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        mainScene = new Scene(mainScrollPane,
                              WINDOW_WIDTH_PIXELS,
                              WINDOW_HEIGHT_PIXELS);
        mainScene.getStylesheets()
                 .add(Objects.requireNonNull(getClass().getResource("/singletonfiles/singletonfiles.css"))
                             .toExternalForm());

        primaryStage.setTitle("SINGLETON FILES");
        primaryStage.setScene(mainScene);

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
     * Creates the top banner.
     *
     * @return the banner as an HBox
     */
    private HBox createTopBanner()
    {
        final HBox banner;
        final Label mainTitle;
        final Label caseIdLabel;
        final Region spacer;

        banner      = new HBox();
        mainTitle   = new Label("SINGLETON FILES");
        caseIdLabel = new Label("CASE FILE: " + activeCase.getCaseIdentifier());
        spacer      = new Region();

        banner.getStyleClass()
              .add("top-banner");
        mainTitle.getStyleClass()
                 .add("main-title");
        caseIdLabel.getStyleClass()
                   .add("case-id-title");
        spacer.getStyleClass()
              .add("banner-separator");

        HBox.setHgrow(spacer,
                      Priority.ALWAYS);
        banner.getChildren()
              .addAll(mainTitle,
                      spacer,
                      caseIdLabel);

        return banner;
    }

    /*
     * Creates the bottom panel containing footer text and the exit button.
     *
     * @param primaryStage the primary stage to close on exit
     * @return the bottom panel as an HBox
     */
    private HBox createBottomPanel(final Stage primaryStage)
    {
        final HBox footer;
        final Label text;
        final Button exitButton;

        footer     = new HBox();
        text       = new Label("AIKA MANALO - BCIT COMP2522.202610   |   ... .. -. --. .-.. . - --- -.    ..-. .. .-.. . ...");
        exitButton = new Button("EXIT TO MENU");

        footer.getStyleClass()
              .add("bottom-panel");
        exitButton.getStyleClass()
                  .add("button");

        exitButton.setOnAction(event ->
                               {
                                   SaveManager.savePlayerStats(activePlayer);
                                   primaryStage.close();
                               });

        footer.getChildren()
              .addAll(text,
                      exitButton);

        return footer;
    }

    /*
     * Finds the guilty entity from a list using a predicate.
     * Demonstrates Lesson 6 & 7: Functional Interfaces and Bounded Generics.
     *
     * @param <T> the type of entity
     * @param entities the list of entities
     * @param guiltyPredicate the condition defining guilt
     * @return the guilty entity, or null if not found
     */
    private <T extends Entity> T findGuiltyEntity(final List<T> entities,
                                                  final Predicate<T> guiltyPredicate)
    {
        return entities.stream()
                       .filter(guiltyPredicate)
                       .findFirst()
                       .orElse(null);
    }

    /*
     * Handles the accusation logic when the accuse button is clicked.
     * Evaluates the player's deductions against the actual guilty entities.
     *
     * @param primaryStage the primary stage to anchor alerts
     */
    private void handleAccuseAction(final Stage primaryStage)
    {
        final String deducedWho;
        final String deducedWhat;
        final String deducedWhen;
        final Suspect murderer;
        final Weapon weapon;
        final Location location;

        deducedWho  = deductionPanel.getDeducedWho();
        deducedWhat = deductionPanel.getDeducedWhat();
        deducedWhen = deductionPanel.getDeducedWhen();

        murderer = findGuiltyEntity(activeCase.getSuspectList(),
                                    suspect -> !suspect.getInnocent());
        weapon   = findGuiltyEntity(activeCase.getWeaponList(),
                                    Weapon::getMurderWeapon);
        location = findGuiltyEntity(activeCase.getLocationList(),
                                    Location::getMurderLocation);

        if (murderer != null && murderer.getName()
                                        .equalsIgnoreCase(deducedWho) &&
            weapon != null && weapon.getName()
                                    .equalsIgnoreCase(deducedWhat) &&
            location != null && location.getName()
                                        .equalsIgnoreCase(deducedWhen))
        {
            activePlayer.incrementSuccessfulCases();
            activePlayer.addSeenCase(activeCase.getCaseIdentifier());
            statsPanel.refreshStats();
            SaveManager.savePlayerStats(activePlayer);
            showLoopAlert(primaryStage,
                          "Case Solved!",
                          "Congratulations! You found the truth.");
        }
        else
        {
            if (accusationAttemptsRemaining == MAXIMUM_ACCUSATION_ATTEMPTS)
            {
                accusationAttemptsRemaining--;
                final Alert warningAlert;
                warningAlert = new Alert(Alert.AlertType.WARNING);
                warningAlert.setTitle("Incorrect Accusation");
                warningAlert.setHeaderText(null);
                warningAlert.setContentText("INCORRECT! YOU HAVE ONE CHANCE LEFT.");
                warningAlert.showAndWait();
            }
            else if (accusationAttemptsRemaining == WARNING_ACCUSATION_ATTEMPT)
            {
                activePlayer.incrementFailedCases();
                activePlayer.addSeenCase(activeCase.getCaseIdentifier());
                statsPanel.refreshStats();
                SaveManager.savePlayerStats(activePlayer);
                showLoopAlert(primaryStage,
                              "Case Failed",
                              "Incorrect. The murderer was " + murderer.getName());
            }
        }
    }

    /*
     * Shows an alert giving the player the choice to play again or quit.
     *
     * @param primaryStage the primary stage to restart or close
     * @param title the title of the alert
     * @param content the content text of the alert
     */
    private void showLoopAlert(final Stage primaryStage,
                               final String title,
                               final String content)
    {
        final Alert loopAlert;
        final ButtonType nextButtonType;
        final ButtonType quitButtonType;
        final Optional<ButtonType> result;

        loopAlert      = new Alert(Alert.AlertType.INFORMATION);
        nextButtonType = new ButtonType("Solve Next Case");
        quitButtonType = new ButtonType("Quit");

        loopAlert.setTitle(title);
        loopAlert.setHeaderText(null);
        loopAlert.setContentText(content + "\n\nAnother case is available, solve the next case?");
        loopAlert.getButtonTypes()
                 .setAll(nextButtonType,
                         quitButtonType);

        result = loopAlert.showAndWait();
        if (result.isPresent() && result.get() == nextButtonType)
        {
            this.start(primaryStage);
        }
        else
        {
            primaryStage.close();
        }
    }
}