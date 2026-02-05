package ca.bcit.comp2522.lecture4.jason;

class Dog2
    extends Mammal1
{
    private final String name;

    Dog2(final String name,
        final String speciesName,
        final int yearBorn)
    {
        super(yearBorn, speciesName);
        this.name = name;
    }


}
