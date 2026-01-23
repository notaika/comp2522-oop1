package ca.bcit.comp2522.quiz.one;

/**
 * Set 2C's quiz 1 for COMP2522 (202610)
 * Answers here are corrected.
 * My Score: 8.5/9 (forgot `final` in Dog initialization)
 */
public class QuizOne
{
    /*
     * 1. List four Java datatypes, describe whether they are primitive or reference types.
     * What are their default values? (2 marks)
     */

    // int - primitive - 0
    // double - primitive - 0.0
    // boolean - primitive - false
    // char - primitive - '\u0000'

    /*
     * 2. Write a method (including Javadoc comments) that returns whether or not its argument
     * (a String) is null, empty, or invalid. Strings that contain the word "jason" are invalid
     * (in any letter casing) (4 marks)
     */

    private final static String INVALID_WORD = "jason";

    /**
     * Checks if the String passed is null, empty or invalid.
     *
     * @param String the string to check
     * @return returns true if argument is null, empty or invalid
     */
    private static boolean validateString(final String word)
    {
        if (word == null || word.isEmpty() || word.toLowerCase().contains(INVALID_WORD))
        {
            return true;
        }
        return false;
    }

    /*
     * 3. Write a Main class with a main() method that declares two different Dog variables and
     * assigns them the names "Rex" and "Fido". The Dog constructor takes a String name argument.
     * Write only the Main class code.
     */

    package ca.bcit.comp2522.dog;

    /**
     * Entry point for program.
     *
     * @author Aika - Set 2C
     * @version 1.0
     */

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(String[] args)
    {
        final Dog aikasDog;
        final Dog mattsDog;

        firstDog = new Dog("Rex");
        secondDog = new Dog("Fido");
    }
}
