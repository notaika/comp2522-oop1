package ca.bcit.comp2522.lab3.device;

import java.util.Objects;

/**
 * Represents a seventeenth generation iPhone.
 *
 * @author Julia Ziebart - 2C
 * @author Aika Manalo - @C
 *
 * @version 1.0
 */
public class IPhone17 extends IPhone
{
    private static final int MIN_STOCK_MEMORY_GB = 256;
    private static final int MAX_STOCK_MEMORY_GB = 2000;

    public final boolean highResCam;
    public final int memoryGb;

    /**
     * Constructs and initializes an iPhone 17 with the carrier, the amount of time on its plan,
     * states if it has a high resolution camera and the amount of memory it has.
     *
     * @param phonePlanCarrier The carrier
     * @param phonePlanTimeMins The amount of time on its plan, in minutes
     * @param highResCam true if the iPhone 17 has a high resolution camera
     * @param memoryGb The amount of memory in GB it can store
     */
    public IPhone17(final double phonePlanTimeMins,
                    final String phonePlanCarrier,
                    final boolean highResCam,
                    final int memoryGb)
    {
        super(phonePlanTimeMins,
              phonePlanCarrier);

        validateMemoryGB(memoryGb);

        this.highResCam = highResCam;
        this.memoryGb = memoryGb;
    }

    /*
     * Validates the amount of storage an iPhone 17 can have.
     * Must be in between MIN_STOCK_MEMORY_GB and MAX_STOCK_MEMORY_GB
     *
     * @param memoryGbToCheck the amount of memory to chack
     * @throws IllegalArguementException if the memory assigned is > MAX_STOCK_MEMORY_GB
     */
    private static void validateMemoryGB(final int memoryGbToCheck)
    {
        if (memoryGbToCheck < MIN_STOCK_MEMORY_GB || memoryGbToCheck > MAX_STOCK_MEMORY_GB)
        {
            throw new IllegalArgumentException("ERROR: iPhone 17 memory only comes in between " +
                                               MIN_STOCK_MEMORY_GB + " and " + MAX_STOCK_MEMORY_GB);
        }
    }

    /**
     * Checks if the iPhone 17 has a high resolution camera
     *
     * @return true if iPhone 17 has a high resolution camera, false otherwise
     */
    public boolean isHighResCam()
    {
        return highResCam;
    }

    public int getMemoryGb()
    {
        return memoryGb;
    }

    /**
     * Prints iPhone 17-specific attributes.
     */
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("High-resolution camera: " + isHighResCam() +
                           "\nMemory (GB): " + getMemoryGb());
    }

    /**
     * Prints all characteristics of an iPhone 17.
     *
     * @return all attributes in a single String
     */
    @Override
    public String toString()
    {
        return super.toString() +
               "\nHigh-resolution camera: " + isHighResCam() +
               "\nMemory (GB): " + getMemoryGb();
    }

    /**
     * Compares two iPhone 17 objects and checks if they're equal.
     *
     * @param o the reference object with which to compare.
     * @return true if phone plan time remaining and high resolution camera are equal
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof IPhone17))
        {
            return false;
        }

        final IPhone17 that;
        that = (IPhone17) o;

        return (this.getPhonePlanTimeMins() == that.getPhonePlanTimeMins()) &&
               (this.highResCam == that.highResCam);
    }

    /**
     * Generates a hashcode for the iPhone 17, determined with the amount of time left on its plan,
     * and if it has a high resolution camera.
     *
     * @return the hash code as an int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(getPhonePlanTimeMins(), highResCam);
    }
}
