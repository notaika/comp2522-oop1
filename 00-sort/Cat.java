package ca.bc.spca;

class Cat extends Animal
{
    Cat(final int birthYear)
    {
        super(birthYear);
    }

    void meow()
    {
        System.out.println("MEOW");
    }

    @Override
    void speak()
    {
        System.out.println("MEOWWWWWWWWWWWW");
    }
}
