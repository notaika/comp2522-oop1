package ca.bcit.comp2522.lab2.creatures;

/**
 * Represents a fantasy orc.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class Orc extends Creature
{
    private static final int MIN_RAGE;
    private static final int LOW_RAGE;
    private static final int BERSERK_RAGE_THRES;
    private static final int MAX_RAGE;
    private static final int RAGE_INCREASE;
    private static final int BERSERK_DAMAGE;

    private int rage;

    MIN_RAGE = 0;
    LOW_RAGE = 5;
    BERSKER_RAGE_THRES = 20;
    MAX_RAGE = 30;
    RAGE_INCREASE = 5;
    BERKSERK_DAMAGE = 15;

    /**
     * Sets Orc's name, dote of birth, health and rage on creation.
     *
     * @param name The name of the Orc
     * @param dateOfBirth The date of birth of the Orc
     * @param health The health of the Orc
     * @param rage The current mana of the Orc
     */
    public Orc(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int rage)
    {
        super(name, dateOfBirth, health);
        validateRage(rage);
        this.rage = rage;
    }

    /*
     * Checks if the rage is between MIN_RAGE and MAX_RAGE.
     *
     * @param rage The rage to check
     */
    private static void validateRage(int rage)
    {
        if (rage < MIN_RAGE ||
            rage > MAX_RAGE)
        {
            throw new IllegalArgumentException("ERROR: rage must be between " +
                                               MIN_RAGE +
                                               " and " +
                                               MAX_RAGE);
        }
    }

    /**
     * Increases Rage by RAGE_INCREASE and deals damage depending on resulting rage.
     * @return BERSERK_DAMAGE if rage is below BERKERK_RAGE_THRES and double that if it's above
     */
    public int berserk()
    {
        int damageDealt;

        damageDealt = BERSERK_DAMAGE;

        rage += RAGE_INCREASE;

        if (rage > MAX_RAGE)
        {
            rage = MAX_RAGE;
        }

        if (rage > BERSERK_RAGE_THRES)
        {
            damageDealt *= 2;
        }

        if (rage < LOW_RAGE)
        {
            throw new LowRageException("ERROR: rage is below" +
                                       LOW_RAGE);
        }

        System.out.println(getName() +
                           " went Berserk: " +
                           damageDealt +
                           "damage points");

        return damageDealt;
    }

    /**
     * Calls Creature's getDetails() and adds rage to the list.
     */
    @Override public void getDetails()
    {
        super.getDetails();
        System.out.println("Rage: " +
                           rage);
    }
}
