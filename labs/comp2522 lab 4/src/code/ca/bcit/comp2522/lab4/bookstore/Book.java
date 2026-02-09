package ca.bcit.comp2522.lab4.bookstore;

import java.util.Objects;


/**
 * Represents a Book in the bookstore system.
 * <p>
 * A Book has a title, a year of publication, and an author.
 * This class implements:
 * <ul>
 * <li>{@code Printable} to display its details.</li>
 * <li>{@code Reversible} to display its title backward.</li>
 * <li>{@code Comparable<Book>} to allow sorting by year of publication.</li>
 * </ul>
 * Equality for Books is determined solely by the year of publication.
 * </p>
 *
 * @author Aika Manalo - 2C
 * @author Devan Lam - 2C
 *
 * @version 1.0
 */
public class Book
    implements Printable,
               Reversible,
               Comparable<Book>
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

    /**
     * Constructs a Book with the specified title, year of publication, and author.
     * <p>
     * Validates that the title is not null, blank, or too long.
     * Validates that the year is within the acceptable range (1 to current year).
     * Validates that the author is not null.
     * </p>
     *
     * @param title         the title of the book
     * @param yearPublished the year the book was published
     * @param author        the author of the book
     * @throws IllegalArgumentException if the title is invalid, year is out of range, or author is null
     */
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

    /*
     * Validates the book title.
     *
     * @param titleToValidate the title string to check
     * @throws IllegalArgumentException if null, blank, or exceeds MAX_NUM_CHARACTERS
     */
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

    /*
     * Validates the publication year.
     *
     * @param yearToValidate the year to check
     * @throws IllegalArgumentException if year is before MIN_VALID_YEAR or in the future
     */
    private static void validateYear(final int yearToValidate)
    {
        if (yearToValidate < MIN_VALID_YEAR || yearToValidate > MAX_VALID_YEAR)
        {
            throw new IllegalArgumentException("ERROR: Year published must be in between " +
                                               MIN_VALID_YEAR + " and " + MAX_VALID_YEAR);
        }
    }

    /*
     * Validates that the author object is not null.
     *
     * @param authorToValidate the Author object to check
     * @throws IllegalArgumentException if author is null
     */
    private static void validateAuthorExistence(final Author authorToValidate)
    {
        if (authorToValidate == null)
        {
            throw new IllegalArgumentException("ERROR: Author cannot be null");
        }
    }

    /**
     * Returns the title of the book.
     *
     * @return the book title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the year the book was published.
     *
     * @return the publication year
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Returns the author of the book.
     *
     * @return the Author object
     */
    public Author getAuthor()
    {
        return author;
    }

    /**
     * Displays the book's details by printing its string representation to the console.
     */
    @Override
    public void display()
    {
        System.out.println(this);
    }

    /**
     * Prints the title of the book in reverse order.
     * <p>
     * Implements the {@code Reversible} interface.
     * </p>
     */
    @Override
    public void backward()
    {
        final StringBuilder sb;

        sb = new StringBuilder();
        sb.append(title);

        System.out.println(sb.reverse());
    }

    /**
     * Returns a string representation of the Book.
     *
     * @return a formatted string containing the title, author, and year published
     */
    @Override
    public String toString()
    {
        return "\"" + title +
                           "\", written by " + author +
                           " Published in " + yearPublished + ".";
    }

    /**
     * Compares this Book to another Book based on the year published.
     * <p>
     * This implementation sorts books in <b>descending</b> order (newest to oldest).
     * </p>
     *
     * @param otherBook the other Book object to be compared
     * @return a negative integer, zero, or a positive integer as this book's year
     * is greater than, equal to, or less than the specified book's year
     */
    @Override
    public int compareTo(final Book otherBook)
    {
        return otherBook.yearPublished - this.yearPublished;
    }

    /**
     * Compares this Book to another object for equality.
     * <p>
     * Two Book objects are considered equal if they have the same
     * year of publication.
     * </p>
     *
     * @param o the object to be compared for equality
     * @return true if the specified object is a Book with the same publication year; false otherwise
     */
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

    /**
     * Returns a hash code value for the Book.
     * <p>
     * The hash code is generated based on the year of publication.
     * </p>
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(yearPublished);
    }
}
