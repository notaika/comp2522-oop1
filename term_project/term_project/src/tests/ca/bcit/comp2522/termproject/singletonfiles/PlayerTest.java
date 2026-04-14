package ca.bcit.comp2522.termproject.singletonfiles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PlayerTest
{
    private static final String TEST_PLAYER_NAME      = "Test Detective";
    private static final String TEST_CASE_ID_ONE      = "M-001";
    private static final String TEST_CASE_ID_TWO      = "X-999";
    private static final String INVALID_BLANK_CASE_ID = "   ";

    private static final int    WINS_PERFECT            = 5;
    private static final int    LOSSES_PERFECT          = 0;
    private static final double EXPECTED_RATING_PERFECT = 5.0;

    private static final int    WINS_HALF            = 1;
    private static final int    LOSSES_HALF          = 1;
    private static final double EXPECTED_RATING_HALF = 2.5;

    private static final int    WINS_ZERO            = 0;
    private static final int    LOSSES_ZERO          = 0;
    private static final double EXPECTED_RATING_ZERO = 0.0;

    private static final int EXPECTED_LIST_SIZE_ONE     = 1;
    private static final int EXPECTED_LIST_SIZE_ZERO    = 0;
    private static final int EXPECTED_INCREMENTED_VALUE = 1;

    private static final String EXPECTED_DETAILS_PERFECT = "Rank: Detective\n> Cases Solved: 5 | Rating: 5.00 ★";

    private Player testPlayer;

    @BeforeEach
    void setUp()
    {
        this.testPlayer = new Player(TEST_PLAYER_NAME);
    }

    @Test
    void testCalculateRatingPerfectScore()
    {
        final double actualRating;

        testPlayer.setTotalSuccessfulCases(WINS_PERFECT);
        testPlayer.setTotalFailedCases(LOSSES_PERFECT);
        actualRating = testPlayer.calculateRatingOutOfFive();

        assertEquals(EXPECTED_RATING_PERFECT,
                     actualRating);
    }

    @Test
    void testCalculateRatingHalfScore()
    {
        final double actualRating;

        testPlayer.setTotalSuccessfulCases(WINS_HALF);
        testPlayer.setTotalFailedCases(LOSSES_HALF);
        actualRating = testPlayer.calculateRatingOutOfFive();

        assertEquals(EXPECTED_RATING_HALF,
                     actualRating);
    }

    @Test
    void testCalculateRatingZeroGamesPlayed()
    {
        final double actualRating;

        testPlayer.setTotalSuccessfulCases(WINS_ZERO);
        testPlayer.setTotalFailedCases(LOSSES_ZERO);
        actualRating = testPlayer.calculateRatingOutOfFive();

        assertEquals(EXPECTED_RATING_ZERO,
                     actualRating);
    }

    @Test
    void testAddSeenCaseValidCaseAddsToList()
    {
        final boolean hasSeenCase;
        final List<String> seenCases;

        testPlayer.addSeenCase(TEST_CASE_ID_ONE);
        hasSeenCase = testPlayer.hasSeenCase(TEST_CASE_ID_ONE);
        seenCases   = testPlayer.getSeenCasesList();

        assertTrue(hasSeenCase);
        assertEquals(EXPECTED_LIST_SIZE_ONE,
                     seenCases.size());
    }

    @Test
    void testAddSeenCaseBlankCaseIgnored()
    {
        final List<String> seenCases;

        testPlayer.addSeenCase(INVALID_BLANK_CASE_ID);
        testPlayer.addSeenCase(null);
        seenCases = testPlayer.getSeenCasesList();

        assertEquals(EXPECTED_LIST_SIZE_ZERO,
                     seenCases.size());
    }

    @Test
    void testHasSeenCaseUnseenCaseReturnsFalse()
    {
        final boolean hasSeenCase;

        testPlayer.addSeenCase(TEST_CASE_ID_ONE);
        hasSeenCase = testPlayer.hasSeenCase(TEST_CASE_ID_TWO);

        assertFalse(hasSeenCase);
    }

    @Test
    void testIncrementsUpdateStatisticsCorrectly()
    {
        testPlayer.incrementSuccessfulCases();
        testPlayer.incrementFailedCases();
        testPlayer.incrementHintsUsed();

        assertEquals(EXPECTED_INCREMENTED_VALUE,
                     testPlayer.getTotalSuccessfulCases());
        assertEquals(EXPECTED_INCREMENTED_VALUE,
                     testPlayer.getTotalFailedCases());
        assertEquals(EXPECTED_INCREMENTED_VALUE,
                     testPlayer.getTotalHintsUsed());
    }

    @Test
    void testGetDetailsFormatsCorrectly()
    {
        final String actualDetails;

        testPlayer.setTotalSuccessfulCases(WINS_PERFECT);
        testPlayer.setTotalFailedCases(LOSSES_PERFECT);
        actualDetails = testPlayer.getDetails();

        assertEquals(EXPECTED_DETAILS_PERFECT,
                     actualDetails);
    }
}
