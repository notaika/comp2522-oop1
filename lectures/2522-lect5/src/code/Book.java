public class Book
{
    private final String title;
    private final int yearPublished;

    public Book(String title,
                int yearPublished)
    {
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public String getTitle()
    {
        return title;
    }

    public int getYearPublished()
    {
        return yearPublished;
    }

    @Override
    public String toString()
    {
        return "Book{" +
               "title='" + title + '\'' +
               ", yearPublished=" + yearPublished +
               '}';
    }
}
