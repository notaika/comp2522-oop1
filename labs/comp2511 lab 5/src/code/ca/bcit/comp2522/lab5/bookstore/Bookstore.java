package ca.bcit.comp2522.lab5.bookstore;

import java.util.*;

public class Bookstore
{
    private static final int NUM_YEARS_END_DECADE = 9;
    private static final int PERCENTAGE_MULTIPLIER = 100;

    private final String             bookstoreName;
    private final List<Novel>        novelList;


    public Bookstore(String bookstoreName)
    {
        validateBookstoreName(bookstoreName);
        this.bookstoreName   = bookstoreName;

        novelList = new ArrayList<>();

        seedLibrary();

    }

    private static void validateBookstoreName(final String nameToCheck)
    {
        if (nameToCheck == null || nameToCheck.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: Bookstore name must not be null or empty.");
        }
    }

    public String getBookstoreName()
    {
        return bookstoreName;
    }

    public List<Novel> getNovelList()
    {
        return novelList;
    }

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

    private void addReference(final String title,
                                 final String authorName,
                                 final int yearPublished)
    {
        final Novel novel;
        novel = new Novel(title, authorName,yearPublished);
        novelList.add(novel);
    }

    public void printAllTitles()
    {
        for (final Novel novel : novelList)
        {
            if (novel != null)
            {
                final String novelTitle;
                novelTitle = novel.getTitle().toUpperCase();

                System.out.println(novelTitle);
            }
        }
    }

    public void printBookTitle(final String title)
    {
        for (final Novel novel : novelList)
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

    public void printTitlesInAlphaOrder()
    {
        final List<Novel> alphaSortedList;
        if (novelList != null)
        {
            alphaSortedList = new ArrayList<>(novelList);

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

    public void printGroupByDecade(final int decade)
    {
        final int endDecade;
        endDecade = decade + NUM_YEARS_END_DECADE;

        for (final Novel novel : novelList)
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

    public String getLongest()
    {
        String longestTitle;
        longestTitle = "";

        for (final Novel novel : novelList)
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

    public boolean isThereABookWrittenIn(final int year)
    {
        for (final Novel novel : novelList)
        {
            if (novel != null &&
                novel.getYearPublished() == year)
            {
                return true;
            }
        }
        return false;
    }

    public int howManyBooksContain(final String word)
    {
        int count;
        count = 0;

        for (final Novel novel : novelList)
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

    public double whichPercentWrittenBetween(int first,
                                             int last)
    {
        final int referencesSize;
        int count;

        referencesSize = novelList.size();
        count = 0;

        for (final Novel novel : novelList)
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

    // EDIT THIS
    public Novel getOldestBook()
    {
        Novel oldestBook;
        oldestBook = null;

        for (final Novel novel : novelList)
        {
            if (novel != null)
            {
                final int currentYear;
                int tempYear;

                currentYear = novel.getYearPublished();
                tempYear = 0;

                if (currentYear > tempYear)
                {
                    oldestBook = novel;
                }
            }
        }

        return oldestBook;
    }

    public List<Novel> getBooksThisLength(final int titleLength)
    {   final List<Novel> filteredBooks;
        filteredBooks = new ArrayList<>();

        for (final Novel novel : novelList)
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

    public static void main(final String[] args)
    {
        final Bookstore bookStore;
        bookStore = new Bookstore("Flourish and Botts");

        // bookStore.printAllTitles();
        // bookStore.printBookTitle("the");
        // bookStore.printTitlesInAlphaOrder();
        // System.out.println(bookStore.getLongest());
         System.out.println(bookStore.isThereABookWrittenIn(2000));
         bookStore.printGroupByDecade(2000);
         System.out.println(bookStore.howManyBooksContain("heart"));
        // Novel n1 = new Novel("aaa", "aaa", 123);
        // bookStore.getNovelReferences().add(n1);
        System.out.println(bookStore.whichPercentWrittenBetween(1940, 1950) + "%");
        final List<Novel> filtered;
        filtered = bookStore.getBooksThisLength(15);

        for (final Novel novel : filtered)
        {
            System.out.println(novel.getTitle());
        }
    }
}
