public abstract class Mammal
    implements Comparable<Mammal>
{
    private final int yearBorn;
    private final String name;

    Mammal(final int yearBorn,
           final String name)
    {
        this.yearBorn = yearBorn;
        this.name = name;
    }

    @Override
    public int compareTo(final Mammal m)
    {
        // older mammals are "larger"

        // returns 0 if this is equal to m
        // returns + if this is > m
        // returns - if this is < m
        // return m.yearBorn - this.yearBorn;

        // longer mammal names are bigger
        return this.name.length() - m.name.length();
    }

    @Override
    public String toString()
    {
        return name + " born in " + yearBorn;
    }
}
