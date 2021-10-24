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
    private static ArrayList<StudentProfile> placeholder;
    private Button backButton1;

    public static Intent newIntent(MainActivity packageContext) {
        Intent i = new Intent(packageContext, UncalledLogActivity.class);
        return i;
    }

    private void updateQuestion1() {
        UnCalledTextView.setText("UncalledLog");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uncalled_activity);




        backButton1 = (Button) findViewById(R.id.BackButton1);
        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
