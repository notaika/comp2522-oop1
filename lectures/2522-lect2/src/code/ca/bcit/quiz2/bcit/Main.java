package ca.bcit.quiz2.bcit;

public class Main
{
    private static void main(final String[] args)
    {
        final A child = new B(1, false, 2030, "f");

        child.speak();

        if (child instanceof B)
        {
            ((B) child).roars();
        }


        try
        {
            connectToDatabase();
        } catch (final Exception error)
        {
            throws new InvalidConnectionException("Database Offline");
        }
    }


}
