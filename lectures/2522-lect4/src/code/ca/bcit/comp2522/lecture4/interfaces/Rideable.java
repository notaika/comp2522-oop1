package ca.bcit.comp2522.lecture4.interfaces;

public interface Rideable
{
    default void crash()
    {
        System.out.println("oof");
    }

    void ride();
}
