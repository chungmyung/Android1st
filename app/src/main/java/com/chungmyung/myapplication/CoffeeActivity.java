package com.chungmyung.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


//        모든 리소스는 내부적으로 int임으로 숫자를 인수에 직접쓰면 안된다.
//        mQuantityTextView.setText("10"); // 직접 TextView에 있는 숫자를 바꾼는 code
//        mQuantityTextView.setText(String.valueOf(mQuantity));  택스트 를  글자로 바꾸는 방법
//        mQuantityTextView.setText("" + mQuantity);  가장 쉬운 방법,문자열과 숫자가 같이 나오면 문자열로 바뀜


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
        message += "\n 가격 : " + String.format(getString(R.string.result_price),
                mFormat.format(mQuantity * COFFEE_PRICE) );

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
     // 메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_coffee, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_item1:
                Toast.makeText(this,"메뉴 1 번 표시",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_item2:
                startActivity(new Intent(this,BasketballActivity.class));
                return true;
            case R.id.action_item3:
                startActivity(new Intent(this,ActivityMoveActivity.class));
                return true;
            case R.id.action_item4:
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void order(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        // 보내는 방법 2.//    intent.setAction(Intent.ACTION_SENDTO);


       // intent.setType("text/plain"); 필요 없는 부분
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{ "mkcjsk@gmail.com","mkcjsk@outlook.kr"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "주문 입니다!!!");
        intent.putExtra(Intent.EXTRA_TEXT, mPriceTextView.getText().toString());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }


}



