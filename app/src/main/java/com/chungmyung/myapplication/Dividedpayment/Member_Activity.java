package com.chungmyung.myapplication.Dividedpayment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.chungmyung.myapplication.R;

public class Member_Activity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mPhoneEditText;
    private EditText mEmalEditText;
    private EditText mDivideedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_);

        mNameEditText = (EditText) findViewById(R.id.name_edit);
        mPhoneEditText = (EditText) findViewById(R.id.phone_edit);
        mEmalEditText = (EditText) findViewById(R.id.email_edit);
        mDivideedEditText = (EditText)findViewById(R.id.divided_edit);


        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String email = intent.getStringExtra("email");
            String amount = intent.getStringExtra("amount");


            mNameEditText.setText(name);
            mPhoneEditText.setText(phone);
            mEmalEditText.setText(email);
            mDivideedEditText.setText(amount);
        }

    }


}
