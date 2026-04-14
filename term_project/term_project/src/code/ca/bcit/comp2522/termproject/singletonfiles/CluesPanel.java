package ca.bcit.comp2522.termproject.singletonfiles;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * Encapsulates the Clues and Evidences UI component.
 * Extends AbstractGamePanel.
 *
 * @author Aika Manalo - Set 2C
 * @version 2.0
 */
public final class CluesPanel
        extends AbstractGamePanel
{
    private static final int INDEX_HINT_ONE = 0;
    private static final int INDEX_HINT_TWO = 1;

    private final CaseFile   activeCase;
    private final Player     activePlayer;
    private final StatsPanel statsPanel;

    /**
     * Constructs the CluesPanel.
     *
     * @param activeCase the current case file
     * @param activePlayer the current player
     * @param statsPanel the stats panel to update when hints are used
     */
    public CluesPanel(final CaseFile activeCase,
                      final Player activePlayer,
                      final StatsPanel statsPanel)
    {
        super("CLUES AND EVIDENCES");

        final Region spacer;
        final Button hintOneButton;
        final Button hintTwoButton;

        this.activeCase   = activeCase;
        this.activePlayer = activePlayer;
        this.statsPanel   = statsPanel;

        spacer        = new Region();
        hintOneButton = new Button("Hint 1");
        hintTwoButton = new Button("Hint 2");

        this.titleBar.getStyleClass()
                     .add("clues-title-bar");
        hintOneButton.getStyleClass()
                     .add("button");
        hintTwoButton.getStyleClass()
                     .add("button");

        hintOneButton.setOnAction(event -> revealHint(hintOneButton,
                                                      INDEX_HINT_ONE));
        hintTwoButton.setOnAction(event -> revealHint(hintTwoButton,
                                                      INDEX_HINT_TWO));

        HBox.setHgrow(spacer,
                      Priority.ALWAYS);

        this.titleBar.getChildren()
                     .addAll(spacer,
                             hintOneButton,
                             hintTwoButton);

        for (final String clue : activeCase.getInitialCluesList())
        {
            final Label clueLabel;
            clueLabel = new Label("• " + clue);
            clueLabel.getStyleClass()
                     .add("clue-bullet");
            this.getChildren()
                .add(clueLabel);
        }
    }

    /*
     * Reveals a locked hint if available and disables the button.
     */
    private void revealHint(final Button button,
                            final int index)
    {
        if (index < activeCase.getLockedHintsList()
                              .size())
        {
            final Alert hintAlert;
            hintAlert = new Alert(Alert.AlertType.INFORMATION);
            hintAlert.setTitle("Detective OS - Hint");
            hintAlert.setHeaderText(null);
            hintAlert.setContentText("EVIDENCE: " + activeCase.getLockedHintsList()
                                                              .get(index));
            hintAlert.showAndWait();
        }

        button.setDisable(true);
        activePlayer.incrementHintsUsed();
        statsPanel.refreshStats();
    }
}