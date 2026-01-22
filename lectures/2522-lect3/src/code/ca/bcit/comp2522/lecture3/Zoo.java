package ca.bcit.comp2522.lecture3;

public class Zoo
{
    public static void main(String[] args)
    {
        final Mammal m1;
        final Mammal m2;
        final Mammal m3;
        final Mammal m4;
        final Mammal m5;

        m1 = new Pitbull(40.0, "rocky"); // <- can be declared as Animal, Mammal or Dog (or Object...)
        m2 = new FruitBat(0.03); // <- Animal, Mammal, Bat
        m3 = new BattlenoseDolphin(200.0); // <- Animal, Mammal, Dolphin

        // because abstract method = child classes MUST override it and implement it
        m1.move();
        m1. speak();

        m2.move();
        m2. speak();

        m3.move();
        m3. speak();
    }
}
