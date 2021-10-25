package com.example.coldcalling;

import android.media.Image;
import android.os.Parcelable;
import android.os.SystemClock;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class StudentProfile implements Serializable {
    private String mStudentName;
    private String FileName;
    private long TimeCalled;
    private int TimesCalled;


    StudentProfile(String StudentName, String File) {
        mStudentName = StudentName;
        FileName = File;
        TimeCalled = 0;
        TimesCalled = 0;
    }

    public int getTimeCalled(){
        return TimesCalled;
    }
    public String JustTheName() {
        return mStudentName;
    }

    public String Call_On_Student() {
        TimesCalled++;
        TimeCalled = System.currentTimeMillis();

        return mStudentName;
    }

    public String Show_Time() {
        long temp = TimeCalled;
        return String.valueOf(temp);
    }

    public Long time_was_called() {
        return TimeCalled;
    }

    public boolean StudentDone() {
        if (TimesCalled < 2 || System.currentTimeMillis() - TimeCalled > 2400000) {
            return false;
        }
        return true;
    }
}


