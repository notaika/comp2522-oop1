package ca.bcit.comp2522.lecture4.review;

public interface FlyableJ
{
    void fly();
    void land();

    default void crash()
    {
        System.out.println("ouch");
    }

}
