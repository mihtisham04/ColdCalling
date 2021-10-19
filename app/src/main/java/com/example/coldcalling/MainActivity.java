package com.example.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private TextView CurrentTimeView, StudentNameView;
    private ImageView ProfilePicView;
    private Button RandomButton, UnCalledLogButton, CalledLogButton;
    private Object StudentProfile;

    private StudentProfile[] = new StudentProfile[]{
            new StudentProfile("Sebastian", "0",)


    }


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
        RandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseAndSetStudent();
            }
        });
    }

    public void chooseAndSetStudent() {
        int num = (int)(Math.random()*33+1);
        StudentProfile temp = StudentProfile[num];

        Image Temp = temp.returnProfilePic();
        ProfilePicView.setImageResource(temp.returnProfilePic());

        StudentNameView.setText(temp.returnStudentName());


    }

}