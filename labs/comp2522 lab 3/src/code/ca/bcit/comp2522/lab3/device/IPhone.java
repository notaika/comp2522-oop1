package ca.bcit.comp2522.lab3.device;

import java.util.Objects;

/**
 * A class that models an iPhone.
 *
 * @author Julia Ziebart
 * @author Aika Manalo
 *
 * @version 1.0
 */
public class IPhone extends IDevice
{
    public static final double MIN_TIME_MINS = 0.1;

    private String phonePlanCarrier;
    private double phonePlanTimeMins;

    // constructor
    public IPhone(final String purpose,
                  final String phonePlanCarrier,
                  final double phonePlanTimeMins)
    {
        super(purpose);
        validatePhonePlanTime(phonePlanTimeMins);
        this.phonePlanCarrier = phonePlanCarrier;
        this.phonePlanTimeMins = phonePlanTimeMins;
    }

    // validation
    private static void validatePhonePlanTime(final double timeMinsToCheck)
    {
        if (timeMinsToCheck < MIN_TIME_MINS)
        {
            throw new IllegalArgumentException("ERROR: Phone Plan Time cannot be less than " +
                                               MIN_TIME_MINS + " mins");
        }
    }

    // getters and setters
    public double getPhonePlanTimeMins()
    {
        return phonePlanTimeMins;
    }

    public void setPhonePlanTimeMins(double phonePlanTimeMins)
    {
        this.phonePlanTimeMins = phonePlanTimeMins;
    }

    public String getPhonePlanCarrier()
    {
        return phonePlanCarrier;
    }

    public void setPhonePlanCarrier(String phonePlanCarrier)
    {
        this.phonePlanCarrier = phonePlanCarrier;
    }

    @Override
    public void printDetails()
    {
        System.out.println("\nPhone Plan Carrier: " + getPhonePlanCarrier() +
                           "\nPhone Plan Time Remaining (Mins): " + getPhonePlanTimeMins());
    }

    @Override
    public String toString()
    {
        return super.toString() +
               "\nPhone Plan Carrier: " + getPhonePlanCarrier() +
               "\nPhone Plan Time Remaining (Mins): " + getPhonePlanTimeMins();
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof IPhone))
        {
            return false;
        }

        final IPhone that;
        that = (IPhone) o;

        return this.phonePlanTimeMins == that.phonePlanTimeMins;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.phonePlanTimeMins);
    }
}
