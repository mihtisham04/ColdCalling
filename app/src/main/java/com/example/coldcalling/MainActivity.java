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
import android.content.Intent;

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
                Intent uncalled = UncalledLogActivity.newIntent(MainActivity.this, UncalledStudents);
                startActivity(uncalled);
            }
        });

        CalledLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent called = CalledLogActivity.newIntent(MainActivity.this, CalledStudents);
                startActivity(called);
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
            if (CurrentStudent.StudentDone()) {
                UncalledStudents.remove(num);
                CalledStudents.add(CurrentStudent);
            }
            StudentNameView.setText(Name);
            int id = getPhotoId(Name);
            ProfilePicView.setImageResource(id);


        }
    }

    public int getPhotoId(String n){
        if (n.equals("Aamir Ali")) {
            return R.drawable.aamir_ali;
        }
        if (n.equals("Adrian Yan")) {
            return R.drawable.adrian_yan;
        }
        if (n.equals("Alexander Aney")) {
            return R.drawable.alex_aney;
        }
        if (n.equals("Bipra Dey")) {
            return R.drawable.bipra_dey;
        }
        if (n.equals("Daniel Belkin")) {
            return R.drawable.blank_student;
        }
        if (n.equals("Daniel Dultsin")) {
            return R.drawable.daniel_dultsin;
        }
        if (n.equals("Darren Dong")) {
            return R.drawable.darren_dong;
        }
        if (n.equals("Dennis Wang")) {
            return R.drawable.dennis_wang;
        }
        if (n.equals("Dhruv Amin")) {
            return R.drawable.dhruv_amin;
        }
        if (n.equals("Eden Kogan")) {
            return R.drawable.eden_kogan;
        }
        if (n.equals("Elie Belkin")) {
            return R.drawable.elie_belkin;
        }
        if (n.equals("Evelyn Paskhaver")) {
            return R.drawable.evelyn_paskhaver;
        }
        if (n.equals("Fardin Iqbal")) {
            return R.drawable.fardin_iqbal;
        }
        if (n.equals("Gareth Chaston")) {
            return R.drawable.gareth_chaston;
        }
        if (n.equals("Jerry He")) {
            return R.drawable.jerry_he;
        }
        if (n.equals("Kenny Cao")) {
            return R.drawable.kenny_cao;
        }
        if (n.equals("Marc Rosenberg")) {
            return R.drawable.marc_rosenberg;
        }
        if (n.equals("Matthew Chen")) {
            return R.drawable.matthew_chen;
        }
        if (n.equals("Michael Wu")) {
            return R.drawable.michael;
        }
        if (n.equals("Ming Lin")) {
            return R.drawable.ming_lin;
        }
        if (n.equals("Mohammed Ihtisham")) {
            return R.drawable.mohammed_ihtisham;
        }
        if (n.equals("Noam Canter")) {
            return R.drawable.noam;
        }
        if (n.equals("Ralf Roland Pacia")) {
            return R.drawable.ralf_pacia;
        }
        if (n.equals("Samuel Iskhakov")) {
            return R.drawable.samuel_iskhakov;
        }
        if (n.equals("Sean Kerrigan")) {
            return R.drawable.sean;
        }
        if (n.equals("Sebastian Marinescu")) {
            return R.drawable.sebastian;
        }
        if (n.equals("Selina Li")) {
            return R.drawable.selina_li;
        }
        if (n.equals("Shuyue Chen")) {
            return R.drawable.shuyue_chen;
        }
        if (n.equals("Tanushri Sundaram")) {
            return R.drawable.tanushri_sundaram;
        }
        if (n.equals("Vaibhav Hariani")) {
            return R.drawable.blank_student;
        }
        if (n.equals("Vasu Patel")) {
            return R.drawable.vasu;
        }
        if (n.equals("Xinrui Ge")) {
            return R.drawable.xinrui_ge;
        }
        if (n.equals("Zhian Maysoon")) {
            return R.drawable.zhian_maysoon;
        }
        return R.drawable.blank_student;
    }
}