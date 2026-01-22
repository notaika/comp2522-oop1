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
    private final static Date DATE_UPPER_LIMIT;

    // Initialize upper date limit??? <- is this the right way to do this???
    static
    {
        DATE_UPPER_LIMIT = new Date(YEAR_UPPER_LIMIT, MONTH_UPPER_LIMIT, DAY_UPPER_LIMIT);
    }

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

    /**
     * Returns the creatures name.
     *
     * @return creatures name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the creatures date of birth.
     *
     * @return creature's date of birth
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Returns the creature's health.
     *
     * @return creature's health
     */
    public int getHealth()
    {
        return health;
    }

    /*
     * Checks if health is between 0 and 100.
     * Throws IllegalArgumentException if invalid.
     *
     * @param healthToCheck health amount to check
     * @throws IllegalArgumentException exception thrown if health is less than 0 or greater than 100
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
     * Checks if date of birth is not in the future.
     * Throws IllegalArgumentException if invalid.
     *
     * @param dateToCheck date of birth to check
     * @throws IllegalArgumentException exception thrown if year, month or day is greater than the upper limit
     */
    private static void validateDOB(Date dateToCheck)
    {
        if  (dateToCheck.getYear() > YEAR_UPPER_LIMIT ||
            (dateToCheck.getYear() == YEAR_UPPER_LIMIT && dateToCheck.getMonth() > MONTH_UPPER_LIMIT) ||
            (dateToCheck.getYear() == YEAR_UPPER_LIMIT && dateToCheck.getMonth() == MONTH_UPPER_LIMIT && dateToCheck.getDay() > DAY_UPPER_LIMIT))
        {
            throw new IllegalArgumentException("ERROR: Birth date must be before" +
                                               DATE_UPPER_LIMIT);
        }
    }

    /*
     * Checks if name is null or empty.
     * Throw IllegalArgumentException if invalid.
     *
     * @param nameToCheck
     * @throws IllegalArgumentException exception thrown if name is null or empty.
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
     * Returns true if health is greater than 0.
     *
     * @param healthToCheck health to check
     * @return true if healthToCheck is greater than min health
     */
    public boolean isAlive(final int healthToCheck)
    {
        return healthToCheck > MIN_HEALTH;
    }

    /**
     * Reduces health by damage. If health goes below 0, set it to 0.
     * If damage is negative, throw an unchecked DamageException.
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

        System.out.println("Damage taken: " + damage + " points");

        // If health goes below min allowed, reset it to min.
        if (health < MIN_HEALTH)
        {
            health = MIN_HEALTH;
            System.out.println("Health: " + getHealth());
            System.out.println(getName() + " is dead.");
        } else
        {
            System.out.println("Health: " + getHealth());
        }
    }

    /**
     * Increases health by healAmount but cannot exceed 100.
     * If healing amount is negative, throw an unchecked HealingException.
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

        System.out.println("Healed for: " + healAmount + " points");

        // If health goes below max allowed, reset it to max.
        if (health > MAX_HEALTH)
        {
            health = MAX_HEALTH;
            System.out.println("Health: " + getHealth());
            System.out.println("Cannot heal above " + MAX_HEALTH);
        } else
        {
            System.out.println("Health: " + getHealth());
        }
    }

    /**
     * Calculates the creature's age in years based on its date of birth.
     *
     * @return age in years
     */
    public int getAgeYears()
    {
        // Subtract creatures year DOB from upper limit year
        if ((dateOfBirth.getMonth() > MONTH_UPPER_LIMIT) ||
            (dateOfBirth.getMonth() == MONTH_UPPER_LIMIT && dateOfBirth.getDay() > DAY_UPPER_LIMIT))
        {
            return DATE_UPPER_LIMIT.getYear() - dateOfBirth.getYear() - 1;
        }
        return DATE_UPPER_LIMIT.getYear() - dateOfBirth.getYear();
    }

    /**
     * Prints the creature's name, dateOfBirth, age in years, and health.
     */
    public void getDetails()
    {
        System.out.println("Name: " + getName() +
                           "\nDate of Birth: " + dateOfBirth.getYyyyMmDd() +
                           "\nAge (in years): " + getAgeYears() +
                           "\nHealth: " + getHealth());
    }

    public static void main(String[] args)
    {
        final Date testDOB = new Date(2007, 10, 7);

        final Creature testCreature = new Creature("Mischa", testDOB, 99);

        System.out.println("=== THE LORAX CREATURE DETAILS ===");
        testCreature.getDetails();



        testCreature.takeDamage(20);

        testCreature.takeDamage(100);
    }
}
















