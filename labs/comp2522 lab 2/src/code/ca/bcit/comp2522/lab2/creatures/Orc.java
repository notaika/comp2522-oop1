package ca.bcit.comp2522.lab2.creatures;

/**
 * Represents a fantasy orc.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class Orc
{
    private static final int MIN_RAGE = 0;
    private static final int LOW_RAGE = 5;
    private static final int MAX_RAGE = 30;

    public int rage;

    public Orc(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int rage)
    {
        super(name, dateOfBirth, health);
        validateRage(rage);
        this.rage = rage;
    }

    private void validateRage(int rage)
    {

    }



}
