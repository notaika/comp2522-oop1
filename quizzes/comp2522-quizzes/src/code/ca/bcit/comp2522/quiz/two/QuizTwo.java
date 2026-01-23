package ca.bcit.comp2522.quiz.two;

/**
 * Set 2C's quiz 2 for COMP2522 (202610)
 * Answers here are corrected.
 * My Score: 10.5/12 (wrapped my constructor in try-catch, was supposed to be in main())
 */
public class QuizTwo
{
    /*
     * 1. Write a class (no JavaDocs required) Restaurant and a class Bad Name
     * (a checked exception class). The restaurant has a String name field. Its
     * constructor stores the namee if valid (i.e., not null); otherwise a BadName
     * exception is thrown. (5 marks
     */

    public class Restaurant
    {
        private final String name;

        public Restaurant(final String name) throws BadName
        {
            validateName(name);
            this.name = name;
        }

        private void validateName(String name) throws BadName {
            if (name == null) {
                throw new BadName("Restaurant name cannot be null.");
            }
        }

        public String getName()
        {
            return name;
        }
    }

    public class BadName extends Exception
    {
        public BadName(final String message)
        {
            super(message);
        }
    }

    /*
     * 2. Write the main method. It must create a Restaurant whose name is "Gotham".
     * Print the name in lowercase (3 marks).
     */
    public static void main(String[] args)
    {
        final Restaurant myRestaurant;
        try
        {
            myRestaurant = new Restaurant("Gotham");
            System.out.println(myRestaurant.getName().toLowerCase());
        }
        catch (BadName e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /*
     * 3. What is overloading? Explain fully. Show a simple example. (2 marks)
     */

    // Overloading is when you create a method/constructor with the same name
    // as an already existing one, but have different method signatures.

    public Restaurant(final String name)
    {
        this.name = name;
    }

    public Restaurant(final String name,
                      final String location)
    {
        this.name = name;
        this.location = location;
    }

    // Other info: substitution, run-time, dynamic

    /*
     * 4. What is overriding? Explain fully. Show a simple example. (2 marks)
     */

    // Overriding is when you redefine an implemented method within a class,
    // changing it's body logic to produce a different outcome.
    // -> polymorphism, compile-time & static, use @ Override to indicate
    // a method is being overriden.

    public class Animal
    {
        // instance variables
        // constructor

        public void speaks()
        {
            System.out.println("Animal speaks");
        }
    }

    public class Dog extends Animal
    {
        // instance variables
        // constructor

        @Override
        public void speak()
        {
            System.out.println("woof");
        }
    }

}
