package ca.bcit.comp2622.lab8.countrygame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Represents a tracker that keeps track of the highest score.
 *
 * @author Aika Manalo
 * @version 2.0
 */
public class HighScoreService
{
    public static final int NO_BEST = Integer.MAX_VALUE;

    private static final Charset CHARSET           = StandardCharsets.UTF_8;
    private static final String  HIGH_SCORE_PREFIX = "COUNTRY=";
    private static final int     SCORE_START_INDEX = 8;

    private static final String DIR_SRC;
    private static final String DIR_RES;
    private static final String DIR_FILE;
    private static final Path   HIGH_SCORE_FILE_PATH;

    private int highestScore;

    static
    {
        DIR_SRC  = "src";
        DIR_RES  = "res";
        DIR_FILE = "highscore.txt";

        HIGH_SCORE_FILE_PATH = Paths.get(DIR_SRC,
                                         DIR_RES,
                                         DIR_FILE);
    }

    /**
     * Constructs and initializes the HighScoreService and loads the current best score.
     */
    public HighScoreService()
    {
        this.highestScore = NO_BEST;
        readHighScore();
    }

    /**
     * Returns the highest score currently saved.
     *
     * @return the highest score as an int
     */
    public int getHighScore()
    {
        return highestScore;
    }

    /**
     * Reads the high score from the text file.
     * If missing, treats it as NO_BEST.
     */
    private void readHighScore()
    {
        if (Files.notExists(HIGH_SCORE_FILE_PATH))
        {
            return;
        }

        try (final BufferedReader reader = Files.newBufferedReader(HIGH_SCORE_FILE_PATH,
                                                                   CHARSET))
        {
            final String firstLine;
            firstLine = reader.readLine();

            if (firstLine != null && firstLine.startsWith(HIGH_SCORE_PREFIX))
            {
                final String scoreString;
                scoreString = firstLine.substring(SCORE_START_INDEX)
                                       .trim();

                this.highestScore = Integer.parseInt(scoreString);
            }
        }
        catch (final IOException e)
        {
            // NO_BEST
        }
    }

    /**
     * Overwrites the high score file if the new attempts are lower than the saved score.
     *
     * @param attempts the number of attempts to win
     */
    public void saveHighScore(final int attempts)
    {
        if (attempts < highestScore)
        {
            highestScore = attempts;
            writeHighScore();
        }
    }

    /**
     * Writes the best score to the file.
     */
    private void writeHighScore()
    {
        final Path directoryPath;
        directoryPath = Paths.get(DIR_SRC,
                                  DIR_RES);

        try
        {
            if (Files.notExists(directoryPath))
            {
                Files.createDirectories(directoryPath);
            }

            try (final BufferedWriter writer = Files.newBufferedWriter(HIGH_SCORE_FILE_PATH,
                                                                       CHARSET))
            {
                writer.write(HIGH_SCORE_PREFIX + highestScore);
            }
        }
        catch (final IOException e)
        {
            System.err.println("ERROR: Could not save high score " + e.getMessage());
        }
    }
}