package ca.bcit.comp2522.lab4.bookstore;

/**
 * Represents a given Name that consists of a first name and last name.
 * <p>
 * Includes validation for valid names and implements the {@link Printable}
 * interface to print the name in standard output format.
 * </p>
 *
 * @author Aika Manalo - 2C
 * @author Devan Lam - 2C
 *
 * @version 1.0
 */
public class Name implements Printable
{
    private static final int MAX_NUM_CHARACTERS = 50;

    private final String firstName;
    private final String lastName;

    /**
     * Constructs a Name object with the specified first and last names.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @throws IllegalArgumentException if invalid
     */
    public Name(final String firstName,
                final String lastName)
    {
        validateName(firstName, "First name");
        validateName(lastName, "Last name");

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*
     * Validates a name part string.
     * Checks if the name is valid.
     *
     * @param nameToCheck         the name string to validate
     * @param namePartForFeedback the label (e.g., "First name") to use in the error message
     * @throws IllegalArgumentException if the name is invalid
     */
    private static void validateName(final String nameToCheck,
                                     final String namePartForFeedback)
    {
        if (nameToCheck == null ||
            nameToCheck.isBlank() ||
            (nameToCheck.length() > MAX_NUM_CHARACTERS))
        {
            throw new IllegalArgumentException("ERROR: " + namePartForFeedback +
                                               " cannot be null, blank or greater than " + MAX_NUM_CHARACTERS +
                                               " characters");
        }
    }

    /**
     * Returns the first name.
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Returns the last name.
     *
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Displays the full name to the standard output.
     * <p>
     * Prints the string representation of this Name object.
     * </p>
     */
    @Override
    public void display()
    {
        System.out.println(this);
    }

    /**
     * Returns the full name as a String.
     * <p>
     * The format is "firstName lastName" (separated by a single space).
     * </p>
     *
     * @return the full name
     */
    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
}
