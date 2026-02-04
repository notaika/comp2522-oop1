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
 */
public class Name implements Printable
{
    private static final int MAX_NUM_CHARACTERS = 50;

    private final String firstName;
    private final String lastName;

    public Name(final String firstName,
                final String lastName)
    {
        validateName(firstName, "First name");
        validateName(lastName, "Last name");

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * not null, blank, < 50 chars
     *
     * @param nameToCheck
     * @param namePartForFeedback
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
     *
     * @return
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     *
     */
    @Override
    public void display()
    {
        System.out.println(this);
    }

    /**
     *
     *
     * @return
     */
    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
}
