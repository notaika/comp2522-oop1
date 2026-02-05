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

    public Author(final Name fullName,
                  final Date dateOfBirth,
                  final Date dateOfDeath,
                  final String genre)
    {
        super(fullName, dateOfBirth, dateOfDeath);

        validateGenreLen(genre);

        this.genre = genre;
    }

    public Author(final Name fullName,
                   final Date dateOfBirth,
                   final String genre)
    {
        this(fullName, dateOfBirth, null, genre);
    }

    private static void validateGenreLen(final String genreStrToCheck)
    {
        if (genreStrToCheck.length() > MAX_NUM_CHARACTERS)
        {
            throw new IllegalArgumentException("ERROR: Genre length cannot exceed " +
                                               MAX_NUM_CHARACTERS + " characters");
        }
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(final String genre)
    {
        this.genre = genre;
    }

    @Override
    protected String getPersonType()
    {
        return "author";
    }

    @Override
    public void display()
    {
        super.display();

        if (this.getDateOfDeath() != null)
        {
            System.out.println("They were a known author in " + genre + " genre.");
        }
        else
        {
            System.out.println("They are a known author in " + genre + " genre.");
        }
    }

    @Override
    public String toString()
    {
        return super.getFullName() + ", an author known in the " +
               genre + " genre";
    }
}
