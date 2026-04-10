package ca.bcit.comp2522.termproject.wordgame;

/**
 * Represents a Country with its name, capital city, and interesting facts.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public final class Country
{
    private static final int NUM_FACTS = 3;

    private final String name;
    private final String capitalCityName;
    private final String[] facts;

    /**
     * Constructs and validates a Country object.
     *
     * @param name            the name of the country
     * @param capitalCityName the name of the capital city
     * @param facts           an array of interesting facts about the country
     * @throws IllegalArgumentException if any parameter is null or invalid
     */
    public Country(final String name,
                   final String capitalCityName,
                   final String[] facts)
    {
        validateString(name, "Country name");
        validateString(capitalCityName, "Capital city name");
        validateFacts(facts);

        this.name = name;
        this.capitalCityName = capitalCityName;
        this.facts = facts;
    }

    /*
     * Validates that a string is not null or blank.
     */
    private static void validateString(final String stringToValidate,
                                       final String fieldName)
    {
        if (stringToValidate == null || stringToValidate.isBlank())
        {
            throw new IllegalArgumentException("ERROR: " + fieldName + " cannot be null or blank.");
        }
    }

    /*
     * Validates that the facts array is not null and has the correct size.
     */
    private static void validateFacts(final String[] factsToValidate)
    {
        if (factsToValidate == null || factsToValidate.length != NUM_FACTS)
        {
            throw new IllegalArgumentException("ERROR: Facts array must contain exactly " + NUM_FACTS + " elements.");
        }

        for (final String fact : factsToValidate)
        {
            validateString(fact, "Fact");
        }
    }

    /**
     * Returns the name of the country.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the name of the capital city.
     *
     * @return the capital city name
     */
    public String getCapitalCityName()
    {
        return capitalCityName;
    }

    /**
     * Returns a specific fact about the country by index.
     *
     * @param index the index of the fact (0 to 2)
     * @return the fact at the specified index
     * @throws IllegalArgumentException if index is out of bounds
     */
    public String getFact(final int index)
    {
        if (index < 0 || index >= facts.length)
        {
            throw new IllegalArgumentException("ERROR: Fact index out of bounds.");
        }
        return facts[index];
    }
}
