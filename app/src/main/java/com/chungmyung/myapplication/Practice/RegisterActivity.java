package com.chungmyung.myapplication.Practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.chungmyung.myapplication.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int REQUEST_CODE_NEWMEMBER = 2000 ;
    private final int REQUEST_CODE_LOGIN = 1000;
    private EditText mIdEditText;
    private EditText mPasswordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mIdEditText = (EditText) findViewById(R.id.id_edit);
        mPasswordEditText = (EditText) findViewById(R.id.password_edit);

        findViewById(R.id.login_button).setOnClickListener(this);
        findViewById(R.id.new_member_text).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                login();
                break;
            case R.id.new_member_text:
                newmeber();
                break;
        }
    }

    private void newmeber() {
        Intent intent = new Intent(this,DepSalesActivity.class);
        startActivityForResult(intent, REQUEST_CODE_NEWMEMBER);
    }

    private void login() {
        Intent intent = new Intent(this,DepSalesActivity.class);
        intent.putExtra("id", mIdEditText.getText().toString());
        intent.putExtra("passWord", mPasswordEditText.getText().toString());
        startActivityForResult(intent, REQUEST_CODE_LOGIN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_LOGIN &&
                    data != null) {
                String text = data.getStringExtra("text");
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

            } else if (requestCode == REQUEST_CODE_NEWMEMBER &&
                       data == null) {
                Toast.makeText(this, "가입 잘되었음", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
