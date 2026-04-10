public class Main
{
    public static void main(final String[] args)
    {
        final Db db1;
        final Db db2;
        final Db db3;

        // won't work anymore due to private constructor
//        db1 = new Db();
//        db2 = new Db();
//        db3 = new Db();

        // we use .getInstance instead
        // these all reference to the same thing
        db1 = Db.getInstance();
        db2 = Db.getInstance();
        db3 = Db.getInstance();

        System.out.println(db1);
        System.out.println(db2);
        System.out.println(db3);
    }
}
