package ca.bcit.comp2522.lab3.device;

import java.util.Objects;

/**
 * Represents an iDevice.
 *
 * @author Aika Manalo - 2C
 * @version 1.0
 */
public abstract class IDevice
{
    private final String purpose;

    public IDevice(final String purpose)
    {
        this.purpose = purpose;
    }

    public String getPurpose()
    {
        return "The purpose of this iDevice is " + purpose;
    }

    // prints all child classes instance variables
    public abstract String printDetails();

    @Override
    public String toString()
    {
        return getPurpose();
    }

    @Override
    public boolean equals(final Object o)
    {
        return (o instanceof IDevice);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.getClass());
    }
}
