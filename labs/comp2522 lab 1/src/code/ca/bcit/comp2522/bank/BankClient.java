package ca.bcit.comp2522.bank;

/**
 * Represents a Bank Client.
 *
 * @author Aika Manalo, Thor Baker - set 2C
 */
public class BankClient
{
    private Name name;
    private final Date birthDate;
    private final Date signUpDate;
    private final Date deathDate;
    private final String clientID;

    /*
    Automatic counter for clientID.
     */
    private static int clientIDCounter;

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

        clientID = "#" + clientIDCounter;
        clientIDCounter++;
    }

    /**
     * Sets the current BankClient values, with death date set to null.
     * @param name the Name of the client
     * @param birthDate the birth date of the client
     */
    BankClient(final Name name, final Date birthDate, final Date signUpDate)
    {
        this(name, birthDate, signUpDate, null);
    }

    String getDetails()
    {
        return name.getFullName + " client " + clientID + " ("
                + ((deathDate == null) ? "alive" :
                "died " + deathDate.getDayOfTheWeek() + ", "
                        + deathDate.getMonth() + " " + deathDate.getDay()
                        + ", " + deathDate.getYear())
                + ") joined the bank on " + signUpDate.getDayOfTheWeek() + ", "
                + signUpDate.getMonth() + " " + signUpDate.getDay()
                + ", " + signUpDate.getYear();
    }
}