package ca.bcit.comp2522.termproject.singletonfiles;

import java.util.Objects;

/**
 * Represents an abstract entity in the detective logic game.
 * Base class for all game objects that can be identified by name.
 * Provides functionality for comparison, equality, and sorting.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.1
 */
public abstract class Entity
        implements Comparable<Entity>
{
    private final String name;

    /**
     * Constructs and validates an Entity with a name.
     *
     * @param name the name of the entity as a String
     * @throws IllegalArgumentException if the name is invalid
     */
    public Entity(final String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("ERROR: Entity name is invalid.");
        }
        this.name = name;
    }

    /**
     * Returns the name of the entity.
     *
     * @return the name as a String
     */
    public final String getName()
    {
        return name;
    }

    /**
     * Compares this Entity to another Entity alphabetically by name.
     * Required for alphabetical sorting in the game grid.
     *
     * @param other the other Entity to compare against
     * @return a negative integer, zero, or a positive integer as this name
     * is lexicographically less than, equal to, or greater than the other name
     */
    @Override
    public final int compareTo(final Entity other)
    {
        if (other == null)
        {
            throw new NullPointerException("ERROR: Cannot compare against null.");
        }
        return this.name.compareToIgnoreCase(other.name);
    }

    /**
     * Checks if this Entity is equal to another object based on name.
     *
     * @param object the object to check for equality
     * @return true if equal, false otherwise
     */
    @Override
    public final boolean equals(final Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (object == null || getClass() != object.getClass())
        {
            return false;
        }
        final Entity otherEntity;
        otherEntity = (Entity) object;
        return name.equalsIgnoreCase(otherEntity.name);
    }

    /**
     * Generates a hash code for this Entity based on its name.
     *
     * @return the hash code as an int
     */
    @Override
    public final int hashCode()
    {
        return Objects.hash(name.toLowerCase());
    }

    /**
     * Returns a string representation of the entity.
     *
     * @return the name as a String
     */
    @Override
    public String toString()
    {
        return name;
    }

    /**
     * Returns a formatted string of the entity's public details for the UI.
     * Must be implemented by all child classes to reveal clues to the player.
     *
     * @return the public details as a String
     */
    public abstract String getDetails();
}
