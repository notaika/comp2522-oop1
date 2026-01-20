package ca.bcit.quiz2.bcit;

public class InvalidConnectionException extends Exception
{
    InvalidConnectionException(final String message)
    {
        super(message);
    }
}
