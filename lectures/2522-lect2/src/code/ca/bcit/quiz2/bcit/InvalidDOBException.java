package ca.bcit.quiz2.bcit;

public class InvalidDOBException extends Exception
{
    InvalidDOBException(final String message)
    {
        super(message);
    }
}
