package ca.bcit.comp2522.game;

/**
 * Represents a player.
 *
 * @author Aika Manalo - Set 2C
 * @author Mayvee Tan - Set 2C
 *
 * @version 1.0
 */
class Player
{
    private final String name;
    private int numGamesPlayed;

    private Player(final String name)
    {
        this.name           = name;
        this.numGamesPlayed = 0;
    }

    private static void validateName(final String nameToCheck)
    {
        if (nameToCheck == null ||
            nameToCheck.isBlank())
        {
            throw new IllegalArgumentException("ERROR: Invalid name");
        }
    }

    private String getName()
    {
        return name;
    }

    private int getNumGamesPlayed()
    {
        return numGamesPlayed;
    }

    private void setNumGamesPlayed(int numGamesPlayed)
    {
        this.numGamesPlayed = numGamesPlayed;
    }
}
