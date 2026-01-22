package ca.bcit.comp2522.review;

/**
 * Represents a smart device.
 *
 * @author Aika Manalo
 * @version 1.0
 */
public class SmartDevice
{
    private static final double DEFAULT_VOLTAGE = 1.0;
    private static final double MIN_BATTERY = 0.0;
    private static final double MAX_BATTERY = 100.0;

    private final String brand;
    private double batteryLevel;
    private boolean isSwitchedOn;

    public SmartDevice(final String brand,
                       final double batteryLevel)
    {
        validateBatteryLevel(batteryLevel);
        this.brand = brand;
        this.batteryLevel = batteryLevel;
        this.isSwitchedOn = false;
    }

    public String getBrand()
    {
        return brand;
    }

    public double getBatteryLevel()
    {
        return batteryLevel;
    }

    public boolean isSwitchedOn()
    {
        return isSwitchedOn;
    }

    /*
     * Validates that battery level does not go below min or above max range.
     *
     * @param batteryLevel input to check
     */
    private static void validateBatteryLevel(final double batteryLevel)
    {
        if (batteryLevel < MIN_BATTERY || batteryLevel > MAX_BATTERY)
        {
            throw new IllegalArgumentException("ERROR: Battery cannot be less than " +
                    MIN_BATTERY + " or exceed " + MAX_BATTERY);
        }
    }

    private static void checkBatteryLevel(final double batteryLevel) throws LowBatteryException
    {
        if (batteryLevel < 10.0)
        {
            throw new LowBatteryException("Battery is less than 10%");
        }
    }

    private static void checkChargeFactor(final double batteryLevel,
                                          final double mins,
                                          final double voltage)
    {
        final double chargeFactor = voltage * mins;
        if ((chargeFactor > MAX_BATTERY) ||
                ((batteryLevel + chargeFactor) > MAX_BATTERY))
        {
            throw new IllegalArgumentException("ERROR: Battery Overload");
        }
    }

    /**
     * Turns on device.
     */
    void switchOn()
    {
        this.isSwitchedOn = true;
    }

    /**
     * Performs main device function.
     */
    public void performFunction() throws LowBatteryException
    {
        if (!isSwitchedOn())
        {
            System.out.println("Device is offline.");
            return;
        }

        checkBatteryLevel(batteryLevel);

        System.out.println("Device is working.");
    }

    /**
     * Charges device battery by a factor of the default voltage.
     *
     * @param minutes time spent charging
     */
    void charge(final int minutes)
    {
        checkChargeFactor(batteryLevel, minutes, DEFAULT_VOLTAGE);
        batteryLevel += (DEFAULT_VOLTAGE * minutes);
    }

    /**
     * Charges device battery by a factor of a given voltage.
     *
     * @param minutes time spent charging
     * @param voltage voltage factor battery increases by
     */
    void charge(final int minutes, final double voltage)
    {
        checkChargeFactor(batteryLevel, minutes, voltage);
        batteryLevel += (voltage * minutes);
    }
}
