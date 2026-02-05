package ca.bcit.comp2522.lab4.bookstore;

/**
 * Main class to demonstrate the Bookstore System.
 *
 * @author Aika Manalo - 2C
 * @author Devan Lam - 2C
 *
 * @version 1.0
 */
public class Main {
    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(String[] args) {

        // Names
        Name nameOrwell;
        Name nameLee;
        Name nameAusten;
        Name nameFitzgerald;
        Name nameMelville;
        Name nameCaro;
        Name nameIsaacson;
        Name nameGilbert;
        Name nameChernow;
        Name nameMoses;
        Name nameJobs;
        Name nameChurchill;
        Name nameHamilton;
        Name nameEinstein;
        Name nameFrank;
        Name nameMandela;
        Name nameGandhi;
        Name nameAngelou;
        Name nameMalcolmX;

        // Dates
        Date dobOrwell;
        Date dodOrwell;
        Date dobLee;
        Date dodLee;
        Date dobAusten;
        Date dodAusten;
        Date dobFitzgerald;
        Date dodFitzgerald;
        Date dobMelville;
        Date dodMelville;
        Date dobCaro;
        Date dobIsaacson;
        Date dobGilbert;
        Date dodGilbert;
        Date dobChernow;
        Date dobMoses;
        Date dodMoses;
        Date dobJobs;
        Date dodJobs;
        Date dobChurchill;
        Date dodChurchill;
        Date dobHamilton;
        Date dodHamilton;
        Date dobEinstein;
        Date dodEinstein;
        Date dobFrank;
        Date dodFrank;
        Date dobMandela;
        Date dodMandela;
        Date dobGandhi;
        Date dodGandhi;
        Date dobAngelou;
        Date dodAngelou;
        Date dobMalcolmX;
        Date dodMalcolmX;

        // Authors
        Author orwell;
        Author lee;
        Author austen;
        Author fitzgerald;
        Author melville;
        Author caro;
        Author isaacson;
        Author gilbert;
        Author chernow;
        Author frank;
        Author mandela;
        Author gandhi;
        Author angelou;
        Author malcolmX;

        // People (Subjects)
        Person moses;
        Person jobs;
        Person churchill;
        Person hamilton;
        Person einstein;

        // Books
        Book b1;
        Book b2;
        Book b3;
        Book b4;
        Book b5;

        // Biographies
        Biography bio1;
        Biography bio2;
        Biography bio3;
        Biography bio4;
        Biography bio5;

        // Autobiographies
        Autobiography auto1;
        Autobiography auto2;
        Autobiography auto3;
        Autobiography auto4;
        Autobiography auto5;

        // --- 2. INITIALIZE ---

        // Names Initialization
        nameOrwell = new Name("George", "Orwell");
        nameLee = new Name("Harper", "Lee");
        nameAusten = new Name("Jane", "Austen");
        nameFitzgerald = new Name("F. Scott", "Fitzgerald");
        nameMelville = new Name("Herman", "Melville");
        nameCaro = new Name("Robert", "Caro");
        nameIsaacson = new Name("Walter", "Isaacson");
        nameGilbert = new Name("Martin", "Gilbert");
        nameChernow = new Name("Ron", "Chernow");
        nameMoses = new Name("Robert", "Moses");
        nameJobs = new Name("Steve", "Jobs");
        nameChurchill = new Name("Winston", "Churchill");
        nameHamilton = new Name("Alexander", "Hamilton");
        nameEinstein = new Name("Albert", "Einstein");
        nameFrank = new Name("Anne", "Frank");
        nameMandela = new Name("Nelson", "Mandela");
        nameGandhi = new Name("Mahatma", "Gandhi");
        nameAngelou = new Name("Maya", "Angelou");
        nameMalcolmX = new Name("Malcolm", "X");

        // Dates Initialization
        dobOrwell = new Date(1903, 6, 25);
        dodOrwell = new Date(1950, 1, 21);
        dobLee = new Date(1926, 4, 28);
        dodLee = new Date(2016, 2, 19);
        dobAusten = new Date(1775, 12, 16);
        dodAusten = new Date(1817, 7, 18);
        dobFitzgerald = new Date(1896, 9, 24);
        dodFitzgerald = new Date(1940, 12, 21);
        dobMelville = new Date(1819, 8, 1);
        dodMelville = new Date(1891, 9, 28);
        dobCaro = new Date(1935, 10, 30);
        dobIsaacson = new Date(1952, 5, 20);
        dobGilbert = new Date(1936, 10, 25);
        dodGilbert = new Date(2015, 2, 3);
        dobChernow = new Date(1949, 3, 3);
        dobMoses = new Date(1888, 12, 18);
        dodMoses = new Date(1981, 7, 29);
        dobJobs = new Date(1955, 2, 24);
        dodJobs = new Date(2011, 10, 5);
        dobChurchill = new Date(1874, 11, 30);
        dodChurchill = new Date(1965, 1, 24);
        dobHamilton = new Date(1755, 1, 11);
        dodHamilton = new Date(1804, 7, 12);
        dobEinstein = new Date(1879, 3, 14);
        dodEinstein = new Date(1955, 4, 18);
        dobFrank = new Date(1929, 6, 12);
        dodFrank = new Date(1945, 2, 1);
        dobMandela = new Date(1918, 7, 18);
        dodMandela = new Date(2013, 12, 5);
        dobGandhi = new Date(1869, 10, 2);
        dodGandhi = new Date(1948, 1, 30);
        dobAngelou = new Date(1928, 4, 4);
        dodAngelou = new Date(2014, 5, 28);
        dobMalcolmX = new Date(1925, 5, 19);
        dodMalcolmX = new Date(1965, 2, 21);

        // Authors Initialization
        orwell = new Author(nameOrwell, dobOrwell, dodOrwell, "Dystopian");
        lee = new Author(nameLee, dobLee, dodLee, "Southern Gothic");
        austen = new Author(nameAusten, dobAusten, dodAusten, "Romance");
        fitzgerald = new Author(nameFitzgerald, dobFitzgerald, dodFitzgerald, "Modernist");
        melville = new Author(nameMelville, dobMelville, dodMelville, "Adventure");
        caro = new Author(nameCaro, dobCaro, null, "Biography");
        isaacson = new Author(nameIsaacson, dobIsaacson, null, "Biography");
        gilbert = new Author(nameGilbert, dobGilbert, dodGilbert, "History");
        chernow = new Author(nameChernow, dobChernow, null, "Biography");
        frank = new Author(nameFrank, dobFrank, dodFrank, "Memoir");
        mandela = new Author(nameMandela, dobMandela, dodMandela, "Politics");
        gandhi = new Author(nameGandhi, dobGandhi, dodGandhi, "Philosophy");
        angelou = new Author(nameAngelou, dobAngelou, dodAngelou, "Poetry");
        malcolmX = new Author(nameMalcolmX, dobMalcolmX, dodMalcolmX, "Memoir");

        // People (Subjects) Initialization
        moses = new Person(nameMoses, dobMoses, dodMoses);
        jobs = new Person(nameJobs, dobJobs, dodJobs);
        churchill = new Person(nameChurchill, dobChurchill, dodChurchill);
        hamilton = new Person(nameHamilton, dobHamilton, dodHamilton);
        einstein = new Person(nameEinstein, dobEinstein, dodEinstein);

        // Books Initialization
        b1 = new Book("1984", 1949, orwell);
        b2 = new Book("To Kill a Mockingbird", 1960, lee);
        b3 = new Book("Pride and Prejudice", 1813, austen);
        b4 = new Book("The Great Gatsby", 1925, fitzgerald);
        b5 = new Book("Moby-Dick", 1851, melville);

        // Biographies Initialization
        bio1 = new Biography("The Power Broker", 1974, caro, moses);
        bio2 = new Biography("Steve Jobs", 2011, isaacson, jobs);
        bio3 = new Biography("Churchill: A Life", 1991, gilbert, churchill);
        bio4 = new Biography("Alexander Hamilton", 2004, chernow, hamilton);
        bio5 = new Biography("Einstein: His Life and Universe", 2007, isaacson, einstein);

        // Autobiographies Initialization
        auto1 = new Autobiography("The Diary of a Young Girl", 1947, frank);
        auto2 = new Autobiography("Long Walk to Freedom", 1994, mandela);
        auto3 = new Autobiography("The Story of My Experiments with Truth", 1927, gandhi);
        auto4 = new Autobiography("I Know Why the Caged Bird Sings", 1969, angelou);
        auto5 = new Autobiography("Autobiography of Malcolm X", 1965, malcolmX);

        // --- 3. USE METHODS ---

        // 3.1 Printing via Printable Interface
        // Lab Requirement: Print details for each object including parent attributes
        System.out.println("=== 3.1 PRINTABLE INTERFACE DEMONSTRATION ===");
        System.out.println("--- Books ---");
        b1.display();
        b2.display();
        b3.display();
        b4.display();
        b5.display();

        System.out.println("\n--- Biographies ---");
        bio1.display();
        bio2.display();
        bio3.display();
        bio4.display();
        bio5.display();

        System.out.println("\n--- Autobiographies ---");
        auto1.display();
        auto2.display();
        auto3.display();
        auto4.display();
        auto5.display();
        System.out.println();

        // 3.2 Reversal via Reversible Interface
        // Lab Requirement: Print book titles and author names backward
        System.out.println("=== 3.2 REVERSIBLE INTERFACE DEMONSTRATION ===");
        System.out.print("Book Title ('1984') Backward: ");
        b1.backward();
        System.out.print("Book Title ('Moby-Dick') Backward: ");
        b5.backward();
        System.out.print("Author Name ('George Orwell') Backward: ");
        orwell.backward();
        System.out.print("Author Name ('Nelson Mandela') Backward: ");
        mandela.backward();
        System.out.println();

        // 3.3 Comparisons via Comparable (compareTo)
        // Older entities are "larger" (positive result)
        System.out.println("=== 3.3 COMPARABLE (OLDER IS LARGER) DEMONSTRATION ===");

        // Compare Books by publication year
        System.out.println("Comparing 'Pride and Prejudice' (1813) to '1984' (1949): " + b3.compareTo(b1));
        System.out.println("Result: " + (b3.compareTo(b1) > 0 ? "Pride and Prejudice is older/larger." : "1984 is older/larger."));

        // Compare Authors by birthdate
        System.out.println("Comparing Jane Austen (1775) to George Orwell (1903): " + austen.compareTo(orwell));
        System.out.println("Result: " + (austen.compareTo(orwell) > 0 ? "Austen is older/larger." : "Orwell is older/larger."));

        // Compare Autobiographies by publication year
        System.out.println("Comparing Gandhi (1927) to Mandela (1994): " + auto3.compareTo(auto2));
        System.out.println();

        // 3.4 Equality via .equals()
        // Lab Requirement: Compare Biographies by subjects
        System.out.println("=== 3.4 EQUALITY (.EQUALS) DEMONSTRATION ===");

        // Test Biography Equality: Different book, same subject
        Biography bioEinsteinNew;
        bioEinsteinNew = new Biography("Relativity and the Soul", 2026, orwell, einstein);
        System.out.println("Comparing bio5 (Einstein) with bioEinsteinNew (Einstein): " + bio5.equals(bioEinsteinNew));

        // Test Biography Equality: Different subjects
        System.out.println("Comparing bio1 (Moses) with bio2 (Jobs): " + bio1.equals(bio2));

        // Test Autobiography Equality: Subject should match Author
        System.out.println("Is auto1 (Anne Frank) equal to its own author as a subject? " + auto1.getAuthor().equals(frank));
    }
}