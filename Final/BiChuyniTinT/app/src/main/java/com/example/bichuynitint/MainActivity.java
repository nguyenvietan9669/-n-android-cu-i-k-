package com.example.bichuynitint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ednhap;
    Spinner sptiente1,sptiente2;
    Button btnhoandoi,btnchuyen;
    TextView tvtiendoi,tvtienduocdoi,tvkq1,tvkq2;
    ArrayList<QuocGia> arrayList1,arrayList2;
    QuocGiaAdapter quocGiaAdapter1,quocGiaAdapter2;
    String ten1,ten2;
    int i,y;
    double tienvn,tiennn,ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        adddanhsach();
        quocGiaAdapter1 = new QuocGiaAdapter(this,R.layout.dong_spinner,arrayList1);
        sptiente1.setAdapter(quocGiaAdapter1);
        quocGiaAdapter2 = new QuocGiaAdapter(this,R.layout.dong_spinner,arrayList2);
        sptiente2.setAdapter(quocGiaAdapter2);

        btnhoandoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sptiente1.setSelection(y);
                sptiente2.setSelection(i);
            }
        });

        sptiente1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ten1 = arrayList1.get(position).getTen();
                i = position;
                if(ten1 == "AUD"){
                    tienvn = 16212.63;
                }
                if(ten1 == "CAD"){
                    tienvn = 17258.66;
                }
                if(ten1 == "CHF"){
                    tienvn = 24882.42;
                }
                if(ten1 == "CNY"){
                    tienvn = 3348.01;
                }
                if(ten1 == "DKK"){
                    tienvn = 3560.82;
                }
                if(ten1 == "EUR"){
                    tienvn = 26687.62;
                }
                if(ten1 == "GBP"){
                    tienvn = 29227.05;
                }
                if(ten1 == "HKD"){
                    tienvn = 3041.68;
                }
                if(ten1 == "INR"){
                    tienvn = 318.07;
                }
                if(ten1 == "JPY"){
                    tienvn = 219.75;
                }
                if(ten1 == "KRW"){
                    tienvn = 20.38;
                }
                if(ten1 == "KWD"){
                    tienvn = 78200.12;
                }
                if(ten1 == "MYR"){
                    tienvn = 5473.64;
                }
                if(ten1 == "NOK"){
                    tienvn = 2448.65;
                }
                if(ten1 == "RUB"){
                    tienvn = 372.99;
                }
                if(ten1 == "SAR"){
                    tienvn = 6415.21;
                }
                if(ten1 == "SEK"){
                    tienvn = 2539.67;
                }
                if(ten1 == "SGD"){
                    tienvn = 16941.15;
                }
                if(ten1 == "THB"){
                    tienvn = 765.23;
                }
                if(ten1 == "USD"){
                    tienvn = 23300.00;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sptiente2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ten2 = arrayList2.get(position).getTen();
                y = position;
                if(ten2 == "AUD"){
                    tiennn = 0.00006272;
                }
                if(ten2 == "CAD"){
                    tiennn = 0.00005892;
                }
                if(ten2 == "CHF"){
                    tiennn = 0.00004081;
                }
                if(ten2 == "CNY"){
                    tiennn = 0.0003047;
                }
                if(ten2 == "DKK"){
                    tiennn = 0.000286;
                }
                if(ten2 == "EUR"){
                    tiennn = 0.00003838;
                }
                if(ten2 == "GBP"){
                    tiennn = 0.00003489;
                }
                if(ten2 == "HKD"){
                    tiennn = 0.0003337;
                }
                if(ten2 == "INR"){
                    tiennn = 0.003256;
                }
                if(ten2 == "JPY"){
                    tiennn = 0.004614;
                }
                if(ten2 == "KRW"){
                    tiennn = 0.05182;
                }
                if(ten2 == "KWD"){
                    tiennn = 0.00001326;
                }
                if(ten2 == "MYR"){
                    tiennn = 0.0001839;
                }
                if(ten2 == "NOK"){
                    tiennn = 0.0004186;
                }
                if(ten2 == "RUB"){
                    tiennn = 0.003004;
                }
                if(ten2 == "SAR"){
                    tiennn = 0.0001615;
                }
                if(ten2 == "SEK"){
                    tiennn = 0.0004019;
                }
                if(ten2 == "SGD"){
                    tiennn = 0.00005998;
                }
                if(ten2 == "THB"){
                    tiennn = 0.00133;
                }
                if(ten2 == "USD"){
                    tiennn = 0.00004305;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ketqua();

    }

    private void ketqua(){
        btnchuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = ednhap.getText().toString();
                int kiemtranhap = ednhap.length();
                if(kiemtranhap == 0)
                {
                    Toast.makeText(MainActivity.this,"Mời nhập số tiền cần chuyển đổi",Toast.LENGTH_LONG).show();
                }
                if(kiemtranhap != 0) {
                    double tien = Double.parseDouble(value);
                    ketqua = tien*tienvn*tiennn;
                    double tiendoi1 = 1*tienvn*tiennn;
                    double tiendoi2 = 1/(tiendoi1);
                    String gan = String.valueOf(ketqua);
                    String gan1 = String.valueOf(tiendoi1);
                    String gan2 = String.valueOf(tiendoi2);
                    String tienduocdoi = gan +" "+ ten2 ;
                    String tiendoi = value +" " + ten1 +" = ";

                    String kq1 = " 1 " + ten1 +" = "+ gan1 +" "+ ten2;
                    String kq2 = " 1 " + ten2 +" = "+ gan2 +" "+ ten1;
                    tvtiendoi.setText(tiendoi);
                    tvtienduocdoi.setText(tienduocdoi);
                    tvkq1.setText(kq1);
                    tvkq2.setText(kq2);
                }
            }
        });
    }

    private void adddanhsach(){
        arrayList1 = new ArrayList<QuocGia>();
        arrayList1.add(new QuocGia(R.drawable.uc,"AUD"));
        arrayList1.add(new QuocGia(R.drawable.canadian,"CAD"));
        arrayList1.add(new QuocGia(R.drawable.thuysi,"CHF"));
        arrayList1.add(new QuocGia(R.drawable.china,"CNY"));
        arrayList1.add(new QuocGia(R.drawable.danmach,"DKK"));
        arrayList1.add(new QuocGia(R.drawable.euro,"EUR"));
        arrayList1.add(new QuocGia(R.drawable.anh,"GBP"));
        arrayList1.add(new QuocGia(R.drawable.hongkong,"HKD"));
        arrayList1.add(new QuocGia(R.drawable.indian,"INR"));
        arrayList1.add(new QuocGia(R.drawable.japan,"JPY"));
        arrayList1.add(new QuocGia(R.drawable.korean,"KRW"));
        arrayList1.add(new QuocGia(R.drawable.kuwait,"KWD"));
        arrayList1.add(new QuocGia(R.drawable.malaysia,"MYR"));
        arrayList1.add(new QuocGia(R.drawable.nauy,"NOK"));
        arrayList1.add(new QuocGia(R.drawable.nga,"RUB"));
        arrayList1.add(new QuocGia(R.drawable.iran,"SAR"));
        arrayList1.add(new QuocGia(R.drawable.thuydien,"SEK"));
        arrayList1.add(new QuocGia(R.drawable.singapore,"SGD"));
        arrayList1.add(new QuocGia(R.drawable.thailan,"THB"));
        arrayList1.add(new QuocGia(R.drawable.hoaky,"USD"));

        arrayList2 = new ArrayList<QuocGia>();
        arrayList2.add(new QuocGia(R.drawable.uc,"AUD"));
        arrayList2.add(new QuocGia(R.drawable.canadian,"CAD"));
        arrayList2.add(new QuocGia(R.drawable.thuysi,"CHF"));
        arrayList2.add(new QuocGia(R.drawable.china,"CNY"));
        arrayList2.add(new QuocGia(R.drawable.danmach,"DKK"));
        arrayList2.add(new QuocGia(R.drawable.euro,"EUR"));
        arrayList2.add(new QuocGia(R.drawable.anh,"GBP"));
        arrayList2.add(new QuocGia(R.drawable.hongkong,"HKD"));
        arrayList2.add(new QuocGia(R.drawable.indian,"INR"));
        arrayList2.add(new QuocGia(R.drawable.japan,"JPY"));
        arrayList2.add(new QuocGia(R.drawable.korean,"KRW"));
        arrayList2.add(new QuocGia(R.drawable.kuwait,"KWD"));
        arrayList2.add(new QuocGia(R.drawable.malaysia,"MYR"));
        arrayList2.add(new QuocGia(R.drawable.nauy,"NOK"));
        arrayList2.add(new QuocGia(R.drawable.nga,"RUB"));
        arrayList2.add(new QuocGia(R.drawable.iran,"SAR"));
        arrayList2.add(new QuocGia(R.drawable.thuydien,"SEK"));
        arrayList2.add(new QuocGia(R.drawable.singapore,"SGD"));
        arrayList2.add(new QuocGia(R.drawable.thailan,"THB"));
        arrayList2.add(new QuocGia(R.drawable.hoaky,"USD"));
    }

    private void Anhxa() {
        ednhap = (EditText) findViewById(R.id.ednhapsotien);
        sptiente1 = (Spinner) findViewById(R.id.sptiente1);
        sptiente2 = (Spinner) findViewById(R.id.sptiente2);
        btnchuyen = (Button) findViewById(R.id.btndoi);
        btnhoandoi =(Button) findViewById(R.id.btnhoandoi);
        tvtiendoi = (TextView) findViewById(R.id.tiendoi);
        tvtienduocdoi = (TextView) findViewById(R.id.tienduocdoi);
        tvkq1 = (TextView) findViewById(R.id.kq1);
        tvkq2 = (TextView) findViewById(R.id.kq2);
    }
}