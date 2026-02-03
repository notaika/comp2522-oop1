public interface Rideable
{
    void ride();

    default void crash()
    {
        System.out.println("oops");
    }
}
