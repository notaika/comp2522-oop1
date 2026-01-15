package ca.bc.spca;

import java.io.IOException;

/**
 * Represents an animal.
 *
 * @author aika
 * @version 1.0
 */
public class Animal
{
    // the default constructor of classes
    // if you create a constructor
    /*
        Animal()
        {
            super();
        }
    */

    private final int birthYear;

    /**
     *
     * @param birthYear year of birth to check
     * @throws IOException if year of birth is invalid
     */
    Animal(final int birthYear)
            throws IOException
    {
        validateBirthYear(birthYear);
        this.birthYear = birthYear;
    }

    /*
     *
     * @param birthYear year of birth to validate
     * @throws IOException if year of birth is invalid (0)
     */
    private static void validateBirthYear(final int birthYear) throws IOException
    {
        // unchecked exception
//        if (birthYear == 0)
//        {
//            throw new IllegalArgumentException("bad year: " + birthYear);
//        }

        // checked exception
        if (birthYear > 2026)
        {
            throw new IOException("bad year: " + birthYear);
        }
    }

    void speak()
    {
        System.out.println("speaks");
    }

//    Animal(){}
}
