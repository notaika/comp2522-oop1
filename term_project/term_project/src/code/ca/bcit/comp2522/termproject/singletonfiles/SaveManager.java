package ca.bcit.comp2522.termproject.singletonfiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Manages saving and loading player statistics and persistence history.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.1
 */
public final class SaveManager
{
    private static final String DIRECTORY_SOURCE          = "src";
    private static final String DIRECTORY_DATA            = "data";
    private static final String DIRECTORY_SINGLETON_FILES = "singletonfiles";
    private static final String FILE_NAME_SAVE            = "singleton_save.txt";
    private static final String SEEN_CASES_DELIMITER      = ",";

    /*
     * Private constructor to prevent instantiation.
     */
    private SaveManager()
    {
    }

    /**
     * Saves the player's statistics and case history to a file.
     *
     * @param playerToSave the Player object to save
     */
    public static void savePlayerStats(final Player playerToSave)
    {
        final Path saveFilePath;
        final String seenCasesString;

        saveFilePath    = Paths.get(DIRECTORY_SOURCE,
                                    DIRECTORY_DATA,
                                    DIRECTORY_SINGLETON_FILES,
                                    FILE_NAME_SAVE);
        seenCasesString = String.join(SEEN_CASES_DELIMITER,
                                      playerToSave.getSeenCasesList());

        try (final BufferedWriter fileWriter = Files.newBufferedWriter(saveFilePath))
        {
            fileWriter.write(String.valueOf(playerToSave.getTotalSuccessfulCases()));
            fileWriter.newLine();
            fileWriter.write(String.valueOf(playerToSave.getTotalFailedCases()));
            fileWriter.newLine();
            fileWriter.write(String.valueOf(playerToSave.getTotalHintsUsed()));
            fileWriter.newLine();
            fileWriter.write(seenCasesString);
            fileWriter.newLine();
        }
        catch (final IOException fileWriteException)
        {
            System.out.println("ERROR: Failed to save player stats.");
        }
    }

    /**
     * Loads the player's statistics and history from a file.
     *
     * @param playerToLoad the Player object to populate
     */
    public static void loadPlayerStats(final Player playerToLoad)
    {
        final Path saveFilePath;

        saveFilePath = Paths.get(DIRECTORY_SOURCE,
                                 DIRECTORY_DATA,
                                 DIRECTORY_SINGLETON_FILES,
                                 FILE_NAME_SAVE);

        if (Files.exists(saveFilePath))
        {
            try (final BufferedReader fileReader = Files.newBufferedReader(saveFilePath))
            {
                final String successfulLine;
                final String failedLine;
                final String hintsLine;
                final String seenCasesLine;

                successfulLine = fileReader.readLine();
                failedLine     = fileReader.readLine();
                hintsLine      = fileReader.readLine();
                seenCasesLine  = fileReader.readLine();

                if (successfulLine != null && failedLine != null && hintsLine != null)
                {
                    playerToLoad.setTotalSuccessfulCases(Integer.parseInt(successfulLine));
                    playerToLoad.setTotalFailedCases(Integer.parseInt(failedLine));
                    playerToLoad.setTotalHintsUsed(Integer.parseInt(hintsLine));
                }

                if (seenCasesLine != null && !seenCasesLine.isBlank())
                {
                    final String[] parsedCases;
                    parsedCases = seenCasesLine.split(SEEN_CASES_DELIMITER);

                    for (final String caseIdentifier : parsedCases)
                    {
                        final String trimmedId;
                        trimmedId = caseIdentifier.trim();

                        if (!trimmedId.isBlank())
                        {
                            playerToLoad.addSeenCase(trimmedId);
                        }
                    }
                }
            }
            catch (final IOException fileReadException)
            {
                System.out.println("ERROR: Failed to load player stats.");
            }
            catch (final NumberFormatException parseException)
            {
                System.out.println("ERROR: Corrupted save file data.");
            }
        }
    }
}
