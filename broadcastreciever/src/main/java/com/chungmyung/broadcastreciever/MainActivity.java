package com.chungmyung.broadcastreciever;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReceiver = new MyReceiver();

    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(MyReceiver.MY_ACTIION);

        registerReceiver(myReceiver, filter);

    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(myReceiver);

    }

    public void onClick(View view) {
        Intent intent = new Intent(MyReceiver.MY_ACTIION);
        sendBroadcast(intent);
    }
}