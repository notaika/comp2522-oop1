import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Class Activity :)
 */
class School
{
    private final Map<String, Student> students;
    private final Set<String> studentIds;

    School()
    {
        students = new HashMap<>();

        final Student devan;
        final Student mischa;
        final Student mayvee;

        devan = new Student("A00000000", "Devan");
        mischa = new Student("A00000001", "Mischa");
        mayvee = new Student("A00000002", "Mayvee");

        students.put(devan.getId(), devan);
        students.put(mischa.getId(), mischa);
        students.put(mayvee.getId(), mayvee);

        studentIds = students.keySet();

        for (final String id : studentIds)
        {
            final Student s;
            s = students.get(id);

            System.out.println(s.getFirstName());
        }

        final Iterator<String> it;
        it = studentIds.iterator();

        while (it.hasNext())
        {
            final String key;
            final Student value;

            key = it.next();
            value = students.get(key);

            System.out.println(value.getFirstName());
        }

    }

    public static void main(String[] args)
    {
        final School bcit;
        bcit = new School();
    }
}
