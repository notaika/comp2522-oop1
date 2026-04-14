package ca.bcit.comp2522.termproject.singletonfiles;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the human player in the game.
 * Extends Entity and tracks gameplay statistics and the history of seen case files.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.4
 */
public final class Player
        extends Entity
{
    private static final int    INITIAL_STATISTIC_VALUE = 0;
    private static final double RATING_MULTIPLIER       = 5.0;
    private static final double ZERO_STATISTIC_DOUBLE   = 0.0;

    private       int          totalSuccessfulCases;
    private       int          totalFailedCases;
    private       int          totalHintsUsed;
    private final List<String> seenCasesList;

    /**
     * Constructs and initializes a Player with a name and zeroed statistics.
     *
     * @param name the name of the player as a String
     * @throws IllegalArgumentException if the name is invalid
     */
    public Player(final String name)
    {
        super(name);

        this.totalSuccessfulCases = INITIAL_STATISTIC_VALUE;
        this.totalFailedCases     = INITIAL_STATISTIC_VALUE;
        this.totalHintsUsed       = INITIAL_STATISTIC_VALUE;
        this.seenCasesList        = new ArrayList<>();
    }

    /**
     * Increments the total number of successfully solved cases.
     */
    public void incrementSuccessfulCases()
    {
        this.totalSuccessfulCases++;
    }

    /**
     * Increments the total number of failed cases.
     */
    public void incrementFailedCases()
    {
        this.totalFailedCases++;
    }

    /**
     * Increments the total number of hints used by the player.
     */
    public void incrementHintsUsed()
    {
        this.totalHintsUsed++;
    }

    /**
     * Sets the total successful cases.
     *
     * @param successfulCasesCount the count to set
     */
    public void setTotalSuccessfulCases(final int successfulCasesCount)
    {
        this.totalSuccessfulCases = successfulCasesCount;
    }

    /**
     * Sets the total failed cases.
     *
     * @param failedCasesCount the count to set
     */
    public void setTotalFailedCases(final int failedCasesCount)
    {
        this.totalFailedCases = failedCasesCount;
    }

    /**
     * Sets the total hints used.
     *
     * @param hintsUsedCount the count to set
     */
    public void setTotalHintsUsed(final int hintsUsedCount)
    {
        this.totalHintsUsed = hintsUsedCount;
    }

    /**
     * Adds a case identifier to the list of seen cases.
     *
     * @param caseIdentifier the case ID as a String
     */
    public void addSeenCase(final String caseIdentifier)
    {
        if (caseIdentifier != null && !caseIdentifier.isBlank())
        {
            this.seenCasesList.add(caseIdentifier);
        }
    }

    /**
     * Checks if a case identifier has already been seen by the player.
     *
     * @param caseIdentifier the case ID as a String
     * @return true if the case has been seen, false otherwise
     */
    public boolean hasSeenCase(final String caseIdentifier)
    {
        return this.seenCasesList.contains(caseIdentifier);
    }

    /**
     * Calculates and returns the player's rating out of 5.0.
     *
     * @return the rating out of 5.0 as a double
     */
    public double calculateRatingOutOfFive()
    {
        final double totalCasesCount;
        final double ratingValue;

        totalCasesCount = (double) totalSuccessfulCases + totalFailedCases;

        if (totalCasesCount == INITIAL_STATISTIC_VALUE)
        {
            return ZERO_STATISTIC_DOUBLE;
        }

        ratingValue = (totalSuccessfulCases / totalCasesCount) * RATING_MULTIPLIER;

        return ratingValue;
    }

    /**
     * Returns the total successful cases.
     *
     * @return the successful cases count as an int
     */
    public int getTotalSuccessfulCases()
    {
        return totalSuccessfulCases;
    }

    /**
     * Returns the total failed cases.
     *
     * @return the failed cases count as an int
     */
    public int getTotalFailedCases()
    {
        return totalFailedCases;
    }

    /**
     * Returns the total hints used.
     *
     * @return the hints used count as an int
     */
    public int getTotalHintsUsed()
    {
        return totalHintsUsed;
    }

    /**
     * Returns a defensive copy of the seen cases list.
     *
     * @return the list of seen case strings
     */
    public List<String> getSeenCasesList()
    {
        final List<String> listCopy;
        listCopy = new ArrayList<>(seenCasesList);
        return listCopy;
    }

    /**
     * Returns a formatted string of the player's public details.
     *
     * @return the details as a String
     */
    @Override
    public String getDetails()
    {
        final String ratingString;
        ratingString = String.format("%.2f",
                                     calculateRatingOutOfFive());

        return "Rank: Detective\n> Cases Solved: " + totalSuccessfulCases + " | Rating: " + ratingString + " ★";
    }
}