package ca.bcit.comp2522.lecture4.interfaces;

public class Dog
    extends Mammal
{
    private final String speciesName;
    Dog(int yearBorn,
        String name,
        String speciesName)
    {
        super(yearBorn,
              name);
        this.speciesName = speciesName;
    }


}
