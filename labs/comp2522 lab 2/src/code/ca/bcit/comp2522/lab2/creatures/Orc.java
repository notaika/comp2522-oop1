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
    private static final int MIN_RAGE = 1;
    private static final int RAGE_FACTOR = 5;
    private static final int RESET_RAGE = 0;
    private static final int BERSERK_RAGE_THRESHOLD = 20;
    private static final int MAX_RAGE = 30;
    private static final int BERSERK_DAMAGE = 15;
    private static final int RAGE_DAMAGE_MULTIPLIER = 2;

    private int rage;

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
     * If rage is above BERSERK_RAGE_THRES then reset it to LOW_RAGE;
     *
     * @param creatureToAttack
     */
    public void berserk(final Creature creatureToAttack)
    {

        final int damageInflicted;
        if (rage < MIN_RAGE)
        {
            throw new LowRageException("ERROR: " + getName() + " doesn't have enough rage " +
                                        " - Attack failed.");
        }

        // If rage > berserk threshold, double damage inflicted
        if (rage >= BERSERK_RAGE_THRESHOLD)
        {
            damageInflicted = BERSERK_DAMAGE * RAGE_DAMAGE_MULTIPLIER;

            // Reset rage
            rage = RESET_RAGE;
        } else
        {
            damageInflicted = BERSERK_DAMAGE;

            // Increased rage by given factor
            rage += RAGE_FACTOR;
        }

        creatureToAttack.takeDamage(damageInflicted);

        if (rage < RAGE_FACTOR)
        {
            throw new LowRageException("WARNING: " + getName() + " rage is critically low!");
        }
    }

    /**
     * Calls Creature's getDetails() and adds rage to the list.
     */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Rage: " +
                           rage);
    }
}
