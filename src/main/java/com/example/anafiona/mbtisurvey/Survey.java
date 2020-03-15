package com.example.anafiona.mbtisurvey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anafiona on 11/16/17.
 */

public class Survey {

    private QuestionnaireDelegate questionnaireDelegate;
    private boolean endQuestionnaire = false;

    private String[] answer_a = new String[]{"I love being with other people.",
            "I need to work on several projects or else I will get bored.",
            "I need to act quickly because thinking first takes too much time.",
            "I always notice the facts first.",
            "I am down-to-earth.",
            "I can only focus on what is happening right now.",
            "I always think of the situation in an objective way and make decisions based on facts.",
            "I value truth and honesty, so I will say the truth.",
            "I try to make a fair decision so I appreciate a logical argument the most.",
            "I always need to be in control of the situation.",
            "Everything needs to be in its place or I cannot function correctly.",
            "I need to make decisions as quickly as possible or else I will feel stressed."};
    private String[] answer_b = new String[]{"I mostly enjoy being around other people.",
            "I usually prefer a little bit of variety in my work.",
            "I would rather act first and think about it later.",
            "I have an easier time gathering the facts first.",
            "I am usually more on the practical side.",
            "I focus on the here and now because the future is not something I am worried about.",
            "I will think about how it will affect others but the ultimate decisions will be based on logic.",
            "I would feel bad if I hurt their feelings, but I would tell the truth because it is better than being lied to.",
            "I mostly base my decisions on how logical the argument sounds.",
            "I usually prefer to be in a leadership position.",
            "I mostly need to work in an organized space.",
            "I would rather make decisions quickly and get it over with."};
    private String[] answer_c = new String[]{"I prefer to be by myself.",
            "I prefer working on one project but I can handle several if needed.",
            "I usually plan before I act.",
            "It is much easier for me to see the underlying connections first.",
            "I prefer to add creativity to my work.",
            "I prefer to look at patterns and make guesses about the future.",
            "Usually it is difficult for me to make decisions without thinking about how it will affect me and other people.",
            "I would feel very anxious about telling them the truth and I will try to avoid it.",
            "Sometimes I feel that emotions can be more powerful than logic, and I will base my decision on that.",
            "I am comfortable with letting other people take the lead if they know what they are doing.",
            "I don't mind a little clutter as long as I can get my things done.",
            "I would rather wait to see what is going on before making the decision."};
    private String[] answer_d = new String[]{"I need to be by myself most of the time.",
            "I need to focus on one task at a time in order to do a good job.",
            "I always need to think before I act.",
            "I always see the underlying connections but have a hard time noticing the details.",
            "I have a very rich imagination and need as much creativity in my work as possible.",
            "I always look at the big picture and imagine how things will be affected.",
            "My decisions need to be based on my personal values.",
            "I would feel horrible if I hurt their feelings, so I would probably tell a small white lie.",
            "I value the feelings of others even if it doesn't make sense.",
            "I would rather just follow other people.",
            "What's the point of organizing?",
            "I would feel anxious if I made a decision now and something better came later on."};

    private String[] question = new String[]{"What energizes you the most? - Interacting with other people or being by yourself?"
            , "Would you rather work on several projects at the same time, or focus your attention on one task at a time?",
            "Are you more comfortable acting first then thinking about it, or thinking first and then acting?",
            "Do you usually pay more attention to the facts and details, or do you try to understand the connections and underlying meaning?",
            "Are you more of a down-to-earth person, or an imaginative and creative person?",
            "Are you more tuned in to the here and now or do you look towards how the future will be affected?",
            "Do I make decisions weighing the pros and cons or based on how I and others will feel about the situations?",
            "Is it more important to be truthful even if it hurts someone's feelings or to protect their feelings with a white lie?",
            "Which usually persuades you more - a good logical argument or a strong emotional appeal?",
            "Is it more important for you to be in control of most situations or are you more comfortable with others calling the shots?",
            "Are you generally more organized or do you have more trouble finding things?",
            "Do I make decisions quickly and easily or does making decisions make you feel anxious and unsure?"};

    private int currentQuestionIndex = 0;

    ArrayList<Question> questions;//array of questions

    public void startSurvey() {
        /*
            Loading survey data
         */
        this.questions=new ArrayList<>();//array of answers`

        for (int i = 0; i < 12; i++) {
            Question someQuestion = new Question();
            someQuestion.question = question[i];//get question in each loop

            //we enter the answers for each choice in the array list
            someQuestion.answers.add(answer_a[i]);
            someQuestion.answers.add(answer_b[i]);
            someQuestion.answers.add(answer_c[i]);
            someQuestion.answers.add(answer_d[i]);

            questions.add(someQuestion);//add the questions to questions arraylist
        }

        // Start asking questions
        this.askNextQuestion(0);

    }


    public void setQuestionnaireDelegate(QuestionnaireDelegate questionnaireDelegate){
        this.questionnaireDelegate=questionnaireDelegate;
    }

    public void askNextQuestion(int index) {
        if (index < 12) {
            Question question = questions.get(index);//get the question from appropriate index in the arraylist
            this.questionnaireDelegate.askQuestion(question, this);
        }
        else
        {
            this.questionnaireDelegate.surveyDone();
        }

    }

    public void answerReceived(int index) {
        // Move on to next question
        currentQuestionIndex++;//increase question index

        // Ask next question
        askNextQuestion(currentQuestionIndex);
    }

}

