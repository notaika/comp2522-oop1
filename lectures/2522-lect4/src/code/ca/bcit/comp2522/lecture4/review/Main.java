package ca.bcit.comp2522.lecture4.review;

public class Main
{
    public static void main(final String[] args)
    {
        final Flyable plane = new Plane();
        final Flyable bee = new Bee();

        plane.crash();
        bee.crash();
    }
}
