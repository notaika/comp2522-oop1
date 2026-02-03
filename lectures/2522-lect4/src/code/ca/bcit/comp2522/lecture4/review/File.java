package ca.bcit.comp2522.lecture4.review;

/**
 * TODO:
 *  - Create two interfaces; one is called File; the other is Bank.
 *  - Both have a concrete method called save(String) plus another method of your choosing.
 *  - Bank just prints "saved money to account number xyz" (xyz is the argument; the String
 *  account number).
 *  - The File Save prints "saved data to file xyz" (the argument is a
 *  filename String). Then create a class OnlineBankAccount that implements both interfaces.
 *  - The OnlineBankAccount overrides the $save()$ method to perform the Bank version. (7 marks)
 */
public interface File
{
    default void save(final String fileLocation)
    {
        System.out.println("saved data to file" + fileLocation);
    }

    void delete();
}
