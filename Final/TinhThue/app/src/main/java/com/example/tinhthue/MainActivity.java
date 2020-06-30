package com.example.tinhthue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spthang,spnam;
    Button btntinhtoan;
    EditText edthunhap,edphuthuoc;
    TextView tvtinhthue,tvTncn;
    double tinhthue,tncn,tiengiam,thunhapchiuthue;
    int ss,ss1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        xetNgay();

        btntinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ss>=7&&ss1>=2020)
                {
                    tiengiam = 11000000;
                    int songphuthuoc = Integer.parseInt((edphuthuoc.getText().toString()));
                    if(songphuthuoc>=1){
                        tiengiam = tiengiam + (4400000*songphuthuoc);
                    }
                }
                else {
                    tiengiam = 9000000;
                    int songphuthuoc = Integer.parseInt((edphuthuoc.getText().toString()));
                    if(songphuthuoc>=1){
                        tiengiam = tiengiam + (3600000*songphuthuoc);
                    }
                }
                tinhThue();
                TNCN();
            }
        });
    }

    private void xetNgay()
    {
        spthang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ss = Integer.parseInt(spthang.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spnam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ss1 = Integer.parseInt(spnam.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void tinhThue(){
        thunhapchiuthue = Double.parseDouble(edthunhap.getText().toString());
        tinhthue = thunhapchiuthue - tiengiam;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(tinhthue);
        tvtinhthue.setText(str1);
    }
    private void TNCN()
    {
        if(tinhthue<=5000000){
            tncn = tinhthue*0.05;
        }
        else if(tinhthue<=10000000){
            tncn = tinhthue*0.1 - 250000;
        }
        else if(tinhthue<=18000000){
            tncn = tinhthue*0.15-750000;
        }
        else  if(tinhthue<=32000000){
            tncn= tinhthue*0.2 - 1650000;
        }
        else if(tinhthue<=52000000){
            tncn= tinhthue*0.25-3250000;
        }
        else if (tinhthue<=80000000){
            tncn = tinhthue*0.3-5850000;
        }
        else{
            tncn = tinhthue*0.35-9850000;
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str2 = currencyVN.format(tncn);
        tvTncn.setText(str2);

    }
    private void Anhxa() {
        spthang = (Spinner) findViewById(R.id.spthang);
        spnam = (Spinner) findViewById(R.id.spnam);
        btntinhtoan = (Button) findViewById(R.id.btntinhtoan);
        edthunhap = (EditText) findViewById(R.id.dethunhapthang);
        edphuthuoc = (EditText) findViewById(R.id.nguoiphuthuoc);
        tvtinhthue = (TextView) findViewById(R.id.tvtinhthue);
        tvTncn = (TextView) findViewById(R.id.tvthuetncn);
    }
}