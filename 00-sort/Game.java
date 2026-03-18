import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

class Game
{
    public static void main(final String[] args)
            throws FileNotFoundException
    {
        final Scanner s;
        final Random  r;
        final File f;

        int computerNumber;
        int userNumber;
        String userInput;

        r = new Random();
        f = new File("guesses.txt");
        //s = new Scanner(System.in);
        s = new Scanner(f);
        // s.useDelimiter(System.lineSeparator());
        computerNumber = r.nextInt(1, 6);

        while(true)
        {
            System.out.println("Type a number 1-5 or X to exit: ");

            if(s.hasNext())
            {
                if(s.hasNextInt())
                {
                    userNumber = s.nextInt();

                    // scanner bug: consume the newline char
                    s.nextLine();

                    if(userNumber == computerNumber)
                    {
                        System.out.printf("CORRECT! You picked %d and computer picked %d%s",
                                userNumber,
                                computerNumber,
                                System.lineSeparator());

                        computerNumber = r.nextInt(1, 6);
                    }
                    else
                    {
                        System.out.printf("WRONG! You picked %d and computer picked %d%s",
                                userNumber,
                                computerNumber,
                                System.lineSeparator());
                    }
                }
                else  // user typed something (but not an int)
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
        }
        s.close();
    }
}
