package com.example.sunjay.crunchtime;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ExtoCalMenu extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public final static String EXERCISE_AMOUNT = "com.example.sunjay.crunchtime.EXERCISE_AMOUNT";
    public final static String EXERCISE = "com.example.sunjay.crunchtime.EXERCISE";
    public final static String EXERCISE_TYPE = "com.example.sunjay.crunchtime.EXERCISE_TYPE";

    String exercise = new String();
    String exercise_type = new String();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exto_cal_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Input Exercise Information");
        Intent intent = getIntent();

        Spinner spinner = (Spinner) findViewById(R.id.exercise_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercise_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Select an exercise");
        spinner.setOnItemSelectedListener(this);
    }

    public void CalcCalFunc(View view){
        String regex = "[0-9]+";
        String exercise_amount = ((EditText)findViewById(R.id.exercise_amount)).getText().toString();
        if (exercise.equals("Select")){
            new AlertDialog.Builder(this)
                    .setTitle("No Exercise Selected")
                    .setMessage("You must select an exercise")
                    .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            return;
        }
        if (!(exercise_amount.matches(regex))){
            new AlertDialog.Builder(this)
                    .setTitle("Invalid Amount")
                    .setMessage("You must input an integer amount of exercise reps/minutes")
                    .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            return;
        }
        Intent intent = new Intent(this, CalcCal.class);
        Bundle extra = new Bundle();
        extra.putString(EXERCISE_AMOUNT, exercise_amount);
        extra.putString(EXERCISE, exercise);
        extra.putString(EXERCISE_TYPE, exercise_type);
        intent.putExtras(extra);
        startActivity(intent);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        exercise = parent.getItemAtPosition(pos).toString();
        if (exercise.equals(getResources().getString(R.string.exercisespinnerprompt))){
            final TextView textViewToChange = (TextView) findViewById(R.id.reps_or_exercise);
            textViewToChange.setText("  ");
        }
        else if (exercise.equals("Pushups") || exercise.equals("Situps") || exercise.equals("Squats") || exercise.equals("Pullups")){
            final TextView textViewToChange = (TextView) findViewById(R.id.reps_or_exercise);
            textViewToChange.setText("  rep(s) ");
            exercise_type = "rep(s)";
        }
        else{
            final TextView textViewToChange = (TextView) findViewById(R.id.reps_or_exercise);
            textViewToChange.setText("  minute(s) ");
            exercise_type = "minute(s)";
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

}
