package ca.bcit.comp2522.lab3.device;

/**
 * A class that models an iPad.
 *
 * @author Julia Ziebart
 * @author Aika Manalo
 *
 * @version 1.0
 */
public class IPad extends IDevice
{
    private static final String CURRENT_IPADOS_VERSION = "1.3.0.8";
    private boolean hasCase;
    private String iPadOSVersion;

    public IPad()
    {
        super("Learning");
    }

    @Override
    public String toString()
    {
        final StringBuilder builder;
        builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Has a case: ");
        builder.append(this.hasCase);
        builder.append(" Current iPadOS Version: ");
        builder.append(" + this.iPadOSVersion");
        return builder.toString();
    }

    public String getiPadOSVersion()
    {
        return iPadOSVersion;
    }

    public boolean getHasCase()
    {
        return hasCase;
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

        if (getiPadOSVersion().equals(otherIPad.getiPadOSVersion())
            && hasCase == otherIPad.getHasCase()) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        //placeholder til we decide on better values
        return 0;
    }
}
