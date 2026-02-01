public interface Rideable
{
    default void crash()
    {
        System.out.println("oof");
    }

    void ride();
}
