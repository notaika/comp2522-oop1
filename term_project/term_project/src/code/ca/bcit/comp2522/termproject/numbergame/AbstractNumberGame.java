package ca.bcit.comp2522.termproject.numbergame;

import javafx.application.Application;

/**
 * Represents all data logic and manages state for Number Game.
 * Implements Scorable interface to track cumulative session stats.
 * Extends Application for an interactive JavaFX GUI.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public abstract class AbstractNumberGame
        extends Application
        implements Scorable
{
    private static final int    MINIMUM_PLACEMENTS = 0;
    private static final int    INITIAL_COUNT      = 0;
    private static final double ZERO_AVERAGE       = 0.0;

    private static final String SUMMARY_FORMAT = "You won %d out of %d games and you lost %d out of %d games, with %d successful placements, an average of %.2f per game.";

    private int totalWins;
    private int totalLosses;
    private int totalSuccessfulPlacements;

    /**
     * Constructs and initializes the AbstractNumberGame with initial statistics.
     */
    protected AbstractNumberGame()
    {
        this.totalWins                 = INITIAL_COUNT;
        this.totalLosses               = INITIAL_COUNT;
        this.totalSuccessfulPlacements = INITIAL_COUNT;
    }

    /*
     * Validates that the given number of placements is not negative.
     *
     * @param placementsToValidate the integer representing placements made
     * @throws IllegalArgumentException if the placements value is invalid
     */
    private static void validatePlacements(final int placementsToValidate)
    {
        if (placementsToValidate < MINIMUM_PLACEMENTS)
        {
            throw new IllegalArgumentException("ERROR: Successful placements cannot be below minimum.");
        }
    }

    /**
     * Records a winning session and adds the placements to the session total.
     * Child classes cannot alter the core recording behaviour.
     *
     * @param successfulPlacements the number of valid number placements made in the round
     */
    @Override
    public final void recordWin(final int successfulPlacements)
    {
        validatePlacements(successfulPlacements);

        this.totalWins++;
        this.totalSuccessfulPlacements += successfulPlacements;
    }

    /**
     * Records a lost session and adds the placements to the session total.
     * Child classes cannot alter the core recording behaviour.
     *
     * @param successfulPlacements the number of valid number placements made in the round before losing
     */
    @Override
    public final void recordLoss(final int successfulPlacements)
    {
        validatePlacements(successfulPlacements);

        this.totalLosses++;
        this.totalSuccessfulPlacements += successfulPlacements;
    }

    /**
     * Generates and returns a formatted summary of the session's cumulative score statistics.
     * Marked final to ensure uniform score reporting formatting.
     *
     * @return the formatted score summary as a String
     */
    @Override
    public final String getScoreSummary()
    {
        final int totalGamesPlayed;
        final double averagePlacementsPerGame;
        final StringBuilder summaryBuilder;

        totalGamesPlayed = totalWins + totalLosses;
        summaryBuilder   = new StringBuilder();

        if (totalGamesPlayed > INITIAL_COUNT)
        {
            averagePlacementsPerGame = (double) totalSuccessfulPlacements / totalGamesPlayed;
        }
        else
        {
            averagePlacementsPerGame = ZERO_AVERAGE;
        }

        if (totalWins > INITIAL_COUNT)
        {
            final String gameWord;
            gameWord = (totalGamesPlayed == 1) ? "game" : "games";
            summaryBuilder.append("You won ")
                          .append(totalWins)
                          .append(" out of ")
                          .append(totalGamesPlayed)
                          .append(" ")
                          .append(gameWord);
        }

        if (totalWins > INITIAL_COUNT && totalLosses > INITIAL_COUNT)
        {
            summaryBuilder.append(" and ");
        }

        if (totalLosses > INITIAL_COUNT)
        {
            final String gameWord;
            gameWord = (totalGamesPlayed == 1) ? "game" : "games";
            summaryBuilder.append("You lost ")
                          .append(totalLosses)
                          .append(" out of ")
                          .append(totalGamesPlayed)
                          .append(" ")
                          .append(gameWord);
        }

        summaryBuilder.append(String.format(", with %d successful placements, an average of %.2f per game.",
                                            totalSuccessfulPlacements,
                                            averagePlacementsPerGame));

        return summaryBuilder.toString();
    }
}
