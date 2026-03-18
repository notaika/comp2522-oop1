package ca.bc.spca;

import java.io.IOException;

class Animal
{
    private final int birthYear;

    /**
     * @param birthYear the year of birth
     * @throws InvalidYearOfBirthException if year of birth is invalid
     */
    Animal(final int birthYear)
            throws InvalidYearOfBirthException
    {
        // super();
        validateBirthYear(birthYear);
        this.birthYear = birthYear;
    }

    /*
     *
     * @param birthYear the year of birth to validate
     * @throws InvalidYearOfBirthException if year of birth is invalid (is > 2026)
     */
    private static void validateBirthYear(final int birthYear)
            throws InvalidYearOfBirthException
    {
        if(birthYear > 2026)
        {
            throw new InvalidYearOfBirthException("bad year: " + birthYear);
        }
    }

    void speak()
    {
        System.out.println("speaking");
    }

}
