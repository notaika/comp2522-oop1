import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map 2.0
 * Introduction to Set
 */
public class Earth
{
    public static void main(String[] args)
    {
        // final HashMap<String, Country> will make it so hard for you to change it later
        // If you wanted to change it into a TreeMap.. ggs

        // Map<Key Type, Value Type> variableNamePlural
        // NOTE THAT TYPE MUST BE REFERENCE TYPES (can't do primitives) <- use wrapper class if needed
        final Map<String, Country> countries;

        // let's make a set of keys
        final Set<String> keys; // countryCodes

        countries = new HashMap<>();

        keys = countries.keySet();

        final Country c1;
        final Country c2;
        final Country c3;
        final Country c4;
        final Country c5;

        c1 = new Country("CA", "Canada");
        c2 = new Country("CH", "China");
        c3 = new Country("MX", "Mexico");
        c4 = new Country("IC", "Iceland");
        c5 = new Country("IT", "Italy");

        countries.put(c1.getCode(), c1);
        countries.put(c2.getCode(), c2);
        countries.put(c3.getCode(), c3);
        countries.put(c4.getCode(), c4);
        countries.put(c5.getCode(), c5);

        // remove country using key (country code)
        countries.remove("IC");

        final Iterator<String> it;
        it = keys.iterator();

        // should use a for each loop, just doing this so we can see iterators again
        while (it.hasNext())
        {
            final String key;
            final Country value;

            key = it.next();
            value = countries.get(key);

            System.out.println(value);

        }



    }
}
