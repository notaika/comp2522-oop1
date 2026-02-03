package ca.bcit.comp2522.lecture4.review;

public class Plane
    implements Flyable
{
    @Override
    public void fly()
    {
        System.out.println("*engine sounds*");
    }

    @Override
    public void land()
    {
        System.out.println("lands at an airport");
    }
}
