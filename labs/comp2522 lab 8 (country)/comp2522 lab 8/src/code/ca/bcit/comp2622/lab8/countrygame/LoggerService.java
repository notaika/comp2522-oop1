import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Updates and keeps track of game logs.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public class LoggerService
{
    private static final String TITLE_DATE_FORMAT = "yyyy-MM-dd_HH-mm-ss";
    private static final String LOG_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String FILE_NAME_SEPARATOR = "_";
    private static final String FILE_NAME_EXTENSION = ".txt";

    private static final String DATA_DIR;
    private static final String LOGS_DIR_NAME;
    private static final Path LOGS_DIR_PATH;

    private final Path logsFilePath;

    static
    {
        DATA_DIR = "data";
        LOGS_DIR_NAME = "logs";
        LOGS_DIR_PATH = Paths.get(DATA_DIR, LOGS_DIR_NAME);
    }

    /**
     * Constructs the LoggerService and initializes the session log file.
     *
     * @param countryToGuess the country name to include in the log file name
     */
    public LoggerService(final String countryToGuess)
    {
        validateString(countryToGuess, "Country To Guess");

        this.logsFilePath = Paths.get(DATA_DIR, LOGS_DIR_NAME, formatFileName(countryToGuess));

        createLogsFile(this.logsFilePath);
    }

    /*
     * Validates that a string is not null or blank.
     *
     * @param stringToValidate the string to check
     * @param fieldName the name of the field for error feedback
     * @throws IllegalArgumentException if invalid
     */
    private static void validateString(final String stringToValidate, final String fieldName)
    {
        if (stringToValidate == null || stringToValidate.isBlank())
        {
            throw new IllegalArgumentException("ERROR: " + fieldName + " cannot be null or blank.");
        }
    }

    /*
     * Creates the logs directory and the session log file if they do not exist.
     *
     * @param filePathToCheck the full path of the log file
     */
    private void createLogsFile(final Path filePathToCheck)
    {
        try
        {
            if (Files.notExists(LOGS_DIR_PATH))
            {
                Files.createDirectories(LOGS_DIR_PATH);
            }

            if (Files.notExists(filePathToCheck))
            {
                Files.createFile(filePathToCheck);
            }
        }
        catch (final IOException e)
        {
            throw new RuntimeException("ERROR: Unable to initialize log file. " + e.getMessage());
        }
    }

    /*
     * Formats the file name with the timestamp and secret country.
     *
     * @param secretCountry the target country
     * @return the fully formatted file name
     */
    private String formatFileName(final String countryToGuess)
    {
        final LocalDateTime currentTime;
        final DateTimeFormatter fileDateFormatter;
        final String formattedDateTime;
        final String fileName;

        currentTime = LocalDateTime.now();
        fileDateFormatter = DateTimeFormatter.ofPattern(TITLE_DATE_FORMAT);
        formattedDateTime = currentTime.format(fileDateFormatter);

        fileName = formattedDateTime + FILE_NAME_SEPARATOR + countryToGuess.toUpperCase() + FILE_NAME_EXTENSION;

        return fileName;
    }

    /**
     * Appends a single guess and its outcome to the active log file using NIO.
     *
     * @param guess the word the player guessed
     * @param outcome the result of the guess
     */
    public void logGuess(final String guess, final String outcome)
    {
        final DateTimeFormatter logTimestampFormatter;
        final String timestampString;
        final String logLine;

        validateString(guess, "Guess");
        validateString(outcome, "Outcome");

        logTimestampFormatter = DateTimeFormatter.ofPattern(LOG_TIMESTAMP_FORMAT);
        timestampString = LocalDateTime.now().format(logTimestampFormatter);

        logLine = timestampString + " - Guess: " + guess + " - Outcome: " + outcome;

        try (final BufferedWriter writer = Files.newBufferedWriter(logsFilePath,
                                                                   StandardCharsets.UTF_8,
                                                                   StandardOpenOption.APPEND))
        {
            writer.write(logLine);
            writer.newLine();
        }
        catch (final IOException e)
        {
            System.out.println("ERROR: Failed to write to log file." + e.getMessage());
        }
    }
}
