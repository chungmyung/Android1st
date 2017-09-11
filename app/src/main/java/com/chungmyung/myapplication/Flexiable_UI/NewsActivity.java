package com.chungmyung.myapplication.Flexiable_UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chungmyung.myapplication.R;

public class NewsActivity extends AppCompatActivity implements FragmentA.OnHeaderlineClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        FragmentA fragment = new FragmentA ();


        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,fragment)
                .commit();
    }

    @Override
    public void onHeaderlineClicked(int position) {
        FragmentB fragmentB = FragmentB.newInstance(position);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,fragmentB)
                .commit();

    }
}
