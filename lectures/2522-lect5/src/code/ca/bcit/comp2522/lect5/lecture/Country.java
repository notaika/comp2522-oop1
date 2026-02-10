package ca.bcit.comp2522.lect5.lecture;

/**
 * Map 2.0
 */
public class Country
{
    private final String code;
    private final String name;

    public Country(String code,
                   String name)
    {
        this.code = code;
        this.name = name;
    }

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    @Override public String toString()
    {
        return "ca.bcit.comp2522.lect5.lecture.Country{" +
               "code='" + code + '\'' +
               ", name='" + name + '\'' +
               '}';
    }
}
