package ca.bc.spca;

public class Pitbull extends Dog
{
    private boolean trained;

    Pitbull(final int     birthYear,
            final String  name,
            final boolean trained)
    {
        super(birthYear, name);
        this.trained = trained;
    }
}
