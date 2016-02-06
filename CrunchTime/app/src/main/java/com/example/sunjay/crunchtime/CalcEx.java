package com.example.sunjay.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class CalcEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Results");
        setContentView(R.layout.activity_calc_ex);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        String calorie_amount = intent.getStringExtra(CaltoExMenu.CALORIE_AMOUNT);

        String newBurnMessage2 = "To burn " + calorie_amount + " Calories, you would need to do:\n";
        final TextView textViewToChange = (TextView) findViewById(R.id.burn_message2);
        textViewToChange.setText(newBurnMessage2);

        String[] exerciseArray = {"Pushups", "Situps","Squats","Leg-lift","Plank","Jumping Jacks","Pullups","Cycling","Walking","Jogging","Swimming","Stair-climbing"};
        TextView[] exerciseTextViewArray = {(TextView) findViewById(R.id.Exercise1),
                (TextView) findViewById(R.id.Exercise2),
                (TextView) findViewById(R.id.Exercise3),
                (TextView) findViewById(R.id.Exercise4),
                (TextView) findViewById(R.id.Exercise5),
                (TextView) findViewById(R.id.Exercise6),
                (TextView) findViewById(R.id.Exercise7),
                (TextView) findViewById(R.id.Exercise8),
                (TextView) findViewById(R.id.Exercise9),
                (TextView) findViewById(R.id.Exercise10),
                (TextView) findViewById(R.id.Exercise11),
                (TextView) findViewById(R.id.Exercise12)};
        for (int i = 0; i < 12; i++){
            Integer exAmt = CalCalc(exerciseArray[i], Integer.parseInt(calorie_amount));
            exerciseTextViewArray[i].setText(exAmt.toString() + repsOrMinutes(exerciseArray[i], exAmt) + " " +exerciseArray[i]);
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


}
