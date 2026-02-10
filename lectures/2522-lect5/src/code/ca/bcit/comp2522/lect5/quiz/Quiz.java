package ca.bcit.comp2522.lect5.quiz;

import java.util.*;

/**
 * Create a class called Quiz. It has a main method in which the following must happen.
 * - Create a HashMap of values: 1-›"one", 2-> "two", 3-"three", 4-> "four", and 5-> five.
 * - Then create a set of the map's keys, and use an iterator to print all the values that
 *   contain the letter "o". Also put those "o" values into an array called "contains".
 * - Then use a for-each loop to iterate through the array and add each value to an ArravList
 *   called "has"
 * - Use all of the best practices that we use in class and make sure your code handles null
 *   values properly.
 */
public class Quiz
{
    public static void main(String[] args)
    {
        final Map<Integer, String> dictionary;
        final Set<Integer> dictionaryKeys;

        dictionary = new HashMap<>();

        dictionary.put(1, "one");
        dictionary.put(2, "two");
        dictionary.put(3, "three");
        dictionary.put(4, "four");
        dictionary.put(5, "five");

        dictionaryKeys = dictionary.keySet();

        final String[] contains;
        contains = new String[5];

        final Iterator<Integer> it;
        it = dictionaryKeys.iterator();

        if (dictionaryKeys != null)
        {
            int count;
            count = 0;

            while (it.hasNext())
            {
                final int key;

                key = it.next();

                final String value;
                value = dictionary.get(key);

                if (value.contains("o"))
                {
                    contains[count] = value;
                    count++;
                }
            }

            final List<String> has;
            has = new ArrayList<>();

            for (final String value : contains)
            {
                if (value != null)
                {
                    has.add(value);
                }
            }

            for (final String h : has)
            {
                System.out.println(h);
            }
        }
    }
}
