package ca.bcit.comp2522.lab3.device;

/**
 * Represents an iPod.
 *
 * @author Aika Manalo - 2C
 * @version 1.0
 */
public class IPod extends IDevice
{
    private static final int MAX_VOLUME_DB = 100;
    private static final int MIN_VOLUME_DB = 0;
    private static final int MIN_NUM_SONGS = 1;

    private final double maxVolumeDb;
    private int numSongsStored;

    /**
     * Constructs and initializes an iPod device with its purpose, max volume in db,
     * and the number of songs currently stored.
     *
     * @param purpose purpose of the device
     * @param maxVolumeDb the max volume (in db) the iPod can play
     * @param numSongsStored the number of songs stored in the iPod storage
     */
    public IPod( final String purpose,
            final double maxVolumeDb,
            final int numSongsStored)
    {
        super(purpose);
        validateMaxVolumeDb(maxVolumeDb);
        validateSongsStored(numSongsStored);
        this.maxVolumeDb = maxVolumeDb;
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
     * Retunrns the max volume (in db) the iPod can allow.
     *
     * @return the max volume (in db)
     */
    public double getMaxVolumeDb()
    {
        return maxVolumeDb;
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
     * Must be greater than MIN_NUM_SONGS
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

    public String printDetails()
    {
        return getMaxVolumeDb() + "\n" +
               getNumSongsStored();
    }

    @Override
    public String toString()
    {
        return "iPod Specs: " + super.toString() + );
    }
}








