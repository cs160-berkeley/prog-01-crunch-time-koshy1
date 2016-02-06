package com.example.sunjay.crunchtime;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class CaltoExMenu extends AppCompatActivity {
    public final static String CALORIE_AMOUNT = "com.example.sunjay.crunchtime.CALORIE_AMOUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calto_ex_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Input Calories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
    }

    public void CalcExFunc(View view){
        String regex = "[0-9]+";
        String calorie_amount = ((EditText)findViewById(R.id.calorie_amount)).getText().toString();
        if (!(calorie_amount.matches(regex))){
            new AlertDialog.Builder(this)
                    .setTitle("Invalid Amount")
                    .setMessage("You must input an integer amount of Calories")
                    .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            return;
        }
        Intent intent = new Intent(this, CalcEx.class);
        intent.putExtra(CALORIE_AMOUNT, calorie_amount);
        startActivity(intent);
    }

}
