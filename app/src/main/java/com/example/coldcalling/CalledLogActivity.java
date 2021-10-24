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
    private static ArrayList<StudentProfile> placeholder1;
    private Button backButton1;

    public static Intent newIntent(MainActivity packageContext, ArrayList<StudentProfile> input1) {
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
        updateQuestion1();



        backButton1 = (Button) findViewById(R.id.BackButton1);
        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
