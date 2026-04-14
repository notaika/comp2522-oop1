package ca.bcit.comp2522.termproject.singletonfiles;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the data for a single mystery case.
 * Contains the specific entities and clues required to solve the logic puzzle.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public final class CaseFile
{
    private static final int TOTAL_SUSPECTS      = 3;
    private static final int TOTAL_WEAPONS       = 3;
    private static final int TOTAL_LOCATIONS     = 3;
    private static final int TOTAL_INITIAL_CLUES = 5;
    private static final int TOTAL_LOCKED_HINTS  = 2;

    private final String         caseIdentifier;
    private final List<Suspect>  suspectList;
    private final List<Weapon>   weaponList;
    private final List<Location> locationList;
    private final List<String>   initialCluesList;
    private final List<String>   lockedHintsList;

    private boolean solved;

    /**
     * Constructs and initializes a CaseFile with strict size requirements for its lists.
     *
     * @param caseIdentifier the unique identifier for this case as a String
     * @param suspectList a list of Suspects
     * @param weaponList a list of Weapons
     * @param locationList a list of Locations
     * @param initialCluesList a list of initial clues
     * @param lockedHintsList a list of locked hints
     * @throws IllegalArgumentException if any validation fails
     */
    public CaseFile(final String caseIdentifier,
                    final List<Suspect> suspectList,
                    final List<Weapon> weaponList,
                    final List<Location> locationList,
                    final List<String> initialCluesList,
                    final List<String> lockedHintsList)
    {
        validateCaseIdentifier(caseIdentifier);
        validateListSize(suspectList,
                         TOTAL_SUSPECTS,
                         "Suspects");
        validateListSize(weaponList,
                         TOTAL_WEAPONS,
                         "Weapons");
        validateListSize(locationList,
                         TOTAL_LOCATIONS,
                         "Locations");
        validateListSize(initialCluesList,
                         TOTAL_INITIAL_CLUES,
                         "Initial Clues");
        validateListSize(lockedHintsList,
                         TOTAL_LOCKED_HINTS,
                         "Locked Hints");

        this.caseIdentifier = caseIdentifier;

        this.suspectList      = new ArrayList<>(suspectList);
        this.weaponList       = new ArrayList<>(weaponList);
        this.locationList     = new ArrayList<>(locationList);
        this.initialCluesList = new ArrayList<>(initialCluesList);
        this.lockedHintsList  = new ArrayList<>(lockedHintsList);

        this.solved = false;
    }

    /*
     * Validates that the case identifier valid.
     *
     * @param identifierToValidate the identifier to validate
     * @throws IllegalArgumentException if the value is invalid
     */
    private static void validateCaseIdentifier(final String identifierToValidate)
    {
        if (identifierToValidate == null || identifierToValidate.isBlank())
        {
            throw new IllegalArgumentException("ERROR: Case identifier is invalid.");
        }
    }

    /*
     * Validates that a generic list is not null and exactly matches the required size.
     *
     * @param listToValidate the list to validate
     * @param requiredSize the given size it must be
     * @param listName the name of the list to validate
     * @throws IllegalArgumentException if the value is invalid
     */
    private static void validateListSize(final List<?> listToValidate,
                                         final int requiredSize,
                                         final String listName)
    {
        if (listToValidate == null)
        {
            throw new IllegalArgumentException("ERROR: " + listName + " list size is invalid.");
        }

        if (listToValidate.size() != requiredSize)
        {
            throw new IllegalArgumentException("ERROR: " + listName + " list must contain exactly " +
                                               requiredSize + " elements.");
        }
    }

    /**
     * Returns the case identifier.
     *
     * @return the identifier as a String
     */
    public String getCaseIdentifier()
    {
        return caseIdentifier;
    }

    /**
     * Returns the solved state of the case.
     *
     * @return true if solved, false otherwise
     */
    public boolean getSolved()
    {
        return solved;
    }

    /**
     * Sets the solved state of the case.
     *
     * @param solved the new solved state
     */
    public void setSolved(final boolean solved)
    {
        this.solved = solved;
    }

    /**
     * Returns a defensive copy of the suspect list.
     *
     * @return the list of Suspects
     */
    public List<Suspect> getSuspectList()
    {
        final List<Suspect> copy;
        copy = new ArrayList<>(suspectList);
        return copy;
    }

    /**
     * Returns a defensive copy of the weapon list.
     *
     * @return the list of Weapons
     */
    public List<Weapon> getWeaponList()
    {
        final List<Weapon> copy;
        copy = new ArrayList<>(weaponList);
        return copy;
    }

    /**
     * Returns a defensive copy of the location list.
     *
     * @return the list of Locations
     */
    public List<Location> getLocationList()
    {
        final List<Location> copy;
        copy = new ArrayList<>(locationList);
        return copy;
    }

    /**
     * Returns a defensive copy of the initial clues list.
     *
     * @return the list of initial clues as Strings
     */
    public List<String> getInitialCluesList()
    {
        final List<String> copy;
        copy = new ArrayList<>(initialCluesList);
        return copy;
    }

    /**
     * Returns a defensive copy of the locked hints list.
     *
     * @return the list of locked hints as Strings
     */
    public List<String> getLockedHintsList()
    {
        final List<String> copy;
        copy = new ArrayList<>(lockedHintsList);
        return copy;
    }
}
