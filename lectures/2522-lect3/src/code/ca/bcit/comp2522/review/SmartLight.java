package ca.bcit.comp2522.review;

/**
 * Represents a smart light.
 *
 * @author Aika Manalo
 * @version 1.0
 */
public class SmartLight extends SmartDevice
{
    private static final double MAX_BRIGHTNESS = 100.0;
    private static final double MIN_BRIGHTNESS = 0.0;

    private int brightness;
    private String color;

    public SmartLight(final String brand,
                       final double batteryLevel,
                       final int brightness,
                       final String color)
    {
        super(brand, batteryLevel);
        validateBrightness(brightness);
        this.brightness = brightness;
        this.color = color;
    }

    private static void validateBrightness(int brightness)
    {
        if ((brightness < MIN_BRIGHTNESS) || (brightness > MAX_BRIGHTNESS))
        {
            throw new IllegalArgumentException("ERROR: Brightness level must be in between " +
                                                       MIN_BRIGHTNESS + " and " + MAX_BRIGHTNESS);
        }
    }

    public String getColor()
    {
        return color;
    }

    public int getBrightness()
    {
        return brightness;
    }

    @Override
    public void performFunction() throws LowBatteryException
    {
        super.performFunction();

        if (!isSwitchedOn())
        {
            return;
        }

        System.out.println("Lighting up the room in " + color + " at " + brightness + "% brightness.");
    }
}
