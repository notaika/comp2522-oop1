class Dog
    extends Mammal
{
    private final String name;

    Dog(final String name,
        final String speciesName,
        final int yearBorn)
    {
        super(yearBorn, speciesName);
        this.name = name;
    }


}
