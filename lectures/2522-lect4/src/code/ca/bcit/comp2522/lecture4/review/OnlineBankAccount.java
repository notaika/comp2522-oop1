package ca.bcit.comp2522.lecture4.review;

public class OnlineBankAccount
        implements File, Bank
{
    @Override
    public void save(final String acctNum)
    {
        Bank.super.save(acctNum);
    }

    @Override
    public void withdraw()
    {
        System.out.println("Withdrew money");
    }

    @Override
    public void delete()
    {
        System.out.println("Files deleted.");
    }
}
