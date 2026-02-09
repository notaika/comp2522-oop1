package ca.bcit.comp2522.lab4.bookstore;

/**
 * Represents an Author who is a type of Person.
 * <p>
 * This class contains information about the author's primary genre.
 * </p>
 *
 * @author Aika Manalo - 2C
 * @author Devan Lam - 2C
 *
 * @version 1.0
 */
public class Author
        extends Person
        implements Printable
{
    private static final int MAX_NUM_CHARACTERS = 30;

    private String genre;

    /**
     * Constructs an Author with a full name, date of birth, date of death, and genre.
     * Validates that the genre does not exceed the maximum character limit.
     *
     * @param fullName    the author's full name
     * @param dateOfBirth the author's date of birth
     * @param dateOfDeath the author's date of death (can be null if alive)
     * @param genre       the genre the author is known for
     * @throws IllegalArgumentException if the genre length exceeds MAX_NUM_CHARACTERS
     */
    public Author(final Name fullName,
                  final Date dateOfBirth,
                  final Date dateOfDeath,
                  final String genre)
    {
        super(fullName, dateOfBirth, dateOfDeath);

        validateGenreLen(genre);

        this.genre = genre;
    }

    /**
     * Constructs a living Author with a full name, date of birth, and genre.
     * The date of death is set to null.
     *
     * @param fullName    the author's full name
     * @param dateOfBirth the author's date of birth
     * @param genre       the genre the author is known for
     * @throws IllegalArgumentException if the genre length exceeds MAX_NUM_CHARACTERS
     */
    public Author(final Name fullName,
                   final Date dateOfBirth,
                   final String genre)
    {
        this(fullName, dateOfBirth, null, genre);
    }

    /*
     * Validates the length of the genre string.
     *
     * @param genreStrToCheck the genre string to validate
     * @throws IllegalArgumentException if the string exceeds MAX_NUM_CHARACTERS
     */
    private static void validateGenreLen(final String genreStrToCheck)
    {
        if (genreStrToCheck.length() > MAX_NUM_CHARACTERS)
        {
            throw new IllegalArgumentException("ERROR: Genre length cannot exceed " +
                                               MAX_NUM_CHARACTERS + " characters");
        }
    }

    /**
     * Returns the genre associated with this author.
     *
     * @return the author's genre
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Sets the genre for this author.
     *
     * @param genre the new genre to set
     */
    public void setGenre(final String genre)
    {
        this.genre = genre;
    }

    /**
     * Returns a string representation of the Author.
     *
     * @return a formatted string containing the author's name and genre
     */
    @Override
    public String toString()
    {
        return super.toString() + " " + genre + ".";
    }
}
