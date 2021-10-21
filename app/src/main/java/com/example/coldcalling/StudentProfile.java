package com.example.coldcalling;

import android.media.Image;
import android.os.SystemClock;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.sql.Time;
import java.util.Date;

public class StudentProfile {

    private String mStudentName;
    private int TimeCalled;
    private int TimesCalled;


    StudentProfile(String StudentName) {
        mStudentName = StudentName;
        TimeCalled = 0;
        TimesCalled = 0;
    }


    public String Call_On_Student() {
        TimesCalled++;
        TimeCalled = (int) System.currentTimeMillis();
        return mStudentName;
    }


    public boolean StudentDone() {
        if (TimesCalled < 2 || (int) System.currentTimeMillis() - TimeCalled > 2400000) {
            return false;
        }
        return true;
    }
}


