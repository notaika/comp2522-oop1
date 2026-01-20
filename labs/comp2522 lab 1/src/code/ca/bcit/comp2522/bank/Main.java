package ca.bcit.comp2522.bank;

/**
 * Proves Date, Name, BankClient and BankAccount classes work.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class Main
{
    /**
     * Drives the program
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        final Name aEinsteinName;
        final Date aEinsteinBirthDate;
        final Date aEinsteinSignUpDate;
        final Date aEinsteinClosedDate;
        final Date aEinsteinDeathDate;
        final BankClient aEinsteinClient;
        final BankAccount aEinsteinAccount;

        final Name nMandelaName;
        final Date nMandelaBirthDate;
        final Date nMandelaSignUpDate;
        final Date nMandelaDeathDate;
        final BankClient nMandelaClient;
        final BankAccount nMandelaAccount;

        final Name fKahloName;
        final Date fKahloDOB;
        final Date fKahloDOD;
        final Date fKahloOpen;
        final Date fKahloClosed;
        final BankClient fKahloClient;
        final BankAccount fKahloAccount;

        final Name jChanName;
        final Date jChanDOB;
        final Date jChanOpen;
        final BankClient jChanClient;
        final BankAccount jChanAccount;


        aEinsteinName = new Name ("Albert", "Einstein");
        aEinsteinBirthDate = new Date (1879, 3, 14);
        aEinsteinSignUpDate = new Date (1900, 1, 1);
        aEinsteinDeathDate = new Date (1955, 4, 18);
        aEinsteinClosedDate = new Date(1950, 10, 14);
        aEinsteinClient = new BankClient(aEinsteinName, aEinsteinBirthDate, aEinsteinSignUpDate, aEinsteinDeathDate, "abc123");
        aEinsteinAccount = new BankAccount(aEinsteinClient, 1000.0, 3141);
        aEinsteinAccount.withdraw(100.0, 3141);
        aEinsteinAccount.closeAccount(aEinsteinClosedDate);

        nMandelaName = new Name("Nelson", "Mandela");
        nMandelaBirthDate = new Date(1918, 7, 18);
        nMandelaDeathDate = new Date(2013, 12, 5);
        nMandelaSignUpDate = new Date(1994, 5, 10);
        nMandelaClient = new BankClient(nMandelaName, nMandelaBirthDate, nMandelaSignUpDate, nMandelaDeathDate, "654321");
        nMandelaAccount = new BankAccount(nMandelaClient, 2000, 4664);
        nMandelaAccount.withdraw(200, 4664);

        fKahloName = new Name ("Frida", "Kahlo");
        fKahloDOB = new Date (1907, 7, 6);
        fKahloDOD = new Date (1954, 7, 13);
        fKahloOpen = new Date(1940, 1, 1);
        fKahloClosed = new Date(1954, 7, 13);
        fKahloClient = new BankClient(fKahloName, fKahloDOB, fKahloOpen, fKahloDOD, "frd123");
        fKahloAccount = new BankAccount(fKahloClient, 500, 1907);
        fKahloAccount.withdraw(50.0, 1907);
        fKahloAccount.closeAccount(fKahloClosed);

        jChanName = new Name("Jackie", "Chan");
        jChanDOB = new Date(1954, 4, 7);
        jChanOpen = new Date(1980, 10, 1);
        jChanClient = new BankClient(jChanName, jChanDOB, jChanOpen, "chan789");
        jChanAccount = new BankAccount(jChanClient, 3000, 1954);
        jChanAccount.withdraw(500, 1954);


        // Name Methods
        System.out.println(aEinsteinName.getFullName());
        System.out.println(aEinsteinName.getInitials());
        System.out.println(aEinsteinName.getReverseName());

        // Date Methods
        System.out.println(aEinsteinBirthDate.getDateFormatted());
        System.out.println(aEinsteinBirthDate.getYyyyMmDd());

        // Client Methods
        System.out.println(aEinsteinClient.getDetails());

        // Bank Account Methods
        System.out.println(aEinsteinAccount.getDetails());

        System.out.println("\n");


        // Name Methods
        System.out.println(nMandelaName.getFullName());
        System.out.println(nMandelaName.getInitials());
        System.out.println(nMandelaName.getReverseName());

        // Date Methods
        System.out.println(nMandelaBirthDate.getDateFormatted());
        System.out.println(nMandelaBirthDate.getYyyyMmDd());

        // Client Methods
        System.out.println(nMandelaClient.getDetails());

        // Bank Account Methods
        System.out.println(nMandelaAccount.getDetails());

        System.out.println("\n");


        // Name Methods
        System.out.println(fKahloName.getFullName());
        System.out.println(fKahloName.getInitials());
        System.out.println(fKahloName.getReverseName());

        // Date Methods
        System.out.println(fKahloDOB.getDateFormatted());
        System.out.println(fKahloDOB.getYyyyMmDd());

        // Client Methods
        System.out.println(fKahloClient.getDetails());

        // Bank Account Methods
        System.out.println(fKahloAccount.getDetails());

        System.out.println("\n");


        // Name Methods
        System.out.println(jChanName.getFullName());
        System.out.println(jChanName.getInitials());
        System.out.println(jChanName.getReverseName());

        // Date Methods
        System.out.println(jChanDOB.getDateFormatted());
        System.out.println(jChanDOB.getYyyyMmDd());

        // Client Methods
        System.out.println(jChanClient.getDetails());

        // Bank Account Methods
        System.out.println(jChanAccount.getDetails());
    }
}
