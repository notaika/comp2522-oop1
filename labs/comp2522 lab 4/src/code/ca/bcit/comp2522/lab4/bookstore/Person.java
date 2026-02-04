package ca.bcit.comp2522.lab4.bookstore;

/**
 * Represents a human being with a name and lifespan.
 * <p>
 * Includes validation for Dates and Name (cannot be null). It implements
 * {@link Comparable} interface to define a natural ordering that uses a person's
 * birthdate to determine their age; older individuals are considered "larger".
 * </p>
 * <p>
 * Also implements {@link Printable} interface to print all attributes in
 * a sentence and {@link Reversible} to print the full name backwards.
 * </p>
 *
 * @author Aika Manalo - 2C
 * @author Devan Lam - 2C
 */
public class Person
    implements Printable, Reversible, Comparable<Person>
{
    private final static int YEAR_UPPER_LIMIT = 2026;
    private final static int MONTH_UPPER_LIMIT = 2;
    private final static int DAY_UPPER_LIMIT = 3;
    private final static Date DATE_TODAY;

    // Assuming eventually the upper limits are automatically calculated and changed daily
    static
    {
        DATE_TODAY = new Date(YEAR_UPPER_LIMIT, MONTH_UPPER_LIMIT, DAY_UPPER_LIMIT);
    }

    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name fullName;

    public Person(final Name fullName,
                  final Date dateOfBirth,
                  final Date dateOfDeath)
    {
        validateNameNotNull(fullName);
        validateBirthDate(dateOfBirth);
        validateDeathDate(dateOfDeath, dateOfBirth);

        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Person(final Name fullName,
                  final Date dateOfBirth)
    {
        this(fullName, dateOfBirth, null);
    }

    /*
     * Checks if name is null.
     *
     * @param nameToCheck
     * @throw IllegalArgumentException thrown if name is null
     */
    private static void validateNameNotNull(final Object nameToCheck)
    {
        if (nameToCheck == null)
        {
            throw new IllegalArgumentException("ERROR: Name cannot cannot be null.");
        }
    }

    /*
     * Checks if date of birth is null or is set in the future.
     * Throws IllegalArgumentException if invalid.
     *
     * @param dobToCheck date of birth to check
     * @throws IllegalArgumentException exception thrown if year, month or day is greater than the upper limit
     */
    private static void validateBirthDate(final Date dobToCheck)
    {
        if (dobToCheck == null ||
           (dobToCheck.getYear() > YEAR_UPPER_LIMIT) ||
           (dobToCheck.getYear() == YEAR_UPPER_LIMIT && dobToCheck.getMonth() > MONTH_UPPER_LIMIT) ||
           (dobToCheck.getYear() == YEAR_UPPER_LIMIT && dobToCheck.getMonth() == MONTH_UPPER_LIMIT && dobToCheck.getDay() > DAY_UPPER_LIMIT))
        {
            throw new IllegalArgumentException("ERROR: Birth date must be before" +
                                               DATE_TODAY);
        }
    }

    /*
     * Checks if date of death is set before the date of birth.
     * Throws IllegalArgumentException if invalid.
     *
     * @param dodToCheck date of death to check
     * @throws IllegalArgumentException exception thrown if year, month or day is less than the date of birth
     */
    private static void validateDeathDate(final Date deathDate,
                                          final Date birthDate)
    {
        if (deathDate == null)
        {
            return;
        }

        if (deathDate.getYear() < birthDate.getYear() ||
           (deathDate.getYear() == birthDate.getYear() && deathDate.getMonth() < birthDate.getMonth()) ||
           (deathDate.getYear() == birthDate.getYear() && deathDate.getMonth() == birthDate.getMonth() && deathDate.getDay() < birthDate.getDay()))
        {
            throw new IllegalArgumentException("ERROR: Death date cannot be before " +
                                               birthDate);
        }
    }


    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    public Name getFullName()
    {
        return fullName;
    }

    public boolean isAlive()
    {
        return false;
    }

    @Override
    public void display()
    {
        if (dateOfDeath != null)
        {
            System.out.println("This person's full name is " + fullName +
                               ", born on " + dateOfBirth +
                               " and died on " + dateOfDeath);
        }
        else
        {
            System.out.println("This person's full name is " + fullName +
                               ", born on " + dateOfBirth +
                               " and is still alive as of " + DATE_TODAY);
        }
    }

    @Override
    public void backward()
    {

    }



    @Override
    public int compareTo(Person o)
    {
        return 0;
    }
}
