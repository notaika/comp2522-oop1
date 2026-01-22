package ca.bcit.comp2522.lecture3;

class Dog extends Mammal
{
    private final String name;

    Dog(final double weightKg,
               final String name)
    {
        super(weightKg);
        this.name = name;
    }

    @Override
    void move()
    {
        System.out.println("run");
    }

    @Override
    void speak()
    {
        System.out.println("bark");
    }
}
