package ca.bcit.comp2522.lecture4.interfaces;

public abstract class Mammal
    implements Comparable<Mammal> // im comparing mammals to mammals
{
    final int yearBorn;
    private final String name;


    Mammal(int yearBorn,
                     String name)
    {
        this.yearBorn = yearBorn;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name + " born in " + yearBorn;
    }

    @Override
    public int compareTo(final Mammal m)
    {
        // QUIZ QUESTION!!! ONE, THE OTHER OR BOTH
        // let's say that older mammals are larger
        // rules:
        // 1. returns 0 if `this` is == m
        // 2. returns some positive number if this > m
        // 3. returns some negative number if this < m

        // comment this out for now
        //return this.yearBorn - m.yearBorn;
    return this.name.length() - m.name.length();
    }
}

// We'll say, older mammals are larger


