package ca.bcit.comp2522.termproject.numbergame;

/**
 * Defines the scoring contract for a number-based placement game.
 * Tracks wins, losses, and successful placements across multiple rounds.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public interface Scorable
{
    /**
     * Records a victorious game round and the number of successful placements made.
     *
     * @param successfulPlacements the number of valid number placements made in the round
     */
    void recordWin(final int successfulPlacements);

    /**
     * Records a lost game round and the number of successful placements made.
     *
     * @param successfulPlacements the number of valid number placements made in the round before losing
     */
    void recordLoss(final int successfulPlacements);

    /**
     * Generates and returns a formatted summary of the session's cumulative score statistics.
     *
     * @return the formatted score summary as a String
     */
    String getScoreSummary();
}
