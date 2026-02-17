package ca.bcit.comp2522.lab5.bookstore;

import java.util.*;

/**
 * Represents a Bookstore containing a library of Novels.
 * Provides various methods to search, filter, and analyze the collection.
 *
 * @author Aika Manalo - Set 2C
 * @author Maeve Le - Set 2C
 *
 * @version 1.0
 */
public class Bookstore
{
    private static final int NUM_YEARS_END_DECADE = 9;
    private static final int PERCENTAGE_MULTIPLIER = 100;

    private final String             bookstoreName;
    private final List<Novel>        library;

    /**
     * Constructs and initializes a Bookstore with a given name and a library that contains a list of Novels.
     * The library is also seeded with a list of Novels.
     *
     * @param bookstoreName the name of the Bookstore
     */
    public Bookstore(String bookstoreName)
    {
        validateBookstoreName(bookstoreName);
        this.bookstoreName   = bookstoreName;

        library = new ArrayList<>();

        seedLibrary();

    }

    /*
     * Validates the Bookstore name is not null or empty.
     *
     * @param nameToCheck the Bookstore name to check
     * @throws IllegalArgumentException if Bookstore name is invalid
     */
    private static void validateBookstoreName(final String nameToCheck)
    {
        if (nameToCheck == null || nameToCheck.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: Bookstore name must not be null or empty.");
        }
    }

    /*
     * Helper method to that seeds the library.
     */
    private void seedLibrary()
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
     * Creates a new Novel instance and adds it onto the Bookstore's library (list of Novels).
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
        library.add(novel);
    }

    /**
     * Getter method for Bookstore name.
     *
     * @return the Bookstore name
     */
    public String getBookstoreName()
    {
        return bookstoreName;
    }

    /**
     * Getter method for the library (list of Novels)
     *
     * @return the library (list of Novels)
     */
    public List<Novel> getLibrary()
    {
        return library;
    }

    /**
     * Prints all Novel titles in the library.
     */
    public void printAllTitles()
    {
        for (final Novel novel : library)
        {
            if (novel != null)
            {
                final String novelTitle;
                novelTitle = novel.getTitle().toUpperCase();

                System.out.println(novelTitle);
            }
        }
    }

    /**
     * Prints all Novel titles specified in the parameter within the library.
     *
     * @param title the Novel title
     */
    public void printBookTitle(final String title)
    {
        for (final Novel novel : library)
        {
            if (novel != null)
            {
                final String referenceTitle;
                final String novelTitle;

                referenceTitle = novel.getTitle().toLowerCase();
                novelTitle = title.toLowerCase();

                if (referenceTitle.contains(novelTitle))
                {
                    final String titleMatchFound;
                    titleMatchFound = novel.getTitle();

                    System.out.println(titleMatchFound);
                }

            }
        }

    }

    /**
     * Prints all Novel titles within the library in alphabetical order (A-Z).
     */
    public void printTitlesInAlphaOrder()
    {
        final List<Novel> alphaSortedList;
        if (library != null)
        {
            alphaSortedList = new ArrayList<>(library);

            alphaSortedList.sort(null);

            for (final Novel novel : alphaSortedList)
            {
                if (novel != null)
                {
                    System.out.println(novel.getTitle());
                }
            }
        }
    }

    /**
     * Prints all Novels for the specified decade.
     * i.e. 2000 -> prints all book titles from 2000 - 2009
     *
     * @param decade the decade range to check
     */
    public void printGroupByDecade(final int decade)
    {
        final int endDecade;
        endDecade = decade + NUM_YEARS_END_DECADE;

        for (final Novel novel : library)
        {
            if (novel != null)
            {
                final int novelYear;
                novelYear = novel.getYearPublished();

                if (novelYear >= decade && novelYear <= endDecade)
                {
                    System.out.println(novel);
                }
            }
        }
    }

    /**
     * Finds the longest title in the Bookstore within the library.
     *
     * @return the Novel with the longest title
     */
    public String getLongest()
    {
        String longestTitle;
        longestTitle = "";

        for (final Novel novel : library)
        {
            if (novel != null)
            {
                final String currentTitle;
                currentTitle  = novel.getTitle();

                if (currentTitle.length() > longestTitle.length())
                {
                    longestTitle = novel.getTitle();
                }
            }
        }
        return longestTitle;
    }

    /**
     * Checks if there is a Novel published in a given year.
     *
     * @param year the year to check if a Novel was published
     * @return true if a Novel was published in specified year, false otherwise
     */
    public boolean isThereABookWrittenIn(final int year)
    {
        for (final Novel novel : library)
        {
            if (novel != null &&
                novel.getYearPublished() == year)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the amount of Novels that contain a given word in their title (case-insensitive).
     *
     * @param word the word to look for in the Novel title
     * @return count of Novels that contain the given word
     */
    public int howManyBooksContain(final String word)
    {
        int count;
        count = 0;

        for (final Novel novel : library)
        {
            if (novel != null)
            {
                final String referenceTitle;
                referenceTitle = novel.getTitle().toLowerCase();

                if (referenceTitle.contains(word.toLowerCase()))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Returns the percentage of Novels that were written between two given years (inclusive).
     *
     * @param first the lower year bound to check
     * @param last the upper year bound to check
     * @return the percentage of Novels written between the lower and upper bound
     */
    public double whichPercentWrittenBetween(int first,
                                             int last)
    {
        final int referencesSize;
        int count;

        referencesSize = library.size();
        count = 0;

        for (final Novel novel : library)
        {
            if (novel != null)
            {
                if (novel.getYearPublished() >= first &&
                    novel.getYearPublished() <= last)
                {
                    count++;
                }
            }
        }
        return ((double) count / referencesSize) * PERCENTAGE_MULTIPLIER;
    }

    /**
     * Returns the oldest Novel in the Bookstore's library collection.
     * If two of the oldest Novels were published in the same year, returns the first Novel found.
     *
     * @return the oldest Novel in the Bookstore's library, null if library is empty
     */
    public Novel getOldestBook()
    {
        Novel oldestBook;
        oldestBook = null;

        for (final Novel novel : library)
        {
            if (novel != null)
            {
                // Set first book as initial oldest to start.
                if (oldestBook == null)
                {
                    oldestBook = novel;
                }
                else
                {
                    final int currentYear;
                    final int oldestYear;

                    currentYear = novel.getYearPublished();
                    oldestYear = oldestBook.getYearPublished();

                    // If the current book is older than the current stored, reassign it.
                    if (currentYear < oldestYear)
                    {
                        oldestBook = novel;
                    }
                }
            }
        }
        return oldestBook;
    }

    /**
     * Returns a List of Novels whose title matches the given length.
     *
     * @param titleLength the title length to check and match
     * @return a list of Novels that match the given title length
     */
    public List<Novel> getBooksThisLength(final int titleLength)
    {   final List<Novel> filteredBooks;
        filteredBooks = new ArrayList<>();

        for (final Novel novel : library)
        {
            if (novel != null)
            {
                final String currNovelTitle;
                currNovelTitle = novel.getTitle();

                if (currNovelTitle.length() == titleLength)
                {
                    filteredBooks.add(novel);
                }
            }
        }
        if (filteredBooks.isEmpty())
        {
            System.out.println("No books whose title is length is " + titleLength +
                               " was found.");
        }
        return filteredBooks;
    }

    /**
     * The main entry point for the application.
     * Demonstrates creating a Bookshop, printing the collection, filtering out
     * specific titles, and printing a sorted list.
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        // Variables
        final Bookstore bookstore;
        final List<Novel> fifteenCharTitles;

        // Initialize Bookstore
        bookstore = new Bookstore("Flourish and Botts");

        // Print out all titles
        System.out.println("All Titles in UPPERCASE:");
        bookstore.printAllTitles();
        System.out.println();

        // Filter books by word
        System.out.println("Book Titles Containing 'the':");
        bookstore.printBookTitle("the");
        System.out.println();

        // Sort books alphabetically
        System.out.println("All Titles in Alphabetical Order:");
        bookstore.printTitlesInAlphaOrder();
        System.out.println();

        // Group by decade
        System.out.println("Books from the 2000s:");
        bookstore.printGroupByDecade(2000);
        System.out.println();

        // Find the longest title
        System.out.println("Longest Book Title:");
        System.out.println(bookstore.getLongest());
        System.out.println();

        // Check for Novels published in specified year
        System.out.println("Is there a book written in 1950?");
        System.out.println(bookstore.isThereABookWrittenIn(1950));
        System.out.println();

        // Count of Novels by given word
        System.out.println("How many books contain 'heart'?");
        System.out.println(bookstore.howManyBooksContain("heart"));
        System.out.println();

        // Calculate the percentage of books written between lower and upper bound
        System.out.println("Percentage of books written between 1940 and 1950:");
        System.out.println(bookstore.whichPercentWrittenBetween(1940, 1950) + "%");
        System.out.println();

        // Find the oldest book in the collection
        System.out.println("Oldest book:");
        System.out.println(bookstore.getOldestBook());
        System.out.println();

        // Filter the title by length
        System.out.println("Books with titles 15 characters long:");
        fifteenCharTitles = bookstore.getBooksThisLength(15);

        for (Novel novel : fifteenCharTitles)
        {
            System.out.println(novel.getTitle());
        }
    }
}
