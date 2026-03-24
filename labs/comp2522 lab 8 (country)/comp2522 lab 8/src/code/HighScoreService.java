import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A utility class that keeps track of the highest score.
 *
 * @author Aika Manalo
 * @version 1.0
 */
public class HighScoreService
{
    private static final int NO_BEST = Integer.MAX_VALUE;
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final String PREFIX = "COUNTRY=";

    // keeps track of highest score
    // reads highscore.txt
    // overwrites it if highest score

    private int highestScore; // lowest number of attempts

    public HighScoreService(final Path path)
    {
        this.highestScore = NO_BEST;
        readHighScore(path);
    }

    private static void validatePath(final Path pathToCheck)
    {
        if (pathToCheck == null)
        {
            throw new IllegalArgumentException("Invalid path");
        }


    }

    private void readHighScore(final Path path)
    {
        if (Files.notExists(path))
        {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path,
                                                             UTF8))
        {
            final String line = reader.readLine();

            if (line != null && line.startsWith(PREFIX))
            {
                final String parsedScore = line.substring(PREFIX.length())
                                               .trim();
                this.highestScore = Integer.parseInt(parsedScore);
            }
        }
        catch (final IOException e)
        {
            System.err.println("File error: " + e.getMessage());
        }
        catch (final NumberFormatException e)
        {
            System.err.println("Parsing error: " + e.getMessage());
        }
    }

    public boolean overwriteFile(final Path path,
                                 final int attempts)
    {
        if (attempts < highestScore)
        {
            highestScore = attempts;
            writeHighScore(path);
            return true;
        }
        return false;
    }

    private void writeHighScore(final Path path)
    {
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                                                             UTF8))
        {
            writer.write(PREFIX + highestScore);
        }
        catch (final IOException e)
        {
            System.err.println("Could not save high score " + e.getMessage());
        }
    }
}
