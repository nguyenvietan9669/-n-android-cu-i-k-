package com.example.dangkythanhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView tvten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvten = (TextView) findViewById(R.id.ten);
        Intent intent = getIntent();
        String ten =intent.getStringExtra("tenne");
        tvten.setText(ten);
    }
}