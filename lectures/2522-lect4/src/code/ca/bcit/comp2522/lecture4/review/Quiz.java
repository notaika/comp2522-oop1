package ca.bcit.comp2522.lecture4.review;

public interface Quiz
{
    String askQuestion();
    boolean checkAnswer(final String answerToCheck);

    default String provideFeedback(final String answer)
    {
        final boolean isCorrectAnswer;
        isCorrectAnswer = checkAnswer(answer);

        if (!isCorrectAnswer)
        {
            return "Your answer: " + answer + " is wrong. Boo.";
        }

        return "Your answer: " + answer + " is right. Yay.";
    }
}
