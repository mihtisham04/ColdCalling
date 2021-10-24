package com.example.coldcalling;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;

public class CalledLogActivity extends AppCompatActivity {

    private TextView CalledTextView;




    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.called_activity);

    }
}
