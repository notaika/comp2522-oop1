package ca.bcit.comp2522.lab4.bookstore;

/**
 *
 */
public class Autobiography
    extends Biography
    implements Printable
{
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author)
    {
        super(title,
              yearPublished,
              author,
              author);
    }

    @Override
    public void display()
    {
        super.display();
        super.getAuthor().display();
    }
}
