package ca.bcit.comp2522.lect5.lecture;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Amazon
{
    // always declare at the level of an interface!
    // gives you a range of more operators to use
    // REF1: <Book> <- only books must be available there
    private final List<Book> books;

    public Amazon()
    {
        // you declare here if you want a particular type of 'List'
        books = new ArrayList<>();
        // RAGS: remove() add() get() size()

        // books.add("hi"); <- won't work (check out REF1)
        books.add(new Book("Displine Equals Freedom", 2010));
        books.add(new Book("Never Finished", 2024));
        books.add(new Book("Can't Hurt Me", 2024));
        books.add(new Book("https://paulgraham.com/articles.html", 2026));

        // 2 ways to loop through them
        for (final Book book: books)
        {
            // find the word me in there, get ride of it
            if (book.getTitle().toLowerCase().contains("me"))
            {
                books.remove(book);
            }
            System.out.println(book);
        }

        System.out.println("There are " + books.size() + " books.");
        // book at index 1 moves to index 0
        books.remove(0);

        System.out.println("There are " + books.size() + " books.");
        System.out.println(books.get(0));

        final Iterator<Book> it;
        it = books.iterator();

        // while 'it' hasNext, next
        System.out.println("\nIterator Example");
        while (it.hasNext())
        {
            final Book b;
            b = it.next();

            System.out.println(b);
        }


    }

    public static void main(String[] args)
    {
        final Amazon amazon;
        amazon = new Amazon();
    }

}
