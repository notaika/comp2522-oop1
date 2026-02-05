package ca.bcit.comp2522.lecture4.jason;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1
{
    public static void main(final String[] args)
    {
        final List<Mammal1> mammals;
        mammals = new ArrayList<>();
        mammals.add(new Bat1(2020, "bat"));
        mammals.add(new Bat1(2011, "Fruit bat"));
        mammals.add(new Dog2("rocky", "puppy", 2015));
        mammals.add(new Bat1(2024, "bat"));
        mammals.add(new Bat1(2025, "vampire bat"));
        mammals.add(new Bat1(2014, "bat"));

        System.out.println(mammals);
        Collections.sort(mammals);
        System.out.println(mammals);


        final Flyable f1;
        final Flyable f2;
        final Flyable f3;

        f1 = new Bat1(2020, "bat");
        f2 = new Airplane("red");

        f1.fly();
        f1.land();
        f1.crash();

        f2.fly();
        f2.land();
        f2.crash();
    }
}
