package ca.bcit.comp2522.lab10.quiz;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Test
{
    public static final int QUESTION_COUNT_OFFSET = 1;

    public static void main(String[] args)
    {
        // 1. Create app instance
        final QuizApp app = new QuizApp();
        final Scanner scan = new Scanner(System.in);

        final Path path = Path.of("src", "data", "quiz.txt");

        try
        {
            app.loadQuestions(path);

            System.out.println("Questions were successfully loaded.");
        }
        catch (final IOException e)
        {
            System.out.println("Error loading file: " + e.getMessage());
            return;
        }

        // 2. Start the game
        app.startGame();
        System.out.println("Game started. Total question count this session: " + app.getCurrQuestionCount());

        // 3. Game loop
        while (app.getCurrQuestionCount() < app.getQuestionsSeen()
                                               .size())
        {

            Question currQuestion = app.getCurrQuestion();

            System.out.println((app.getCurrQuestionCount() + QUESTION_COUNT_OFFSET) +
                               ". " +
                               currQuestion.getQuestion());
            System.out.print("Answer: ");

            String userAns = scan.nextLine();

            app.submitAnswer(userAns);
            System.out.println("Answer recorded.");
        }

        System.out.println("\n Game Over \n");
        System.out.println("Final Score: " + app.getScore() + "/" + app.getCurrQuestionCount());

        if (!app.getQuestionsWrong().isEmpty()) {
            System.out.println("\nQuestions you missed:");
            for (Question q : app.getQuestionsWrong()) {
                System.out.println("- " + q.getQuestion() + " (Correct Answer was: " + q.getAnswer() + ")");
            }
        } else {
            System.out.println("\nPerfect score!");
        }

        scan.close();
    }












}
