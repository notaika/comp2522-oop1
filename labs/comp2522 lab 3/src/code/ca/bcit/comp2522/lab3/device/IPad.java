package ca.bcit.comp2522.lab3.device;

/**
 * A class that models an iPad.
 *
 * @author Julia Ziebart - 2C
 * @author Aika Manalo - @C
 *
 * @version 1.0
 */
public class IPad extends IDevice
{
    private static final double MIN_IPADOS_VERSION = 18.0;
    private static final double LATEST_IPADOS_VERSION = 26.2;

    private boolean hasCase;
    private String iPadOSVersion;

    // overloaded constructors; can start with case or no case
    public IPad(final boolean hasCase,
            final double ipadOsVersion)
    {
        super("learning");
        validateIpadOSVersion(ipadOsVersion);

        this.hasCase = hasCase;
        this.iPadOSVersion = "iPadOS v" + ipadOsVersion;
    }

    public IPad(final double ipadOsVersion)
    {
        super("learning");
        validateIpadOSVersion(ipadOsVersion);

        this.hasCase = false;
        this.iPadOSVersion = "iPadOS v" + ipadOsVersion;
    }

    // validator methods
    private static void validateIpadOSVersion(final double ipadOsVersionToCheck)
    {
        if (ipadOsVersionToCheck < MIN_IPADOS_VERSION || ipadOsVersionToCheck > LATEST_IPADOS_VERSION)
        {
            throw new IllegalArgumentException("ERROR: iPad only supports OS versions " +
                                               MIN_IPADOS_VERSION + " to " + LATEST_IPADOS_VERSION);
        }
    }

    // getters and setters
    public String getiPadOSVersion()
    {
        return iPadOSVersion;
    }

    public boolean getHasCase()
    {
        return hasCase;
    }

    public void setHasCase(boolean hasCase)
    {
        this.hasCase = hasCase;
    }

    public void setiPadOSVersion(String iPadOSVersion)
    {
        this.iPadOSVersion = iPadOSVersion;
    }


    @Override
    public void printDetails()
    {
        System.out.println( "\nHas case: " + getHasCase() +
                                  "\nOS Version: " + getiPadOSVersion());
    }

    @Override
    public String toString()
    {
        final StringBuilder builder;
        builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("\nHas a case: ");
        builder.append(this.hasCase);
        builder.append("\nCurrent iPadOS Version: ");
        builder.append(this.iPadOSVersion);
        return builder.toString();
    }

    @Override
    public boolean equals(final Object other)
    {
        if(other == null)
        {
            return false;
        }

        if(other.getClass() != this.getClass())
        {
            return false;
        }

        IPad otherIPad = (IPad) other;

        return getiPadOSVersion().equals(otherIPad.getiPadOSVersion());

        // removed this line because only ipad's with same operating sys
        // versions are considered equal
               //&& hasCase == otherIPad.getHasCase();
    }

    @Override
    public int hashCode() {
        //placeholder til we decide on better values
        return 0;
    }

    // testing.. delete later
    public static void main(String[] args)
    {
        final IPad ipadM1 = new IPad(true, 18.2);
        final IPad ipadM2 = new IPad(false, 26.2);
        final IPad ipadM3 = new IPad(26.2);

        System.out.println(ipadM1.getiPadOSVersion());
        System.out.println(ipadM1.equals(ipadM2));
        System.out.println(ipadM2.equals(ipadM3));
        System.out.println(ipadM3.toString());
        ipadM2.printDetails();
    }
}
