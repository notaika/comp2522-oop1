package ca.bcit.comp2522.termproject.singletonfiles;

/**
 * Represents a suspect in the detective logic game.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.2
 */
public final class Suspect
        extends Entity
{
    private final String  alibi;
    private final boolean innocent;
    private final int     heightCentimeters;
    private final String  eyeColour;

    /**
     * Constructs and initializes a Suspect with all physical and case data.
     *
     * @param name the suspect's name as a String
     * @param alibi the suspect's alibi statement as a String
     * @param innocent the innocence status as a boolean
     * @param heightCentimeters the suspect's height in cm as an int
     * @param eyeColour the suspect's eye colour as a String
     * @throws IllegalArgumentException if fields are invalid
     */
    public Suspect(final String name,
                   final String alibi,
                   final boolean innocent,
                   final int heightCentimeters,
                   final String eyeColour)
    {
        super(name);

        validateString(alibi,
                       "Alibi");
        validateString(eyeColour,
                       "Eye Colour");

        this.alibi             = alibi;
        this.innocent          = innocent;
        this.heightCentimeters = heightCentimeters;
        this.eyeColour         = eyeColour;
    }

    /*
     * Validates that a string is not null or blank.
     *
     * @param stringToValidate the string to validate
     * @param fieldName the field validated for feedback
     * @throws IllegalArgumentException if the value is invalid
     */
    private static void validateString(final String stringToValidate,
                                       final String fieldName)
    {
        if (stringToValidate == null || stringToValidate.isBlank())
        {
            throw new IllegalArgumentException("ERROR: " + fieldName + " is invalid.");
        }
    }

    /**
     * Returns the suspect's alibi.
     *
     * @return the alibi as a String
     */
    public String getAlibi()
    {
        return alibi;
    }

    /**
     * Returns whether the suspect is innocent.
     *
     * @return true if innocent, false otherwise
     */
    public boolean getInnocent()
    {
        return innocent;
    }

    /**
     * Returns the suspect's height.
     *
     * @return the height in centimeters as an int
     */
    public int getHeightCentimeters()
    {
        return heightCentimeters;
    }

    /**
     * Returns the suspect's eye colour.
     *
     * @return the eye colour as a String
     */
    public String getEyeColour()
    {
        return eyeColour;
    }

    /**
     * Returns a formatted string of the suspect's known public details.
     * Excludes the innocence status to prevent game-breaking spoilers.
     *
     * @return the details as a String
     */
    @Override
    public String getDetails()
    {
        return "Alibi: " + alibi + "\nEyes: " + eyeColour + " | Height: " + heightCentimeters + "cm";
    }
}