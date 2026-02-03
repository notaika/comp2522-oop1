package ca.bcit.comp2522.lab4.bookstore;

/**
 * Defines the contract for objects that can display their internal state.
 * <p>
 * Implementing classes must provide a body to print all of their instance
 * variables (including those inherited from parent classes) in a sentence.
 * </p>
 *
 * @author Aika Manalo - Set 2C
 * @author Devan Lam - Set 2C
 *
 * @version 1.0
 */
public interface Printable
{
    /**
     * Prints every instance variable (including those in parent classes)
     * of an object in a sentence.
     */
    void display();
}
