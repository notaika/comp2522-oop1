package ca.bcit.comp2522.lab5.bookstore;

import java.util.Objects;

/**
 * Represents a Novel with a title, author, and publication year.
 * Implements Comparable to allow sorting by novel title (case-insensitive).
 *
 * @author Aika Manalo - Set 2C
 * @author Maeve Le - Set 2C
 *
 * @version 1.0
 */
public class Novel
    implements Comparable<Novel>
{
    private static final int MIN_YEAR = 1;
    private static final int MAX_YEAR = 2026;

    private final String title;
    private final String authorName;
    private final int yearPublished;

    /**
     * Constructs and initializes a new Novel instance and validates the input parameters.
     *
     * @param title         the title of the novel
     * @param authorName    the author of the novel
     * @param yearPublished the year the novel was published
     * @throws IllegalArgumentException if the title, authorName or yearPublished are invalid
     */
    public Novel(final String title,
          final String authorName,
          final int yearPublished)
    {
        validateIsNotNull(title);
        validateIsNotNull(authorName);
        validateYearPublished(yearPublished);

        this.title         = title;
        this.authorName    = authorName;
        this.yearPublished = yearPublished;
    }

    /*
     * Validates that a string field is not null or empty.
     *
     * @param fieldToCheck the string to validate
     * @throws IllegalArgumentException if the field is null or empty
     */
    private static void validateIsNotNull(final String fieldToCheck)
    {
        if (fieldToCheck == null || fieldToCheck.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: Title cannot be null or empty.");
        }
    }

    /*
     * Validates that the publication year falls within the accepted range.
     *
     * @param yearToCheck the year to validate
     * @throws IllegalArgumentException if the year is invalid
     */
    private static void validateYearPublished(final int yearToCheck)
    {
        if (yearToCheck < MIN_YEAR || yearToCheck > MAX_YEAR)
        {
            throw new IllegalArgumentException("ERROR: Year must be in between " +
                                               MIN_YEAR + " and " + MAX_YEAR);
        }
    }

    /**
     * Getter method for Novel title.
     *
     * @return the Novel title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Getter method for Novel author.
     *
     * @return the Novel author
     */
    public String getAuthorName()
    {
        return authorName;
    }

    /**
     * Getter method for Novel's year published.
     *
     * @return the Novel's publication year
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Compares this novel to another novel based on their titles (case-insensitive).
     * This is used for sorting collections of Novels alphabetically.
     *
     * @param   o the other Novel to compare against
     * @return  a negative integer if this title comes before other title
     *          zero if this title is equal to the other title
     *          a positive integer if this title comes after the other title
     */
    @Override
    public int compareTo(final Novel o)
    {
        return this.title.compareToIgnoreCase(o.getTitle());
    }

    /**
     * Compares this Novel to another Novel object. The result is true if and only if
     * the argument is not null and is a Novel object that represents the same
     * title, author, and publication year as this object.
     *
     * @param o the object to compare this Novel against
     * @return true if the given object represents a Novel equivalent to this novel, false otherwise
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (this.getClass() != o.getClass())
        {
            return false;
        }

        final Novel otherNovel;
        otherNovel = (Novel) o;

        return ((this.yearPublished == otherNovel.yearPublished) &&
                (Objects.equals(this.title, otherNovel.title)) &&
                (Objects.equals(this.authorName, otherNovel.authorName)));

    }

    /**
     * Returns a hash code value for the Novel. This method is supported for the
     * benefit of hash tables such as those provided by HashMap.
     *
     * @return a hash code value for this Novel
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(title, authorName, yearPublished);
    }

    /**
     * Returns a formatted string representation of the novel.
     * Example format: "The Great Gatsby" by F. Scott Fitzgerald, 1925
     *
     * @return a string describing the novel
     */
    @Override
    public String toString()
    {
        return "\"" + title + "\"" +
               " by " + authorName +
               ", " + yearPublished;
    }
}
