package com.chungmyung.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mPasswordEditText;
    private EditText mPasswordConfirmEditText;
    private EditText mEmailText;
    private RadioGroup mGenderRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mIdEditText = (EditText) findViewById((R.id.id_edit));
        mPasswordEditText = (EditText) findViewById(R.id.password_edit);
        mPasswordConfirmEditText = (EditText) findViewById(R.id.passwordConfirm_edit);
        mEmailText = (EditText) findViewById(R.id.email_edit);
        mGenderRadioGroup = (RadioGroup) findViewById(R.id.gender_group);

        // button Event
        findViewById(R.id.reset_button).setOnClickListener(this);
        findViewById(R.id.sign_up_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset_button:
                break;
            case R.id.sign_up_button:
                if (isEditTextEmpty()){
                    Toast.makeText(this, "모두 입력해 주셔야 합니다.", Toast.LENGTH_SHORT).show();
                    return;
        }
                if (isInvalidPassword()) {
                    Toast.makeText(this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
        }

        String gender = "남자";
        if (mGenderRadioGroup.getCheckedRadioButtonId() == R.id.female_radio_button) {
            gender = "여자";       }  // 성능이 아래 보다 더 좋다 .fVBI 때문.
        // String gender = ((RadioButton)findViewById((mGenderRadioGroup.getCheckedRadioButtonId())).getTag().toString();

        Intent intent = new Intent(SignUpActivity.this, SignUpMessageActivity.class);
        intent.putExtra("id", mIdEditText.getText().toString());
        intent.putExtra("password", mPasswordEditText.getText().toString());
        intent.putExtra("email", mEmailText.getText().toString());
        intent.putExtra("gender", gender);
        startActivityForResult(intent, 1000);
    }


    private boolean isInvalidPassword() {
        return mPasswordEditText.getText().toString().equals(mPasswordConfirmEditText.getText().toString()) == false;
    }

    private boolean isEditTextEmpty() {
        return TextUtils.isEmpty(mIdEditText.getText().toString()) ||
                TextUtils.isEmpty(mPasswordEditText.getText().toString()) ||
                TextUtils.isEmpty(mPasswordConfirmEditText.getText().toString()) ||
                TextUtils.isEmpty(mEmailText.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && requestCode == RESULT_OK) {
            Toast.makeText(this, "확인버튼을 누르셨습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
