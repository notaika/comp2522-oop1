package ca.bcit.comp2522.lecture4.interfaces;

public class Airplane
        extends Vehicle
        implements Flyable, Rideable
{
    public Airplane(String colour)
    {
        super(colour);
    }

    @Override
    public void fly()
    {
        System.out.println("bernoulli effect");
    }

    @Override
    public void land()
    {
        System.out.println("on wheels");
    }

    @Override public double getMaxSpeedKmPerHour()
    {
        return 999;
    }

    // Q: what if a class implements interfaces with the same abstract method
    // same default method signatures? how will we know which one it will pick?
    // e.g. ca.bcit.comp2522.lecture4.interfaces.Flyable and Rideable have the same default method `crash()`
    @Override
    public void crash()
    {
        // A: can do any combination of the three
        Flyable.super.crash(); // either do flyable or just rideable (picking one)
        Rideable.super.crash(); // do both
        System.out.println("Boom"); // do both and add the airplane way
    }

    @Override public void ride()
    {

    }
}
