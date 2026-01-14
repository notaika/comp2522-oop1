package ca.bcit.comp2522.bank;

/**
 * Represents a date.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public class Date
{

    private static final int MAX_MONTH_DAY_31 = 31;
    private static final int MAX_MONTH_DAY_30 = 30;
    private static final int MAX_MONTH_DAY_29 = 29;
    private static final int MAX_MONTH_DAY_28 = 28;

    private static final int MAX_MONTH = 12;

    private static final int MINIMUM_DAY_MONTH = 0;
    
    private static final int CURRENT_YEAR = 2026;
    private static final int MINIMUM_YEAR = 1800;

    private static final String[] DAYS_OF_WEEK;

//    private static final int[] MONTH_CODES;

    static
    {
        DAYS_OF_WEEK = new String[7];

        DAYS_OF_WEEK[0] = "Saturday";
        DAYS_OF_WEEK[1] = "Sunday";
        DAYS_OF_WEEK[2] = "Monday";
        DAYS_OF_WEEK[3] = "Tuesday";
        DAYS_OF_WEEK[4] = "Wednesday";
        DAYS_OF_WEEK[5] = "Thursday";
        DAYS_OF_WEEK[6] = "Friday";

    }

//    static
//    {
//        MONTH_CODES = new int[12];
//
//        MONTH_CODES[0] = 1;
//        MONTH_CODES[1] = 4;
//        MONTH_CODES[2] = 4;
//        MONTH_CODES[3] = 0;
//        MONTH_CODES[4] = 2;
//        MONTH_CODES[5] = 5;
//        MONTH_CODES[6] = 0;
//        MONTH_CODES[7] = 3;
//        MONTH_CODES[8] = 6;
//        MONTH_CODES[9] = 1;
//        MONTH_CODES[10] = 4;
//        MONTH_CODES[11] = 6;
//    }

    private final int year;
    private final int month;
    private final int day;

    public Date(final int year, final int month, final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    private static void validateYear(final int year) 
    {
        if (year > CURRENT_YEAR || year < MINIMUM_YEAR)
        {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
    }

    private static void validateMonth(final int month)
    {
        if (month > MAX_MONTH || month < MINIMUM_DAY_MONTH)
        {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    private static void validateDay(final int year, final int month, final int day)
    {
        switch (month)
        {
            case 1, 3, 5, 7, 8, 10, 12 ->
            {
                if (day > MAX_MONTH_DAY_31 || day <= MINIMUM_DAY_MONTH)
                {
                    throw new IllegalArgumentException ("Invalid day: " + day);
                }
            }
            case 4, 6, 9, 11 ->
            {
                if (day > MAX_MONTH_DAY_30 || day <= MINIMUM_DAY_MONTH)
                {
                    throw new IllegalArgumentException ("Invalid day: " + day);
                }
            }
            default ->
            {
                if (isLeapYear(year))
                {
                    if (day > MAX_MONTH_DAY_29 || day <= MINIMUM_DAY_MONTH)
                    {
                        throw new IllegalArgumentException("Invalid day: " + day);
                    }
                } else {
                    if (day > MAX_MONTH_DAY_28 || day <= MINIMUM_DAY_MONTH)
                    {
                        throw new IllegalArgumentException("Invalid day: " + day);
                    }
                }
            }
        }
    }

    private static boolean isLeapYear(int year)
    {
        return ((year % 4) == 0
                && ((year % 100) >= 1
                || (year % 400) == 0));
    }


    public int getYear()
    {
        return year;
    }

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public String getYYYYMMDD()
    {
        return year + "-" + month + "-" + day;
    }

    public String getDayOfTheWeek()
    {
        // change to lower case

        final int dayIndex;

        dayIndex = convertDayOfTheWeek(year, month, day);

        return DAYS_OF_WEEK[dayIndex];
    }

    // expected full page of comments for this method
    private static int convertDayOfTheWeek(final int year, final int month, final int day)
    {
        // make sure to change variable names...
        // encapsulate variables as well
        //
        final int twelve = 12;
        final int four = 4;
        final int currentYear = 2026;
        final int numOfDays = 7;
        final int yearMultiplier = 100;
        final String MONTH_CODE = "144025036146";


        final int century;
        final int centuryYear;

        // 20 of 2026
        century = year / yearMultiplier;

        // 26 of 2026
        centuryYear = year % yearMultiplier;

        // step 1: calc num of 12s
        final int numOfTwelves = (int) (centuryYear / twelve);

        // step 2 calc remainder from step 1
        final int remainder = centuryYear % twelve;

        // step 3: calc num of 4s from step 2
        final int numberOfFours = (int) (remainder / four);

        // step 4: add day of month to each step above
        final int sum = day + numOfTwelves + remainder + numberOfFours;

        // step 5: add month code to sum
        // get month code
        final int monthCode = Character.getNumericValue(MONTH_CODE.charAt(month - 1));

        int sumTot = sum + monthCode;

        // step 6: add all and get remainder (dayIndex)
        final int dayIndex = sumTot % numOfDays;

        return dayIndex;
    }

    public static void main(String[] args) {
        Date test = new Date(1977, 10, 31);

        System.out.println(test.getDay());
//        System.out.println(test.getCentury(2026));
//        System.out.println(test.getCenturyYear(2026));
        System.out.println(test.getDayOfTheWeek());
    }







    // java doc only anything that is not private

    /*
     constructor
     range: year: 1800 - current year
     months: 1 - 12
     days: 1-31 (or 30, 29, 28 - leep)

     methods
     getDay
     getMonth
     getYear
     getYYYYMMDD -> YYYY-MM-DD
     */
}
