package com.chungmyung.myapplication.fragment.Exam;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chungmyung.myapplication.R;
import com.chungmyung.myapplication.fragment.Color.ColorFragment;

/**
 * Created by user on 2017-08-02.
 */

public class ExamColorActivity extends AppCompatActivity {


    private ColorFragment mFrame1 ;
    private ColorFragment mFrame2 ;
    private ColorFragment mFrame3 ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_exam_color);

        mFrame1 = ColorFragment.newInstance(Color.RED);
        mFrame2 = ColorFragment.newInstance(Color.BLUE);
        mFrame3 = ColorFragment.newInstance(Color.GREEN);    }

    public void onButtonClicked(View view) {
        ColorFragment fragment = null;
        int frame  = R.id.frame1;
        switch (view.getId()) {
            case R.id.button_1:
                frame = R.id.frame1;
                fragment = mFrame1 ;
                break;
            case R.id.button_2:
                frame = R.id.frame2;
                fragment = mFrame2;
                break;
            case R.id.button_3:
                frame = R.id.frame3;
                fragment = mFrame3 ;
        }



        // 안 붙었으면 넣고 붙었으면 빼자
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (!fragment.isAdded()) {
            transaction.replace(frame, fragment);
        } else {
            transaction.remove(fragment);
        }
        transaction.commit();
    }
}

