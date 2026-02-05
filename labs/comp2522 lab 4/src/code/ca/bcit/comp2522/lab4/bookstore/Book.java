package ca.bcit.comp2522.lab4.bookstore;

import java.util.Objects;

/**
 *
 */
public class Book
    implements Printable, Reversible, Comparable<Book>
{
    private static final int MAX_NUM_CHARACTERS = 100;
    private static final int MIN_VALID_YEAR = 1;
    private static final int MAX_VALID_YEAR;

    static
    {
        final Date dateToday;
        dateToday = new Date(2026, 2, 4);

        MAX_VALID_YEAR = dateToday.getYear();
    }

    private final String title;
    private final int yearPublished;
    private final Author author;

    public Book(final String title,
                final int yearPublished,
                final Author author)
    {
        validateTitle(title);
        validateYear(yearPublished);
        validateAuthorExistence(author);

        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    private static void validateTitle(final String titleToValidate)
    {
        if ((titleToValidate == null) ||
            (titleToValidate.isBlank()) ||
            (titleToValidate.length() > MAX_NUM_CHARACTERS))
        {
            throw new IllegalArgumentException("ERROR: Title cannot be null, blank, or greater than " +
                                               MAX_NUM_CHARACTERS);
        }
    }

    private static void validateYear(final int yearToValidate)
    {
        if (yearToValidate < MIN_VALID_YEAR || yearToValidate > MAX_VALID_YEAR)
        {
            throw new IllegalArgumentException("ERROR: Year published must be in between " +
                                               MIN_VALID_YEAR + " and " + MAX_VALID_YEAR);
        }
    }

    private static void validateAuthorExistence(final Author authorToValidate)
    {
        if (authorToValidate == null)
        {
            throw new IllegalArgumentException("ERROR: Author cannot be null");
        }
    }

    public String getTitle()
    {
        return title;
    }

    public int getYearPublished()
    {
        return yearPublished;
    }

    public Author getAuthor()
    {
        return author;
    }

    @Override
    public void display()
    {
        System.out.println("This book is \"" + title +
                           "\", written by " + author +
                           " and was published in " + yearPublished + ".");
    }

    @Override
    public void backward()
    {
        final StringBuilder sb;

        sb = new StringBuilder();
        sb.append(title);

        System.out.println(sb.reverse());
    }

    @Override
    public int compareTo(final Book otherBook)
    {
        return otherBook.yearPublished - this.yearPublished;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!this.getClass()
                 .equals(o.getClass()))
        {
            return false;
        }

        final Book otherBook;
        otherBook = (Book) o;

        return Objects.equals(this.yearPublished, otherBook.yearPublished);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(yearPublished);
    }
}
