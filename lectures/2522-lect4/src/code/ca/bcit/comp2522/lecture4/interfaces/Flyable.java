package ca.bcit.comp2522.lecture4.interfaces;

/**
 *
 */

// interfaces already imply that they are abstract
// adding abstract is redundant
public interface Flyable
{
    // not a functional interface
    // functional interfaces can only have one METHOD
    // doesn't have to be void; can put arguments in here
    void fly();
    void land();
    double getMaxSpeedKmPerHour();

    // default means concrete
    // don't have to implement it on child classes
    default void crash()
    {
        System.out.println("ouch");
    }
}
