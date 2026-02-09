package ca.bcit.comp2522.lab4.bookstore;

import java.util.Objects;

/**
 * Represents a human being with a name and lifespan.
 * <p>
 * A Person has a name, a date of birth, and an optional date of death.
 * This class implements:
 * <ul>
 * <li>{@code Printable} to display their details.</li>
 * <li>{@code Reversible} to display their name backward.</li>
 * <li>{@code Comparable<Person>} to define a natural ordering based on age.</li>
 * </ul>
 * Older individuals are considered "larger" in the natural ordering.
 * </p>
 *
 * @author Aika Manalo - 2C
 * @author Devan Lam - 2C
 *
 * @version 1.0
 */
public class Person
        implements Printable,
                   Reversible,
                   Comparable<Person>
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
    private Date dateOfDeath;
    private final Name fullName;

    /**
     * Constructs a Person with a specified death date.
     *
     * @param fullName    the person's full name, cannot be null
     * @param dateOfBirth the person's birthdate, cannot be null or in the future
     * @param dateOfDeath the person's death date, can be null but cannot be before birthdate
     *
     * @throws IllegalArgumentException if any validation rules are violated
     */
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

    /**
     * Constructs a living Person (no death date).
     *
     * @param fullName    the person's full name, cannot be null
     * @param dateOfBirth the person's birthdate, cannot be null or in the future
     * @throws IllegalArgumentException if any validation rules are violated
     */
    public Person(final Name fullName,
                  final Date dateOfBirth)
    {
        this(fullName, dateOfBirth, null);
    }

    /*
     * Validates that the Name object is not null.
     *
     * @param nameToCheck Name object to validate
     * @throws IllegalArgumentException thrown if name is null
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
     *
     * @param dobToCheck date of birth to check
     * @throws IllegalArgumentException exception thrown if year, month or day is greater than the upper limit
     */
    private static void validateBirthDate(final Date dobToCheck)
    {
        if (dobToCheck == null || compareDates(dobToCheck, DATE_TODAY) > 0) {
            throw new IllegalArgumentException("ERROR: Birth date cannot be in the future.");
        }
    }

    /*
     * Checks if date of death is set before the date of birth.
     * If date is null, return from validation (person is alive)
     *
     * @param deathDate the date of death to check
     * @param birthDate the date of birth to compare against
     * @throws IllegalArgumentException thrown if deathdate comes before the birthdate
     */
    private static void validateDeathDate(final Date deathDate,
                                          final Date birthDate)
    {
        if (deathDate == null)
        {
            return;
        }

        if (compareDates(deathDate, birthDate) < 0) {
            throw new IllegalArgumentException("ERROR: Death date cannot be before " + birthDate);
        }
    }

    /*
     * Compares two dates to determine their chronological order.
     *
     * @param dateToCompare the primary date being compared
     * @param dateReference the date to compare against
     *
     * @return positive integer if dateToCompare is after dateReference
     *         negative integer if dateToCompare is before dateReference
     *         zero if they are equal
     */
    private static int compareDates(final Date dateToCompare, final Date dateReference)
    {
        if (dateToCompare.getYear() != dateReference.getYear()) {
            return dateToCompare.getYear() - dateReference.getYear();
        }
        if (dateToCompare.getMonth() != dateReference.getMonth()) {
            return dateToCompare.getMonth() - dateReference.getMonth();
        }

        return dateToCompare.getDay() - dateReference.getDay();
    }

    /**
     * Gets the person's date of birth.
     *
     * @return the date of birth
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Gets the person's date of death.
     *
     * @return the date of death, or null if the person is alive
     */
    public Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    /**
     * Gets the person's full name.
     *
     * @return the Name object representing the full name
     */
    public Name getFullName()
    {
        return fullName;
    }

    /**
     * Sets the person's date of death.
     *
     * @param dateOfDeath the new date of death (can be null)
     */
    public void setDateOfDeath(final Date dateOfDeath)
    {
        this.dateOfDeath = dateOfDeath;
    }

    /**
     * Displays the person's details to the standard output.
     * <p>
     * This method prints the string representation of the Person object,
     * including their name and lifespan, as defined by the {@code toString()} method.
     * </p>
     */
    @Override
    public void display()
    {
        System.out.println(this);
    }

    /**
     * Returns a string representation of the Person.
     * <p>
     * The returned string contains the person's full name followed by their life span.
     * If the person is deceased, the format is "(DateOfBirth - DateOfDeath)".
     * If the person is currently alive, the format is "(DateOfBirth - Present)".
     * </p>
     *
     * @return a formatted string containing the person's name and dates
     */
    @Override
    public String toString()
    {
        if (dateOfDeath != null)
        {
            return fullName + " (" + dateOfBirth +
                               " - " + dateOfDeath + ").";
        }

            return fullName + " (" + dateOfBirth +
                               " - Present).";

    }

    /**
     * Prints the full name of this person in reverse order.
     */
    @Override
    public void backward()
    {
        final StringBuilder sb;

        sb = new StringBuilder();
        sb.append(fullName);

        System.out.println(sb.reverse());
    }

    /**
     * Compares this person with another person for order.
     * <p>
     * The ordering is based on age, where older people (earlier birthdates)
     * are considered "larger" than younger people.
     * </p>
     *
     * @param other the Person object to compare
     * @return negative integer if this person is younger (born later),
     *         positive integer if this person is older (born earlier),
     *         zero if they have the same birthdate
     */
    @Override
    public int compareTo(final Person other)
    {
        return compareDates(other.dateOfBirth, this.dateOfBirth);
    }

    /**
     * Checks if this person is equal to another object.
     * <p>
     * this Person object is equal to another Person object if they
     * are the same age (same birthdate).
     * </p>
     *
     * @param o the reference object with which to compare
     * @return true if both Person objects have the same birthdate, false otherwise
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || this.getClass() != o.getClass())
        {
            return false;
        }

        final Person otherPerson;
        otherPerson = (Person) o;

        return compareDates(this.dateOfBirth, otherPerson.dateOfBirth) == 0;
    }

    /**
     * Returns a hash code value for the person.
     * <p>
     * Hash is generated based on the birthday only.
     * </p>
     *
     * @return the hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(dateOfBirth.getYear(),
                            dateOfBirth.getMonth(),
                            dateOfBirth.getDay());
    }
}
