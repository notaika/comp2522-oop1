package ca.bcit.cst.comp2522.lambdas;

/**
 * Represents a Hockey Player with a name, position, year of birth and number of goals.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public class HockeyPlayer
{
    private final static int MIN_COUNT = 0;

    private final static String POS_F = "F";
    private final static String POS_D = "D";
    private final static String POS_G = "G";

    private final String name;
    private final String position;
    private final int yearOfBirth;
    private final int goals;

    public HockeyPlayer(String name,
                 String position,
                 int yearOfBirth,
                 int goals)
    {
        validateIntField(yearOfBirth, "year of birth");
        validateIntField(goals, "number of goals");

        this.name        = name;
        this.position    = position;
        this.yearOfBirth = yearOfBirth;
        this.goals       = goals;
    }

    private static void validateIntField(final int valueToValidate,
                                         final String fieldToValidate)
    {
        if (valueToValidate < MIN_COUNT)
        {
            throw new IllegalArgumentException("ERROR: " + fieldToValidate + " cannot be less than " + MIN_COUNT);
        }
    }

    public String getName()
    {
        return name;
    }

    public String getPosition()
    {
        return position;
    }

    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    public int getGoals()
    {
        return goals;
    }

    @Override
    public String toString()
    {
        return "Name: " + getName() +
               "\nPosition: " + getPosition() +
               "\nGoals: " + getGoals();
    }
}
