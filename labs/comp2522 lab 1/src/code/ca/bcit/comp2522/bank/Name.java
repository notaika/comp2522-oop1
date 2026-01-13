package ca.bcit.comp2522.bank;

/**
 * Represents a person's name.
 *
 * @author Aika Manalo
 * @version 1.0
 */
public class Name
{
    private static final int MAX_NAME_LEN = 45;
    private static final String ILLEGAL_NAME_ADMIN = "admin";

    private final String first;
    private final String last;

    /**
     * Constructs, validates and initializes a Name object.
     *
     * @param first first name as String
     * @param last last name as String
     */
    public Name(final String first, final String last)
    {
        validateName(first, "First name");
        validateName(last, "Last name");

        this.first = first;
        this.last = last;
    }

    private static void validateName(final String namePart, final String namePartType)
    {
        if (namePart == null || namePart.isBlank())
        {
            throw new IllegalArgumentException("ERROR: " + namePartType + " cannot be null or blank.");
        }

        if (namePart.length() > MAX_NAME_LEN)
        {
            throw new IllegalArgumentException(("ERROR: " + namePartType + " cannot be greater than 45 characters."));
        }

        if (namePart.toLowerCase().contains(ILLEGAL_NAME_ADMIN))
        {
            throw new IllegalArgumentException("ERROR: " + namePartType + " cannot contain the word \"admin\"");
        }
    }

    /**
     * Returns first Name.
     *
     * @return first name
     */
    public String getFirst() {
        return first;
    }

    /**
     * Returns last Name.
     *
     * @return last name
     */
    public String getLast() {
        return last;
    }


    /**
     * Return's the first and last initial of Name.
     *
     * @return the initials
     */
    public String getInitials()
    {
        final String firstInitial;
        final String lastInitial;
        final String initials;

        firstInitial = first.substring(0, 1).toUpperCase();
        lastInitial = last.substring(0, 1).toUpperCase();

        initials = firstInitial + "." + lastInitial +".";

        return initials;
    }

    /**
     * Returns the full Name formatted in title case.
     *
     * @return first and last name
     */
    public String getFullName()
    {
        final String firstInitial;
        final String firstRemainder;
        final String lastInitial;
        final String lastRemainder;
        final String fullName;

        firstInitial = first.substring(0, 1).toUpperCase();
        firstRemainder = first.substring(1).toLowerCase();
        lastInitial = last.substring(0, 1).toUpperCase();
        lastRemainder = last.substring(1).toLowerCase();
        fullName = firstInitial + firstRemainder + " " + lastInitial + lastRemainder;

        return fullName;
    }

    /**
     * Returns the Name in reverse (e.g. "tigER wooDS" would return "SDoow REgit").
     *
     * @return full name in reversed
     */
    public String getReverseName()
    {
        String fullName;
        String reversedName;

        fullName = first + " " + last;
        reversedName = "";

        for (int i = fullName.length() - 1; i >= 0; i--)
        {
            reversedName += fullName.charAt(i);
        }

        return reversedName;
    }
}
