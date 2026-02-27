package ca.bcit.cst.comp2522.midterm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionsPrac
{

}

class Bookstore
{
    private final Map<String, Book> library;
    private final Set<String>       keys;

    Bookstore()
    {
        library = new HashMap<>();

        final Book b1;
        final Book b2;

        b1 = new Book("Learning Java", 2026);
        b2 = new Book("Java 101", 2010);

        library.put(b1.getTitle(), b1);
        library.put(b2.getTitle(), b2);

        keys = library.keySet();

        if (keys != null)
        {
            for (final String key : keys)
            {
                if (key != null)
                {
                    final Book value;

                    value = library.get(key);
                    System.out.println(value.getTitle() + " was published in " + value.getYearPublished());
                }
            }
        }
    }
}
// hashmap of book titles (Stirngs as keys)
// for books

class Book
{
    private final String title;
    private final int yearPublished;

    Book(String title,
         int yearPublished)
    {
        this.title         = title;
        this.yearPublished = yearPublished;
    }

    String getTitle()
    {
        return title;
    }

    int getYearPublished()
    {
        return yearPublished;
    }
}