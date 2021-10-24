package com.example.coldcalling;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UncalledLogActivity extends AppCompatActivity {

    private TextView UnCalledTextView;
    private static ArrayList<StudentProfile> placeholder;
    private Button backButton;

    public static Intent newIntent(MainActivity packageContext, ArrayList<StudentProfile> input) {
        Intent i = new Intent(packageContext, UncalledLogActivity.class);
        return i;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uncalled_activity);

        UnCalledTextView = (TextView) findViewById(R.id.UnCalledTextBox);










    }

}
