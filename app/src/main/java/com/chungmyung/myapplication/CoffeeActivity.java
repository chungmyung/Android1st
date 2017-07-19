package com.chungmyung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class CoffeeActivity extends AppCompatActivity {
   // 메인
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 레이아웃 설정
        setContentView(R.layout.activity_coffee);
        //xml에 있은 view의 레퍼런스를 가져오는 방법
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        quantityTextView.setText("10");
    }




    public void submitOrder(View view){
        int quantity = 0;
        String priceMessage = "Price $" + (quantity * 5);
        displayMessage(priceMessage);
    }

    private void displayPrice(int i) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + i);
    }

    private void display(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void minusButtonClicked(View view) {
        Toast.makeText(this, "잘눌림", Toast.LENGTH_SHORT).show();
    }

    public void plusButtonClicked(View view) {
        Toast.makeText(this, "잘눌림", Toast.LENGTH_SHORT).show();
    }
}
