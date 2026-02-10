package ca.bcit.comp2522.lab5.bookstore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookStore
{
    private static final int MIN_NAME_CHARACTERS = 1;
    private static final int NUM_YEARS_END_DECADE = 9;

    private final String      bookstoreName;
    private final List<Novel> novelReferences;

    public BookStore(String bookstoreName)
    {
        validateBookstoreName(bookstoreName);
        this.bookstoreName   = bookstoreName;

        novelReferences = new ArrayList<>();

        // 1. DECLARATIONS
        final Novel n1;
        final Novel n2;
        final Novel n3;
        final Novel n4;
        final Novel n5;
        final Novel n6;
        final Novel n7;
        final Novel n8;
        final Novel n9;
        final Novel n10;
        final Novel n11;
        final Novel n12;
        final Novel n13;
        final Novel n14;
        final Novel n15;
        final Novel n16;
        final Novel n17;
        final Novel n18;
        final Novel n19;
        final Novel n20;
        final Novel n21;
        final Novel n22;
        final Novel n23;
        final Novel n24;
        final Novel n25;
        final Novel n26;
        final Novel n27;
        final Novel n28;
        final Novel n29;
        final Novel n30;
        final Novel n31;
        final Novel n32;
        final Novel n33;
        final Novel n34;
        final Novel n35;
        final Novel n36;
        final Novel n37;
        final Novel n38;
        final Novel n39;
        final Novel n40;
        final Novel n41;
        final Novel n42;
        final Novel n43;
        final Novel n44;
        final Novel n45;
        final Novel n46;
        final Novel n47;
        final Novel n48;
        final Novel n49;
        final Novel n50;
        final Novel n51;
        final Novel n52;
        final Novel n53;
        final Novel n54;
        final Novel n55;
        final Novel n56;
        final Novel n57;
        final Novel n58;
        final Novel n59;
        final Novel n60;
        final Novel n61;
        final Novel n62;
        final Novel n63;
        final Novel n64;
        final Novel n65;
        final Novel n66;
        final Novel n67;
        final Novel n68;
        final Novel n69;
        final Novel n70;
        final Novel n71;
        final Novel n72;
        final Novel n73;
        final Novel n74;
        final Novel n75;
        final Novel n76;
        final Novel n77;
        final Novel n78;
        final Novel n79;
        final Novel n80;
        final Novel n81;
        final Novel n82;
        final Novel n83;
        final Novel n84;
        final Novel n85;
        final Novel n86;
        final Novel n87;
        final Novel n88;
        final Novel n89;
        final Novel n90;
        final Novel n91;
        final Novel n92;
        final Novel n93;
        final Novel n94;
        final Novel n95;
        final Novel n96;
        final Novel n97;
        final Novel n98;
        final Novel n99;
        final Novel n100;

        // 2. INSTANTIATION
        n1 = new Novel("The Adventures of Augie March", "Saul Bellow", 1953);
        n2 = new Novel("All the King's Men", "Robert Penn Warren", 1946);
        n3 = new Novel("American Pastoral", "Philip Roth", 1997);
        n4 = new Novel("An American Tragedy", "Theodore Dreiser", 1925);
        n5 = new Novel("Animal Farm", "George Orwell", 1946);
        n6 = new Novel("Appointment in Samarra", "John O'Hara", 1934);
        n7 = new Novel("Are You There God? It's Me, Margaret.", "Judy Blume", 1970);
        n8 = new Novel("The Assistant", "Bernard Malamud", 1957);
        n9 = new Novel("At Swim-Two-Birds", "Flann O'Brien", 1938);
        n10 = new Novel("Atonement", "Ian McEwan", 2002);
        n11 = new Novel("Beloved", "Toni Morrison", 1987);
        n12 = new Novel("The Berlin Stories", "Christopher Isherwood", 1946);
        n13 = new Novel("The Big Sleep", "Raymond Chandler", 1939);
        n14 = new Novel("The Blind Assassin", "Margaret Atwood", 2000);
        n15 = new Novel("Blood Meridian", "Cormac McCarthy", 1986);
        n16 = new Novel("Brideshead Revisited", "Evelyn Waugh", 1946);
        n17 = new Novel("The Bridge of San Luis Rey", "Thornton Wilder", 1927);
        n18 = new Novel("Call It Sleep", "Henry Roth", 1935);
        n19 = new Novel("Catch-22", "Joseph Heller", 1961);
        n20 = new Novel("The Catcher in the Rye", "J.D. Salinger", 1951);
        n21 = new Novel("A Clockwork Orange", "Anthony Burgess", 1963);
        n22 = new Novel("The Confessions of Nat Turner", "William Styron", 1967);
        n23 = new Novel("The Corrections", "Jonathan Franzen", 2001);
        n24 = new Novel("The Crying of Lot 49", "Thomas Pynchon", 1966);
        n25 = new Novel("A Dance to the Music of Time", "Anthony Powell", 1951);
        n26 = new Novel("The Day of the Locust", "Nathanael West", 1939);
        n27 = new Novel("Death Comes for the Archbishop", "Willa Cather", 1927);
        n28 = new Novel("A Death in the Family", "James Agee", 1958);
        n29 = new Novel("The Death of the Heart", "Elizabeth Bowen", 1958);
        n30 = new Novel("Deliverance", "James Dickey", 1970);
        n31 = new Novel("Dog Soldiers", "Robert Stone", 1974);
        n32 = new Novel("Falconer", "John Cheever", 1977);
        n33 = new Novel("The French Lieutenant's Woman", "John Fowles", 1969);
        n34 = new Novel("The Golden Notebook", "Doris Lessing", 1962);
        n35 = new Novel("Go Tell It on the Mountain", "James Baldwin", 1953);
        n36 = new Novel("Gone with the Wind", "Margaret Mitchell", 1936);
        n37 = new Novel("The Grapes of Wrath", "John Steinbeck", 1939);
        n38 = new Novel("Gravity's Rainbow", "Thomas Pynchon", 1973);
        n39 = new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        n40 = new Novel("A Handful of Dust", "Evelyn Waugh", 1934);
        n41 = new Novel("The Heart Is a Lonely Hunter", "Carson McCullers", 1940);
        n42 = new Novel("The Heart of the Matter", "Graham Greene", 1948);
        n43 = new Novel("Herzog", "Saul Bellow", 1964);
        n44 = new Novel("Housekeeping", "Marilynne Robinson", 1981);
        n45 = new Novel("A House for Mr. Biswas", "V.S. Naipaul", 1962);
        n46 = new Novel("I, Claudius", "Robert Graves", 1934);
        n47 = new Novel("Infinite Jest", "David Foster Wallace", 1996);
        n48 = new Novel("Invisible Man", "Ralph Ellison", 1952);
        n49 = new Novel("Light in August", "William Faulkner", 1932);
        n50 = new Novel("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950);
        n51 = new Novel("Lolita", "Vladimir Nabokov", 1955);
        n52 = new Novel("Lord of the Flies", "William Golding", 1954);
        n53 = new Novel("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        n54 = new Novel("Loving", "Henry Green", 1945);
        n55 = new Novel("Lucky Jim", "Kingsley Amis", 1954);
        n56 = new Novel("The Man Who Loved Children", "Christina Stead", 1940);
        n57 = new Novel("Midnight's Children", "Salman Rushdie", 1981);
        n58 = new Novel("Money", "Martin Amis", 1984);
        n59 = new Novel("The Moviegoer", "Walker Percy", 1961);
        n60 = new Novel("Mrs. Dalloway", "Virginia Woolf", 1925);
        n61 = new Novel("Naked Lunch", "William Burroughs", 1959);
        n62 = new Novel("Native Son", "Richard Wright", 1940);
        n63 = new Novel("Neuromancer", "William Gibson", 1984);
        n64 = new Novel("Never Let Me Go", "Kazuo Ishiguro", 2005);
        n65 = new Novel("1984", "George Orwell", 1948);
        n66 = new Novel("On the Road", "Jack Kerouac", 1957);
        n67 = new Novel("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962);
        n68 = new Novel("The Painted Bird", "Jerzy Kosinski", 1965);
        n69 = new Novel("Pale Fire", "Vladimir Nabokov", 1962);
        n70 = new Novel("A Passage to India", "E.M. Forster", 1924);
        n71 = new Novel("Play It as It Lays", "Joan Didion", 1970);
        n72 = new Novel("Portnoy's Complaint", "Philip Roth", 1969);
        n73 = new Novel("Possession", "A.S. Byatt", 1990);
        n74 = new Novel("The Power and the Glory", "Graham Greene", 1939);
        n75 = new Novel("The Prime of Miss Jean Brodie", "Muriel Spark", 1961);
        n76 = new Novel("Rabbit, Run", "John Updike", 1960);
        n77 = new Novel("Ragtime", "E.L. Doctorow", 1975);
        n78 = new Novel("The Recognitions", "William Gaddis", 1955);
        n79 = new Novel("Red Harvest", "Dashiell Hammett", 1929);
        n80 = new Novel("Revolutionary Road", "Richard Yates", 1961);
        n81 = new Novel("The Sheltering Sky", "Paul Bowles", 1949);
        n82 = new Novel("Slaughterhouse-Five", "Kurt Vonnegut", 1969);
        n83 = new Novel("Snow Crash", "Neal Stephenson", 1992);
        n84 = new Novel("The Sot-Weed Factor", "John Barth", 1960);
        n85 = new Novel("The Sound and the Fury", "William Faulkner", 1929);
        n86 = new Novel("The Sportswriter", "Richard Ford", 1986);
        n87 = new Novel("The Spy Who Came in from the Cold", "John le Carré", 1964);
        n88 = new Novel("The Sun Also Rises", "Ernest Hemingway", 1926);
        n89 = new Novel("Their Eyes Were Watching God", "Zora Neale Hurston", 1937);
        n90 = new Novel("Things Fall Apart", "Chinua Achebe", 1959);
        n91 = new Novel("To Kill a Mockingbird", "Harper Lee", 1960);
        n92 = new Novel("To the Lighthouse", "Virginia Woolf", 1929);
        n93 = new Novel("Tropic of Cancer", "Henry Miller", 1934);
        n94 = new Novel("Ubik", "Philip K. Dick", 1969);
        n95 = new Novel("Under the Net", "Iris Murdoch", 1954);
        n96 = new Novel("Under the Volcano", "Malcolm Lowry", 1947);
        n97 = new Novel("Watchmen", "Alan Moore and Dave Gibbons", 1986);
        n98 = new Novel("White Noise", "Don DeLillo", 1985);
        n99 = new Novel("White Teeth", "Zadie Smith", 2000);
        n100 = new Novel("Wide Sargasso Sea", "Jean Rhys", 1966);

        // 3. ADD TO LIST
        novelReferences.add(n1);
        novelReferences.add(n2);
        novelReferences.add(n3);
        novelReferences.add(n4);
        novelReferences.add(n5);
        novelReferences.add(n6);
        novelReferences.add(n7);
        novelReferences.add(n8);
        novelReferences.add(n9);
        novelReferences.add(n10);
        novelReferences.add(n11);
        novelReferences.add(n12);
        novelReferences.add(n13);
        novelReferences.add(n14);
        novelReferences.add(n15);
        novelReferences.add(n16);
        novelReferences.add(n17);
        novelReferences.add(n18);
        novelReferences.add(n19);
        novelReferences.add(n20);
        novelReferences.add(n21);
        novelReferences.add(n22);
        novelReferences.add(n23);
        novelReferences.add(n24);
        novelReferences.add(n25);
        novelReferences.add(n26);
        novelReferences.add(n27);
        novelReferences.add(n28);
        novelReferences.add(n29);
        novelReferences.add(n30);
        novelReferences.add(n31);
        novelReferences.add(n32);
        novelReferences.add(n33);
        novelReferences.add(n34);
        novelReferences.add(n35);
        novelReferences.add(n36);
        novelReferences.add(n37);
        novelReferences.add(n38);
        novelReferences.add(n39);
        novelReferences.add(n40);
        novelReferences.add(n41);
        novelReferences.add(n42);
        novelReferences.add(n43);
        novelReferences.add(n44);
        novelReferences.add(n45);
        novelReferences.add(n46);
        novelReferences.add(n47);
        novelReferences.add(n48);
        novelReferences.add(n49);
        novelReferences.add(n50);
        novelReferences.add(n51);
        novelReferences.add(n52);
        novelReferences.add(n53);
        novelReferences.add(n54);
        novelReferences.add(n55);
        novelReferences.add(n56);
        novelReferences.add(n57);
        novelReferences.add(n58);
        novelReferences.add(n59);
        novelReferences.add(n60);
        novelReferences.add(n61);
        novelReferences.add(n62);
        novelReferences.add(n63);
        novelReferences.add(n64);
        novelReferences.add(n65);
        novelReferences.add(n66);
        novelReferences.add(n67);
        novelReferences.add(n68);
        novelReferences.add(n69);
        novelReferences.add(n70);
        novelReferences.add(n71);
        novelReferences.add(n72);
        novelReferences.add(n73);
        novelReferences.add(n74);
        novelReferences.add(n75);
        novelReferences.add(n76);
        novelReferences.add(n77);
        novelReferences.add(n78);
        novelReferences.add(n79);
        novelReferences.add(n80);
        novelReferences.add(n81);
        novelReferences.add(n82);
        novelReferences.add(n83);
        novelReferences.add(n84);
        novelReferences.add(n85);
        novelReferences.add(n86);
        novelReferences.add(n87);
        novelReferences.add(n88);
        novelReferences.add(n89);
        novelReferences.add(n90);
        novelReferences.add(n91);
        novelReferences.add(n92);
        novelReferences.add(n93);
        novelReferences.add(n94);
        novelReferences.add(n95);
        novelReferences.add(n96);
        novelReferences.add(n97);
        novelReferences.add(n98);
        novelReferences.add(n99);
        novelReferences.add(n100);
    }

    private static void validateBookstoreName(final String nameToCheck)
    {
        if (nameToCheck == null || nameToCheck.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: BookStore name must not be null or empty.");
        }
    }

    String getBookstoreName()
    {
        return bookstoreName;
    }

    List<Novel> getNovelReferences()
    {
        return novelReferences;
    }

    public void printAllTitles()
    {
        if (novelReferences != null)
        {
            for (final Novel novel : novelReferences)
            {
                if (novel != null)
                {
                    final String novelTitle;
                    novelTitle = novel.getTitle().toUpperCase();

                    System.out.println(novelTitle);
                }
            }
        }
    }

    public void printBookTitle(final String title)
    {
        if (novelReferences != null)
        {
            for (final Novel novel : novelReferences)
            {
                final String referenceTitle;
                final String novelTitle;

                referenceTitle = novel.getTitle().toLowerCase();
                novelTitle = title.toLowerCase();

                if (novel != null && referenceTitle.contains(novelTitle))
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
        alphaSortedList = new ArrayList<>(novelReferences);

        Collections.sort(alphaSortedList);

        for (final Novel novel : alphaSortedList)
        {
            if (novel != null)
            {
                System.out.println(novel.getTitle());
            }
        }
    }

    public void printGroupByDecade(final int decade)
    {
        final int endDecade;
        endDecade = decade + NUM_YEARS_END_DECADE;

        for (final Novel novel : novelReferences)
        {
            if (novel != null)
            {
                final int novelYear;
                novelYear = novel.getYearPublished();

                if (novelYear >= decade && novelYear <= endDecade)
                {
                    System.out.println(novel.getTitle());
                }
            }
        }
    }

    public String getLongest()
    {
        String longestTitle;
        longestTitle = "";

        for (final Novel novel : novelReferences)
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









    public static void main(final String[] args)
    {
        final BookStore bookStore;
        bookStore = new BookStore("Flourish and Botts");

        // bookStore.printAllTitles();
        // bookStore.printBookTitle("the");
        // bookStore.printTitlesInAlphaOrder();

    }
}
