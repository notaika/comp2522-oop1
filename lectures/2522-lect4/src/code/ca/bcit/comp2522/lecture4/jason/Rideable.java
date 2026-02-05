package ca.bcit.comp2522.lecture4.jason;


public interface Rideable
{
    void ride();

    default void crash()
    {
        System.out.println("oops");
    }
}
