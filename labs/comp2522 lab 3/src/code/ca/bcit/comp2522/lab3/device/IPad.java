package ca.bcit.comp2522.lab3.device;

import java.util.Objects;

/**
 * Represents an iPad.
 *
 * @author Julia Ziebart - 2C
 * @author Aika Manalo - 2C
 *
 * @version 1.0
 */
public class IPad extends IDevice
{
    private boolean encased;
    private String iPadOSVersion;

    /**
     * Constructor. Initializes an iPad with the specified data.
     *
     * @param encased whether it has a case
     * @param ipadOsVersion the OS version this iPad is on
     */
    public IPad(final boolean encased,
            final String ipadOsVersion)
    {
        super("learning");

        this.encased = encased;
        this.iPadOSVersion = ipadOsVersion;
    }

    /**
     * Constructor. Assumes that the created iPad has no case.
     *
     * @param ipadOsVersion the version of the created iPad.
     */
    public IPad(final String ipadOsVersion)
    {
        this(false, ipadOsVersion);
    }

    /**
     * Returns the version of this iPad.
     *
     * @return The version
     */
    public String getIPadOSVersion()
    {
        return iPadOSVersion;
    }

    /**
     * Returns whether this iPad has a case.
     *
     * @return whether it has a case.
     */
    public boolean hasCase()
    {
        return encased;
    }

    /**
     * Puts on or takes off a case.
     *
     * @param encased whether the iPad has a case or not
     */
    public void isEncased(final boolean encased)
    {
        this.encased = encased;
    }

    /**
     * Sets the version of this iPad.
     *
     * @param iPadOSVersion the version to set
     */
    public void setIPadOSVersion(final String iPadOSVersion)
    {
        this.iPadOSVersion = iPadOSVersion;
    }

    /*
     * Gets the instance variables of this device and returns them as a string
     */
    @Override
    protected String getLocalDetails() {
        return "Has case: " + hasCase() +
               "\nOS Version: " + getIPadOSVersion();
    }

    /**
     * Prints the details of this specific device (and not its parent's)
     */
    @Override
    public void printDetails()
    {
        System.out.println(getLocalDetails());
    }

    /**
     * Returns the instance variables of this device as well as data from its parent class.
     *
     * @return The details, as a string.
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("\n");
        builder.append(getLocalDetails());
        return builder.toString();
    }

    /**
     * Compares this iPad to the specified object.
     * If the other object is not an iPad, they are not equal.
     * Otherwise, if this has the same version as the reference object, they are equal.
     *
     * @param other the reference object with which to compare.
     * @return The equality.
     */
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

        final IPad otherIPad;
        otherIPad = (IPad) other;

        return getIPadOSVersion().equals(otherIPad.getIPadOSVersion());
    }

    /**
     * Returns a hashcode for this object, determined with its version.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.iPadOSVersion);
    }
}
