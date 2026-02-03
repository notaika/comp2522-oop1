public class Airplane
    extends Vehicle
    implements Flyable, Rideable
{

    Airplane(final String color)
    {
        super(color);
    }

    @Override
    public void crash()
    {
        Flyable.super.crash();
        Rideable.super.crash();
        System.out.println("boom");
    }

    @Override
    public void ride()
    {
        System.out.println("sitting in seats");
    }

    @Override
    public void fly()
    {
        System.out.println("bernouilli effect");
    }

    @Override
    public void land()
    {
        System.out.println("on wheels");
    }

    @Override
    public double getMaxSpeedKmPerHour()
    {
        return 1000;
    }
}
