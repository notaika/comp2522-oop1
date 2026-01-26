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
    private static final int MIN_FIREPOWER = 0;
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
     * @return FIRE_DAMAGE
     * @throws LowFirePowerException if firePower is below LOW_FIREPOWER_THRESHOLD
     */
    public int breatheFire() throws LowFirePowerException
    {
        // Send a warning if firepower is less than LOW_FIREPOWER_THRESHOLD
        if (firePower < LOW_FIREPOWER_THRESHOLD)
        {
            throw new LowFirePowerException("Firepower is at " +
                                            getFirePower());
        }

        // Reduce firepower by LOW_FIREPOWER_THRESHOLD
        firePower -= LOW_FIREPOWER_THRESHOLD;
        System.out.println(getName() +
                           " breathed fire: " +
                           FIRE_DAMAGE +
                           " damage points");

        System.out.println("Firepower: " +
                           getFirePower());
        // Deals FIRE_DAMAGE damage
        return FIRE_DAMAGE;
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
        System.out.println("Firepower restored: " +
                           amountToRestore +
                           " points");
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

    public static void main(String[] args)
    {
        final Date testDOB = new Date(2000, 8, 31);
        final Dragon testDragon = new Dragon("Toothless", testDOB, 100, 40);

        testDragon.getDetails();

        try
        {
            testDragon.breatheFire();
            testDragon.breatheFire();
            testDragon.breatheFire();
            testDragon.breatheFire();
            testDragon.breatheFire();
            testDragon.breatheFire();
        }
        catch (LowFirePowerException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
    }











}
