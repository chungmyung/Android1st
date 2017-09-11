package com.chungmyung.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    // 나만의 브로드케스트 정의  by String
    public static final String MY_ACTIION = "com.myapplciattionapp.broadcastreceiver.action.MY_ACTION";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())) {
            Toast.makeText(context,"전원 연결됨",Toast.LENGTH_SHORT).show();;
        } else if (Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())){
            Toast.makeText(context, "전원 뽑힘", Toast.LENGTH_SHORT).show();
        } else  if (MY_ACTIION.equals(intent.getAction())) {
            Toast.makeText(context,"나만의 액션이다.", Toast.LENGTH_SHORT).show();

        }
    }
}
