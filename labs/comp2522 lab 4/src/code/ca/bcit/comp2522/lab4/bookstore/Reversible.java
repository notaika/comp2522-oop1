package ca.bcit.comp2522.lab4.bookstore;

/**
 * Defines the contract for objects that can be displayed in reverse.
 * <p>
 * Implementing classes must provide the body to print the identifier
 * in backward order
 * </p>
 *
 * @author Aika Manalo - Set 2C
 * @author Devan Lam - Set 2C
 *
 * @version 1.0
 */
public interface Reversible
{
    /**
     * Prints the name or title of an object backwards.
     * <p>
     * e.g. Given an instance variable named "Java" it
     * will be printed as "avaJ".
     * </p>
     */
    void backward();
}
