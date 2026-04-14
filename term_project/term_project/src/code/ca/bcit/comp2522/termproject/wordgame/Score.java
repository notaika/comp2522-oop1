package ca.bcit.comp2522.termproject.wordgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a session score for the WordGame.
 * Handles calculation of points and persistence to file.
 *
 * @author Aika Manalo - Set 2C
 * @version 2.2
 */
public final class Score
{
    private static final int    PTS_FIRST_ATTEMPT  = 2;
    private static final int    PTS_SECOND_ATTEMPT = 1;
    private static final String DATE_TIME_FORMAT   = "yyyy-MM-dd HH:mm:ss";
    private static final char VALUE_DELIMITER          = ':';

    private static final int  EXPECTED_LINES_PER_SCORE = 6;
    private static final int  LINE_INDEX_DATE          = 0;
    private static final int  LINE_INDEX_GAMES         = 1;
    private static final int  LINE_INDEX_FIRST         = 2;
    private static final int  LINE_INDEX_SECOND        = 3;
    private static final int  LINE_INDEX_INCORRECT     = 4;
    private static final int  COLON_OFFSET_DEFAULT     = 1;

    private final LocalDateTime dateTimePlayed;
    private final int           numGamesPlayed;
    private final int           numCorrectFirstAttempt;
    private final int           numCorrectSecondAttempt;
    private final int           numIncorrectTwoAttempts;

    /**
     * Constructs and initializes a Score object.
     *
     * @param dateTimePlayed the date and time the session ended
     * @param numGamesPlayed total number of word games played
     * @param numCorrectFirstAttempt total correct on first try
     * @param numCorrectSecondAttempt total correct on second try
     * @param numIncorrectTwoAttempts total failed attempts
     */
    public Score(final LocalDateTime dateTimePlayed,
                 final int numGamesPlayed,
                 final int numCorrectFirstAttempt,
                 final int numCorrectSecondAttempt,
                 final int numIncorrectTwoAttempts)
    {
        validateAttempts(numGamesPlayed,
                         "Games played");
        validateAttempts(numCorrectFirstAttempt,
                         "Correct first attempts");
        validateAttempts(numCorrectSecondAttempt,
                         "Correct second attempts");
        validateAttempts(numIncorrectTwoAttempts,
                         "Incorrect attempts");

        this.dateTimePlayed          = dateTimePlayed;
        this.numGamesPlayed          = numGamesPlayed;
        this.numCorrectFirstAttempt  = numCorrectFirstAttempt;
        this.numCorrectSecondAttempt = numCorrectSecondAttempt;
        this.numIncorrectTwoAttempts = numIncorrectTwoAttempts;
    }

    /*
     * Validates that the provided integer value is not negative.
     *
     * @param value the value to check
     * @param fieldName the name of the field for the error message
     * @throws IllegalArgumentException if the value is invalid
     */
    private static void validateAttempts(final int value,
                                         final String fieldName)
    {
        if (value < 0)
        {
            throw new IllegalArgumentException("ERROR: " + fieldName + " cannot be negative.");
        }
    }

    /**
     * Calculates the total points for this session.
     *
     * @return the total score
     */
    public int getScore()
    {
        return (numCorrectFirstAttempt * PTS_FIRST_ATTEMPT) + (numCorrectSecondAttempt * PTS_SECOND_ATTEMPT);
    }

    /**
     * Returns the number of games played in this session.
     *
     * @return number of games
     */
    public int getNumGamesPlayed()
    {
        return numGamesPlayed;
    }

    /**
     * Returns the formatted date and time played.
     *
     * @return formatted date/time string
     */
    public String getDateTimePlayedFormatted()
    {
        final DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return dateTimePlayed.format(formatter);
    }

    /**
     * Appends a score object to the specified file.
     *
     * @param score the score to save
     * @param filename the destination file path
     * @throws IOException if file operations fail
     */
    public static void appendScoreToFile(final Score score,
                                         final String filename) throws IOException
    {
        final Path path;
        path = Paths.get(filename);

        try (final BufferedWriter writer = Files.newBufferedWriter(path,
                                                                   StandardOpenOption.CREATE,
                                                                   StandardOpenOption.APPEND))
        {
            writer.write(score.toString() + System.lineSeparator());
        }
    }

    /**
     * Reads all past session scores from the specified file.
     *
     * @param filename the source file path
     * @return a list of Score objects
     * @throws IOException if file operations fail
     */
    public static List<Score> readScoresFromFile(final String filename) throws IOException
    {
        final Path path;
        final List<String> allLines;
        final List<Score> scores;

        path   = Paths.get(filename);
        scores = new ArrayList<>();

        if (Files.notExists(path))
        {
            return scores;
        }

        allLines = new ArrayList<>();

        try (final BufferedReader reader = Files.newBufferedReader(path))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                allLines.add(line);
            }
        }

        int i;
        i = 0;

        while (i + LINE_INDEX_INCORRECT < allLines.size())
        {
            final String currentLine;
            currentLine = allLines.get(i);

            if (!currentLine.isBlank())
            {
                final LocalDateTime dt;
                final int games;
                final int first;
                final int second;
                final int incorrect;

                dt = LocalDateTime.parse(allLines.get(i + LINE_INDEX_DATE)
                                                 .substring(allLines.get(i + LINE_INDEX_DATE)
                                                                    .indexOf(VALUE_DELIMITER) + COLON_OFFSET_DEFAULT +
                                                            1)
                                                 .trim(),
                                         DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));

                games     = Integer.parseInt(extractValue(allLines.get(i + LINE_INDEX_GAMES)));
                first     = Integer.parseInt(extractValue(allLines.get(i + LINE_INDEX_FIRST)));
                second    = Integer.parseInt(extractValue(allLines.get(i + LINE_INDEX_SECOND)));
                incorrect = Integer.parseInt(extractValue(allLines.get(i + LINE_INDEX_INCORRECT)));

                scores.add(new Score(dt,
                                     games,
                                     first,
                                     second,
                                     incorrect));

                i += EXPECTED_LINES_PER_SCORE;
            }
            else
            {
                i++;
            }
        }

        return scores;
    }

    /*
     * Helper to extract the numeric/string value after the delimiter in the score file format.
     *
     * @param line the line to parse
     * @return the extracted value string
     */
    private static String extractValue(final String line)
    {
        final int colonIndex;
        colonIndex = line.indexOf(VALUE_DELIMITER);
        return line.substring(colonIndex + COLON_OFFSET_DEFAULT)
                   .trim();
    }

    /**
     * Returns a string representation of the Score.
     *
     * @return the formatted score string
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        final DateTimeFormatter formatter;

        builder   = new StringBuilder();
        formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

        builder.append("Date and Time: ")
               .append(dateTimePlayed.format(formatter))
               .append("\n");
        builder.append("Games Played: ")
               .append(numGamesPlayed)
               .append("\n");
        builder.append("Correct First Attempts: ")
               .append(numCorrectFirstAttempt)
               .append("\n");
        builder.append("Correct Second Attempts: ")
               .append(numCorrectSecondAttempt)
               .append("\n");
        builder.append("Incorrect Attempts: ")
               .append(numIncorrectTwoAttempts)
               .append("\n");
        builder.append("Score: ")
               .append(getScore())
               .append(" points\n");

        return builder.toString();
    }
}