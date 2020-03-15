package com.example.anafiona.mbtisurvey;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Anafiona on 11/16/17.
 */

public interface QuestionnaireDelegate {
    public void askQuestion(Question someQuestion, Survey sourceSurvey);
    public void surveyDone();
}

