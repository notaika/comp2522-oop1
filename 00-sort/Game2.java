package ca.bcit.comp2522.numbergame;

import java.util.Scanner;

/**
 * Game class.
 *
 * @author Everyone
 *
 * @version 0.1
 */
public class Game2
{
    private static final int MIN_INPUT_VALUE = 1;
    private static final int MAX_INPUT_VALUE = 5;
    private static final String EXIT_CHAR = "x";

    public static void main(final String[] args)
    {

    }

    private static String getInput(final String prompt)
    {
        final Scanner keyboardScanner;
        final String scannedInput;

        keyboardScanner = new Scanner(System.in);

        System.out.println(prompt);

        scannedInput = keyboardScanner.nextLine();

        validateInput(scannedInput);
        keyboardScanner.close();

        return scannedInput;
    }

    private static void validateInput(final String input)
    {
        final Scanner stringScanner;

        if(input == null || input.isBlank())
        {
            throw new RuntimeException("Input is empty");
        }

        stringScanner = new Scanner(input);

        if (stringScanner.hasNext())
        {
            if(!stringScanner.hasNextInt() &&
                    !input.equalsIgnoreCase(EXIT_CHAR))
            {
                throw new RuntimeException("Input is invalid");
            }
        }
    }

}
