package ca.bcit.comp2522.bank;

/**
 * Represents a date.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 *
 * @version 1.0
 */
public class Date
{

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private static final int MAX_DAY_SMALL = 30;
    private static final int MAX_DAY_FEB_LEAP = 29;
    private static final int MAX_DAY_FEB = 28;

    private static final int MIN_YEAR = 1800;
    private static final int CURRENT_YEAR = 2026;

    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL   = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private static final int STEP_ONE_TWELVE = 12;
    private static final int STEP_TWO_FOUR = 4;
    private static final int NUM_DAYS_IN_WEEK = 7;
    private static final int MIN_CENTURY_OFFSET = 2;
    private static final int MAX_CENTURY_OFFSET = 6;
    private static final int LEAP_MONTH_OFFSET = 6;
    private static final String MONTH_CODE = "144025036146";

    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructs a date.
     *
     * @param year the date's year
     * @param month the date's month
     * @param day the date's day
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        validateDate(year,
                     month,
                     day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /*
     * Validates a given Date.
     *
     * @param year The year of the Date
     * @param month The month of the date
     * @param day The day of the Date
     */
    private static void validateDate(final int year,
                                     final int month,
                                     final int day)
    {
        if (year < MIN_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid year: " + year);
        }

        if (month < JANUARY || month > DECEMBER)
        {
            throw new IllegalArgumentException("Invalid month: " + month);
        }

        switch (month)
        {
            case FEBRUARY ->
            {
                if ((isLeapYear(year) &&
                        (day < MIN_DAY ||
                         day > MAX_DAY_FEB_LEAP))||
                        (day < MIN_DAY || day > MAX_DAY_FEB))
                {
                    throw new IllegalArgumentException("Invalid day: " + day);
                }
            }
            case APRIL, JUNE, SEPTEMBER, NOVEMBER ->
            {
                if (day < MIN_DAY || day > MAX_DAY_SMALL)
                {
                    throw new IllegalArgumentException("Invalid day: " + day);
                }
            }
            default ->
            {
                if (day < MIN_DAY || day > MAX_DAY)
                {
                    throw new IllegalArgumentException("Invalid day: " + day);
                }
            }
        }
    }

    /**
     * Return's the date's year.
     *
     * @return the date's year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Return's the date's day.
     *
     * @return the date's day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Return's the date's month.
     *
     * @return the date's month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Returns the name of the month string.
     *
     * @return month name
     */
    public String getMonthName()
    {
        final String monthName;

        switch (month) {
            case JANUARY -> monthName = "January";
            case FEBRUARY -> monthName = "February";
            case MARCH -> monthName = "March";
            case APRIL -> monthName = "April";
            case MAY -> monthName = "May";
            case JUNE -> monthName = "June";
            case JULY -> monthName = "July";
            case AUGUST -> monthName = "August";
            case SEPTEMBER -> monthName = "September";
            case OCTOBER -> monthName = "October";
            case NOVEMBER -> monthName = "November";
            case DECEMBER -> monthName = "December";
            default -> throw new IllegalArgumentException("ERROR: Month out of bounds");
        }

        return monthName;
    }

    /**
     * Returns the Date in format YYYY-MM-DD.
     * @return date format in YYYY-MM-DD
     */
    public String getYyyyMmDd()
    {
        if (month < OCTOBER)
        {
            return year + "-0" + month + "-" + day;
        }
        return year + "-" + month + "-" + day;
    }

    /*
     * Helper method for getting the day of the week.
     * Uses an algorithm to calculate the day of the week of a given Date.
     * Step 1: Calculate the number of 12's in the last two digits of given year
     * Step 2: Calculate the remainder from Step 1
     * Step 3: Calculate the number of fours in Step 2
     * Step 4: Add the day of the month to each step above (Steps 1, 2, and 3)
     * Step 5: Add the month code (getMonthCode(month))
     * Step 6: Add the previous five numbers (Steps 1, 2, 3, 4, and 5)
     * Step 7: Result is the number associated of the day of the week
     *
     * @param year The year of the Date
     * @param month The month of the Date
     * @param day The day of the Date
     * @return the number associated of the day of the week
     */
    private static int convertDayOfTheWeek(final int year,
                                           final int month,
                                           final int day)
    {
        final int centuryDivisor = 100;
        final int lastTwoDigitsOfYear;
        final boolean leapYear;
        final int step1;
        final int step2;
        final int step3;
        final int step4;
        final int step5;
        final int step6;
        final int step7;

        int sumOfSteps;

        // step 0: get century (1800s, 1900s, 2000s)
        sumOfSteps = calculateCentury(year);

        // step 1: calc num of 12s
        lastTwoDigitsOfYear = year % centuryDivisor;
        step1 = (lastTwoDigitsOfYear / STEP_ONE_TWELVE);

        // step 2 calc remainder from step 1
        step2 = lastTwoDigitsOfYear % STEP_ONE_TWELVE;

        // step 3: calc num of 4s from step 2
        step3 = (step2 / STEP_TWO_FOUR);

        // step 4: add day of month to each step above
        step4 = day + step1 + step2 + step3;

        // step 5: add month code to sum
        // final int monthCode = getMonthCode(month);
        step5 = step4 + getMonthCode(month);

        // step 5.5 check if year is a leap year
        leapYear = isLeapYear(year);

        if (leapYear && (month == 1 || month == 2))
        {
            sumOfSteps += LEAP_MONTH_OFFSET;
        }
        // step 6: add all previous five numbers
        step6 = sumOfSteps + step5;

        // step 7: get the remainder
        step7 = step6 % NUM_DAYS_IN_WEEK;

        return step7;
    }

    /*
     * Helper method for convertDayOfTheWeek.
     * Returns the given months corresponding month code for day of the week calculation.
     *
     * @param the month to convert
     */
    private static int getMonthCode(final int monthToConvert)
    {
        return Character.getNumericValue(MONTH_CODE.charAt(monthToConvert - 1));
    }

    /*
     * Helper method for convertDayOfTheWeek.
     * Check's if the given year is a leap year.
     *
     * @param year The year to check
     * @return true if the year is a leap year
     */
    private static boolean isLeapYear(int year)
    {
        return ((year % 4) == 0
                && ((year % 100) >= 1
                || (year % 400) == 0));
    }

    /*
     * Calculates the date's century [1800, 2000].
     *
     * @param year The year to calculate century
     * @return the century
     */
    private static int calculateCentury(final int year)
    {
        int centuryCalculation;
        centuryCalculation = 0;

        if (year >= 2000)
        {
            centuryCalculation += MAX_CENTURY_OFFSET;
        } else if (year >= 1800 && year < 1900)
        {
            centuryCalculation += MIN_CENTURY_OFFSET;
        }
        return centuryCalculation;
    }

    /**
     * Returns the date's day of the week.
     *
     * @return date's day of the week as a String
     */
    public String getDayOfTheWeek()
    {
        final int dayIndex;

        final String dayName;

        dayIndex = convertDayOfTheWeek(year, month, day);

        switch (dayIndex) {
            case SATURDAY -> dayName = "Saturday";
            case SUNDAY -> dayName = "Sunday";
            case MONDAY -> dayName = "Monday";
            case TUESDAY -> dayName = "Tuesday";
            case WEDNESDAY -> dayName = "Wednesday";
            case THURSDAY -> dayName = "Thursday";
            case FRIDAY -> dayName = "Friday";
            default -> throw new IllegalArgumentException("ERROR: Day index out of bounds");
        }

        return dayName;
    }

    /**
     * Concatenates and formats the Date.
     *
     * @return the day of the week, followed by month name, day and year as a String
     */
    public String getDateFormatted()
    {
        return getDayOfTheWeek() + ", " + getMonthName() + " " + day + ", " + year;
    }
}
