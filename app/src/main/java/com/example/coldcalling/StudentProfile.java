package com.example.coldcalling;

import android.media.Image;
import android.os.SystemClock;

import java.util.Date;

public class StudentProfile {

    private String mStudentName;
    private int mTimeWhenCalled;
    Image mProfilePic;


    private StudentProfile(String StudentName, int TimeWhenCalled, Image ProfilePic) {
        mStudentName = StudentName;
        mTimeWhenCalled = TimeWhenCalled;
        mProfilePic = ProfilePic;
    }

    public String returnStudentName() {
        return mStudentName;
    }

    private int returnTimeWhenCalled() {
        mTimeWhenCalled = (int) System.currentTimeMillis();
        return mTimeWhenCalled;
    }

    public boolean wasCalledInPast40Min() {
        int currentTime = (int) System.currentTimeMillis();
        int elapsedTime = currentTime-mTimeWhenCalled;
        int FourtyMintoMilli = 2400000;

        if (elapsedTime <= FourtyMintoMilli) {
            return true;
        }

        return false;
    }

    private Image returnProfilePic() {
        return mProfilePic;
    }






}
