package ca.bcit.comp2522.termproject.singletonfiles;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the visual grid board and acts as the Subject in the Observer Pattern.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.1
 */
public final class LogicGridBoard
        extends GridPane
{
    private static final int    GRID_SIZE_DIMENSION = 6;
    private static final int    REGION_SIZE         = 3;
    private static final double ICON_SIZE_PIXELS    = 28.0;

    private static final int OFFSET_TOP_LEFT_ROW    = 0;
    private static final int OFFSET_TOP_LEFT_COL    = 0;
    private static final int OFFSET_TOP_RIGHT_ROW   = 0;
    private static final int OFFSET_TOP_RIGHT_COL   = 3;
    private static final int OFFSET_BOTTOM_LEFT_ROW = 3;
    private static final int OFFSET_BOTTOM_LEFT_COL = 0;
    private static final int OFFSET_GRID_LABELS     = 1;
    private static final int INDEX_HEADER_AXIS      = 0;

    private static final String STATE_EMPTY      = " ";
    private static final String STATE_IMPOSSIBLE = "X";
    private static final String STATE_CONFIRMED  = "O";

    private final Button[][]         logicGridButtons;
    private final List<GridObserver> observers;
    private final CaseFile           activeCase;

    private final String[] suspectIconPaths;
    private final String[] weaponIconPaths;
    private final String[] locationIconPaths;

    /**
     * Constructs the LogicGridBoard.
     *
     * @param activeCase the active case containing entities
     * @param suspectIconPaths paths to suspect icons
     * @param weaponIconPaths paths to weapon icons
     * @param locationIconPaths paths to location icons
     */
    public LogicGridBoard(final CaseFile activeCase,
                          final String[] suspectIconPaths,
                          final String[] weaponIconPaths,
                          final String[] locationIconPaths)
    {
        super();

        this.activeCase        = activeCase;
        this.suspectIconPaths  = suspectIconPaths;
        this.weaponIconPaths   = weaponIconPaths;
        this.locationIconPaths = locationIconPaths;

        this.logicGridButtons = new Button[GRID_SIZE_DIMENSION][GRID_SIZE_DIMENSION];
        this.observers        = new ArrayList<>();

        this.getStyleClass()
            .add("logic-grid");

        populateHeaders();
        populateButtons();
    }

    /**
     * Adds an observer to be notified of deduction changes.
     *
     * @param observer the observer to add
     */
    public void addObserver(final GridObserver observer)
    {
        if (observer != null)
        {
            this.observers.add(observer);
        }
    }

    /*
     * Notifies all observers that a deduction update has occurred.
     */
    private void notifyObservers(final String who,
                                 final String what,
                                 final String when)
    {
        for (final GridObserver observer : observers)
        {
            observer.onDeductionUpdated(who,
                                        what,
                                        when);
        }
    }

    /*
     * Populates the grid axes with visual headers (icons).
     */
    private void populateHeaders()
    {
        for (int index = 0; index < REGION_SIZE; index++)
        {
            final Image suspectImg;
            final Image weaponImg;
            final Image locTopImg;
            final Image locSideImg;

            final ImageView suspectIcon;
            final ImageView weaponIcon;
            final ImageView locationIconTop;
            final ImageView locationIconSide;

            suspectImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream(suspectIconPaths[index])));
            weaponImg  = new Image(Objects.requireNonNull(getClass().getResourceAsStream(weaponIconPaths[index])));
            locTopImg  = new Image(Objects.requireNonNull(getClass().getResourceAsStream(locationIconPaths[index])));
            locSideImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream(locationIconPaths[index])));

            suspectIcon      = new ImageView(suspectImg);
            weaponIcon       = new ImageView(weaponImg);
            locationIconTop  = new ImageView(locTopImg);
            locationIconSide = new ImageView(locSideImg);

            suspectIcon.setFitWidth(ICON_SIZE_PIXELS);
            suspectIcon.setFitHeight(ICON_SIZE_PIXELS);
            weaponIcon.setFitWidth(ICON_SIZE_PIXELS);
            weaponIcon.setFitHeight(ICON_SIZE_PIXELS);
            locationIconTop.setFitWidth(ICON_SIZE_PIXELS);
            locationIconTop.setFitHeight(ICON_SIZE_PIXELS);
            locationIconSide.setFitWidth(ICON_SIZE_PIXELS);
            locationIconSide.setFitHeight(ICON_SIZE_PIXELS);

            GridPane.setHalignment(suspectIcon,
                                   HPos.CENTER);
            GridPane.setHalignment(locationIconTop,
                                   HPos.CENTER);
            GridPane.setHalignment(weaponIcon,
                                   HPos.CENTER);
            GridPane.setHalignment(locationIconSide,
                                   HPos.CENTER);

            this.add(suspectIcon,
                     index + OFFSET_GRID_LABELS,
                     INDEX_HEADER_AXIS);
            this.add(locationIconTop,
                     index + REGION_SIZE + OFFSET_GRID_LABELS,
                     INDEX_HEADER_AXIS);
            this.add(weaponIcon,
                     INDEX_HEADER_AXIS,
                     index + OFFSET_GRID_LABELS);
            this.add(locationIconSide,
                     INDEX_HEADER_AXIS,
                     index + REGION_SIZE + OFFSET_GRID_LABELS);
        }
    }

    /*
     * Populates the grid with interactive buttons and safely handles click states.
     * Eliminates "continue" keywords to adhere to strict single-entry/single-exit rules.
     */
    private void populateButtons()
    {
        for (int rowNumber = 0; rowNumber < GRID_SIZE_DIMENSION; rowNumber++)
        {
            for (int columnNumber = 0; columnNumber < GRID_SIZE_DIMENSION; columnNumber++)
            {
                if (rowNumber < OFFSET_BOTTOM_LEFT_ROW || columnNumber < OFFSET_TOP_RIGHT_COL)
                {
                    final Button cellButton;
                    cellButton = new Button(STATE_EMPTY);

                    cellButton.getStyleClass()
                              .addAll("grid-button",
                                      "grid-button-empty");

                    cellButton.setOnAction(event ->
                                           {
                                               final String currentText;
                                               currentText = cellButton.getText();

                                               if (currentText.equals(STATE_EMPTY))
                                               {
                                                   cellButton.setText(STATE_IMPOSSIBLE);
                                                   cellButton.getStyleClass()
                                                             .remove("grid-button-empty");
                                                   cellButton.getStyleClass()
                                                             .add("grid-button-impossible");
                                               }
                                               else if (currentText.equals(STATE_IMPOSSIBLE))
                                               {
                                                   cellButton.setText(STATE_CONFIRMED);
                                                   cellButton.getStyleClass()
                                                             .remove("grid-button-impossible");
                                                   cellButton.getStyleClass()
                                                             .add("grid-button-confirmed");
                                                   updateDeductions();
                                               }
                                               else
                                               {
                                                   cellButton.setText(STATE_EMPTY);
                                                   cellButton.getStyleClass()
                                                             .remove("grid-button-confirmed");
                                                   cellButton.getStyleClass()
                                                             .add("grid-button-empty");
                                                   updateDeductions();
                                               }
                                           });

                    logicGridButtons[rowNumber][columnNumber] = cellButton;
                    this.add(cellButton,
                             columnNumber + OFFSET_GRID_LABELS,
                             rowNumber + OFFSET_GRID_LABELS);
                }
            }
        }
    }

    /*
     * Scans the grid for confirmed connections and triggers updates via the Observer Pattern.
     */
    private void updateDeductions()
    {
        final List<Suspect> suspects;
        final List<Weapon> weapons;
        final List<Location> locations;

        String who;
        String what;
        String when;

        who  = STATE_EMPTY;
        what = STATE_EMPTY;
        when = STATE_EMPTY;

        suspects  = activeCase.getSuspectList();
        weapons   = activeCase.getWeaponList();
        locations = activeCase.getLocationList();

        for (int row = OFFSET_TOP_LEFT_ROW; row < REGION_SIZE; row++)
        {
            for (int col = OFFSET_TOP_LEFT_COL; col < REGION_SIZE; col++)
            {
                final Button button;
                button = logicGridButtons[row][col];

                if (button != null && button.getText()
                                            .equals(STATE_CONFIRMED))
                {
                    who  = suspects.get(col)
                                   .getName();
                    what = weapons.get(row)
                                  .getName();
                }
            }
        }

        for (int row = OFFSET_TOP_RIGHT_ROW; row < REGION_SIZE; row++)
        {
            for (int col = OFFSET_TOP_RIGHT_COL; col < REGION_SIZE + OFFSET_TOP_RIGHT_COL; col++)
            {
                final Button button;
                button = logicGridButtons[row][col];

                if (button != null && button.getText()
                                            .equals(STATE_CONFIRMED))
                {
                    what = weapons.get(row)
                                  .getName();
                    when = locations.get(col - OFFSET_TOP_RIGHT_COL)
                                    .getName();
                }
            }
        }

        for (int row = OFFSET_BOTTOM_LEFT_ROW; row < REGION_SIZE + OFFSET_BOTTOM_LEFT_ROW; row++)
        {
            for (int col = OFFSET_BOTTOM_LEFT_COL; col < REGION_SIZE; col++)
            {
                final Button button;
                button = logicGridButtons[row][col];

                if (button != null && button.getText()
                                            .equals(STATE_CONFIRMED))
                {
                    when = locations.get(row - OFFSET_BOTTOM_LEFT_ROW)
                                    .getName();
                    who  = suspects.get(col)
                                   .getName();
                }
            }
        }

        notifyObservers(who,
                        what,
                        when);
    }
}