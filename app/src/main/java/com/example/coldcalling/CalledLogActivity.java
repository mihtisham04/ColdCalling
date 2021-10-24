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
    private Button backButton2;

    public static Intent newIntent(MainActivity packageContext) {
        Intent called = new Intent(packageContext, CalledLogActivity.class);
        return called;
    }

    private void updateQuestion2() {
        CalledTextView.setText("CalledLog");
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.called_activity);

        CalledTextView = findViewById(R.id.CalledTextBox);
        updateQuestion2();

        backButton2 = (Button) findViewById(R.id.BackButton1);
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
