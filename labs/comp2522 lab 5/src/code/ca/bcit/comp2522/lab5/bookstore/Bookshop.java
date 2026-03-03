package ca.bcit.comp2522.lab5.bookstore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents a Bookshop containing a collection of Novels.
 * Provides functionality to print, filter and sort the inventory.
 *
 * @author Aika Manalo - Set 2C
 * @author Maeve Le - Set 2C
 *
 * @version 1.0
 */
public class Bookshop
{
    private final String             bookshopName;
    private final Map<String, Novel> novelDictionary;
    private final Set<String>        novelKeySet;

    /**
     * Constructs a new Bookshop with the specified name.
     * Initializes the dictionary and seeds it with a default collection of Novels.
     *
     * @param bookshopName the name of the Bookshop
     * @throws IllegalArgumentException if provided Bookshop name is invalid
     */
    public Bookshop(final String bookshopName)
    {
        validateBookshopName(bookshopName);

        this.bookshopName = bookshopName;

        novelDictionary = new HashMap<>();
        seedDictionary();

        novelKeySet = novelDictionary.keySet();
    }

    /*
     * Validates that the provided Bookshop name is not null or empty.
     *
     * @param nameToCheck the Bookstore given name to check
     * @throw IllegalArgumentException if provided Bookshop name is invalid
     */
    private static void validateBookshopName(final String nameToCheck)
    {
        if (nameToCheck == null || nameToCheck.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: Bookshop name must not be null or empty.");
        }
    }

    /*
     * Populates the Novel dictionary with a predefined list of Novels.
     */
    private void seedDictionary()
    {
        addReference("The Adventures of Augie March", "Saul Bellow", 1953);
        addReference("All the King's Men", "Robert Penn Warren", 1946);
        addReference("American Pastoral", "Philip Roth", 1997);
        addReference("An American Tragedy", "Theodore Dreiser", 1925);
        addReference("Animal Farm", "George Orwell", 1946);
        addReference("Appointment in Samarra", "John O'Hara", 1934);
        addReference("Are You There God? It's Me, Margaret.", "Judy Blume", 1970);
        addReference("The Assistant", "Bernard Malamud", 1957);
        addReference("At Swim-Two-Birds", "Flann O'Brien", 1938);
        addReference("Atonement", "Ian McEwan", 2002);
        addReference("Beloved", "Toni Morrison", 1987);
        addReference("The Berlin Stories", "Christopher Isherwood", 1946);
        addReference("The Big Sleep", "Raymond Chandler", 1939);
        addReference("The Blind Assassin", "Margaret Atwood", 2000);
        addReference("Blood Meridian", "Cormac McCarthy", 1986);
        addReference("Brideshead Revisited", "Evelyn Waugh", 1946);
        addReference("The Bridge of San Luis Rey", "Thornton Wilder", 1927);
        addReference("Call It Sleep", "Henry Roth", 1935);
        addReference("Catch-22", "Joseph Heller", 1961);
        addReference("The Catcher in the Rye", "J.D. Salinger", 1951);
        addReference("A Clockwork Orange", "Anthony Burgess", 1963);
        addReference("The Confessions of Nat Turner", "William Styron", 1967);
        addReference("The Corrections", "Jonathan Franzen", 2001);
        addReference("The Crying of Lot 49", "Thomas Pynchon", 1966);
        addReference("A Dance to the Music of Time", "Anthony Powell", 1951);
        addReference("The Day of the Locust", "Nathanael West", 1939);
        addReference("Death Comes for the Archbishop", "Willa Cather", 1927);
        addReference("A Death in the Family", "James Agee", 1958);
        addReference("The Death of the Heart", "Elizabeth Bowen", 1958);
        addReference("Deliverance", "James Dickey", 1970);
        addReference("Dog Soldiers", "Robert Stone", 1974);
        addReference("Falconer", "John Cheever", 1977);
        addReference("The French Lieutenant's Woman", "John Fowles", 1969);
        addReference("The Golden Notebook", "Doris Lessing", 1962);
        addReference("Go Tell It on the Mountain", "James Baldwin", 1953);
        addReference("Gone with the Wind", "Margaret Mitchell", 1936);
        addReference("The Grapes of Wrath", "John Steinbeck", 1939);
        addReference("Gravity's Rainbow", "Thomas Pynchon", 1973);
        addReference("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        addReference("A Handful of Dust", "Evelyn Waugh", 1934);
        addReference("The Heart Is a Lonely Hunter", "Carson McCullers", 1940);
        addReference("The Heart of the Matter", "Graham Greene", 1948);
        addReference("Herzog", "Saul Bellow", 1964);
        addReference("Housekeeping", "Marilynne Robinson", 1981);
        addReference("A House for Mr. Biswas", "V.S. Naipaul", 1962);
        addReference("I, Claudius", "Robert Graves", 1934);
        addReference("Infinite Jest", "David Foster Wallace", 1996);
        addReference("Invisible Man", "Ralph Ellison", 1952);
        addReference("Light in August", "William Faulkner", 1932);
        addReference("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950);
        addReference("Lolita", "Vladimir Nabokov", 1955);
        addReference("Lord of the Flies", "William Golding", 1954);
        addReference("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        addReference("Loving", "Henry Green", 1945);
        addReference("Lucky Jim", "Kingsley Amis", 1954);
        addReference("The Man Who Loved Children", "Christina Stead", 1940);
        addReference("Midnight's Children", "Salman Rushdie", 1981);
        addReference("Money", "Martin Amis", 1984);
        addReference("The Moviegoer", "Walker Percy", 1961);
        addReference("Mrs. Dalloway", "Virginia Woolf", 1925);
        addReference("Naked Lunch", "William Burroughs", 1959);
        addReference("Native Son", "Richard Wright", 1940);
        addReference("Neuromancer", "William Gibson", 1984);
        addReference("Never Let Me Go", "Kazuo Ishiguro", 2005);
        addReference("1984", "George Orwell", 1948);
        addReference("On the Road", "Jack Kerouac", 1957);
        addReference("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962);
        addReference("The Painted Bird", "Jerzy Kosinski", 1965);
        addReference("Pale Fire", "Vladimir Nabokov", 1962);
        addReference("A Passage to India", "E.M. Forster", 1924);
        addReference("Play It as It Lays", "Joan Didion", 1970);
        addReference("Portnoy's Complaint", "Philip Roth", 1969);
        addReference("Possession", "A.S. Byatt", 1990);
        addReference("The Power and the Glory", "Graham Greene", 1939);
        addReference("The Prime of Miss Jean Brodie", "Muriel Spark", 1961);
        addReference("Rabbit, Run", "John Updike", 1960);
        addReference("Ragtime", "E.L. Doctorow", 1975);
        addReference("The Recognitions", "William Gaddis", 1955);
        addReference("Red Harvest", "Dashiell Hammett", 1929);
        addReference("Revolutionary Road", "Richard Yates", 1961);
        addReference("The Sheltering Sky", "Paul Bowles", 1949);
        addReference("Slaughterhouse-Five", "Kurt Vonnegut", 1969);
        addReference("Snow Crash", "Neal Stephenson", 1992);
        addReference("The Sot-Weed Factor", "John Barth", 1960);
        addReference("The Sound and the Fury", "William Faulkner", 1929);
        addReference("The Sportswriter", "Richard Ford", 1986);
        addReference("The Spy Who Came in from the Cold", "John le Carré", 1964);
        addReference("The Sun Also Rises", "Ernest Hemingway", 1926);
        addReference("Their Eyes Were Watching God", "Zora Neale Hurston", 1937);
        addReference("Things Fall Apart", "Chinua Achebe", 1959);
        addReference("To Kill a Mockingbird", "Harper Lee", 1960);
        addReference("To the Lighthouse", "Virginia Woolf", 1929);
        addReference("Tropic of Cancer", "Henry Miller", 1934);
        addReference("Ubik", "Philip K. Dick", 1969);
        addReference("Under the Net", "Iris Murdoch", 1954);
        addReference("Under the Volcano", "Malcolm Lowry", 1947);
        addReference("Watchmen", "Alan Moore and Dave Gibbons", 1986);
        addReference("White Noise", "Don DeLillo", 1985);
        addReference("White Teeth", "Zadie Smith", 2000);
        addReference("Wide Sargasso Sea", "Jean Rhys", 1966);
    }

    /*
     * Creates a new Novel instance and adds it onto the Bookshop's dictionary.
     *
     * @param title the Novel title
     * @param authorName the Novel author
     * @param yearPublished the year the Novel was published
     */
    private void addReference(final String title,
                              final String authorName,
                              final int yearPublished)
    {
        final Novel novel;
        novel = new Novel(title, authorName,yearPublished);

        novelDictionary.put(novel.getTitle(), novel);
    }

    /**
     * Getter method for Bookshop name.
     *
     * @return the Bookshop's name
     */
    public String getBookshopName()
    {
        return bookshopName;
    }

    /**
     * Getter method for the Novel dictionary that contains all novels in the Bookshop.
     *
     * @return a Map where the key is the Novel title and value is the Novel
     */
    public Map<String, Novel> getNovelDictionary()
    {
        return novelDictionary;
    }

    /**
     * Getter method for the set of keys (Novel titles) that currently exist in the bookshop's dictionary.
     *
     * @return a Set of String keys representing the Novel titles
     */
    public Set<String> getNovelKeySet()
    {
        return novelKeySet;
    }

    /**
     * Iterates through the bookshop's dictionary and prints each novel to the standard output.
     */
    public void printBooks()
    {
        final Iterator<String> it;
        it = novelKeySet.iterator();

        while(it.hasNext())
        {
            final String novelKey;
            final Novel novel;

            novelKey = it.next();
            novel = novelDictionary.get(novelKey);

            System.out.println(novel);
        }
    }

    /**
     * Iterates through a provided list of keys and prints the corresponding novels.
     *
     * @param keySet a List of novel titles (keys) to print
     */
    public void printBooks(final List<String> keySet)
    {
        final Iterator<String> it;
        it = keySet.iterator();

        while(it.hasNext())
        {
            final String novelKey;
            final Novel novel;

            novelKey = it.next();
            novel = novelDictionary.get(novelKey);

            System.out.println(novel);
        }
    }

    /**
     * Filters the Bookshop's dictionary by removing any novel whose title
     * contains the specified word (case-insensitive).
     *
     * @param wordToRemove the substring to search for and remove
     */
    public void filterBooks(final String wordToRemove)
    {
        final Iterator<String> it;
        it = novelKeySet.iterator();

        while(it.hasNext())
        {
            final Novel novel;
            final String novelKey;
            final String novelTitle;


            novelKey = it.next();
            novel = novelDictionary.get(novelKey);
            novelTitle = novel.getTitle().toLowerCase();


            if (novelTitle
                      .contains(wordToRemove.toLowerCase()))
            {
                it.remove();
            }
        }
    }

    /**
     * Sorts the keys (novel titles) of the current dictionary alphabetically.
     *
     * @return a sorted List of strings containing the novel titles
     */
    public List<String> sortKeys()
    {
        final List<String> keyList;
        keyList = new ArrayList<>(novelKeySet);

        Collections.sort(keyList);

        return keyList;
    }

    /**
     * The main entry point for the application.
     * Demonstrates creating a Bookshop, printing the collection, filtering out
     * specific titles, and printing a sorted list.
     *
     * @param args unused
     */
    public static void main(String[] args)
    {
        final Bookshop bookShop;
        bookShop = new Bookshop("Nourish and Potts");

        System.out.println("1. Print all books | TOTAL: " + bookShop.getNovelDictionary().size());
        bookShop.printBooks();

        System.out.println();

        bookShop.filterBooks("the");
        System.out.println("2. Filter books | TOTAL: " + bookShop.getNovelDictionary().size());
        bookShop.printBooks();


        System.out.println();

        System.out.println("3. Sort books | TOTAL: " + bookShop.getNovelDictionary().size());
        final List<String> sortedKeys;
        sortedKeys = bookShop.sortKeys();
        bookShop.printBooks(sortedKeys);
    }
}
