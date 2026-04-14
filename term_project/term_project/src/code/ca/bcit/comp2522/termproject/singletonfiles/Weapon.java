package ca.bcit.comp2522.termproject.singletonfiles;

/**
 * Represents a weapon entity in the detective logic game.
 * Stores the weight classification and whether it is the murder weapon.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.2
 */
public final class Weapon
        extends Entity
{
    private final String  weightCategory;
    private final boolean murderWeapon;

    /**
     * Constructs and initializes a Weapon with a name, weight category, and murder status.
     *
     * @param name the name of the weapon as a String
     * @param weightCategory the weight classification (e.g., light-weight) as a String
     * @param murderWeapon true if this is the murder weapon, false otherwise
     * @throws IllegalArgumentException if the name or weight category is invalid
     */
    public Weapon(final String name,
                  final String weightCategory,
                  final boolean murderWeapon)
    {
        super(name);

        validateWeightCategory(weightCategory);

        this.weightCategory = weightCategory;
        this.murderWeapon   = murderWeapon;
    }

    /*
     * Validates that the weight category is not null or blank.
     *
     * @param categoryToValidate the weight category to check
     * @throws IllegalArgumentException if the value is invalid
     */
    private static void validateWeightCategory(final String categoryToValidate)
    {
        if (categoryToValidate == null || categoryToValidate.isBlank())
        {
            throw new IllegalArgumentException("ERROR: Weight category is invalid.");
        }
    }

    /**
     * Returns the weight category of the weapon.
     *
     * @return the weight category as a String
     */
    public String getWeightCategory()
    {
        return weightCategory;
    }

    /**
     * Returns whether this is the murder weapon.
     *
     * @return true if it is the murder weapon, false otherwise
     */
    public boolean getMurderWeapon()
    {
        return murderWeapon;
    }

    /**
     * Returns a formatted string of the weapon's public details.
     * Excludes the murder weapon status to prevent game-breaking spoilers.
     *
     * @return the details as a String
     */
    @Override
    public String getDetails()
    {
        return "Weight: " + weightCategory;
    }
}