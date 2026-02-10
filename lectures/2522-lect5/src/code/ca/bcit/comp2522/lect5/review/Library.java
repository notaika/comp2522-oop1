package ca.bcit.comp2522.lect5.review;
import java.util.List;
import java.util.ArrayList;

class Library
{
    private final List<Book> books;

    Library()
    {
        this.books = new ArrayList<>();

        final Book b1;
        final Book b2;
        final Book b3;

        b1 = new Book("Atomic Habits", 2018);
        b2 = new Book("Never Finished", 2024);
        b3 = new Book("Can't Hurt Me", 2024);

        books.add(b1);
        books.add(b2);
        books.add(b3);

        if (books != null)
        {
            for (final Book book : books)
            {
                if (book != null)
                {
                    System.out.println(book);
                }
            }
        }
    }

    List<Book> getBooks()
    {
        return books;
    }

    @Override
    public String toString()
    {
        return "Books: " + books;
    }

    public static void main(String[] args)
    {
        final Library bcitLibrary;
        bcitLibrary = new Library();
    }
}
