package ca.bcit.comp2522.lect5.review;

class Book
{
    private final String title;
    private final int yearPublished;

    Book(final String title,
         final int yearPublished)
    {
        this.title = title;
        this.yearPublished = yearPublished;
    }

    String getTitle()
    {
        return title;
    }

    int getYearPublished()
    {
        return yearPublished;
    }

    @Override
    public String toString()
    {
        return "\"" + title + '\"' +
               ", " + yearPublished + '.';
    }

}
