package ca.bcit.comp2522.lecture4.review;

public interface Bank
{
    default void save(final String acctNum)
    {
        System.out.println("saved money to account number " + acctNum);
    }

    void withdraw();
}
