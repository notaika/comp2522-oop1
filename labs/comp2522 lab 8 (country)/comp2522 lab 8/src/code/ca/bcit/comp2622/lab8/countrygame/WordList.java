package ca.bcit.comp2622.lab8.countrygame;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a list of words.
 *
 * @author Aika Manalo - Set 2C
 * @version 2.0
 */
public class WordList
{
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final String  DIR_SRC;
    private static final String  DIR_RES;
    private static final String  DIR_FILE;
    private static final Path    WORD_LIST_FILE_PATH;

    private final List<String> words;
    private final Random       random;

    static
    {
        DIR_SRC  = "src";
        DIR_RES  = "res";
        DIR_FILE = "countries.txt";

        WORD_LIST_FILE_PATH = Paths.get(DIR_SRC,
                                        DIR_RES,
                                        DIR_FILE);
    }

    /**
     * Constructs and initializes a list of words (countries) and a random generator.
     */
    public WordList()
    {
        this.words  = new ArrayList<>();
        this.random = new Random();

        validatePath();
        loadWords();
    }

    /**
     * Validates that the file path containing the word list exists.
     *
     * @throws IllegalArgumentException if path is invalid
     */
    private static void validatePath()
    {
        if (Files.notExists(WORD_LIST_FILE_PATH))
        {
            throw new IllegalArgumentException("ERROR: Missing " + WORD_LIST_FILE_PATH + " file.");
        }
    }

    /**
     * Reads from the predefined path and adds words to the list.
     */
    private void loadWords()
    {
        try (final BufferedReader reader = Files.newBufferedReader(WORD_LIST_FILE_PATH,
                                                                   CHARSET))
        {
            String line;
            line = reader.readLine();

            while (line != null)
            {
                final String trimmedLine;
                trimmedLine = line.trim();

                if (!trimmedLine.isEmpty())
                {
                    this.words.add(trimmedLine);
                }
                line = reader.readLine();
            }
        }
        catch (final IOException e)
        {
            System.err.println("ERROR: Could not read file. " + e.getMessage());
        }
    }

    /**
     * Gets a random word from the list.
     *
     * @return random word as a String
     */
    public String getRandomWord()
    {
        final int randomIndex;
        randomIndex = random.nextInt(words.size());

        return words.get(randomIndex);
    }
}