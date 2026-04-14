package ca.bcit.comp2522.termproject.singletonfiles;

import java.util.List;

/**
 * Temporary runner class to test implementations.
 * Tests GameManager's unseen case filtering and SaveManager persistence.
 *
 * @author Aika Manalo - Set 2C
 * @version 3.0
 */
public final class SingletonMain
{
    private static final String TEST_PLAYER_NAME = "CLI Test Detective";

    /**
     * Main entry point for the temporary diagnostic runner.
     *
     * @param arguments unused
     */
    public static void main(final String[] arguments)
    {
        final GameManager manager;
        final Player testPlayer;
        final CaseFile testCase;
        final List<Suspect> suspects;
        final List<Weapon> weapons;
        final List<Location> locations;
        final List<String> clues;
        final List<String> hints;

        System.out.println("--- INITIALIZING GAME MANAGER & LOADING FILES ---");
        manager = GameManager.getInstance();
        manager.loadAllEntities();

        System.out.println("--- LOADING PLAYER SAVE DATA ---");
        testPlayer = new Player(TEST_PLAYER_NAME);
        SaveManager.loadPlayerStats(testPlayer);

        System.out.println("Previously Seen Cases: " + testPlayer.getSeenCasesList());

        System.out.println("--- FETCHING NEXT UNSEEN CASE ---");
        testCase = manager.getNextUnseenCase(testPlayer);

        if (testCase == null)
        {
            System.out.println("\nNO CASES HAVE BEEN FILED. ALL CASES COMPLETED.");
            return;
        }

        suspects = testCase.getSuspectList();
        weapons = testCase.getWeaponList();
        locations = testCase.getLocationList();
        clues = testCase.getInitialCluesList();
        hints = testCase.getLockedHintsList();

        System.out.println("\nCASE IDENTIFIER: " + testCase.getCaseIdentifier());

        System.out.println("\n--- SUSPECTS ---");
        for (final Suspect suspect : suspects)
        {
            System.out.println("Name: " + suspect.getName() +
                               " | Alibi: " + suspect.getAlibi() +
                               " | Innocent: " + suspect.getInnocent());
        }

        System.out.println("\n--- WEAPONS ---");
        for (final Weapon weapon : weapons)
        {
            System.out.println("Name: " + weapon.getName() +
                               " | Murder Weapon: " + weapon.getMurderWeapon());
        }

        System.out.println("\n--- LOCATIONS ---");
        for (final Location location : locations)
        {
            System.out.println("Name: " + location.getName() +
                               " | Murder Location: " + location.getMurderLocation());
        }

        System.out.println("\n--- CLUES ---");
        for (final String clue : clues)
        {
            System.out.println("- " + clue);
        }

        System.out.println("\n--- HINTS ---");
        for (final String hint : hints)
        {
            System.out.println("- " + hint);
        }
    }
}