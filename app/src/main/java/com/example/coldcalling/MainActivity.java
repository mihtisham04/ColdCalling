package com.example.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private TextView CurrentTimeView, StudentNameView;
    private ImageView ProfilePicView;
    private Button RandomButton, UnCalledLogButton, CalledLogButton;
    StudentProfile person = new StudentProfile("Sebastian");
    private ArrayList<StudentProfile> UncalledStudents;
    private ArrayList<StudentProfile> CalledStudents;
    BufferedReader namebuild;

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
        UnCalledLogButton = (Button) findViewById(R.id.UnCalledButton);
        CalledLogButton= (Button) findViewById(R.id.CalledButton);
        try {
            namebuild = new BufferedReader(new FileReader("/Users/vaibhav/AndroidStudioProjects/ColdCallingApp/app/src/main/java/com/example/coldcalling/Names.txt"));
            String Name = namebuild.readLine();
            System.out.println(Name);

            while (Name != null) {
                System.out.println(Name);
                UncalledStudents.add(new StudentProfile("contentLine"));
                Name = namebuild.readLine();

            }
        } catch (Exception e){
            e.printStackTrace();
        }


        UncalledStudents = new ArrayList<StudentProfile>();
        CalledStudents = new ArrayList<StudentProfile>();



        RandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseAndSetStudent();
            }
        });
        
        UnCalledLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        CalledLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





    }

    public void chooseAndSetStudent() {
        int num = (int) (Math.random() * UncalledStudents.size()-1);
        System.out.println(UncalledStudents.size());
        StudentProfile CurrentStudent = UncalledStudents.get(num);
        String Name = CurrentStudent.Call_On_Student();
        if (CurrentStudent.StudentDone()) {
            CalledStudents.remove(num);
            UncalledStudents.add(CurrentStudent);
        }
        StudentNameView.setText(Name);
    }
}