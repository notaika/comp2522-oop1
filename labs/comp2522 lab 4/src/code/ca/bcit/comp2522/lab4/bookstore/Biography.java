package ca.bcit.comp2522.lab4.bookstore;

import java.util.Objects;

/**
 *
 */
public class Biography
        extends Book
{
    private final Person subject;

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

    private static void validateSubject(final Person subjectToValidate)
    {
        if (subjectToValidate == null)
        {
            throw new IllegalArgumentException("ERROR: Subject of biography cannot be null");
        }
    }

    @Override
    public void display()
    {
        super.display();
    }

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

    @Override
    public int hashCode()
    {
        return Objects.hash(this.subject);
    }
}
