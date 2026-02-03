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
    public static final double MIN_PLAN_TIME_MINS = 0.1;

    private String phonePlanCarrier;
    private double phonePlanTimeMins;

    /**
     * Constructs and initializes an iPhone with the carrier and the amount of time on its plan
     *
     * @param phonePlanCarrier The carrier
     * @param phonePlanTimeMins The amount of time on its plan, in minutes
     */
    public IPhone(final double phonePlanTimeMins,
            final String phonePlanCarrier )
    {
        super("talking");

        validatePhonePlanTime(phonePlanTimeMins);

        this.phonePlanCarrier = phonePlanCarrier;
        this.phonePlanTimeMins = phonePlanTimeMins;
    }

    // validates the phone plan time
    private static void validatePhonePlanTime(final double timeMinsToCheck)
    {
        if (timeMinsToCheck < MIN_PLAN_TIME_MINS)
        {
            throw new IllegalArgumentException("ERROR: Phone Plan Time cannot be less than " +
                                               MIN_PLAN_TIME_MINS + " mins");
        }
    }

    /**
     * Gets the amount of time left on this phone's plan
     *
     * @return the time in minutes
     */
    public double getPhonePlanTimeMins()
    {
        return phonePlanTimeMins;
    }

    /**
     * Sets the phone's plan time to a specified number of minutes.
     *
     * @param phonePlanTimeMins The amount of time this phone should have
     */
    public void setPhonePlanTimeMins(double phonePlanTimeMins)
    {
        validatePhonePlanTime(phonePlanTimeMins);
        this.phonePlanTimeMins = phonePlanTimeMins;
    }

    /**
     * Gets the carrier that provides this phone's data plan.
     *
     * @return The carrier
     */
    public String getPhonePlanCarrier()
    {
        return phonePlanCarrier;
    }

    /**
     * Changes this phone's carrier.
     *
     * @param phonePlanCarrier the carrier to change the plan to
     */
    public void setPhonePlanCarrier(String phonePlanCarrier)
    {
        this.phonePlanCarrier = phonePlanCarrier;
    }

    /*
     * Gets the instance variables of this class and returns them as a string
     *
     * @return instance variables as a String
     */
    @Override
    protected String getLocalDetails() {
        return "Phone Plan Carrier: " + getPhonePlanCarrier() +
               "\nPhone Plan Time Remaining (Mins): " + getPhonePlanTimeMins();
    }

    /**
     * Prints the instance variables of this class (but not its parent's).
     */
    @Override
    public void printDetails()
    {
        System.out.println(getLocalDetails());
    }

    /**
     * Returns a string representation of this object,
     * comprising the parent's instance data as well as its own.
     *
     * @return the data as a String
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
     * Compares this iPhone to the specified object.
     * If the other object is not an iPhone, they are not equal.
     * Otherwise, if this has the same number of minuts on its plan
     * as the reference object, they are equal.
     *
     * @param o   the reference object with which to compare.
     * @return The equality.
     */
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

    /**
     * Generates a hashcode for the iPhone, determined with the amount of time left on its plan.
     *
     * @return the hash code as an int
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.phonePlanTimeMins);
    }
}
