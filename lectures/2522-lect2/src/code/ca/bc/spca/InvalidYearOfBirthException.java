package ca.bc.spca;

public class InvalidYearOfBirthException
    extends Exception         // checked
    // extends RuntimeException  // unchecked
{
    InvalidYearOfBirthException(final String message)
    {
        super(message);
    }
}
