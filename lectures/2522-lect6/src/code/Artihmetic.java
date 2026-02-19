import java.util.function.Function;
import java.util.function.IntPredicate;

/**
 * Watch out for this on exam
 */
public class Artihmetic
{
    public static void main(String[] args)
    {
        // create variables to do the following:
            // a.) tells if an integer is even
            // b.) tells if an integer positive
            // c.) tells if an integer 1000+

        final IntPredicate even; // a
        even = (n)->n%2==0;
        System.out.println("Is even?");
        System.out.println(even.test(2));
        System.out.println(even.test(21));

        final IntPredicate positive; // b
        positive = num->num>0;
        System.out.println("Is positive?");
        System.out.println(positive.test(21));

        final IntPredicate big; // c
        big = (final int i)->i>1000;
        System.out.println("Is > 1000?");
        System.out.println(big.test(21));

        final Function<Integer, Boolean> small;
        small = (n)->n<1000;
        System.out.println("Is < 1000?");
        System.out.println(small.apply(21));

    }
}
