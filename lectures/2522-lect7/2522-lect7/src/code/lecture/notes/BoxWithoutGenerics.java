package lecture.notes;

/**
 * Example of a class without the use of generics.
 * No type-safety, therefore -> must explicitly cast
 */
class BoxWithoutGenerics
{
    private Object t;

    void set(final Object t)
    {
        this.t = t;
    }

    Object get()
    {
        return t;
    }

    public static void main(final String[] args)
    {
        final BoxWithoutGenerics box = new BoxWithoutGenerics();

        box.set("Hello"); // storing a string

        final String s;
        s = (String) box.get(); // EXPLICIT CASTING IS NEEDED
        System.out.println(s);

        box.set(123); // storing and integer
        final Integer i;
        i = (Integer) box.get(); // EXPLICIT CASTING
        System.out.println(i);
    }
}
