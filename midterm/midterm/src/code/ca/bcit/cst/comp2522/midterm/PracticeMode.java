package ca.bcit.cst.comp2522.midterm;

public class PracticeMode
{
    public static void main(final String[] args)
    {
        final NumberProcessor adder;
        adder = (a, b)->a+b;
        System.out.println("Lambda Addition:");
        System.out.println(adder.process(10, 5));
        System.out.println("Method Reference Addition:");
        printCaculatedResult(10, 5, adder);
        System.out.println();

        final NumberProcessor multiplier;
        System.out.println("Multiplier Method Reference:");
        multiplier = PracticeMode::multiplyNumbers;
        System.out.println(multiplier.process(10, 5));
        System.out.println("Multiplier Call: ");
        printCaculatedResult(10, 5, multiplier);
        System.out.println();
    }

    public static void printCaculatedResult(final int a,
                                     final int b,
                                     final NumberProcessor processor)
    {
        System.out.println(processor.process(a, b));
    }

    public static int multiplyNumbers(final int a,
                                      final int b)
    {
        return a * b;
    }
}
