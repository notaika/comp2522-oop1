package ca.bcit.comp2522.termproject.singletonfiles;

/**
 * Uses the Factory Design Pattern to parse strings and instantiate
 * the correct Entity subclass dynamically.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.1
 */
public final class EntityFactory
{
    private static final String DELIMITER_REGEX = "\\|";
    private static final String TYPE_SUSPECT    = "SUSPECT";
    private static final String TYPE_WEAPON     = "WEAPON";
    private static final String TYPE_LOCATION   = "LOCATION";

    private static final int MINIMUM_PARTS_COUNT = 3;
    private static final int INDEX_ENTITY_TYPE   = 0;
    private static final int INDEX_NAME          = 1;

    private static final int INDEX_SUSPECT_ALIBI              = 2;
    private static final int INDEX_SUSPECT_HEIGHT_CENTIMETERS = 3;
    private static final int INDEX_SUSPECT_EYE_COLOUR         = 4;
    private static final int INDEX_SUSPECT_INNOCENT_STATUS    = 5;

    private static final int INDEX_WEAPON_WEIGHT_CATEGORY = 2;
    private static final int INDEX_WEAPON_MURDER_STATUS   = 3;

    private static final int INDEX_LOCATION_INDOORS_STATUS = 2;
    private static final int INDEX_LOCATION_MURDER_STATUS  = 3;

    /*
     * Private constructor to prevent instantiation of a Factory class.
     */
    private EntityFactory()
    {
    }

    /**
     * Parses a delimited string and returns the corresponding Entity.
     *
     * @param unparsedLine the raw string from the text file
     * @return an instantiated Entity subclass
     * @throws IllegalArgumentException if parsing fails
     */
    public static Entity createEntity(final String unparsedLine)
    {
        final String[] parsedParts;
        final String entityType;

        validateUnparsedLine(unparsedLine);

        parsedParts = unparsedLine.split(DELIMITER_REGEX);

        if (parsedParts.length < MINIMUM_PARTS_COUNT)
        {
            throw new IllegalArgumentException("ERROR: Insufficient data parts in line.");
        }

        entityType = parsedParts[INDEX_ENTITY_TYPE];

        if (entityType.equalsIgnoreCase(TYPE_SUSPECT))
        {
            return createSuspect(parsedParts);
        }
        else if (entityType.equalsIgnoreCase(TYPE_WEAPON))
        {
            return createWeapon(parsedParts);
        }
        else if (entityType.equalsIgnoreCase(TYPE_LOCATION))
        {
            return createLocation(parsedParts);
        }
        else
        {
            throw new IllegalArgumentException("ERROR: Unknown entity type: " + entityType);
        }
    }

    /*
     * Validates that the raw line is safe to split.
     */
    private static void validateUnparsedLine(final String lineToValidate)
    {
        if (lineToValidate == null || lineToValidate.isBlank())
        {
            throw new IllegalArgumentException("ERROR: Line to parse is invalid.");
        }
    }

    /*
     * Instantiates a Suspect from the parsed string array.
     */
    private static Suspect createSuspect(final String[] parsedParts)
    {
        final String name;
        final String alibi;
        final int heightCentimeters;
        final String eyeColour;
        final boolean innocent;

        name              = parsedParts[INDEX_NAME];
        alibi             = parsedParts[INDEX_SUSPECT_ALIBI];
        heightCentimeters = Integer.parseInt(parsedParts[INDEX_SUSPECT_HEIGHT_CENTIMETERS]);
        eyeColour         = parsedParts[INDEX_SUSPECT_EYE_COLOUR];
        innocent          = Boolean.parseBoolean(parsedParts[INDEX_SUSPECT_INNOCENT_STATUS]);

        return new Suspect(name,
                           alibi,
                           innocent,
                           heightCentimeters,
                           eyeColour);
    }

    /*
     * Instantiates a Weapon from the parsed string array.
     */
    private static Weapon createWeapon(final String[] parsedParts)
    {
        final String name;
        final String weightCategory;
        final boolean murderWeapon;

        name           = parsedParts[INDEX_NAME];
        weightCategory = parsedParts[INDEX_WEAPON_WEIGHT_CATEGORY];
        murderWeapon   = Boolean.parseBoolean(parsedParts[INDEX_WEAPON_MURDER_STATUS]);

        return new Weapon(name,
                          weightCategory,
                          murderWeapon);
    }

    /*
     * Instantiates a Location from the parsed string array.
     */
    private static Location createLocation(final String[] parsedParts)
    {
        final String name;
        final boolean indoors;
        final boolean murderLocation;

        name           = parsedParts[INDEX_NAME];
        indoors        = Boolean.parseBoolean(parsedParts[INDEX_LOCATION_INDOORS_STATUS]);
        murderLocation = Boolean.parseBoolean(parsedParts[INDEX_LOCATION_MURDER_STATUS]);

        return new Location(name,
                            indoors,
                            murderLocation);
    }
}
