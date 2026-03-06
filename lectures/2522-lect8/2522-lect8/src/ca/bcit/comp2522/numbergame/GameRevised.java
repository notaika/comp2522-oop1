package ca.bcit.comp2522.numbergame;

import java.util.Scanner;

/**
 * A Number Game.
 * A better version of the Game class.
 *
 * @author Class
 * @version 1.0
 */
public class GameRevised
{
    private static final String EXIT_CHAR = "X";
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 6;

    private static int userNumber;
    private static int computerNumber;

    private static String getInput()
    {
        final Scanner keyboardScanner;

        keyboardScanner = new Scanner(System.in);

        if (keyboardScanner.hasNext())
        {
            final String userInput;

            userInput = keyboardScanner.next();
            validateInput(userInput);


            try
            {
                userNumber = Integer.parseInt(userInput);
            }
            catch (final RuntimeException e)
            {
                System.out.println("");
            }
        }


        keyboardScanner.close();
        return "";
    }

    private static boolean validateInput(final String input)
    {
        final Scanner stringScanner;

        if (input == null || input.isEmpty())
        {
            throw new IllegalArgumentException("ERROR: Invalid input.");
        }

        stringScanner = new Scanner(input);

        if (stringScanner.hasNext())
        {
            if (!stringScanner.hasNextInt() ||
                !stringScanner.hasNext(EXIT_CHAR))
            {
                throw new IllegalArgumentException("ERROR: Invalid input.");
            }

            if (stringScanner.hasNextInt())
            {
                return true;
            }
            else if (stringScanner.hasNext(EXIT_CHAR))
            {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {

    }
}