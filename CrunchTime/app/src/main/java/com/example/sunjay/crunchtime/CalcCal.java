package com.example.sunjay.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class CalcCal extends AppCompatActivity {
    String exerciseAmountStr = new String();
    String exercise = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Results");
        setContentView(R.layout.activity_calc_cal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        exerciseAmountStr = extra.getString(ExtoCalMenu.EXERCISE_AMOUNT);
        int exercise_amount = Integer.parseInt(exerciseAmountStr);
        exercise = extra.getString(ExtoCalMenu.EXERCISE);
        String exercise_type = extra.getString(ExtoCalMenu.EXERCISE_TYPE);
        String newBurnMessage = "Doing " + exerciseAmountStr + " " + exercise_type + " of " + exercise + " will burn:";
        final TextView textViewToChange = (TextView) findViewById(R.id.burn_message);
        textViewToChange.setText(newBurnMessage);
        final TextView textViewToChange2 = (TextView) findViewById(R.id.burn_amount);
        Integer burn_amount = exerciseCalc(exercise, exercise_amount);
        textViewToChange2.setText(burn_amount.toString());
        final TextView textViewToChange3 = (TextView) findViewById(R.id.followingexercises);
        textViewToChange3.setText("The following exercises will also burn " + burn_amount.toString() + " calories:\n");
        String[] exerciseArray = {"Pushups", "Situps","Squats","Leg-lift","Plank","Jumping Jacks","Pullups","Cycling","Walking","Jogging","Swimming","Stair-climbing"};
        TextView[] exerciseTextViewArray = {(TextView) findViewById(R.id.exercise1),
                                            (TextView) findViewById(R.id.exercise2),
                                            (TextView) findViewById(R.id.exercise3),
                                            (TextView) findViewById(R.id.exercise4),
                                            (TextView) findViewById(R.id.exercise5),
                                            (TextView) findViewById(R.id.exercise6),
                                            (TextView) findViewById(R.id.exercise7),
                                            (TextView) findViewById(R.id.exercise8),
                                            (TextView) findViewById(R.id.exercise9),
                                            (TextView) findViewById(R.id.exercise10),
                                            (TextView) findViewById(R.id.exercise11)};
        int j = 0;
        for (int i = 0; i < 11; i++){
            if (exerciseArray[j].equals(exercise)){
                j++;
            }
            Integer exAmt = CalCalc(exerciseArray[j], burn_amount);
            exerciseTextViewArray[i].setText(exAmt.toString() + repsOrMinutes(exerciseArray[j], exAmt) + " " +exerciseArray[j]);
            j++;
        }
    }

    protected String repsOrMinutes(String exercise, Integer exerciseAmount){
        if (exercise.equals("Pushups") || exercise.equals("Situps") || exercise.equals("Squats") || exercise.equals("Pullups")){
            if (exerciseAmount > 1) {
                return " rep(s) ";
            }
            return " rep ";
        }
        else{
            if (exerciseAmount > 1) {
                return " minute(s) ";
            }
            return " minute ";
        }
    }

    protected int CalCalc(String exercise, int cal){
        int returnval = 0;
        switch(exercise){
            case "Pushups":
                returnval = (int)((cal/100.0)*350);
                break;
            case "Situps":
                returnval = (int)((cal/100.0)*200);
                break;
            case "Squats":
                returnval = (int)((cal/100.0)*225);
                break;
            case "Leg-lift":
                returnval = (int)((cal/100.0)*25);
                break;
            case "Plank":
                returnval = (int)((cal/100.0)*25);
                break;
            case "Jumping Jacks":
                returnval = (int)((cal/100.0)*10);
                break;
            case "Pullups":
                returnval = (int)((cal/100.0)*100);
                break;
            case "Cycling":
                returnval = (int)((cal/100.0)*12);
                break;
            case "Walking":
                returnval = (int)((cal/100.0)*20);
                break;
            case "Jogging":
                returnval = (int)((cal/100.0)*12);
                break;
            case "Swimming":
                returnval = (int)((cal/100.0)*13);
                break;
            case "Stair-climbing":
                returnval = (int)((cal/100.0)*15);
                break;
            default:
                returnval = 0;
                break;
        }
        return returnval;
    }

    protected int exerciseCalc(String exercise, int amount){
        int returnval = 0;
        switch(exercise){
            case "Pushups":
                returnval = (int)((amount/350.0)*100);
                break;
            case "Situps":
                returnval = (int)((amount/200.0)*100);
                break;
            case "Squats":
                returnval = (int)((amount/225.0)*100);
                break;
            case "Leg-lift":
                returnval = (int)((amount/25.0)*100);
                break;
            case "Plank":
                returnval = (int)((amount/25.0)*100);
                break;
            case "Jumping Jacks":
                returnval = (int)((amount/10.0)*100);
                break;
            case "Pullups":
                returnval = (int)((amount/100.0)*100);
                break;
            case "Cycling":
                returnval = (int)((amount/12.0)*100);
                break;
            case "Walking":
                returnval = (int)((amount/20.0)*100);
                break;
            case "Jogging":
                returnval = (int)((amount/12.0)*100);
                break;
            case "Swimming":
                returnval = (int)((amount/13.0)*100);
                break;
            case "Stair-climbing":
                returnval = (int)((amount/15.0)*100);
                break;
            default:
                returnval = 0;
                break;
        }
        return returnval;
    }

}
