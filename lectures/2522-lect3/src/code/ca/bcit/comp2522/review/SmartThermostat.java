package ca.bcit.comp2522.review;

public class SmartThermostat extends SmartDevice
{
    private final static double MIN_TEMP = 10.0;
    private final static double MAX_TEMP = 30.0;

    private final double temperature;

    public SmartThermostat(final String brand,
                           final double batteryLevel,
                           final double temperature)
    {
        super(brand, batteryLevel);
        validateTemperature(temperature);
        this.temperature = temperature;
    }

    private static void validateTemperature(final double temperature)
    {
        if (temperature < MIN_TEMP || temperature > MAX_TEMP)
        {
            throw new IllegalArgumentException("ERROR: Temperature must be in between " +
                    MIN_TEMP + " and " + MAX_TEMP);
        }
    }

    @Override
    public void performFunction() throws LowBatteryException
    {
        super.performFunction();

        if (!isSwitchedOn())
        {
            return;
        }

        System.out.println("Thermostat set to " + temperature + "C.");
    }
}
