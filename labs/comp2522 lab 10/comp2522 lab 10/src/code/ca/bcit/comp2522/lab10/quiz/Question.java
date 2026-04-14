package ca.bcit.comp2522.lab10.quiz;

/**
 * Represents a quiz question and its correct answer.
 *
 * @author Aika Manalo - Set 2C
 * @author Quinn Callander - Set 2C
 * @version 1.1
 */
public class Question
{
    private final String question;
    private final String correctAnswer;

    /**
     * Constructs a Question.
     *
     * @param question the question text
     * @param correctAnswer the correct answer
     */
    public Question(final String question,
                    final String correctAnswer)
    {
        validateString(question,
                       "question input");
        validateString(correctAnswer,
                       "answer input");

        this.question      = question.trim();
        this.correctAnswer = correctAnswer.trim();
    }

    /**
     * Validates that the string passed is not null or blank.
     *
     * @param stringToCheck the string to check
     * @param stringType the "type" (e.g. question or answer)
     */
    private void validateString(final String stringToCheck,
                                final String stringType)
    {
        if (stringToCheck == null || stringToCheck.isBlank())
        {
            throw new IllegalArgumentException("ERROR: Invalid " + stringType);
        }
    }

    /**
     * Gets the question text.
     *
     * @return the question as a String
     */
    public String getQuestion()
    {
        return question;
    }

    /**
     * Gets the correct answer.
     *
     * @return the answer as a String
     */
    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    /**
     * Checks if the provided answer matches the correct response case-insensitively.
     *
     * @param userAnswer the answer provided by the user
     * @return true if correct, false otherwise
     */
    public boolean isCorrect(final String userAnswer)
    {
        if (userAnswer == null)
        {
            return false;
        }

        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }
}