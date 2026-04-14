package ca.bcit.comp2522.termproject.wordgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents the countries that are a part of the trivia game.
 * Handles loading data from text files and randomizes entries.
 *
 * @author Aika Manalo - Set 2C
 * @version 2.1
 */
public final class World
{
    private static final String DIR_SRC = "src";
    private static final String DIR_DATA = "res/numbergame";
    private static final String FILE_EXTENSION = ".txt";

    private static final char ALPHABET_START = 'a';
    private static final char ALPHABET_END = 'z';
    private static final char VALUE_DELIMITER = ':';

    private static final int START_INDEX = 0;
    private static final int NUM_FACTS = 3;
    private static final int COLON_INDEX_OFFSET = 1;
    private static final int FACT_LINE_OFFSET = 1;
    private static final int INDEX_NOT_FOUND = -1;

    private final Map<String, Country> countries;
    private final Random random;

    /**
     * Constructs and initializes the World by loading country data.
     */
    public World()
    {
        this.countries = new HashMap<>();
        this.random = new Random();
        loadAllCountries();
    }

    /*
     * Iterates through files a.txt to z.txt and loads game data.
     */
    private void loadAllCountries()
    {
        for (char letter = ALPHABET_START; letter <= ALPHABET_END; letter++)
        {
            final String filename;
            filename = letter + FILE_EXTENSION;
            loadFile(filename);
        }
    }

    /*
     * Parses a single text file and populates the countries map.
     *
     * @param filename the file to load
     */
    private void loadFile(final String filename)
    {
        final Path path;
        final List<String> allLines;

        path = Paths.get(DIR_SRC, DIR_DATA, filename);

        if (Files.notExists(path))
        {
            return;
        }

        allLines = new ArrayList<>();

        try (final BufferedReader reader = Files.newBufferedReader(path))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                allLines.add(line);
            }
            parseLines(allLines);
        }
        catch (final IOException e)
        {
            throw new RuntimeException("ERROR: Could not read " + filename, e);
        }
    }

    /*
     * Parses the list of strings into Country objects without using break/continue.
     *
     * @param lines the raw text lines from the file
     */
    private void parseLines(final List<String> lines)
    {
        for (int i = 0; i < lines.size(); i++)
        {
            final String line;
            line = lines.get(i).trim();

            if (!line.isEmpty())
            {
                final int colonIndex;
                colonIndex = line.indexOf(VALUE_DELIMITER);

                if (colonIndex != INDEX_NOT_FOUND)
                {
                    final String countryName;
                    final String capitalName;
                    final String[] facts;

                    countryName = line.substring(START_INDEX, colonIndex).trim();
                    capitalName = line.substring(colonIndex + COLON_INDEX_OFFSET).trim();

                    facts = new String[NUM_FACTS];

                    for (int f = 0; f < NUM_FACTS; f++)
                    {
                        if (i + FACT_LINE_OFFSET + f < lines.size())
                        {
                            facts[f] = lines.get(i + FACT_LINE_OFFSET + f).trim();
                        }
                    }

                    countries.put(countryName, new Country(countryName, capitalName, facts));

                    i += NUM_FACTS;
                }
            }
        }
    }

    /**
     * Returns a random Country from the map.
     *
     * @return a random Country object
     */
    public Country getRandomCountry()
    {
        final List<Country> countryList;
        final int randomIndex;

        countryList = new ArrayList<>(countries.values());

        if (countryList.isEmpty())
        {
            throw new IllegalStateException("ERROR: No countries loaded. Check data files.");
        }

        randomIndex = random.nextInt(countryList.size());
        return countryList.get(randomIndex);
    }
}
