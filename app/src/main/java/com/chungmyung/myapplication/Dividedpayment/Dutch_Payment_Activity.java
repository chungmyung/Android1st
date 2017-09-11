package com.chungmyung.myapplication.Dividedpayment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.chungmyung.myapplication.R;

public class Dutch_Payment_Activity extends AppCompatActivity implements OnClickListener {


    private EditText mEventName;
    private EditText mTotalAmount;
    private EditText mTotalSupportAmount;
    private EditText mNumAttendee;
    private EditText mNumSupporter;

    private int mNumber;
    private int mSize;
    private int mTotalSpentAmount;
    private int mTotalsupportAmount;
    private int mActualSpentAmout;
    private int mDividedAmountperAttendee;
    private int mAvrgSupportedAmountperSupporter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dutch__payment_);

        mEventName = (EditText) findViewById(R.id.eventName_edit);
        mTotalAmount = (EditText) findViewById(R.id.totalAmount_edit);
        mTotalSupportAmount = (EditText) findViewById(R.id.totalSupportAmount_edit);
        mNumAttendee = (EditText) findViewById(R.id.numAttendee_edit);
        mNumSupporter = (EditText) findViewById(R.id.numSupporter_edit);

        mNumber = Integer.parseInt (mNumAttendee.getText().toString());
        mSize = Integer.parseInt(mNumSupporter.getText().toString());

        //Button event
        findViewById(R.id.act_button)
                .setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (isEditTextEmpty()) {
            Toast.makeText(this, "Please input all items", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Dutch_Payment_Activity.this, Result_divided_Activity.class);
        intent.putExtra("eventname", mEventName.getText().toString());
        intent.putExtra("totalamount", mTotalAmount.getText().toString());
        intent.putExtra("totalsupportamount", mTotalSupportAmount.getText().toString());
        intent.putExtra("numattendee", mNumAttendee.getText().toString());
        intent.putExtra("numsupporter", mNumSupporter.getText().toString());

        startActivityForResult(intent, 1000);

    }

    private boolean isEditTextEmpty() {
        return TextUtils.isEmpty(mEventName.getText().toString()) ||
                TextUtils.isEmpty(mTotalAmount.getText().toString()) ||
                TextUtils.isEmpty(mTotalSupportAmount.getText().toString()) ||
                TextUtils.isEmpty(mNumAttendee.getText().toString()) ||
                TextUtils.isEmpty(mNumSupporter.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && requestCode == RESULT_OK) {
            Toast.makeText(this, "you have clicked the CONFIRMATION Button"
                    , Toast.LENGTH_SHORT).show();
        }
    }
}









