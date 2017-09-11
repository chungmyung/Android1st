package com.chungmyung.myapplication;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeCycleActivity extends AppCompatActivity {

    private int mNum = 0;
    private Button mButton;

    private static final String TAG = LifeCycleActivity.class.getSimpleName();

    //액티비티가 실행 될때
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        mButton = (Button) findViewById(R.id.number_button);

        // 초기화
        Log.d(TAG, "onCreate: ");
    }

    //시작
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }


    //재시작 화면이 보이기 직전.
    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: ");

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        mNum = settings.getInt("number", 0);

        mButton.setText("" + mNum);

        Log.d(TAG, "onResume: 복원");
    }

    //일시 정지 화면이 안보이기 직전
    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: ");

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("number", mNum);
    }

    // 정지, 홈키를 눌렀을대 최종 위치. 화면에서 한 동안  안뵈게 되면 자동으로 종료되어 onCreate로 감.
    // 앱실행 중  전화가 왔을 경우,  그 앱은 onPause 또는 onStop0에서  전화가 끝나면 다시 onCreate되어 자동실행.

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    // Activity가 종료 될때
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 메모리 해제
        Log.d(TAG, "onDestroy: ");
    }

    public void showDialog(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("test");
        builder.setMessage("test");
        builder.show();
    }

    public void increment(View view) {
        mNum++;
        ((Button) view).setText("" + mNum);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        // 저장

        super.onSaveInstanceState(outState);
    }

    // onStart 와  onResume 사이에서 복원됨
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");

        // 복원
    }

}

