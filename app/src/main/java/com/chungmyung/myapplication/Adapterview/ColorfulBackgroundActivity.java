package com.chungmyung.myapplication.Adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chungmyung.myapplication.R;

import java.util.ArrayList;

public class ColorfulBackgroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorful_background);

       // View
        ListView listView = (ListView)findViewById(R.id.list_view);

       // Data
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0 ; i <100 ; i++){
            data.add("포지션" + i);  }

       // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ColorfulBackgroundActivity.this,
                android.R.layout.simple_list_item_1,data);

        listView.setAdapter(adapter);

    }
}
