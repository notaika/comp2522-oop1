import java.util.function.BiFunction;

@FunctionalInterface
public interface Formattable
{
    String format(String s, int n);
}

class Main
{
    public static void main(String[] args)
    {
        // make a lambda expression that implements formattable
        // create a variable and store some functionality in it

        // calling with sample input data: "tiger", 3
            // a.) tigertigertiger
            // b.) g
            // c.) tig
            // d.) tiger3


        // lambda (->) means "this is about to apply some implementation"
        // left side: don't have to put type of parameters, it's inferred
        // right side: this is the implementation
        // don't need braces; can just say what you're saying

        final Formattable joiner; // d
        joiner = (str, num)->str+num;
        System.out.println(joiner.format("tiger", 3));

        final Formattable nthChar; // b
        nthChar = (str, num)->""+str.charAt(num-1);
        System.out.println(nthChar.format("tiger", 3));

        final Formattable repeater; // a
        repeater = (str, num)->{
            String returnValue = "";
            for(int i = 0; i < num; i++)
            {
                returnValue += str;
            }
            return returnValue;
        };

        System.out.println(repeater.format("tiger", 3));

        final Formattable firstNChars; // c
        firstNChars = (str, num)->str.substring(0, num);;
        System.out.println(firstNChars.format("tiger", 3));


        // Using BiFunctions
        // use .apply instead
        // also make sure that the parameter types are WRAPPER CLASSES
        // <type of FIRST ARG, type of SECOND ARG, type of RESULT>
        final BiFunction<String, Integer, String> repeaterAgain;
        repeaterAgain = (str, num)->{
            String returnValue = "";
            for(int i = 0; i < num; i++)
            {
                returnValue += str;
            }
            return returnValue;
        };

        System.out.println(repeaterAgain.apply("tiger", 3));
        System.out.println();



        // METHOD REFERENCE EXAMPLE
        // only do this if you're doing it more than once
        final Formattable joiner2;


        //Instead of defining it as (str, num)->str+num;...
            // you reference a defined function (line 91)
        // Main because the method reference is within 'Class main'
        joiner2 = Main::concatenate;
        System.out.println("Method Reference:");
        System.out.println(joiner2.format("tiger", 3));
        System.out.println();
        // third argument can either be:
        // repeater, nthChar, firstNChars, or joiner
        System.out.println("Print formatted data:");
        printFormattedData("bcit", 2, repeater);
    }

    // static because we're calling it in main method
    static String concatenate(final String s,
                           final int i)
    {
        return s + i;
    }

    // i don't know how to format this thing
    // it prints any format it's called..?
    static void printFormattedData(final String s,
                                   final int i,
                                   Formattable f)
    {
        System.out.println(f.format(s, i));
    }





}