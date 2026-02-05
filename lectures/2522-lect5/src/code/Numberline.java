import java.util.HashMap;
import java.util.Map;

/**
 * Maps (Dictionaries)
 */
public class Numberline
{
    // Map <Key, Value>
    private final Map<String, Integer> numbers;

    public Numberline()
    {
        numbers = new HashMap<>();
        // RAGS: remove() put() get() size()

        numbers.put("six", 6);
        numbers.put("zero", 0);
        numbers.put("eight", 8);
        numbers.put("one hundred", 100);

        System.out.println(numbers.size()); // 1
        System.out.println(numbers.get("eight")); // 8
    }

    public static void main(String[] args)
    {
        final Numberline n;
        n = new Numberline();
    }
}
