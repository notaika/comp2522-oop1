public class App
    implements Openable
{
    @Override
    public void open()
    {
        System.out.println("swipe, user face id");
    }

    @Override
    public void close()
    {
        System.out.println("tap X button");
    }
}
