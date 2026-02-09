package ca.bcit.comp2522.lab4.bookstore;

/**
 * Represents an Autobiography, which is a type of Biography.
 * <p>
 * In an autobiography, the author and the subject of the book are the same person.
 * </p>
 *
 * @author Aika Manalo - 2C
 * @author Devan Lam - 2C
 *
 * @version 1.0
 */
public class Autobiography
    extends Biography
{
    /**
     * Constructs an Autobiography with a given title, year of publication,
     * and author.
     * <p>
     * The author is passed to the superclass constructor
     * as both the writer and the subject of the biography.
     * </p>
     *
     * @param title         the title of the autobiography
     * @param yearPublished the year the autobiography was published
     * @param author        the author (who is also the subject) of the book
     */
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author)
    {
        super(title,
              yearPublished,
              author,
              author);
    }


    /**
     * Returns a string representation of the Autobiography.
     *
     * @return a formatted string containing the title, author (where the subject is himself), and year published
     */
    @Override
    public String toString()
    {
        return "\"" + getTitle() +
               "\", an autobiography written by " + getAuthor() +
               " Published in " + getYearPublished() + ".";
    }
}
