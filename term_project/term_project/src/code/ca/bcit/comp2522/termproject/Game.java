package ca.bcit.comp2522.termproject;

/**
 * Abstract base class representing a generic game within this project.
 * Standardizes game execution logic across all games.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public abstract class Game
{
    private final String title;

    /**
     * Constructs and validates the Game.
     *
     * @param title the display name of the game
     */
    protected Game(final String title)
    {
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException("ERROR: Game title cannot be null or blank.");
        }
        this.title = title;
    }

    /**
     * Returns the title of the game.
     *
     * @return the title as a String
     */
    public final String getTitle()
    {
        return title;
    }

    /**
     * Begins the execution of the game.
     * Blocks the terminal thread if necessary until the game concludes.
     */
    public abstract void play();
}