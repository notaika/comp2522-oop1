package ca.bcit.comp2522.lecture3;

abstract class Database
{
    abstract boolean query(String queryStr); // don't have to put final here, can put it in the class

}

class Firebase extends Database {

    @Override
    boolean query(final String queryStr)
    {
        System.out.println("querying firebase: " + queryStr);
        return true;
    }
}

class MySQL extends Database {

    @Override
    boolean query(final String queryStr)
    {
        System.out.println("querying MySQL: " + queryStr);
        return true;
    }
}

class Main
{
    public static void main(String[] args)
    {
        final Database db;

        db = new MySQL();
        db.query("woot");
    }
}