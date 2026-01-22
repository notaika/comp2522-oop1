package ca.bcit.comp2522.lecture3;

class Bat extends Mammal
{
    Bat(double weightKg)
    {
        super(weightKg);
    }

    @Override void move()
    {
        System.out.println("fly");
    }

    @Override void speak()
    {
        System.out.println("ultra high ee ee e e e");
    }


}
