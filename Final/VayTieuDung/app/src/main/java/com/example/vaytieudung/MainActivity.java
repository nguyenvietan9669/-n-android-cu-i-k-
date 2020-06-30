package com.example.vaytieudung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edthunhap,edchiphi,edtienvay;
    Spinner splaisuat;
    RadioGroup group1,group2,group3;
    RadioButton rb12,rb18,rb24,rb32,rb36,rb42,rb48,rb54,rb62;
    Button btntinhtoan;
    TextView tvketqua;
    int sothang;
    double sotienmuonvay,thunhapthang,chiphiphaitra,tienconlai,tienlai,phantram;
    boolean isnull,kiemtratienvay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        checkradio();
        btntinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kiemtranull();
                if(isnull== false &&kiemtratienvay== false) {
                    sotienmuonvay();
                    tinhthang();
                    tinhphantram();
                    tinhlai();
                }

            }
        });
    }
    private void checkradio(){
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rb12.isChecked()||rb18.isChecked()||rb24.isChecked()) {
                    group2.clearCheck();
                    group3.clearCheck();
                }
            }
        });
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rb32.isChecked()||rb36.isChecked()||rb42.isChecked()) {
                    group1.clearCheck();
                    group3.clearCheck();
                }
            }
        });
        group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rb48.isChecked()||rb54.isChecked()||rb62.isChecked()) {
                    group2.clearCheck();
                    group1.clearCheck();
                }
            }
        });
    }
    private void kiemtranull(){
        if(edthunhap.getText().toString().length()==0){
            Toast.makeText(this,"Mời điền thu nhập tháng của bạn",Toast.LENGTH_LONG).show();
            isnull=true;
        }
        if(edchiphi.getText().toString().length()==0){
            Toast.makeText(this,"Mời điền chi phí phải trả",Toast.LENGTH_LONG).show();
            isnull=true;
        }
        if(edtienvay.getText().toString().length()==0){
            Toast.makeText(this,"Mời điền số tiền cần vay",Toast.LENGTH_LONG).show();
            isnull=true;
        }
        if(rb12.isChecked()||rb18.isChecked()||rb24.isChecked()||rb32.isChecked()||rb36.isChecked()
        ||rb42.isChecked()||rb48.isChecked()||rb54.isChecked()||rb62.isChecked()){
            isnull = false;
        }
        else {
            Toast.makeText(this,"Mời chọn thời gian vay",Toast.LENGTH_LONG).show();
            isnull=true;
        }
    }
    private void Anhxa() {
        edthunhap = (EditText) findViewById(R.id.edthunhapthang);
        edchiphi = (EditText) findViewById(R.id.edchiphi);
        edtienvay = (EditText) findViewById(R.id.edsotienmuon);
        splaisuat = (Spinner) findViewById(R.id.splaisuat);
        rb12 = (RadioButton) findViewById(R.id.rb12);
        rb18 = (RadioButton) findViewById(R.id.rb18);
        rb24 = (RadioButton) findViewById(R.id.rb24);
        rb32 = (RadioButton) findViewById(R.id.rb32);
        rb36 = (RadioButton) findViewById(R.id.rb36);
        rb42 = (RadioButton) findViewById(R.id.rb42);
        rb48 = (RadioButton) findViewById(R.id.rb48);
        rb54 = (RadioButton) findViewById(R.id.rb54);
        rb62 = (RadioButton) findViewById(R.id.rb62);
        btntinhtoan = (Button) findViewById(R.id.btntinhtoan);
        tvketqua = (TextView) findViewById(R.id.tvketqua);
        group1 = (RadioGroup) findViewById(R.id.group1);
        group2 = (RadioGroup) findViewById(R.id.group2);
        group3 = (RadioGroup) findViewById(R.id.group3);
    }

    private void sotienmuonvay(){
        thunhapthang = Double.parseDouble(edthunhap.getText().toString());
        chiphiphaitra = Double.parseDouble(edchiphi.getText().toString());
        sotienmuonvay = Double.parseDouble(edtienvay.getText().toString());
        tienconlai = thunhapthang - chiphiphaitra;
        if(sotienmuonvay > 10*tienconlai){
            Toast.makeText(this,"số tiền muốn vay quá lớn",Toast.LENGTH_LONG).show();
            kiemtratienvay = true;
        }
        else if(sotienmuonvay<20000000){
            Toast.makeText(this,"số tiền muốn vay phải lớn hơn 20tr",Toast.LENGTH_LONG).show();
            kiemtratienvay = true;
        }
    }

    private void tinhthang(){

        if(rb12.isChecked()){
            sothang = 12;
        }
        if(rb18.isChecked()){
            sothang =18;
        }
        if(rb24.isChecked()){
            sothang=24;
        }
        if(rb32.isChecked()){
            sothang=32;
        }
        if(rb36.isChecked()){
            sothang=36;
        }
        if(rb42.isChecked()){
            sothang=42;
        }
        if(rb48.isChecked()){
            sothang=48;
        }
        if(rb54.isChecked()){
            sothang=54;
        }
        if(rb62.isChecked()){
            sothang=62;
        }
    }
    private void tinhphantram(){
        splaisuat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String phantramlai = splaisuat.getItemAtPosition(position).toString();
                if(phantramlai.contains("16%")||phantramlai.isEmpty()){
                    phantram = 0.01333;
                }
                if(phantramlai.contains("17%")){
                    phantram = 0.01416;
                }
                if(phantramlai.contains("18%")){
                    phantram = 0.015;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tienlai = (sotienmuonvay*Math.pow((1+0.01333),sothang)/sothang);
            }
        });
    }
    private void tinhlai(){
        tienlai = (sotienmuonvay*Math.pow((1+phantram),sothang)/sothang);
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str2 = currencyVN.format(tienlai);
        tvketqua.setText(str2);
    }
}