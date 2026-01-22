package ca.bcit.comp2522.review;

public class Main
{
    public static void main(String[] args)
    {
        final SmartDevice d1;
        final SmartDevice d2;
        final SmartDevice d3;

        d1 = new SmartDevice("Phillips", 25.0);
        d2 = new SmartLight("Phillips", 5.0, 50, "purple");
        d3 = new SmartThermostat("Phillips", 30.0, 25);

        // d1.switchOn();
        // d1.performFunction();


        d2.switchOn();

        try
        {
            d2.performFunction();
        } catch (LowBatteryException e)
        {
            System.out.println("WARNING: " + e.getMessage());
        }

        if (d2 instanceof SmartLight)
        {
            System.out.println(((SmartLight) d2).getBrightness());
        }

        // tests
//        final SmartDevice testLight1 = new SmartLight("Phillips", 90.0, 50, "purple");
//        final SmartDevice testLight2 = new SmartLight("Phillips", 5.0, 50, "purple");
//
//        final SmartDevice testThermostat1 = new SmartThermostat("Phillips", 9.99, 30.0);
//        final SmartDevice testThermostat2 = new SmartThermostat("Phillips", 30.0, 25);


//        testLight1.performFunction();
//        System.out.println(testLight1.getBatteryLevel());
//        testLight1.charge(5, 0.2);
//        System.out.println(testLight1.getBatteryLevel());
//        System.out.println();
//        testLight2.performFunction();
//        System.out.println();
//        System.out.println();
//        testThermostat1.performFunction();
//        System.out.println();
//        testThermostat2.performFunction();
    }
}
