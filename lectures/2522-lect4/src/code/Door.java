/**
 * Let's say higher doors are bigger.. how to?
 * comparable
 */

public class Door
    implements Openable, Comparable<Door>
{
    private final int heightCm;


    public Door(int heightCm)
    {
        this.heightCm = heightCm;
    }

    @Override
    public void open()
    {
        System.out.println("turn handle, push");
    }

    @Override
    public void close()
    {
        System.out.println("close on hinges");
    }

    @Override
    public int compareTo(final Door d)
    {
        return this.heightCm - d.heightCm;
    }
}
