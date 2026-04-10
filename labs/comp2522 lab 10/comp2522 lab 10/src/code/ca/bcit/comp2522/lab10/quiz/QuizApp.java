package ca.bcit.comp2522.lab10.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A quizzing game application.
 *
 * @author Aika Manalo - Set 2C
 * @author Quinn Callender - Set 2C
 *
 * @version 1.0
 */
public class QuizApp
{
    private static final int MAX_QUESTIONS_PER_GAME = 10;
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    // All possible questions
    private final List<Question> questionBank;

    // Current session?
    private final List<Question> questionsSeen;
    private final List<Question> questionsWrong;
    private int score;
    private int currQuestionCount;

    public QuizApp()
    {
        this.questionBank = new ArrayList<>();
        this.questionsSeen = new ArrayList<>();
        this.questionsWrong = new ArrayList<>();
        this.score = 0;
        this.currQuestionCount = 0;
    }

    public List<Question> getQuestionBank()
    {
        return questionBank;
    }

    public List<Question> getQuestionsSeen()
    {
        return questionsSeen;
    }

    public List<Question> getQuestionsWrong()
    {
        return questionsWrong;
    }

    public int getScore()
    {
        return score;
    }

    public int getCurrQuestionCount()
    {
        return currQuestionCount;
    }

    public void loadQuestions(final Path path) throws IOException
    {
        try (final BufferedReader reader = Files.newBufferedReader(path,
                                                                   CHARSET))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                if (!line.trim()
                         .isEmpty())
                {
                    final Question newQuestion = createQuestion(line);

                    if (newQuestion != null)
                    {
                        questionBank.add(newQuestion);
                    }
                }
            }
        }
    }

    public Question createQuestion(final String line)
    {
        final String[] parts = line.split("\\|");

        final String prompt = parts[0].trim();
        final String answer = parts[1].trim();

        return new Question(prompt, answer);
    }

    public void startGame()
    {
        this.score = 0;
        this.currQuestionCount = 0;
        this.questionsWrong.clear();
        this.questionsSeen.clear();

        Collections.shuffle(questionBank);

        // Grab 10 questions
        for (int i = 0; i < MAX_QUESTIONS_PER_GAME; i++)
        {
            this.questionsSeen.add(questionBank.get(i));
        }
    }

    public Question getCurrQuestion()
    {
        if (this.currQuestionCount < questionsSeen.size())
        {
            return questionsSeen.get(currQuestionCount);
        }

        return null;
    }

    public void submitAnswer(final String userAnswer)
    {
        Question currQuestion = getCurrQuestion();

        if (currQuestion != null)
        {
            if (currQuestion.isCorrect(userAnswer))
            {
                score++;
            } else
            {
                questionsWrong.add(currQuestion);
            }

            currQuestionCount++;
        }
    }

    public int getTotalSessionQuestions()
    {
        return questionsSeen.size();
    }
}
