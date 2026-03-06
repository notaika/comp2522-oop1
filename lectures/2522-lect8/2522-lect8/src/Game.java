import java.util.Random;
import java.util.Scanner;

/**
 * M08 - Scanner
 */
public class Game
{
    public static void main(final String[] args)
    {
        final Scanner s; // should give var names like fileScanner, keyboardScanner, etc.
        final Random r;

        int computerNumber;
        int userNumber;
        String userInput;

        r = new Random();
        s = new Scanner(System.in);
        // s.useDelimiter(System.lineSeparator());

        while (true)
        {
            computerNumber = r.nextInt(1,
                                       6);
            System.out.println("Type a number 1-5 or X to exit.");

            // if scanner has something in it...
            if (s.hasNext())
            {
                // is there's an int
                if (s.hasNextInt())
                {
                    userNumber = s.nextInt();

                    // scanner bug: consume the newline char
                    s.nextLine();

                    // find out if computer matches user number
                    if (userNumber == computerNumber)
                    {
                        System.out.printf("CORRECT: You picked %d and computer picked %d.%s",
                                          userNumber,
                                          computerNumber,
                                          System.lineSeparator());

                        // if they get it correct, they play again
                        computerNumber = r.nextInt(1,
                                                   6);
                    }
                    else
                    {
                        System.out.printf("WRONG: You picked %d and computer picked %d.%s",
                                          userNumber,
                                          computerNumber,
                                          System.lineSeparator());
                    }
                }
                else // user typed something but is not an int
                {
                    userInput = s.next();

                    if(userInput.equalsIgnoreCase("X"))
                    {
                        System.out.println("Bye");
                        break;
                    }
                    else
                    {
                        System.err.println("Error input: " + userInput);
                    }

                }
            }
            s.close();
        }
    }
}
