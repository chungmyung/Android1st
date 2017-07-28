package com.chungmyung.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class CoffeeActivity extends AppCompatActivity {
    public static final int MIN_Quantity = 1;
    public static final int DEFAULT_QUANTITY = 1;
    public static final int COFFEE_PRICE = 3000;

    private TextView mQuantityTextView;
    private TextView mPriceTextView;
    private CheckBox mWippedCreamCheckBox;
    private EditText mNameEditText;
    private int mQuantity = DEFAULT_QUANTITY;

    //    private DecimalFormat mFormat =
    private DecimalFormat mFormat = new DecimalFormat("#,##0.00");


    // 메인
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 레이아웃 설정
        setContentView(R.layout.activity_coffee);

        //xml에 있은 view의 레퍼런스를 가져오는 방법
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        //  mQuantityTextView.setText(String.valuaOf(mQuantity));
        mPriceTextView = (TextView) findViewById(R.id.price_text_view);
        mWippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check);
        mNameEditText = (EditText) findViewById(R.id.name_edit);


//      mQuantityTextView.setText(String.valueOf(mQuantity));
        display();

        if (getIntent() != null) {
            String message = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            mNameEditText.setText(message);

        }
    }
    private void display() {
        mQuantityTextView.setText("" + mQuantity);

        String message = "주문자 :" + mNameEditText.getText().toString();
        message += "\n=====================";
        message += "\n휘핑그림 추가 여부 : " + mWippedCreamCheckBox.isChecked();
        message += "\n 갯수 : " + mQuantity;
        message += "\n 가격 : " + mFormat.format(mQuantity * COFFEE_PRICE) + "원";

        mPriceTextView.setText(message);
    }


    public void minusButtonClicked(View view) {
//        Toast.makeText(this, "잘눌림", Toast.LENGTH_SHORT).show();
        mQuantity--;
        if (mQuantity < MIN_Quantity) {
            mQuantity = MIN_Quantity;
        }
//        mQuantityTextView.setText("" + mQuantity);
//        mPriceTextView.setText(mFormat.format(mQuantity * 3000) + "원");
        display();
    }

    public void plusButtonClicked(View view) {
//        Toast.makeText(this, "잘눌림", Toast.LENGTH_SHORT).show();
        mQuantity++;
//        mQuantityTextView.setText("" + mQuantity);
//        mPriceTextView.setText(mFormat.format(mQuantity * 3000) + "원");
        display();
    }

    public void onCheckBoxClicked(View view) {
//        CheckBox checkBox = (CheckBox) view;
//        Toast.makeText(this, "잘되나?" + checkBox.isChecked(), Toast.LENGTH_SHORT).show();
        display();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_coffee,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_item1:
                return true;
            case R.id.action_item2:
                return true;
            case R.id.action_item3:
                return true;
            case R.id.action_item4:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}



