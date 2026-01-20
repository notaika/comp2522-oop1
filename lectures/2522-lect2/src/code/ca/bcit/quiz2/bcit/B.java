package ca.bcit.quiz2.bcit;

public class B extends A
{
    private final String e;

    B(final int c, final boolean d, final int dob, final String e)
    {
        super(c, d, dob);
        this.e = e;
    }

    public void roars() {
        System.out.println("Roars");
    }

    @Override
    public void speak()
    {
        System.out.println("B speaks");
    }
}
