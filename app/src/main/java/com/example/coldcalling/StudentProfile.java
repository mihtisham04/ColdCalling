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
    private int mTimeWhenCalled;
    String ProfilePath;
    Bitmap bitmap;
    private int TimesCalled;


    StudentProfile(String StudentName, int TimeWhenCalled, String imagePath) {
        mStudentName = StudentName;
        mTimeWhenCalled = TimeWhenCalled;
        ProfilePath = imagePath;
        bitmap = BitmapFactory.decodeFile(ProfilePath);
        TimesCalled = 0;


    }

    public String returnStudentName() {
        return mStudentName;
    }

    private int returnTimesCalled() {
        return TimesCalled;
    }

    private int increaseTimesCalled() {
        TimesCalled++;
        return TimesCalled;
    }

    private int resetTimesCalled() {
        TimesCalled = 0;
        return TimesCalled;
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
        ImageView imageView = (ImageView) getActivity().findViewById(R.id.imageView);
        imageView.setImageBitmap(BitmapFactory.decodeFile(ProfilePath));


    }






}
