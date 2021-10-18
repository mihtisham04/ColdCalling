package com.example.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView CurrentTimeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CurrentTimeView =(TextView)findViewById(R.id.CurrentTimeView);
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
        CurrentTimeView.setText(currentDateTimeString);


    }

    public chooseStudent() {
        int num = (int)(Math.random()*33+1);
        System.out.println("Method Executed:chooseStudent");

    }

}