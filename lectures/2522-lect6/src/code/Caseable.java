import java.util.function.UnaryOperator;

/**
 * Changes a case (upper, lower, title, reverse).
 */
@FunctionalInterface
interface Caseable
{
    // why doesn't he do final?
    // oh.. can use UnaryOperator functional interface
    String applyCase(String s);
}



class Test2
{
    public static void main(String[] args)
    {
        // a.) tiGEr -> TIGER
        // b.) tiGEr -> tiger
        // c.) tiGEr -> Tiger
        // d.) tiGEr -> tigeR
        // e.) tiGEr -> TigeR

        // we'll do both Caseable and UnaryOperator for examples
        final Caseable toUpper; // a
        toUpper = s->s.toUpperCase();
        System.out.println(toUpper.applyCase("tiGEr"));

        final UnaryOperator<String> toLower;
        toLower = s->s.toLowerCase();
        System.out.println(toLower.apply("tiGEr"));
    }
}