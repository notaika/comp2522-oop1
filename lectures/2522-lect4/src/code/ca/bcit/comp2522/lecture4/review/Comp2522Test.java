package ca.bcit.comp2522.lecture4.review;


public class Comp2522Test
    implements Quiz
{
    private final String question;
    private final String answer;

    public Comp2522Test(final String question,
                        final String answer)
    {
        this.question = question;
        this.answer = answer;
    }


    @Override
    public String askQuestion()
    {
        return question;
    }

    @Override
    public boolean checkAnswer(final String studentAnswer)
    {
        return this.answer.equals(studentAnswer);
    }

    public static void main(String[] args)
    {
        final Quiz simmyQuiz = new Comp2522Test("Where do we go", "when the effin lights go out?");

        System.out.println(simmyQuiz.askQuestion());
        System.out.println(simmyQuiz.provideFeedback("when the lights go out?"));
        System.out.println(simmyQuiz.provideFeedback("when the effin lights go out?"));
    }
}
