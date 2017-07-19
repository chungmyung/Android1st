package com.chungmyung.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;


public class CoffeeActivity extends AppCompatActivity {
    public static final int MIN_Quantity = 1;
    private TextView mQuantityTextView;
    private TextView mPriceTextView;
    private int mQuantity = 1;

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
        mQuantityTextView.setText("" + mQuantity);
//        mQuantityTextView.setText(String.valuaOf(mQuantity));
        mPriceTextView = (TextView) findViewById(R.id.price_text_view);
        mPriceTextView.setText("3000");
        mQuantityTextView.setText("" + mQuantity);

    }


    public void minusButtonClicked(View view) {
//        Toast.makeText(this, "잘눌림", Toast.LENGTH_SHORT).show();
        mQuantity--;
        if (mQuantity < MIN_Quantity) {
            mQuantity = MIN_Quantity;
        }
        mQuantityTextView.setText("" + mQuantity);
        mPriceTextView.setText(mFormat.format(mQuantity * 3000) + "원");

    }

    public void plusButtonClicked(View view) {
//        Toast.makeText(this, "잘눌림", Toast.LENGTH_SHORT).show();
        mQuantity++;
        mQuantityTextView.setText("" + mQuantity);
        mPriceTextView.setText(mFormat.format(mQuantity * 3000) + "원");
    }
}
