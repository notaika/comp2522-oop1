package ca.bcit.comp2522.lab2.creatures;

/**
 * Represents a fantasy dragon.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class Dragon extends Creature
{
    private static final int MIN_FIREPOWER = 1;
    private static final int LOW_FIREPOWER_THRESHOLD = 10;
    private static final int MAX_FIREPOWER = 100;
    private static final int FIRE_DAMAGE = 20;

    private int firePower;

    /**
     * Sets Dragon's name, dote of birth, health and fire power on creation.
     *
     * @param name The name of the Dragon
     * @param dateOfBirth The date of birth of the Dragon
     * @param health The health of the Dragon
     * @param firePower The current firePower of the Dragon
     */
    public Dragon(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int firePower)
    {
        super(name, dateOfBirth, health);
        validateFirePower(firePower);
        this.firePower = firePower;
    }

    /*
     * Checks if firepower is between MIN_FIREPOWER and MAX_FIREPOWER.
     * Throws IllegalArgumentException if invalid.
     *
     * @param firePower the stat to check
     * @throws IllegalArgumentException if firepower is invalid
     */
    private static void validateFirePower(final int firePower)
    {
        if (firePower < MIN_FIREPOWER || firePower > MAX_FIREPOWER)
        {
            throw new IllegalArgumentException("ERROR: Firepower must be in between " +
                                               MIN_FIREPOWER +
                                               " and " +
                                               MAX_FIREPOWER);
        }
    }

    /**
     * Returns the dragon's firepower stat.
     *
     * @return dragon's firepower stat
     */
    public int getFirePower()
    {
        return firePower;
    }

    /**
     * Deals FIRE_DAMAGE damage to another creature and reduces firepower by LOW_FIREPOWER_THRESHOLD.
     * Throws a LowFirePowerException if firepower is low.
     *
     * @param creatureToAttack
     * @throws LowFirePowerException if firePower is below LOW_FIREPOWER_THRESHOLD
     */
    public void breatheFire(final Creature creatureToAttack) throws LowFirePowerException
    {
        if (isPassedOut())
        {
            System.out.println(getName() + " is passed out. Attack failed!");
            return;
        }

        // If firepower is at 0, send error.
        if (firePower < MIN_FIREPOWER)
        {
            throw new LowFirePowerException("ERROR: " + getName() + " doesn't have enough firepower " +
                                            " - Attack failed.");
        }

        // Reduce firepower by LOW_FIREPOWER_THRESHOLD
        firePower -= LOW_FIREPOWER_THRESHOLD;
        System.out.println(getName() +
                           " breathed fire: inflicted +" +
                           FIRE_DAMAGE +
                           " fire damage | Firepower left: " + getFirePower());

        // Inflict damage onto creature
        creatureToAttack.takeDamage(FIRE_DAMAGE);

        // Send a warning if firepower is less than LOW_FIREPOWER_THRESHOLD
        if (firePower < LOW_FIREPOWER_THRESHOLD)
        {
            throw new LowFirePowerException("WARNING: " + getName() + " firepower is critically low!");
        }
    }

    /**
     * Adds specified amount to firePower.
     *
     * @param amountToRestore The amount to add to firePower
     */
    public void restoreFirePower(final int amountToRestore)
    {
        if (amountToRestore < MIN_FIREPOWER)
        {
            throw new IllegalArgumentException("ERROR: Firepower must be in between " +
                                           MIN_FIREPOWER +
                                           " and " +
                                           MAX_FIREPOWER);
        }

        firePower += amountToRestore;

        // Firepower capped at 100
        if (firePower > MAX_FIREPOWER)
        {
            firePower = MAX_FIREPOWER;
        }
        System.out.println(getName() + " restored " + amountToRestore + " firepower.");
    }

    /**
     * Calls Creature getDetails() and adds firePower to the end.
     */
    @Override
    public void getDetails()
    {
        super.getDetails();

        System.out.println("Firepower: " +
                           getFirePower());
    }

}
