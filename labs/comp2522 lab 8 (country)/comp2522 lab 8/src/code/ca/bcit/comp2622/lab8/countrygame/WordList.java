import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

/**
 * Represents a list of words.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public class WordList
{
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private static final String DIR;
    private static final String DIR_FILE;
    private static final Path WORD_LIST_FILE_PATH;

    private final List<String>    words;
    private final RandomGenerator random;

    // is this right?
    static
    {
        DIR = "src/data";
        DIR_FILE = "countries.txt";
        WORD_LIST_FILE_PATH = Paths.get(DIR, DIR_FILE);
    }

    /**
     * Constructs and initializes a list of words (countries) and a random generator.
     *
     * @param path path to the list of words to load
     */
    public WordList(final Path path)
    {
        this.words = new ArrayList<>();
        this.random    = RandomGenerator.getDefault();

        validatePath(path);
        loadWords(path);
    }

    /**
     * Validates that the file path containing the word list is not empty.
     *
     * @param pathToCheck path to check
     * @throws IllegalArgumentException if path is invalid
     */
    private static void validatePath(final Path pathToCheck)
    {
        if (Files.notExists(pathToCheck))
        {
            throw new IllegalArgumentException("ERROR: Invalid path.");
        }
    }

    /**
     * Reads from a given path that contains a list of words and adds them
     * all to a list.
     *
     * @param path path to read from
     */
    private void loadWords(final Path path)
    {
        try (BufferedReader reader = Files.newBufferedReader(path,
                                                             CHARSET))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (!line.trim()
                         .isEmpty())
                {
                    this.words.add(line.trim());
                }
            }
        }
        catch (final IOException e)
        {
            System.out.println("ERROR: Could not read file. " + e.getMessage());
        }
    }

    /**
     * Returns a list of words.
     *
     * @return words in a list
     */
    public List<String> getWords()
    {
        return words;
    }

    /**
     * Gets a random word from the list.
     *
     * @return random word
     */
    public String getRandomWord()
    {
        final int randomIndex = random.nextInt(words.size());

        return words.get(randomIndex);
    }

    /**
     * Tests.
     *
     * @param args unused
     */
    public static void main(String[] args)
    {
        final WordList list;

        list = new WordList(WORD_LIST_FILE_PATH);

        for (final String word : list.getWords())
        {
             System.out.println(word);
        }

        System.out.println(list.getRandomWord());
    }
}