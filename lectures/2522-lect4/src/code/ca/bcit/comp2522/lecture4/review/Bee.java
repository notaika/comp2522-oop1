package ca.bcit.comp2522.lecture4.review;

public class Bee
    implements Flyable
{
    @Override
    public void fly()
    {
        System.out.println("bzz bzz");
    }

    @Override
    public void land()
    {
        System.out.println("lands on a flower petal");
    }
}
