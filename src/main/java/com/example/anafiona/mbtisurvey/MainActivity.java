package com.example.anafiona.mbtisurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements QuestionnaireDelegate {

    Survey aSurvey = new Survey();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSurvey.setQuestionnaireDelegate(this);
        aSurvey.startSurvey();
    }

    Button button1;
    Button button2;
    Button button3;
    Button button4;


    @Override
    public void askQuestion(Question someQuestion, Survey sourceSurvey){
        TextView textView = (TextView) findViewById(R.id.question);
        textView.setText(someQuestion.question);

       this.aSurvey=sourceSurvey;


        button1=(Button) findViewById(R.id.answer1);
        button1.setText(someQuestion.answers.get(0));

        button2=(Button) findViewById(R.id.answer2);
        button2.setText(someQuestion.answers.get(1));

        button3=(Button) findViewById(R.id.answer3);
        button3.setText(someQuestion.answers.get(2));

        button4=(Button) findViewById(R.id.answer4);
        button4.setText(someQuestion.answers.get(3));
    }

    private int score=0;
    ArrayList<Integer> totalScore=new ArrayList<>();//get score for each

    public void clicked(/*Survey sourceSurvey, Question someQuestion,*/ View v) {

       //sourceSurvey.answerReceived(sourceSurvey.questions.indexOf(someQuestion.question));
       this.buttonPress(v);



   }
    /*
    askQuestion(question, ArrayList<Answers>, questionaire);

    questionaire.answerReceived(index)
     */

    public void buttonPress(View v){
        int indexOfAnswer = 0;
        switch(v.getId()){
            case R.id.answer1:
                indexOfAnswer = 0;
              score++;
                break;
            case R.id.answer2:
                score++;
                indexOfAnswer = 1;
                break;
            case R.id.answer3:
                indexOfAnswer = 2;
                break;
            case R.id.answer4:
                indexOfAnswer = 3;
                break;
        }
       totalScore.add(score);
        aSurvey.answerReceived(indexOfAnswer);

    }

    @Override
    public void surveyDone() {
        Intent intent=new Intent(this,FinalResult.class);
        Results theResults=new Results(totalScore);//pass array of scores
        FinalResult.finalResult = theResults;
        startActivity(intent);
    }





}