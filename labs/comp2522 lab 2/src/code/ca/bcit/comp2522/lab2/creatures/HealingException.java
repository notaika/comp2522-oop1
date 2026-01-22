package ca.bcit.comp2522.lab2.creatures;

/**
 * Thrown to indicate that the damage argument passed is illegal.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class HealingException extends RuntimeException
{
    /**
     * Constructs a <code>HealingException</code> with a specified message.
     *
     * @param message the detail message
     */
    public HealingException(final String message)
    {
        super(message);
    }
}
