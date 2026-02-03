package ca.bcit.comp2522.lecture4.jason;

public class Bat
        extends Mammal
        implements Flyable, Speakable
{


    Bat(final int yearBorn,
        final String name)
    {
        super(yearBorn, name);
    }

    @Override
    public void speak()
    {
        System.out.println("ee e e");
    }

    @Override
    public void shout()
    {
        System.out.println("EE  E EE E");
    }

    @Override
    public void fly()
    {
        System.out.println("flap wings");
    }

    @Override
    public void land()
    {
        System.out.println("upside down on ceiling");
    }

    @Override
    public double getMaxSpeedKmPerHour()
    {
        return 25;
    }
}
