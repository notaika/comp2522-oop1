package ca.bcit.comp2522.termproject.singletonfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Handles all file reading and data loading for the game.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public final class GameDataLoader
{
    private static final String DIRECTORY_SOURCE          = "src";
    private static final String DIRECTORY_DATA            = "data";
    private static final String DIRECTORY_SINGLETON_FILES = "singletonfiles";

    /*
     * Private constructor to prevent instantiation of a utility class.
     */
    private GameDataLoader()
    {
    }

    /**
     * Parses an entity file using the Factory pattern and populates the appropriate lists.
     *
     * @param fileName the name of the file to read
     * @param suspectList the master list of suspects to populate
     * @param weaponList the master list of weapons to populate
     * @param locationList the master list of locations to populate
     */
    public static void loadEntities(final String fileName,
                                    final List<Suspect> suspectList,
                                    final List<Weapon> weaponList,
                                    final List<Location> locationList)
    {
        final Path filePath;
        filePath = Paths.get(DIRECTORY_SOURCE,
                             DIRECTORY_DATA,
                             DIRECTORY_SINGLETON_FILES,
                             fileName);

        try (final BufferedReader fileReader = Files.newBufferedReader(filePath))
        {
            String currentLine;
            currentLine = fileReader.readLine();

            while (currentLine != null)
            {
                final Entity parsedEntity;
                parsedEntity = EntityFactory.createEntity(currentLine);

                if (parsedEntity instanceof Suspect)
                {
                    suspectList.add((Suspect) parsedEntity);
                }
                else if (parsedEntity instanceof Weapon)
                {
                    weaponList.add((Weapon) parsedEntity);
                }
                else if (parsedEntity instanceof Location)
                {
                    locationList.add((Location) parsedEntity);
                }

                currentLine = fileReader.readLine();
            }
        }
        catch (final IOException fileException)
        {
            throw new RuntimeException("ERROR: Failed to read file " + fileName,
                                       fileException);
        }
    }

    /**
     * Parses a raw text file line-by-line into a destination list.
     *
     * @param fileName the name of the file to read
     * @param destinationList the list to populate with the file's lines
     */
    public static void loadRawStrings(final String fileName,
                                      final List<String> destinationList)
    {
        final Path filePath;
        filePath = Paths.get(DIRECTORY_SOURCE,
                             DIRECTORY_DATA,
                             DIRECTORY_SINGLETON_FILES,
                             fileName);

        try (final BufferedReader stringReader = Files.newBufferedReader(filePath))
        {
            String currentLine;
            currentLine = stringReader.readLine();

            while (currentLine != null)
            {
                destinationList.add(currentLine);
                currentLine = stringReader.readLine();
            }
        }
        catch (final IOException fileException)
        {
            throw new RuntimeException("ERROR: Failed to read string file " + fileName,
                                       fileException);
        }
    }
}