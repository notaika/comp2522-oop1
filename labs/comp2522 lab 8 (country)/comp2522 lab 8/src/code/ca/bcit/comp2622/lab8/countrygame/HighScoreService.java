import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    private static final String HIGH_SCORE_PREFIX = "COUNTRY=";
    private static final String DIR;
    private static final String DIR_FILE;
    private static final Path HIGH_SCORE_FILE_PATH;

    private int highestScore;

    static
    {
        DIR = "src/data";
        DIR_FILE = "highscore.txt";
        HIGH_SCORE_FILE_PATH = Paths.get(DIR, DIR_FILE);
    }

    public HighScoreService(final Path path)
    {
        this.highestScore = NO_BEST;
        readHighScore(path);
    }

    /**
     * Validates that the file path containing the word list is not empty.
     *
     * @throws IllegalArgumentException if path is invalid
     */
    private static void validatePath()
    {
        if (Files.notExists(HIGH_SCORE_FILE_PATH))
        {
            throw new IllegalArgumentException("ERROR: Invalid path.");
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

            if (line != null && line.startsWith(HIGH_SCORE_PREFIX))
            {
                final String parsedScore = line.substring(HIGH_SCORE_PREFIX.length())
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
            writer.write(HIGH_SCORE_PREFIX + highestScore);
        }
        catch (final IOException e)
        {
            System.err.println("ERROR: Could not save high score " + e.getMessage());
        }
    }
}
