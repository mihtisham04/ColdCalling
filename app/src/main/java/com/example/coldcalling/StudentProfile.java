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
    private String FileName;
    private int TimeCalled;
    private int TimesCalled;


    StudentProfile(String StudentName, String File) {
        mStudentName = StudentName;
        FileName = File;
        TimeCalled = 0;
        TimesCalled = 0;
    }

    public String Call_On_Student() {
        TimesCalled++;
        TimeCalled = (int) System.currentTimeMillis();
        return mStudentName;
    }

    public String Show_Time() {
        Integer temp = TimeCalled;
        return temp.toString();
    }


    public boolean StudentDone() {
        if (TimesCalled < 2 || (int) System.currentTimeMillis() - TimeCalled > 2400000) {
            return false;
        }
        return true;
    }
}


