package ca.bcit.comp2522.lecture3;

public class Dolphin extends Mammal
{
    public Dolphin(double weightKg)
    {
        super(weightKg);
    }

    @Override
    void move()
    {
        System.out.println("swim");
    }

    @Override
    void speak()
    {
        System.out.println("eee ee e e eee");
    }


}
