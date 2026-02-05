/**
 *
 */
public class Student
{
    private final String id;
    private final String firstName;

    public Student(String id,
                   String firstName)
    {
        this.id = id;
        this.firstName = firstName;
    }

    public String getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }


    @Override public String toString()
    {
        return "Student{" +
               "id='" + id + '\'' +
               ", firstName='" + firstName + '\'' +
               '}';
    }
}
