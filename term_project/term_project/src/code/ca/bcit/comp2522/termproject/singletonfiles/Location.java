package ca.bcit.comp2522.termproject.singletonfiles;

/**
 * Represents a location entity in the detective logic game.
 * Tracks whether the location is situated indoors or outdoors, and if it is the murder location.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.2
 */
public final class Location
        extends Entity
{
    private final boolean indoors;
    private final boolean murderLocation;

    /**
     * Constructs and initializes a Location with a name, indoors state, and murder status.
     *
     * @param name the name of the location as a String
     * @param indoors true if the location is indoors, false if outdoors
     * @param murderLocation true if this is the murder location, false otherwise
     * @throws IllegalArgumentException if the name is invalid
     */
    public Location(final String name,
                    final boolean indoors,
                    final boolean murderLocation)
    {
        super(name);

        this.indoors        = indoors;
        this.murderLocation = murderLocation;
    }

    /**
     * Returns the state representing whether the location is indoors.
     *
     * @return true if indoors, false otherwise
     */
    public boolean getIndoors()
    {
        return indoors;
    }

    /**
     * Returns whether this is the murder location.
     *
     * @return true if it is the murder location, false otherwise
     */
    public boolean getMurderLocation()
    {
        return murderLocation;
    }

    /**
     * Returns a formatted string of the location's public details.
     * Excludes the murder location status to prevent game-breaking spoilers.
     *
     * @return the details as a String
     */
    @Override
    public String getDetails()
    {
        final String environment;

        if (indoors)
        {
            environment = "Indoors";
        }
        else
        {
            environment = "Outdoors";
        }

        return "Environment: " + environment;
    }
}