import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(final String[] args)
    {
        final List<Mammal> mammals;
        mammals = new ArrayList<>();
        mammals.add(new Bat(2020, "bat"));
        mammals.add(new Bat(2011, "Fruit bat"));
        mammals.add(new Dog("rocky", "puppy", 2015));
        mammals.add(new Bat(2024, "bat"));
        mammals.add(new Bat(2025, "vampire bat"));
        mammals.add(new Bat(2014, "bat"));

        System.out.println(mammals);
        Collections.sort(mammals);
        System.out.println(mammals);


        final Flyable f1;
        final Flyable f2;
        final Flyable f3;

        f1 = new Bat(2020, "bat");
        f2 = new Airplane("red");

        f1.fly();
        f1.land();
        f1.crash();

        f2.fly();
        f2.land();
        f2.crash();
    }
}
