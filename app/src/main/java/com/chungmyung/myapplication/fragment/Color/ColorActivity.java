package com.chungmyung.myapplication.fragment.Color;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chungmyung.myapplication.R;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }



    public void onCreateRedFragmentButtonClicked(View view) {
        //새로운 프래그 먼트 생성
        ColorFragment fragment = ColorFragment.newInstance(Color.RED);

        //프래그먼트에게 넘겨주기위해선   Bundle에다 넘겨야 한다. 위의 coding으로 없어지는 부분
//        Bundle bundle = new Bundle();
//        bundle.putInt("activity_color", Color.RED);
//        bundle.putString("name", "어쩌구");
//        fragment.setArguments(bundle);

        // R.id.container영역에 프래그먼트를 교체하겠다.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();



    }

    public void onCreateBlueFragmentButtonClicked(View view) {
        //새로운 프래그 먼트 생성
        ColorFragment fragment = ColorFragment.newInstance(Color.BLUE);

        // R.id.container영역에 프래그먼트를 교체하겠다.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void onCreateGreenFragmentButtonClicked(View view) {

        //새로운 프래그 먼트 생성
        ColorFragment fragment =ColorFragment.newInstance(Color.GREEN);

        // R.id.container영역에 프래그먼트를 교체하겠다.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void onCreateRandomFragmentButtonClicked(View view) {

        ColorFragment fragment =ColorFragment.newInstance();

        // R.id.container영역에 프래그먼트를 교체하겠다.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();



    }
}
