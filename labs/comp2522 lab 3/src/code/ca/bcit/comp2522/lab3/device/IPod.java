package ca.bcit.comp2522.lab3.device;

import java.util.Objects;

/**
 * Represents an iPod.
 *
 * @author Aika Manalo - 2C
 * @author Julia Ziebart - 2C
 *
 * @version 1.0
 */
public class IPod extends IDevice
{
    private static final double MAX_VOLUME_DB = 100.0;
    private static final double MIN_VOLUME_DB = 0.0;
    private static final int MIN_NUM_SONGS = 1;

    private final double maxVolumeDb;
    private int numSongsStored;

    /**
     * Constructs and initializes an iPod device with its purpose, max volume in db,
     * and the number of songs currently stored.
     *
     * @param maxVolumeDb the max volume (in db) the iPod can play
     * @param numSongsStored the number of songs stored in the iPod storage
     */
    public IPod(final int numSongsStored,
                final double maxVolumeDb)
    {
        super("music");

        validateMaxVolumeDb(maxVolumeDb);
        validateSongsStored(numSongsStored);

        this.maxVolumeDb = maxVolumeDb;
        this.numSongsStored = numSongsStored;
    }

    /*
     * Validates the max volume an iPod device can have.
     * Must be in between [MIN_VOLUME_DB, MAX_VOLUME_DB]
     *
     * @param maxVolumeDbToCheck the maximum volume to validate
     * @throws IllegalArguementException if the number to check is < MIN_VOLUME_DB or > MAX_VOLUME_DB
     */
    private static void validateMaxVolumeDb(final double maxVolumeDbToCheck)
    {
        if (maxVolumeDbToCheck < MIN_VOLUME_DB || maxVolumeDbToCheck > MAX_VOLUME_DB)
        {
            throw new IllegalArgumentException("ERROR: Volume must be in between " +
                                               MIN_VOLUME_DB + " and " + MAX_VOLUME_DB);
        }
    }

    /*
     * Validates the number of songs that can be stored in an iPod.
     * Must be greater than MIN_NUM_SONGS.
     *
     * @param numSongsToStore the maximum volume to validate
     * @throws IllegalArguementException if the number to store is < MIN_NUM_SONGS
     */
    private static void validateSongsStored(final double numSongsToStore)
    {
        if (numSongsToStore < MIN_NUM_SONGS)
        {
            throw new IllegalArgumentException("ERROR: Must store at least a minimum of " +
                                               MIN_NUM_SONGS +
                                               " of songs");
        }
    }

    /**
     * Sets number of songs stored in the iPod.
     *
     * @param numSongsStored the number of songs to store
     */
    public void setNumSongsStored(int numSongsStored)
    {
        this.numSongsStored = numSongsStored;
    }

    /**
     * Returns the number of songs stored in the iPod.
     *
     * @return number of songs stored
     */
    public int getNumSongsStored()
    {
        return numSongsStored;
    }

    /**
     * Returns the max volume (in db) the iPod can allow.
     *
     * @return the max volume (in db)
     */
    public double getMaxVolumeDb()
    {
        return maxVolumeDb;
    }

    /*
     * Gets the instance variables of this class and returns them as a string
     *
     * @return instance variables as a String
     */
    @Override
    protected String getLocalDetails() {
        return "Number of Songs Stored: " + getNumSongsStored() +
               "\nMax Volume: " + getMaxVolumeDb();
    }

    /**
     * Prints the instance variables of this class (but not its parent's)
     */
    public void printDetails()
    {
        System.out.println(getLocalDetails());
    }

    /**
     * Returns a string representation of this object,
     * comprising the parent's instance data as well as its own.
     *
     * @return the data as a String
     */
    @Override
    public String toString()
    {
        return super.toString() + "\n" +
               getLocalDetails();
    }

    /**
     * Compares this iPod to the specified object.
     * If the other object is not an iPod, they are not equal.
     * Otherwise, if this has the same number of songs stored as the reference object, they are equal.
     *
     * @param o the reference object with which to compare.
     * @return The equality.
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof IPod))
        {
            return false;
        }

        final IPod that;
        that = (IPod) o;

        return this.numSongsStored == that.numSongsStored;
    }

    /**
     * Returns a hashcode for this object, determined with the number of songs stored.
     *
     * @return the hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.numSongsStored);
    }

}








