package com.example.coldcalling;

import android.media.Image;
import android.os.SystemClock;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.util.Date;

public class StudentProfile {

    private String mStudentName;
    private int mTimeWhenCalled;
    String ProfilePath;
    Bitmap bitmap;


    StudentProfile(String StudentName, int TimeWhenCalled, String imagePath) {
        mStudentName = StudentName;
        mTimeWhenCalled = TimeWhenCalled;
        ProfilePath = imagePath;
        bitmap = BitmapFactory.decodeFile(ProfilePath);


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
        ImageView imageView = (ImageView) getActivity().findViewById(R.id.imageView);
        imageView.setImageBitmap(BitmapFactory.decodeFile(ProfilePath));


    }






}
