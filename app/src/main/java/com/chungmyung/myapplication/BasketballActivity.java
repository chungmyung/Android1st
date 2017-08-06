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
        mScorebTextView = (TextView) findViewById(R.id.scoreb_text);


        if (savedInstanceState != null) {
            // 복원
            mScorea = savedInstanceState.getInt("a");
            mScoreb = savedInstanceState.getInt("b");

            mScoreaTextView.setText("" + mScorea);
            mScorebTextView.setText("" + mScoreb);
        }
    }

    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.point1a_button:
                mScorea++;
                break;
            case R.id.point2a_button:
                mScorea += 2;
                break;
            case R.id.point3a_button:
                mScorea += 3;
                break;
            case R.id.point1b_button:
                mScoreb++;
                break;
            case R.id.point2b_button:
                mScoreb += 2;
                break;
            case R.id.point3b_button:
                mScoreb += 3;
                break;
            case R.id.reset_button:
                mScorea = 0;
                mScoreb = 0;
                break;
        }

        mScoreaTextView.setText("" + mScorea);
        mScorebTextView.setText("" + mScoreb);


//    public void resetButtonClicked(View view) {
//        mScorea = 0;
//        mScoreaTextView.setText("" + mScorea);
//        mScoreb = 0;
//        mScorebTextView.setText("" + mScorea);
//    }

    }

        @Override
        protected void onSaveInstanceState (Bundle outState){
            // 저장
            outState.putInt("a", mScorea);
            outState.putInt("b", mScoreb);

            super.onSaveInstanceState(outState);
        }

        @Override
        protected void onRestoreInstanceState (Bundle savedInstanceState){
            super.onRestoreInstanceState(savedInstanceState);

            // 복원
            mScorea = savedInstanceState.getInt("a");
            mScoreb = savedInstanceState.getInt("b");

            mScoreaTextView.setText("" + mScorea);
            mScorebTextView.setText("" + mScoreb);
        }
}
