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

    /**
     * Prints the details of the device, "details" comprising the
     * instance variables of the parent and child classes
     */
    public abstract void printDetails();

    /**
     * Returns all of an object's instance variables.
     *
     * @return local class' instance variables
     */
    protected abstract String getLocalDetails();

    /**
     * Returns this device's purpose.
     *
     * @return The purpose, as a String.
     */
    @Override
    public String toString()
    {
        return getPurpose();
    }

    /**
     * Compares this device to the specified object.
     * If the other object is not an iPad, they are not equal.
     * Otherwise, if this has the same version as the reference object, they are equal.
     *
     * @param o the reference object with which to compare.
     * @return The equality.
     */
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

    /**
     * Returns the hashcode of this object, generated with its purpose
     *
     * @return this hashcode
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(purpose);
    }
}
