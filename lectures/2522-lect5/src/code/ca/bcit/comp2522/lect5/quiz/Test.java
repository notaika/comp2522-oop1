package ca.bcit.comp2522.lect5.quiz;

import java.util.*;

/**
 * - Create a class called Test. It has a main() method in which the following must happen.
 * - Create an array that can hold ten strings called "advice".
 * - Then add in the following strings:
 *      "use a partner"
 *      "get rest"
 *      "work hard"
 *      "have fun"
 *      "start now"
 * - Use a for loop (NOT a for-each loop) to iterate through the array and add each of the array elements
 *   IN UPPERCASE to an ArrayList, but only if it contains the letter "a".
 * - Then use an Iterator to iterate through the ArrayList and create a HashMap;
 *   the values are the ArrayList's contents and each key is the first letter of the string
 *   (e.g. "u"→ "use a partner; "w"→"work hard", etc...).
 * - Then create a set of keys from the Map.
 * - Use a for-each loop to iterate through the keys and print each map value in lowercase.
 * - Use all of the best practices that we use in class and make sure your code handles null values properly.
 */
public class Test
{
    public static void main(final String[] args)
    {
        final String[] advice;
        advice = new String[10];

        advice[0] = "use a partner";
        advice[1] = "get rest";
        advice[2] = "work hard";
        advice[3] = "have fun";
        advice[4] = "start now";

        final List<String> filteredAdvice;
        filteredAdvice = new ArrayList<>();

        final int arrLen;
        arrLen = advice.length;

        for (int i = 0; i < arrLen; i++)
        {
            if (advice[i] != null && advice[i].contains("a"))
            {
                final String adviceUpper = advice[i].toUpperCase();
                filteredAdvice.add(adviceUpper);
            }
        }

        System.out.println(filteredAdvice.size());

        final Map<Character, String> filteredAdviceMap;
        final Set<Character> adviceKeys;

        filteredAdviceMap = new HashMap<>();

        final Iterator<String> it;
        it = filteredAdvice.iterator();

        if (filteredAdvice != null)
        {
            while(it.hasNext())
            {
                final String value;
                value = it.next();

                final char key;
                key = value.charAt(0);

                filteredAdviceMap.put(key, value);
            }
        }

        adviceKeys = filteredAdviceMap.keySet();

        for (final char key : adviceKeys)
        {
            final String adviceLowerCase;
            adviceLowerCase = filteredAdviceMap.get(key).toLowerCase();

            System.out.println(adviceLowerCase);
        }
    }
}
