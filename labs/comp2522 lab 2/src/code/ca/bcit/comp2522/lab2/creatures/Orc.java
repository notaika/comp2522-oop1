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
    private static final int BERSERK_RAGE_THRESHOLD = 20;
    private static final int MAX_RAGE = 30;
    private static final int BERSERK_DAMAGE = 15;
    private static final int RAGE_DAMAGE_MULTIPLIER = 2;

    private int rage;

    /**
     * Constructs and initializes Orc's name, date of birth, health and rage.
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
     * Returns the Orc's rage stat
     *
     * @return Orc's rage stat
     */
    public int getRage()
    {
        return rage;
    }

    /**
     * Increases Rage by RAGE_INCREASE and deals damage depending on resulting rage.
     * If rage is above BERSERK_RAGE_THRES then reset it to LOW_RAGE;
     *
     * @param creatureToAttack the creature to inflict damage on
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
            System.out.println(getName() + " is raging! Damage increased from "
                               + BERSERK_DAMAGE + " to " + MAX_RAGE);
        } else
        {
            damageInflicted = BERSERK_DAMAGE;
        }

        System.out.println(getName() +
                           " goes berserk: inflicted +" +
                           damageInflicted +
                           " damage | Rage left: " + getRage());

        creatureToAttack.takeDamage(damageInflicted);

        // Reset rage when max limit is hit (calms down)
        if (rage >= MAX_RAGE)
        {
            rage = RAGE_FACTOR;
            System.out.println(getName() + " overheated and is calming down. | Rage: " + getRage());
        } else
        {
            // Increased rage by given factor
            rage += RAGE_FACTOR;
            System.out.println(getName() + " gained " + RAGE_FACTOR + " rage | Rage: " + getRage());
        }

        if (rage < RAGE_FACTOR)
        {
            throw new LowRageException("WARNING: " + getName() + " rage is critically low!");
        }
    }

    /**
     * Prints details about the Orc - name, date of birth, age (in years), health and rage.
     */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Rage: " +
                           rage);
    }
}
