package ca.bcit.comp2522.lecture4.jason;

public interface Flyable
{
    double PI = 3.1415;

    void fly();
    void land();
    double getMaxSpeedKmPerHour();

    default void crash()
    {
        System.out.println("ouch");
    }


}
