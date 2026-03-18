package ca.bc.spca;

import java.io.IOException;

public class Main
{
    public static void main(final String[] args)
    {
        final Animal a1;
        final Animal a2;
        final Animal a3;
        final Animal a4;

        a1 = new Dog(2020, "rocky");
        a2 = new Cat(2025);
        a3 = new Pitbull(2021, "fido", true);

        try
        {
            a4 = new Animal(2026);
            a4.speak();
        }
        catch(final InvalidYearOfBirthException e)
        {
            System.out.println("BAD YEAR OF BIRTH");
        }

        if(a2 instanceof Cat)
        {
            final Cat c;
            c = (Cat)a2;
            c.meow();
        }

        a1.speak();
        a2.speak();
        a3.speak();

    }
}
