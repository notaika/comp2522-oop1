package ca.bcit.comp2522.lab5.bookstore;

/**
 * Represents a Novel.
 *
 * @author Aika Manalo - Set 2C
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

    private static void validateIsNotNull(final String fieldToCheck)
    {
        if (fieldToCheck == null || fieldToCheck.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: Title cannot be null or empty.");
        }
    }

    private static void validateYearPublished(final int yearToCheck)
    {
        if (yearToCheck < MIN_YEAR || yearToCheck > MAX_YEAR)
        {
            throw new IllegalArgumentException("ERROR: Year must be in between " +
                                               MIN_YEAR + " and " + MAX_YEAR);
        }
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthorName()
    {
        return authorName;
    }

    public int getYearPublished()
    {
        return yearPublished;
    }

    @Override
    public int compareTo(final Novel o)
    {
        return this.title.compareToIgnoreCase(o.getTitle());
    }
}
