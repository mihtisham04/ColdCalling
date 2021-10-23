package com.example.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Date;
import java.util.Random;

import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private TextView CurrentTimeView, StudentNameView;
    private ImageView ProfilePicView;
    private Button RandomButton, UnCalledLogButton, CalledLogButton;
    private ArrayList<StudentProfile> UncalledStudents;
    private ArrayList<StudentProfile> CalledStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BufferedReader namebuild;
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
        UncalledStudents = new ArrayList<StudentProfile>();
        CalledStudents = new ArrayList<StudentProfile>();

        try {
            InputStream is = getAssets().open("Names.txt");
            namebuild = new BufferedReader(new InputStreamReader(is));
            String Line = namebuild.readLine();

            while (Line != null) {
                String[] Split = Line.split("\\|");
                String Name = Split[0];
                String imgfile = Split[1];
                UncalledStudents.add(new StudentProfile(Name, imgfile));
                Line = namebuild.readLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

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
        if (UncalledStudents.size() <= 1) {
            StudentNameView.setText("No Students Left");
        } else {
        Random rand = new Random();
        int num = rand.nextInt(UncalledStudents.size());
            StudentProfile CurrentStudent = UncalledStudents.get(num);
            String Name = CurrentStudent.Call_On_Student();
            String picFile = CurrentStudent.Get_File();
            if (CurrentStudent.StudentDone()) {
                UncalledStudents.remove(num);
                CalledStudents.add(CurrentStudent);
            }
            StudentNameView.setText(Name);
            ///ProfilePicView.setImageResource(R.drawable.);

        }
    }
}