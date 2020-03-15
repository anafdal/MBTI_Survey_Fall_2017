package com.example.anafiona.mbtisurvey;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class FinalResult extends AppCompatActivity {
    static Results finalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        Results finalResult = FinalResult.finalResult;//never do this



       // ArrayList<Integer> resultScores=finalResult.scoreCalculations(finalResult.getScores());//ehh

        TextView answer1=(TextView) findViewById(R.id.answer1);//introversion or extraversion
        answer1.setText(finalResult.getEI(finalResult.finalResults.get(0)));//compare score and get result

        TextView answer2=(TextView) findViewById(R.id.answer2);//intuition or sensing
        answer2.setText(finalResult.getSN(finalResult.finalResults.get(1)));//compare score and get result

        TextView answer3=(TextView) findViewById(R.id.answer3);//thinking or feeling
        answer3.setText(finalResult.getTF(finalResult.finalResults.get(2)));//compare score and get result

        TextView answer4=(TextView) findViewById(R.id.answer4);//perceiving or judgement
        answer4.setText(finalResult.getJP(finalResult.finalResults.get(3)));//compare score and get result
    }


}
