package ca.bcit.comp2522.lect5.lecture;

/**
 * Lecture 5: Arrays
 */
public class Bookstore
{
    // final <- don't want to change the reference to this array
    // don't want "titles" variable to reference another array
    // always make array variables plural
    // make all arrays final your whole life - jason
    private final String[] titles;

    public Bookstore()
    {
        titles = new String[12];

        titles[4] = "Getting Real";
        titles[0] = "The Four-Hour Work Week";
        titles[9] = "C Programming";
        titles[6] = "Cracking the Code Interview";
        titles[2] = "Can't Hurt Me";

        // final; halfway through the loop it cannot be reassigned?
        // not sure, need to research what he says
        for (final String title: titles)
        {
            if (title != null)
            {
                System.out.println(title);
            }
        }

        // 2. make it final out here
        final int length;
        length = titles.length;

        // 1. can't say final int.
        // 1.1 only do final on reference types  like on line 23 (6:40)
        for (int i = 0; i < length; i++)
        {
            if (titles[i] != null)
            {
                System.out.println(titles[i].toLowerCase());
            }
        }
    }

    public static void main(String[] args)
    {

        final Bookstore b;
        b = new Bookstore();


    }
}
