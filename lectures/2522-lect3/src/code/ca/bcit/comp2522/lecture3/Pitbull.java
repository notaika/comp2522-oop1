package ca.bcit.comp2522.lecture3;

class Pitbull extends Dog
{
    public Pitbull(double weightKg,
                   String name)
    {
        super(weightKg,
              name);
    }

    @Override
    void speak()
    {
        System.out.println("yap yap");
    }
}
