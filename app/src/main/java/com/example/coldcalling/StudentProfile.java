package com.example.coldcalling;

import android.os.SystemClock;
import android.widget.ImageView;

import java.util.Date;

public class StudentProfile {

    private String mStudentName;
    private int mTimeWhenCalled;
    ImageView mProfilePic;


    private StudentProfile(String StudentName, int TimeWhenCalled, ImageView ProfilePic) {
        mStudentName = StudentName;
        mTimeWhenCalled = TimeWhenCalled;
        mProfilePic = ProfilePic;
    }

    public String returnStudentName() {
        return mStudentName;
    }

    private int returnTimeWhenCalled() {
        return mTimeWhenCalled;
    }

    public boolean wasCalledInPast40Min() {
        int currentTime = (int) System.currentTimeMillis();
        int elapsedTime = currentTime-mTimeWhenCalled;
        int FourtyMintoMilli = 2400000;

        if (elapsedTime >= FourtyMintoMilli) {
            return true;
        }

        return false;
    }

    private ImageView returnProfilePic() {
        return mProfilePic;
    }






}
