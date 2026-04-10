package ca.bcit.comp2522.lab10.quiz;

public class Question
{
    private final String question;
    private final String answer;

    public Question(String question,
                    String answer)
    {
        this.question = question;
        this.answer   = answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public boolean isCorrect(final String answerToCheck)
    {
        return this.answer.equalsIgnoreCase(answerToCheck.trim());
    }
}
