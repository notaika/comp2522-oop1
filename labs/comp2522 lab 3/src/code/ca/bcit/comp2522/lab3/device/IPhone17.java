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

    public boolean highResCam;
    public final int memoryGb;

    // constructor
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

    // validator
    private static void validateMemoryGB(final int memoryGbToCheck)
    {
        if (memoryGbToCheck < MIN_STOCK_MEMORY_GB || memoryGbToCheck > MAX_STOCK_MEMORY_GB)
        {
            throw new IllegalArgumentException("ERROR: iPhone 17 memory only comes in between " +
                                               MIN_STOCK_MEMORY_GB + " and " + MAX_STOCK_MEMORY_GB);
        }
    }

    // getters and setters
    public boolean isHighResCam()
    {
        return highResCam;
    }

    public int getMemoryGb()
    {
        return memoryGb;
    }

    public void setHighResCam(boolean highResCam)
    {
        this.highResCam = highResCam;
    }

    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("High-resolution camera: " + isHighResCam() +
                           "\nMemory (GB): " + getMemoryGb());
    }

    @Override
    public String toString()
    {
        return super.toString() +
               "\nHigh-resolution camera: " + isHighResCam() +
               "\nMemory (GB): " + getMemoryGb();
    }

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

    @Override
    public int hashCode()
    {
        return Objects.hash(getPhonePlanTimeMins(), highResCam);
    }
}
