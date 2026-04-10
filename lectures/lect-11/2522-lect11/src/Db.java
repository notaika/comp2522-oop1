class Db
{
    private static Db db;

    // this constructor can't be called outside of this class because it's private
    private Db()
    {

    }

    // this can call the constructor
    // why is it static?
    // static means that theres ONE PER CLASS (shared by all instances of the whole class)
    static Db getInstance()
    {
        // if and only if you don't have one..
        if (db == null)
        {
            db = new Db(); // make one
        }

        return db;
    }
}
