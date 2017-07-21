package com.chungmyung.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class BasketballActivity extends AppCompatActivity {

    private TextView mScoreaTextView;
    private TextView mScorebTextView;
    private int mScorea = 0;
    private int mScoreb = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);

        mScoreaTextView = (TextView) findViewById(R.id.scorea_text);
        mScoreaTextView.setText("" + mScorea);
        mScorebTextView = (TextView) findViewById(R.id.scoreb_text);
        mScorebTextView.setText("" + mScoreb);
    }


    public void point3aButtonClicked(View view) {
        mScorea+=3;
        mScoreaTextView.setText("" + mScorea);
    }

    public void point3bButtonClicked(View view) {
        mScoreb+=3;
        mScorebTextView.setText("" + mScoreb);
    }


    public void point2aButtonClicked(View view) {
        mScorea+=2;
        mScoreaTextView.setText("" + mScorea);
    }

    public void point2bButtonClicked(View view) {
        mScoreb+=2;
        mScorebTextView.setText("" + mScoreb);
    }

    public void pointa1buttonClicked(View view) {
        mScorea+=1;
        mScoreaTextView.setText("" + mScorea);
    }

    public void point1bButtonClicked(View view) {
        mScoreb+=1;
        mScorebTextView.setText("" + mScoreb);
    }


    public void resetButtonClicked(View view) {
        mScorea = 0;
        mScoreaTextView.setText("" + mScorea);
        mScoreb = 0;
        mScorebTextView.setText("" + mScorea);
    }
}
