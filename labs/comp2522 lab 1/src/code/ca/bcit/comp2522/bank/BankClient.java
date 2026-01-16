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
    private final Name name;
    private final Date birthDate;
    private final Date signUpDate;
    private final Date deathDate;
    private final String clientID;

    /*
    Maximum client ID.
     */
    private static final int ID_MAX = 999999;

    /*
    Automatic counter for clientID.
     */
    private static int clientIDCounter;

    /**
     * Sets the current BankClient values, with death date set to null.
     * @param name the Name of the client
     * @param birthDate the birth date of the client
     */
    BankClient(final Name name, final Date birthDate, final Date signUpDate)
    {
        this(name, birthDate, signUpDate, null);
    }

    /**
     * Sets the current BankClient values, including the death date.
     * @param name the Name of the client
     * @param birthDate the birth date of the client
     * @param deathDate the death date of the client
     */
    BankClient(final Name name, final Date birthDate, final Date signUpDate, final Date deathDate)
    {
        //Name objects are immutable
        this.name = name;

        //Date objects are immutable
        this.birthDate = birthDate;
        this.signUpDate = signUpDate;
        this.deathDate = deathDate;

        clientID = formatClientID(clientIDCounter++);
    }

    /*
    Helper method to format the clientID
     */
    private static String formatClientID(int id)
    {
        if (id > ID_MAX)
        {
            throw new IllegalArgumentException("ERROR: Max ID reached");
        }

        String formatID;
        String idString;

        formatID = "#";
        idString = "" + id;

        for (int i = 0; i < 6 - idString.length(); i++)
        {
            formatID += "0";
        }

        formatID += idString;

        return formatID;
    }

    /**
     * Getter for the client's name.
     * @return the clients name as a Name
     */
    Name getName()
    {
        return name;
    }

    /**
     * Returns the client details in a sentence.
     * @return all client details as a String
     */
    String getDetails()
    {
        return name.getFullName() + " client " + clientID + " ("
                + ((deathDate == null) ? "alive" :
                "died " + deathDate.getDayOfTheWeek() + ", "
                        + deathDate.getMonth() + " " + deathDate.getDay()
                        + ", " + deathDate.getYear())
                + ") joined the bank on " + signUpDate.getDayOfTheWeek() + ", "
                + signUpDate.getMonth() + " " + signUpDate.getDay()
                + ", " + signUpDate.getYear();
    }
}