package ca.bcit.comp2522.lab2.creatures;

/**
 * Represents a fantasy creature.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class Creature
{
    private final static int MIN_HEALTH = 0;
    private final static int MAX_HEALTH = 100;

    private final static int YEAR_UPPER_LIMIT = 2026;
    private final static int MONTH_UPPER_LIMIT = 1;
    private final static int DAY_UPPER_LIMIT = 21;

    private final String name; // not null or empty
    private final Date dateOfBirth; // must not be in the future

    private int health; // must be 1 - 100

    public Creature(final String name,
                    final Date dateOfBirth,
                    final int health)
    {
        validateName(name);
        validateDOB(dateOfBirth);
        validateHealth(health);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
    }

    /*
     *
     *
     * @param healthToCheck
     */
    private static void validateHealth(int healthToCheck)
    {
        if (healthToCheck < MIN_HEALTH || healthToCheck > MAX_HEALTH)
        {
            throw new IllegalArgumentException("ERROR: Health must be in between " +
                                               MIN_HEALTH + " and " + MAX_HEALTH);
        }
    }

    /*
     *
     *
     * @param dateToCheck
     */
    private static void validateDOB(Date dateToCheck)
    {
        final Date DATE_UPPER_LIMIT;
        DATE_UPPER_LIMIT = new Date(YEAR_UPPER_LIMIT, MONTH_UPPER_LIMIT, DAY_UPPER_LIMIT);

        if  (dateToCheck.getYear() > YEAR_UPPER_LIMIT ||
            (dateToCheck.getYear() == YEAR_UPPER_LIMIT && dateToCheck.getMonth() > MONTH_UPPER_LIMIT) ||
            (dateToCheck.getYear() == YEAR_UPPER_LIMIT && dateToCheck.getMonth() == MONTH_UPPER_LIMIT && dateToCheck.getDay() > DAY_UPPER_LIMIT))
        {
            throw new IllegalArgumentException("ERROR: Birth date must be before" +
                                               DATE_UPPER_LIMIT);
        }
    }

    /*
     *
     *
     * @param nameToCheck
     * @throws IllegalArgumentException
     */
    private static void validateName(String nameToCheck)
    {
        if (nameToCheck == null || nameToCheck.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: Name cannot be null or empty.");
        }
    }

    /**
     * Checks if creature is still alive.
     *
     * @param healthToCheck health to check
     * @return true if healthToCheck is greater than min health
     */
    public boolean isAlive(final int healthToCheck)
    {
        return healthToCheck > MIN_HEALTH;
    }

    /**
     * Reduces creature's health by the specified damage amount.
     * If health falls below the stated minimum, resets to minimum.
     *
     * @param damage amount of health to take away (damage), must not go below stated minimum
     * @throws DamageException exception thrown if damage is below the stated minimum
     */
    public void takeDamage(final int damage)
    {
        if (damage < MIN_HEALTH)
        {
            throw new DamageException("ERROR: Damage cannot be lower than " + MIN_HEALTH);
        }

        health -= damage;

        // If health goes below min allowed, reset it to min.
        if (health < MIN_HEALTH)
        {
            health = MIN_HEALTH;
        }
    }

    /**
     * Add's specified heal amount to creature's health.
     * Health cannot exceed stated maximum amount.
     *
     * @param healAmount amount of health to add (heal), must not go below minimum
     * @throws HealingException exception throw if heal amount is below the allowed minimum
     */
    public void heal(int healAmount)
    {
        if (healAmount < MIN_HEALTH)
        {
            throw new HealingException("ERROR: Cannot heal for less than " + MIN_HEALTH);
        }

        health += healAmount;

        // If health goes below max allowed, reset it to max.
        if (health > MAX_HEALTH)
        {
            health = MAX_HEALTH;
        }
    }

    /**
     * Calculates
     *
     * @return age in years
     */
    public int getAgeYears()
    {

    }


}
















