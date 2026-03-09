package ca.bcit.comp2522.game;

/**
 * Represents a player.
 *
 * @author Aika Manalo - Set 2C
 * @author Mayvee Tan - Set 2C
 *
 * @version 1.0
 */
public class Player
{
    private final String name;
    private int numGamesPlayed;

    public Player(final String name)
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

    public String getName()
    {
        return name;
    }

    public int getNumGamesPlayed()
    {
        return numGamesPlayed;
    }

    public void setNumGamesPlayed(int numGamesPlayed)
    {
        this.numGamesPlayed = numGamesPlayed;
    }
}
