package lecture.notes;

/**
 * Example of a class without the use of generics.
 * Don't have to explicitly cast!
 */
public class BoxWithGenerics<T>
{
    private T t;

    public void set(final T t)
    {
        this.t = t;
    }

    public T get()
    {
        return t;
    }

    public static void main(String[] args)
    {
        final BoxWithGenerics<String> stringBox = new BoxWithGenerics<>();
        final BoxWithGenerics<Integer> intBox = new BoxWithGenerics<>();

        stringBox.set("Hello"); // storing a string

        final String s;
        s = stringBox.get(); // EXPLICIT CASTING IS NEEDED
        System.out.println(s);

        intBox.set(123); // storing and integer
        final Integer i;
        i = intBox.get(); // EXPLICIT CASTING
        System.out.println(i);
    }
}
