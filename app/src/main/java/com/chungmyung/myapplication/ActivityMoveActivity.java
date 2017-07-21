package com.chungmyung.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityMoveActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        View.OnClickListener Listener = new MyclickListner();


        Button button = (Button)findViewById(R.id.coffee_button);
        button.setOnClickListener(Listener);

        findViewById(R.id.basketball_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMoveActivity.this,BasketballActivity.class);
                startActivity(intent);
            }
        });

       //데이터 전송.

        findViewById(R.id.send_date_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "김정수 훌륭한 개발자가 되세요";
                Intent intent = new Intent(ActivityMoveActivity.this,TargetActivity.class);
                intent.putExtra("data",message);
                startActivity(intent);
            }
        });
    }

    class MyclickListner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(ActivityMoveActivity.this, "잘되나", Toast.LENGTH_SHORT);
        }


    }
}
