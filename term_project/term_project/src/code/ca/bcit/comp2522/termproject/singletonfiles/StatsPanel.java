package ca.bcit.comp2522.termproject.singletonfiles;

import javafx.scene.control.Label;

/**
 * Represents the Stats Box UI component.
 * Extends AbstractGamePanel.
 *
 * @author Aika Manalo - Set 2C
 * @version 2.0
 */
public final class StatsPanel
        extends AbstractGamePanel
{
    private final Player activePlayer;
    private final Label  ratingLabel;
    private final Label  solvedLabel;
    private final Label  unsuccessfulLabel;
    private final Label  hintsUsedLabel;

    /**
     * Constructs the StatsPanel.
     *
     * @param activePlayer the current player
     */
    public StatsPanel(final Player activePlayer)
    {
        super("DETECTIVE STATS");

        this.activePlayer      = activePlayer;
        this.ratingLabel       = new Label();
        this.solvedLabel       = new Label();
        this.unsuccessfulLabel = new Label();
        this.hintsUsedLabel    = new Label();

        this.getChildren()
            .addAll(ratingLabel,
                    solvedLabel,
                    unsuccessfulLabel,
                    hintsUsedLabel);
    }

    /**
     * Refreshes the text of the stat labels based on the player's current data.
     */
    public void refreshStats()
    {
        final String rating;
        rating = String.format("%.2f",
                               activePlayer.calculateRatingOutOfFive());

        ratingLabel.setText("Rating: " + rating + " ★");
        solvedLabel.setText("Cases Solved: " + activePlayer.getTotalSuccessfulCases());
        unsuccessfulLabel.setText("Cases Failed: " + activePlayer.getTotalFailedCases());
        hintsUsedLabel.setText("Hints Used: " + activePlayer.getTotalHintsUsed());
    }
}