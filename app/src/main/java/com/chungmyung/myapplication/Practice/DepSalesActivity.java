package com.chungmyung.myapplication.Practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chungmyung.myapplication.R;

public class DepSalesActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dep_sales);

        findViewById(R.id.manage1_button).setOnClickListener(this);
        findViewById(R.id.manage2_button).setOnClickListener(this);
        findViewById(R.id.manage3_button).setOnClickListener(this);

        findViewById(R.id.confirm_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
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

