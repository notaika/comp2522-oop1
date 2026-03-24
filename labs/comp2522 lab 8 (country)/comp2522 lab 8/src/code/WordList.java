import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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

    private final List<String>    words;
    private final RandomGenerator random;

    public WordList(final Path path) throws IOException
    {
        this.words = new ArrayList<>();
        this.random    = RandomGenerator.getDefault();
        validatePath(path);
        loadWords(path);
    }

    /**
     * Validates that the file path containing the word list is not empty.
     *
     * @param path path to check
     * @throws IllegalArgumentException if path is empty
     */
    private static void validatePath(final Path path)
    {
        if (path == null)
        {
            throw new IllegalArgumentException("Invalid path.");
        }
    }

    /**
     * Reads from a given path that contains a list of words and adds them
     * all to a list.
     *
     * @param path path to read from
     * @throws IOException if there was an error in the stream
     */
    private void loadWords(final Path path) throws IOException
    {
        try (BufferedReader reader = Files.newBufferedReader(path, CHARSET))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (!line.trim().isEmpty())
                {
                    this.words.add(line.trim());
                }
            }
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
        Path path = Path.of("src", "data", "countries.txt");

        WordList list = null;
        try
        {
             list = new WordList(path);
        }
        catch (final IOException e)
        {
            System.out.println("Unable to create WordList: " + e.getMessage());
        }

        if (list != null)
        {
            for (final String word : list.getWords())
            {
                // System.out.println(word);
            }

            System.out.println(list.getRandomWord());
        }
    }
}


















