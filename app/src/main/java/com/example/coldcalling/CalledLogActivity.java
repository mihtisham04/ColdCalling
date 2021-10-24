package com.example.coldcalling;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.util.ArrayList;

public class CalledLogActivity extends AppCompatActivity {

    private TextView CalledTextView;
    private static ArrayList<StudentProfile> CalledLog;
    private Button backButton1;


    public static Intent newIntent(MainActivity packageContext) {
        Intent i = new Intent(packageContext, CalledLogActivity.class);
        return i;
    }

    private void updateQuestion1() {
        CalledTextView.setText("CalledLog");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.called_activity);


        CalledTextView = (TextView) findViewById(R.id.CalledTextBox);

        CalledLog = (ArrayList<StudentProfile>)getIntent().getExtras().getSerializable("CalledLog");

        String text = "";

        for (StudentProfile temp: CalledLog) {
            String input = temp.JustTheName() + " was called " + temp.getTimeCalled() + " times";
            text = text.concat(input + "\n");
        }

        CalledTextView.setText(text);



        backButton1 = (Button) findViewById(R.id.BackButton1);
        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
