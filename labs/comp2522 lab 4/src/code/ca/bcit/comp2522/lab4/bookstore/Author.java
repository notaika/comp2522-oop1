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
{
    private static final int MAX_NUM_CHARACTERS = 30;

    private final String genre;

    /**
     * Constructs and validates an Author with a full name, date of birth, date of death, and genre.
     *
     * @param fullName    the author's full name
     * @param dateOfBirth the author's date of birth
     * @param dateOfDeath the author's date of death
     * @param genre       the author's genre
     * @throws IllegalArgumentException if invalid
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
     * @param genre       the author's genre
     * @throws IllegalArgumentException if invalid
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
     * @throws IllegalArgumentException if invalid
     */
    private static void validateGenreLen(final String genreStrToCheck)
    {
        if (genreStrToCheck == null ||
            genreStrToCheck.isBlank() ||
            genreStrToCheck.length() > MAX_NUM_CHARACTERS)
        {
            throw new IllegalArgumentException("ERROR: Genre length cannot be null, blank or exceed " +
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
