package ca.bcit.comp2522.review;

/**
 * Throws an exception if the battery level is too low.
 *
 * @author Aika Manalo
 * @version 1.0
 */
public class LowBatteryException extends Exception
{
    /**
     * Constructs low battery exception message.
     *
     * @param message exception message
     */
    public LowBatteryException(final String message)
    {
        super(message);
    }
}
