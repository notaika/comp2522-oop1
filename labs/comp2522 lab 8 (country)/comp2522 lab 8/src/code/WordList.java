import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Loads countries.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public class WordList
{
    private static final Charset utf8 = StandardCharsets.UTF_8;

    private final int upperBound;
    private final List<String> countries;
    private final Random       random;

    public WordList(final Path path) throws IOException
    {
        this.countries = new ArrayList<>();
        this.random    = new Random();
        loadCountries(path);

        this.upperBound = countries.size();
    }

    private void loadCountries(final Path path) throws IOException
    {
        try (BufferedReader reader = Files.newBufferedReader(path, utf8))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (!line.trim().isEmpty())
                {
                    this.countries.add(line.trim());
                }
            }
        }
    }

    public List<String> getCountries()
    {
        return countries;
    }

    public Random getRandom()
    {
        return random;
    }

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
            for (final String country : list.getCountries())
            {
                System.out.println(country);
            }
        }
    }
}


















