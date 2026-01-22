package ca.bcit.comp2522.lab2.creatures;

/**
 * Thrown to indicate that the firepower is low.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class LowFirePowerException extends Exception
{
    /**
     * Constructs a <code>LowFirePowerException</code> with a specified message.
     *
     * @param message the detail message
     */
    public LowFirePowerException(final String message)
    {
        super(message);
    }
}
