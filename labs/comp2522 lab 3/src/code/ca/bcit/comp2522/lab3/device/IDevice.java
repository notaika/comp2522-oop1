package ca.bcit.comp2522.lab3.device;

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
        return "iDevice Specifications: " + getPurpose();
    }
}
