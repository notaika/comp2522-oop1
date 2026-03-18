package ca.bc.spca;

class Dog extends Animal
{
    private final String name;

    Dog(final int    birthYear,
        final String name)
    {
        super(birthYear);
        //System.out.println("hi");
        this.name = name;
    }

    void bark()
    {
        System.out.println("WOOF");
    }

    @Override
    void speak()
    {
        System.out.println("WOOFFFFFFFFFFFFFFFFFF");
    }
}
