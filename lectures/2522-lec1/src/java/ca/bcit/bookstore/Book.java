package ca.bcit.bookstore; // rules for naming packages -> reverse domain name
// package good for organization
// code should never be in default package
// why put things in package: for organization
// should be reverse domain, lowercase, meaningful, unique


/**
 * from lecture 1
 * good quiz question to write + add packages and javadocs
 */

class Book
{ // removed public: only make it as visible as it needs to
    private static final int MAX_LEN_TITLE = 100;
    private final String title;

    Book(final String title)
    {
        validateTitle(title);
        this.title = title;
    }

    private static void validateTitle(final String title)
    {
        if(title == null || title.length() > MAX_LEN_TITLE)
        {
            throw new IllegalArgumentException("bad title: " + title);
        }
    }
}
