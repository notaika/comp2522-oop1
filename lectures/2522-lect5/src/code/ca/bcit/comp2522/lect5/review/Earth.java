package ca.bcit.comp2522.lect5.review;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Earth
{
    private final Map<String, Country> countries;
    private final Set<String>          countryKeys;

    Earth()
    {
        countries = new HashMap<>();

        final Country c1;
        final Country c2;
        final Country c3;

        c1 = new Country("CA", "Canada");
        c2 = new Country("US", "United States");
        c3 = new Country("JP", "Japan");

        countries.put(c1.getCountryCode(), c1);
        countries.put(c2.getCountryCode(), c2);
        countries.put(c3.getCountryCode(), c3);

        countryKeys = countries.keySet();

        if (countryKeys != null)
        {
            for (final String key : countryKeys)
            {
                if (key != null)
                {
                    final Country c;
                    c = countries.get(key);
                    System.out.println(c);
                }
            }
        }

        final Iterator<String> it;
        it = countryKeys.iterator();

        if (countryKeys != null)
        {
            while (it.hasNext())
            {
                final String key;
                key = it.next();

                if (key != null)
                {
                    final Country value;
                    value = countries.get(key);

                    System.out.println(value.getCountryName());
                }
            }
        }
    }

    public static void main(String[] args)
    {
        final Earth earth;
        earth = new Earth();
    }
}
