package ca.bcit.comp2522.bank;

/**
 * Represents a client of a bank.
 * TODO:
 *  - Need to add validators for constructors
 *  - Could probably make getDetails method more readable
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 */
public class BankClient
{
    private static final int MIN_ID_LEN = 6;
    private static final int MAX_ID_LEN = 7;

    private final Name name;
    private final Date birthDate;
    private final Date signUpDate;
    private final Date deathDate;
    private final String clientID;

    /**
     * Sets the current BankClient values, including the death date.
     * @param name the Name of the client
     * @param birthDate the birth date of the client
     * @param deathDate the death date of the client
     */
    BankClient(final Name name,
               final Date birthDate,
               final Date signUpDate,
               final Date deathDate,
               final String clientID)
    {
        validateName(name);
        //Name objects are immutable
        this.name = name;

        validateDate(birthDate);
        validateDate(signUpDate);
        //Date objects are immutable
        this.birthDate = birthDate;
        this.signUpDate = signUpDate;
        this.deathDate = deathDate;

        validateClientID(clientID);
        this.clientID = clientID;
    }

    /**
     * Sets the current BankClient values, with death date set to null.
     * @param name the Name of the client
     * @param birthDate the birth date of the client
     */
    BankClient(final Name name,
               final Date birthDate,
               final Date signUpDate,
               final String clientID)
    {
        this(name, birthDate, signUpDate, null, clientID);
    }

    /**
     * Throws an error if the account number is too long (6 or 7).
     * @param acctNumToCheck the account number to check
     */
    private static void validateClientID(final String acctNumToCheck)
    {
        if (acctNumToCheck.length() < MIN_ID_LEN || acctNumToCheck.length() > MAX_ID_LEN)
        {
            throw new IllegalArgumentException("ERROR: ClientID must be between 6 to 7 characters.");
        }
    }

    /**
     * Validator for Name objects.
     * @param name the name being validated
     */
    private static void validateName(Name name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("ERROR: Name is null.");
        }
    }

    /**
     * Validator for Date objects.
     * @param date the name being validated
     */
    private static void validateDate(Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("ERROR: Date is null.");
        }
    }

    /**
     * Getter for the client's name.
     * @return the client's name as a Name
     */
    Name getName()
    {
        return name;
    }

    /**
     * Getter for the client's birthday.
     * @return the client's birthday as a Date
     */
    Date getBirthDate()
    {
        return birthDate;
    }

    /**
     * Getter for the client's sign up date.
     * @return the client's sign up date as a Date
     */
    Date getSignUpDate()
    {
        return signUpDate;
    }

    /**
     * Getter for the client's death date
     * @return the client's death date as a Date
     */
    Date getDeathDate()
    {
        return deathDate;
    }

    /**
     * Getter for the client ID.
     * @return the client ID as a String
     */
    String getClientID()
    {
        return clientID;
    }

    /**
     * Returns the client details in a sentence.
     * @return all client details as a String
     */
    String getDetails()
    {
        final StringBuilder clientDetails;
        clientDetails = new StringBuilder();

        clientDetails.append(name.getFullName());
        clientDetails.append(" client #");
        clientDetails.append(clientID);
        clientDetails.append(" (");
        clientDetails.append((deathDate == null) ? "alive" : "died " + deathDate.getDateFormatted());
        clientDetails.append(") joined the bank on ");
        clientDetails.append(signUpDate.getDateFormatted());

        return clientDetails.toString();
    }
}