package com.example.anafiona.mbtisurvey;

import java.util.ArrayList;

/**
 * Created by Anafiona on 11/16/17.
 */

public class Results {

    private ArrayList<Integer> questionScores=new ArrayList<>();
    //private int totalScores=0;
    //private ArrayList<Integer> resultScores=new ArrayList<>();

    public Results(ArrayList<Integer> scores){
        this.questionScores=scores;
        scoreCalculations(questionScores, finalResults);
    }
    ArrayList<Integer> finalResults= new ArrayList<>();



    public void scoreCalculations(ArrayList<Integer> scores, ArrayList<Integer> finalResults) {
        int totalScores=0;

        for (int i = 0; i <12; i++) {

            if (i % 3 == 0) {
                finalResults.add(totalScores);
                totalScores = 0;
            } else
                totalScores = +scores.get(i);
        }
       //return the list of 4 main results
    }

   /* public String getExtraversionCode(int eiScore) {
        if (eiScore >= 2) {
            return "E-";
        }
        return "I-";
    }
    */

    public String getEI(int score) {
        if (score >= 2) {//for extraversion
            return "E-active; focusing on the outside world.";
        }
        else//for introversion
        {
            return "I- reflective; focusing on the inner world.";
        }
    }
    public String getSN(int score) {
        if (score >= 2) {//for sensing
            return "S-attending to practical and factual details; confining attention to what is being said and done; in touch with physical reality.";
        } else//for intuition
        {
            return "N-seeing possibilities and patterns; projecting for the future; looking for the bigger picture.";
        }
    }

    public String getTF(int score) {
        if (score >= 2) {//for thinking
            return "T-using logical analysis and objective criteria; drawing cause and effect relationship; prizing logical order.";
        }
        else//for feeling
        {
            return "F-applying personal priorities; weighing human values and motives in order to make a decision; prizing harmony ";
        }
    }

    public String getJP(int score) {
        if(score>=2){//for judgement
            return "J-organazing and scheduling; controlling and regulating; goal-oriented; wanting closure.";
        }
        else//for perceiving
        {
            return "P-curious and comfortable following others; adapting and changing; resisting closure to obtain data.";
        }
    }



}
