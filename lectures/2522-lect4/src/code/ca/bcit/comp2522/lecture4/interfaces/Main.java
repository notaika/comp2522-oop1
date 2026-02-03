package ca.bcit.comp2522.lecture4.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        // you're counting on the fact that they have the ability to fly, land and crash
        // doesn't need to be specific mammal, vehicle, etc
        // great substitution - very abstract
        final Flyable f1;
        final Flyable f2;
        final Flyable f3;

        // can substitute anything that flies; the only thing that matters is their abilities
        f1 = new Bat(2020,
                     "bat");
        f2 = new Airplane("red");

        f1.fly();
        f1.land();
        f1.crash();

        f2.fly();
        f2.land();
        f2.crash();

        final List<Mammal> mammals;
        mammals = new ArrayList<>();
        mammals.add(new Bat(2020, "bat"));
        mammals.add(new Bat(2011, "bat"));
        mammals.add(new Dog(2020, "Rocky", "ca.bcit.comp2522.lecture4.interfaces.Dog"));
        mammals.add(new Bat(2009, "bat"));

        Collections.sort(mammals);

        System.out.println();
        System.out.println();
        System.out.println();

        final Openable o1;
        final Openable o2;
        final Openable o3;
        final Openable o4;

        o1 = new Door(30);
        o2 = new Door(37);
        o3 = new Door(25);
        o4 = new Door(35);

        o1.open();
        o1.close();

        o2.open();
        o2.close();

        //System.out.println(o1.compareTo(o2));
    }
}
