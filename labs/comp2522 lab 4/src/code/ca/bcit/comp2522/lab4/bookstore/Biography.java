package ca.bcit.comp2522.lab4.bookstore;

import java.util.Objects;

/**
 * Represents a Biography, which is a specific type of Book.
 * <p>
 * A Biography is a written account of a person's life (the subject).
 * Equality is determined solely by the subject of the biography.
 * </p>
 *
 * @author Aika Manalo - 2C
 * @author Devan Lam - 2C
 *
 * @version 1.0
 */
public class Biography
        extends Book
{
    private final Person subject;

    /**
     * Constructs a Biography with the specified title, year of publication,
     * author, and subject.
     *
     * @param title         the title of the biography
     * @param yearPublished the year the biography was published
     * @param author        the author who wrote the biography
     * @param subject       the person who is the subject of the biography
     * @throws IllegalArgumentException if the subject is null
     */
    public Biography(final String title,
                     final int yearPublished,
                     final Author author,
                     final Person subject)
    {
        super(title,
              yearPublished,
              author);

        validateSubject(subject);

        this.subject = subject;
    }

    /*
     * Validates that the subject of the biography.
     *
     * @param subjectToValidate the Person object to check
     * @throws IllegalArgumentException if the subject is invalid
     */
    private static void validateSubject(final Person subjectToValidate)
    {
        if (subjectToValidate == null)
        {
            throw new IllegalArgumentException("ERROR: Subject of biography cannot be null");
        }
    }

    /**
     * Compares this Biography to another object for equality.
     * <p>
     * Two Biography objects are considered equal if they describe the exact
     * same subject (Person), regardless of the author or publication year.
     * </p>
     *
     * @param o the object to be compared for equality
     * @return true if the specified object is a Biography with the same subject; false otherwise
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof Biography))
        {
            return false;
        }

        final Biography otherBio;
        otherBio = (Biography) o;

        return Objects.equals(this.subject, otherBio.subject);
    }

    /**
     * Returns a hash code value for the Biography.
     * <p>
     * The hash code is generated based solely on the subject of the biography
     * to remain consistent with the {@code equals} method.
     * </p>
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(this.subject);
    }

    /**
     * Returns a string representation of the Biography.
     *
     * @return a formatted string containing the title, subject, author, and year published
     */
    @Override
    public String toString()
    {
        return "\"" + getTitle() +
               "\", a biography on " + subject.getFullName() +
                " written by " + getAuthor() +
               " Published in " + getYearPublished() + ".";
    }
}
