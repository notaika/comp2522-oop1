import java.util.Comparator;
import java.util.List;

public class Streams
{
    public static void main(String[] args)
    {
        final List<Province> allExceptNulls = provinces.stream()
                                                       .filter(p->p != null)
                                                       .filter(p->p.getName()!=null)
                                                       .filter(p->!p.getName().isBlank())
                                                       .sorted(Comparator.comparing(p->p.getName()))
                                                       .toList();

        allExceptNulls.forEach(System.out::println);
    }
}
