package ca.bcit.comp2522.lab3.device;

import java.util.Objects;

/**
 * Represents an iDevice.
 *
 * @author Aika Manalo - 2C
 * @author Julia Ziebart - 2C
 *
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
    public abstract void printDetails();

    @Override
    public String toString()
    {
        return getPurpose();
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof IDevice))
        {
            return false;
        }

        final IDevice that;
        that = (IDevice) o;

        return Objects.equals(purpose, that.purpose);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(purpose);
    }
}
