package com.example.coldcalling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UncalledLogActivity extends AppCompatActivity {

    private TextView UnCalledTextView;
    private ArrayList<StudentProfile> UncalledLog;
    private Button backButton2;

    public static Intent newIntent(MainActivity packageContext) {
        Intent i = new Intent(packageContext, UncalledLogActivity.class);
        return i;
    }



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uncalled_activity);

        UnCalledTextView = (TextView) findViewById(R.id.UnCalledTextBox);



        UncalledLog = (ArrayList<StudentProfile>)getIntent().getExtras().getSerializable("UncalledLog");

        String text = "";
        if (UncalledLog.isEmpty()) {
            text = "No Students Left!";
        }

        for (StudentProfile temp: UncalledLog) {
            if (temp.getTimeCalled() == 0) {
                String input = temp.JustTheName();
                text = text.concat(input + "\n");
            }
        }

        UnCalledTextView.setText(text);

        backButton2 = (Button) findViewById(R.id.BackButton2);
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
           }
        });
    }
}
