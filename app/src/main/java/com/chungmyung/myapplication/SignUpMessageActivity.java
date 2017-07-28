package com.chungmyung.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SignUpMessageActivity extends AppCompatActivity {

    private TextView mMessageTextViw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_message);

        mMessageTextViw = (TextView)findViewById(R.id.message_edit);

        Intent intent = getIntent();
        if (intent != null){
            String id = intent.getStringExtra("id");
            String password = intent.getStringExtra("password");
            String email = intent.getStringExtra("email");
            String gender = intent.getStringExtra("gender");

            mMessageTextViw.setText(id + ","  + password + "," + email + "," + gender);
        }

    }
    public void confirm(View view) {
        setResult(RESULT_OK);
        finish();
    }
}
