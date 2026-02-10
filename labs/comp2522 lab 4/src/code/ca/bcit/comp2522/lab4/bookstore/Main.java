package ca.bcit.comp2522.lab4.bookstore;

/**
 * Main class to demonstrate the Bookstore System.
 * Tests inheritance, interfaces (Printable, Reversible, Comparable),
 * and object equality.
 *
 * @author Aika Manalo - 2C
 * @author Devan Lam - 2C
 * @version 1.0
 */
public class Main
{
    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        // 1. Setup Authors and Subjects
        // ---------------------------------------------------------------------
        // George Orwell (Deceased)
        final Name nameOrwell = new Name("George", "Orwell");
        final Date dobOrwell = new Date(1903, 6, 25);
        final Date dodOrwell = new Date(1950, 1, 21);
        final Author authorOrwell = new Author(nameOrwell, dobOrwell, dodOrwell, "Dystopian");

        // Walter Isaacson (Living)
        final Name nameIsaacson = new Name("Walter", "Isaacson");
        final Date dobIsaacson = new Date(1952, 5, 20);
        final Author authorIsaacson = new Author(nameIsaacson, dobIsaacson, "Biography");

        // Anne Frank (Autobiographer)
        final Name nameFrank = new Name("Anne", "Frank");
        final Date dobFrank = new Date(1929, 6, 12);
        final Date dodFrank = new Date(1945, 2, 1);
        final Author authorFrank = new Author(nameFrank, dobFrank, dodFrank, "Memoir");

        // Subject: Steve Jobs
        final Person subjectJobs = new Person(new Name("Steve", "Jobs"),
                                              new Date(1955, 2, 24),
                                              new Date(2011, 10, 5));

        // 2. Create Book Objects
        // ---------------------------------------------------------------------
        // Standard Book
        final Book book1984;
        book1984 = new Book("1984", 1949, authorOrwell);

        // Biography (Steve Jobs by Isaacson)
        final Biography bioJobs;
        bioJobs = new Biography("Steve Jobs", 2011, authorIsaacson, subjectJobs);

        // Autobiography (Anne Frank)
        final Autobiography autoFrank;
        autoFrank = new Autobiography("The Diary of a Young Girl", 1947, authorFrank);

        // 3. Test Printable Interface
        // ---------------------------------------------------------------------
        System.out.println("=== TEST 1: PRINTABLE ===");
        System.out.print("BOOK: ");
        book1984.display();
        System.out.print("BIOGRAPHY: ");
        bioJobs.display();
        System.out.print("AUTOBIOGRAPHY: ");
        autoFrank.display();
        System.out.println();

        // 4. Test Reversible Interface (backward)
        // ---------------------------------------------------------------------
        System.out.println("=== TEST 2: REVERSIBLE ===");
        System.out.print("Reversing Book Title '1984': ");
        book1984.backward();

        System.out.print("Reversing Author Name 'George Orwell': ");
        authorOrwell.backward();
        System.out.println();

        // 5. Test Comparable Interface (compareTo)
        // ---------------------------------------------------------------------
        System.out.println("=== TEST 3: COMPARABLE ===");
        final int comparison = book1984.compareTo(bioJobs);
        System.out.println("Comparing '1984' (1949) to 'Steve Jobs' (2011): " + comparison);

        if (comparison > 0)
        {
            System.out.println("PASS: 1984 is considered 'larger' (older).");
        }
        else
        {
            System.out.println("FAIL: Steve Jobs is considered 'larger' (older).");
        }
        System.out.println();

        // 6. Test Equality (.equals)
        // ---------------------------------------------------------------------
        System.out.println("=== TEST 4: EQUALITY ===");

        final Biography anotherJobsBio;
        anotherJobsBio = new Biography("Becoming Steve Jobs", 2015, authorOrwell, subjectJobs);

        // Compare two biographies about Steve Jobs
        System.out.println("Comparing two different books about Steve Jobs:");
        if (bioJobs.equals(anotherJobsBio))
        {
            System.out.println("PASS: The biographies are considered equal (Same Subject).");
        }
        else
        {
            System.out.println("FAIL: The biographies are NOT equal.");
        }

        // Compare Book to Biography (Should be false)
        System.out.println("Comparing '1984' to 'Steve Jobs': ");
        if (!book1984.equals(bioJobs))
        {
            System.out.println("PASS: false | Book != Biography");
        }
        else
        {
            System.out.println("FAIL: true; a book is not always a biography");
        }
    }


}