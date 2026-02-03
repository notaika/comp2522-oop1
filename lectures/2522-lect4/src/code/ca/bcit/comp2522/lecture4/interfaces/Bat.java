package ca.bcit.comp2522.lecture4.interfaces;

public class Bat
        extends Mammal
        implements Flyable, Speakable
{
    public Bat(int yearBorn,
               String name)
    {
        super(yearBorn,
              name
             );
    }

    @Override public void fly()
    {
        System.out.println("flap wings");
    }

    @Override public void land()
    {
        System.out.println("hanging upside down on the ceiling");
    }

    @Override public double getMaxSpeedKmPerHour()
    {
        return 0;
    }

    @Override public void speak()
    {
        System.out.println("e e eee e");
    }

    @Override public void shout()
    {
        System.out.println("EE EE EE");
    }

    @Override public int compareTo(Mammal o)
    {
        return 0;
    }
}
