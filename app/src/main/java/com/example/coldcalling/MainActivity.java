package com.example.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.Date;
import java.util.Random;
import java.util.ArrayList;

import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private TextView CurrentTimeView, StudentNameView;
    private ImageView ProfilePicView;
    private Button RandomButton, UnCalledLogButton, CalledLogButton;
    StudentProfile person = new StudentProfile("Sebastian");
    private ArrayList<StudentProfile> UncalledStudents;
    private ArrayList<StudentProfile> CalledStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CurrentTimeView =(TextView)findViewById(R.id.CurrentTimeView);
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

        CurrentTimeView.setText(currentDateTimeString);
        StudentNameView = (TextView)findViewById(R.id.StudentNameView);
        ProfilePicView = (ImageView)findViewById(R.id.ProfilePicImageView);
        RandomButton = (Button) findViewById(R.id.RandomButton);
        UncalledStudents = new ArrayList<StudentProfile>();
        CalledStudents = new ArrayList<StudentProfile>();



        RandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseAndSetStudent();
            }
        });
    }

    public void chooseAndSetStudent() {
        int num = (int)(Math.random()*33);

        Image Temp = temp.returnProfilePic();
        ProfilePicView.setImageResource(temp.returnProfilePic());

        StudentNameView.setText(temp.returnStudentName());


    }
}