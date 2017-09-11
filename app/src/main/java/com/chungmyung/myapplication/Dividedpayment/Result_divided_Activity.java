package com.chungmyung.myapplication.Dividedpayment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.chungmyung.myapplication.R;

import java.util.ArrayList;

public class Result_divided_Activity extends AppCompatActivity {


    private ArrayList<Attendee> mAttendeeAdapter;
    private ArrayList<Supporter> mSupporterAdapter;
    private ListView mAttendeeListView;
    private ListView mSupporterListView;

    private int mNumber;
    private int mSize;
    private int mTotalSpentAmount;
    private int mTotalsupportAmount;
    private int mActualSpentAmout;
    private int mDividedAmountperAttendee;
    private int mAvrgSupportedAmountperSupporter;


    private TextView mMessageTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_divided_);

        mMessageTextView = (TextView) findViewById(R.id.message_text);


        Intent intent = getIntent();
        if (intent != null) {
            String eventName = intent.getStringExtra("eventname");
            String totalAmount = intent.getStringExtra("totalamount");
            String totalSupportAmount = intent.getStringExtra("totalsupportamount");
            String numAttendee = intent.getStringExtra("numattendee");
            String numSupporter = intent.getStringExtra("numsupporter");

            mMessageTextView.setText(eventName + "," + totalAmount + "," + totalSupportAmount + ","
                    + numAttendee + "," + numSupporter + ",");

            int mTotalSpentAmount = Integer.parseInt(totalAmount);
            int mTotalsupportAmount = Integer.parseInt(totalSupportAmount);
            int mNumber = Integer.parseInt(numAttendee);
            int mSize = Integer.parseInt(numSupporter);


            int mActualSpentAmout = mTotalSpentAmount - mTotalsupportAmount;

            int mDividedAmountperAttendee = mActualSpentAmout / mNumber;


            String message = "Event Name " + eventName;
            message += "\n ===============================";
            message += "\n 총 소요 금액 ; " + totalAmount + "원";
            message += "\n 총 후원 금액 ; " + totalSupportAmount + "원";
            message += "\n 총 분담인원수 ; " + numAttendee + "명";
            message += "\n ===============================";
            message += "\n 인당 분담금 ; " + mDividedAmountperAttendee + "원";

            mMessageTextView.setText(message);

        }


        // View

        ListView mAttendeeListView = (ListView) findViewById(R.id.attendee_list);

        ListView mSupporterListView = (ListView) findViewById(R.id.supporter_list);


        // Data
        mAttendeeAdapter = new ArrayList<>();
        for (int i = 0; i < mNumber; i++) {
            Attendee attendee =
                    new Attendee("홍길동" + i, "전화번호" + i, "이메일" + i, "분담금" + mDividedAmountperAttendee);
            mAttendeeAdapter.add(attendee);


            //Adapter for ListView of Attendee
            mAttendeeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Attendee attendee = (Attendee) adapterView.getAdapter().getItem(position);

                    Intent intent = new Intent(Result_divided_Activity.this, Member_Activity.class);
                    intent.putExtra("name", attendee.getName());
                    intent.putExtra("phone", attendee.getPhone());
                    intent.putExtra("email", attendee.getEmail());
                    intent.putExtra("amount", attendee.getAmount());

                    startActivityForResult(intent, 1000);
                }
            });
        }


        //Data for supporter
        mSupporterAdapter = new ArrayList<>();
        for (int j = 0; j < mSize; j++) {
            Supporter supporter =
                    new Supporter("홍길동" + j, "전화번호" + j, "이메일" + j, "지원금(고정분담금)" + j);
        }

        // Adapter for Supporter

        mSupporterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int no, long l) {
                Supporter supporter = (Supporter) parent.getAdapter().getItem(no);

                Intent intents = new Intent(Result_divided_Activity.this, Member_Activity.class);
                intents.putExtra("name", supporter.getName());
                intents.putExtra("phone", supporter.getName());
                intents.putExtra("email", supporter.getName());
                intents.putExtra("amount", supporter.getName());

                startActivityForResult(intents, 2000);
            }
        });


    }
}

