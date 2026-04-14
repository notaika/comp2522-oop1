package ca.bcit.comp2522.termproject.singletonfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Centrally manages sequential case generation using the Singleton Pattern.
 *
 * @author Aika Manalo - Set 2C
 * @version 2.0
 */
public final class GameManager
{
    private static final int ENTITIES_PER_CASE = 3;
    private static final int CLUES_PER_CASE    = 5;
    private static final int HINTS_PER_CASE    = 2;

    private static final String FILE_NAME_SUSPECTS  = "suspects.txt";
    private static final String FILE_NAME_WEAPONS   = "weapons.txt";
    private static final String FILE_NAME_LOCATIONS = "locations.txt";
    private static final String FILE_NAME_CLUES     = "clues.txt";
    private static final String FILE_NAME_HINTS     = "hints.txt";
    private static final String FILE_NAME_CASE_IDS  = "case_ids.txt";

    private static GameManager instance;

    private final List<Suspect>  masterSuspectList;
    private final List<Weapon>   masterWeaponList;
    private final List<Location> masterLocationList;
    private final List<String>   masterClueList;
    private final List<String>   masterHintList;
    private final List<String>   masterCaseIdList;

    /*
     * Private constructor for Singleton initialization.
     */
    private GameManager()
    {
        this.masterSuspectList  = new ArrayList<>();
        this.masterWeaponList   = new ArrayList<>();
        this.masterLocationList = new ArrayList<>();
        this.masterClueList     = new ArrayList<>();
        this.masterHintList     = new ArrayList<>();
        this.masterCaseIdList   = new ArrayList<>();
    }

    /*
     * Retrieves a cohesive mystery case based on the provided index.
     * Randomizes the lists after assignment to obscure the solution.
     *
     * @param caseIndex the numerical index of the case to retrieve
     * @return a CaseFile containing cohesive entities and clues
     */
    private CaseFile getCaseByIndex(final int caseIndex)
    {
        final int entityStartIndex;
        final int clueStartIndex;
        final int hintStartIndex;
        final String caseIdentifier;
        final List<Suspect> chosenSuspects;
        final List<Weapon> chosenWeapons;
        final List<Location> chosenLocations;
        final List<String> chosenClues;
        final List<String> chosenHints;

        entityStartIndex = caseIndex * ENTITIES_PER_CASE;
        clueStartIndex   = caseIndex * CLUES_PER_CASE;
        hintStartIndex   = caseIndex * HINTS_PER_CASE;

        caseIdentifier = masterCaseIdList.get(caseIndex);

        chosenSuspects  = new ArrayList<>();
        chosenWeapons   = new ArrayList<>();
        chosenLocations = new ArrayList<>();
        chosenClues     = new ArrayList<>();
        chosenHints     = new ArrayList<>();

        for (int i = 0; i < ENTITIES_PER_CASE; i++)
        {
            final int currentEntityIndex;
            currentEntityIndex = entityStartIndex + i;

            chosenSuspects.add(masterSuspectList.get(currentEntityIndex));
            chosenWeapons.add(masterWeaponList.get(currentEntityIndex));
            chosenLocations.add(masterLocationList.get(currentEntityIndex));
        }

        for (int i = 0; i < CLUES_PER_CASE; i++)
        {
            final int currentClueIndex;
            currentClueIndex = clueStartIndex + i;
            chosenClues.add(masterClueList.get(currentClueIndex));
        }

        for (int i = 0; i < HINTS_PER_CASE; i++)
        {
            final int currentHintIndex;
            currentHintIndex = hintStartIndex + i;
            chosenHints.add(masterHintList.get(currentHintIndex));
        }

        Collections.shuffle(chosenSuspects);
        Collections.shuffle(chosenWeapons);
        Collections.shuffle(chosenLocations);

        return new CaseFile(caseIdentifier,
                            chosenSuspects,
                            chosenWeapons,
                            chosenLocations,
                            chosenClues,
                            chosenHints);
    }

    /**
     * Returns the global instance of the GameManager safely across multiple threads.
     *
     * @return the GameManager instance
     */
    public static GameManager getInstance()
    {
        if (instance == null)
        {
            synchronized (GameManager.class)
            {
                if (instance == null)
                {
                    instance = new GameManager();
                }
            }
        }
        return instance;
    }

    /**
     * Triggers the parsing of all text files via GameDataLoader to populate the master lists.
     */
    public void loadAllEntities()
    {
        GameDataLoader.loadEntities(FILE_NAME_SUSPECTS,
                                    masterSuspectList,
                                    masterWeaponList,
                                    masterLocationList);
        GameDataLoader.loadEntities(FILE_NAME_WEAPONS,
                                    masterSuspectList,
                                    masterWeaponList,
                                    masterLocationList);
        GameDataLoader.loadEntities(FILE_NAME_LOCATIONS,
                                    masterSuspectList,
                                    masterWeaponList,
                                    masterLocationList);

        GameDataLoader.loadRawStrings(FILE_NAME_CLUES,
                                      masterClueList);
        GameDataLoader.loadRawStrings(FILE_NAME_HINTS,
                                      masterHintList);
        GameDataLoader.loadRawStrings(FILE_NAME_CASE_IDS,
                                      masterCaseIdList);
    }

    /**
     * Retrieves the next cohesive mystery case that the player has not seen.
     *
     * @param activePlayer the current player
     * @return a CaseFile containing cohesive entities and clues, or null if all seen
     */
    public CaseFile getNextUnseenCase(final Player activePlayer)
    {
        for (int i = 0; i < masterCaseIdList.size(); i++)
        {
            final String currentCaseIdentifier;
            currentCaseIdentifier = masterCaseIdList.get(i);

            if (!activePlayer.hasSeenCase(currentCaseIdentifier))
            {
                return getCaseByIndex(i);
            }
        }
        return null;
    }
}