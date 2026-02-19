@FunctionalInterface
public interface Testable
{
    boolean test(String s, int i);
}

class Main3
{
    public static void main(final String[] args)
    {
        // EXAM Q: MIDTERM
        // 1. lambda
        // 2. method reference
        // 3. pass behaviour as an argument

        // does string have that many characters?
        // using lambda
        final Testable atleastNChars;
        atleastNChars = (s, i)->s.length() >= i;
        System.out.print("Lambda: ");
        System.out.println(atleastNChars.test("bcit", 2));
        System.out.println();

        final Testable atleastNChars2;
        atleastNChars2 = Main3::testString;
        System.out.print("Method Reference: ");
        System.out.println(atleastNChars2.test("bcit", 3));
        System.out.println();

        System.out.println("Pass behaviour as argument: ");
        Main3.printIfMeetsCriteria("bcit", 2, atleastNChars);
        Main3.printIfMeetsCriteria("bcit", 2, atleastNChars2);
        System.out.println();

        // does this string s contain n
        final Testable doesStringContainInt;
        // or (s, i)->s.contains(""+i);
        doesStringContainInt = (s, i)->s.contains(Integer.toString(i));
        System.out.println("Another example... does this string s contain int n?");
        System.out.println(doesStringContainInt.test("bcit123", 1));
    }

    static boolean testString(final String s,
                           final int i)
    {
        return s.length() >= i;
    }

    // really generic
    static void printIfMeetsCriteria(final String s,
                                     final int i,
                                     final Testable t)
    {
        System.out.println(t.test(s, i));
    }
}