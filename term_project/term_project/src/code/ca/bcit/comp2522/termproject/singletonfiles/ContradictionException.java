package ca.bcit.comp2522.termproject.singletonfiles;

/**
 * Thrown when a logical contradiction occurs in the game grid.
 * For example, if a user attempts to confirm a connection that violates
 * already established rules or facts.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public final class ContradictionException
        extends Exception
{
    /**
     * Constructs a ContradictionException with a detailed error message.
     *
     * @param message the explanation of the logical contradiction as a String
     */
    public ContradictionException(final String message)
    {
        super(message);
    }
}
