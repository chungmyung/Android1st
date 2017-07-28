package com.chungmyung.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SalesActivity extends AppCompatActivity implements View.OnClickListener {
    private String mMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        findViewById(R.id.customer_button).setOnClickListener(this);
        findViewById(R.id.salesamount_button).setOnClickListener(this);
        findViewById(R.id.item_button).setOnClickListener(this);


        findViewById(R.id.result2_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        if (getIntent() != null) {
            String id = getIntent().getStringExtra("id");
            String password = getIntent().getStringExtra("password");
            Toast.makeText(this, id + "," + password, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        String text = ((Button) v).getText().toString();
        intent.putExtra("text", text);
        setResult(RESULT_OK, intent);
        finish();
    }
}
