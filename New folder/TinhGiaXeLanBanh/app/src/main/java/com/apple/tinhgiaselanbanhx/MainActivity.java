package com.apple.tinhgiaselanbanhx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edt_Gia_Xe;
    TextView tv_Gia_Dam_Phan,tv_tit_gia_dam_phan,tv_tit_phi_truoc_ba,tv_phi_truoc_ba,tv_phi_duong_bo;
    TextView tv_bh,tv_bs,tv_pdk,tv_tong_cong,tv_tong_cong_2;
    Button btn_tinh_toan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_Gia_Xe = findViewById(R.id.edt_gia_xe);
        tv_Gia_Dam_Phan = findViewById(R.id.tv_gia_dam_phan);
        tv_tit_gia_dam_phan = findViewById(R.id.tv_tit_gia_dam_phan);
        btn_tinh_toan = findViewById(R.id.btn_tinh_toan);
        tv_tit_phi_truoc_ba = findViewById(R.id.tv_tit_phi_truoc_ba);
        tv_phi_truoc_ba = findViewById(R.id.tv_phi_truoc_ba);
        tv_phi_duong_bo = findViewById(R.id.tv_phi_duong_bo);
        tv_bh = findViewById(R.id.tv_bh);
        tv_bs = findViewById(R.id.tv_bs);
        tv_pdk = findViewById(R.id.tv_pdk);
        tv_tong_cong = findViewById(R.id.tv_tong_cong);
        tv_tong_cong_2 = findViewById(R.id.tv_tong_cong_2);

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        String[] itemsX = new String[]{"Xe Du Lịch Dưới 10 Chỗ", "Xe bán Tải", "Xe Tải Nhỏ"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, itemsX);

        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (position) {
                    case 1:
                        Locale localeVN = new Locale("vi", "VN");
                        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                        tv_phi_duong_bo.setText( currencyVN.format(2160000));
                        tv_bh.setText(currencyVN.format(933000));
                        tv_pdk.setText(currencyVN.format(540000));
                        break;
                    case 2:
                        Locale localeVN1 = new Locale("vi", "VN");
                        NumberFormat currencyVN1 = NumberFormat.getCurrencyInstance(localeVN1);
                        tv_phi_duong_bo.setText(currencyVN1.format(2160000));
                        tv_bh.setText(currencyVN1.format(953000));
                        tv_pdk.setText(currencyVN1.format(540000));
                        break;
                    case 0:
                    default:
                        Locale localeVN2 = new Locale("vi", "VN");
                        NumberFormat currencyVN2 = NumberFormat.getCurrencyInstance(localeVN2);
                        tv_phi_duong_bo.setText(currencyVN2.format(794000));
                        tv_bh.setText(currencyVN2.format(1560000));
                        tv_pdk.setText(currencyVN2.format(340000));
                        break;
                }
                Log.v("item", (String) parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        String[] itemsY = new String[]{"TP.HCM", "Đồng Nai", "Bình Dương", "Long An", "Vũng Tàu"};
        ArrayAdapter<String> adapterY = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, itemsY);
        spinner2.setAdapter(adapterY);
        spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (position) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        Locale localeVN = new Locale("vi", "VN");
                        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                        tv_tit_phi_truoc_ba.setText("Phí Trước Bạ(3%)");
                        tv_bs.setText(currencyVN.format(3000000));
                        break;
                    case 0:
                    default:
                        Locale localeVN1 = new Locale("vi", "VN");
                        NumberFormat currencyVN1 = NumberFormat.getCurrencyInstance(localeVN1);
                        tv_tit_phi_truoc_ba.setText("Phí Trước Bạ(10%)");
                        tv_bs.setText(currencyVN1.format(11000000));
                        break;
                }
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        btn_tinh_toan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_Gia_Xe.getText().length()==0){
                    Toast.makeText(MainActivity.this,"Mời nhập giá xe",Toast.LENGTH_LONG).show();
                }
                else {
                    double gia_xe = Double.parseDouble(edt_Gia_Xe.getText().toString());
                    Locale localeVN1 = new Locale("vi", "VN");
                    NumberFormat currencyVN1 = NumberFormat.getCurrencyInstance(localeVN1);
                    tv_Gia_Dam_Phan.setText(currencyVN1.format(gia_xe));

                    int where_spin1 = spinner1.getSelectedItemPosition();
                    int where_spin2 = spinner2.getSelectedItemPosition();

                    if (where_spin2 == 0) {
                        double gia_ptb = ((gia_xe * 10) / 100);
                        Locale localeVN = new Locale("vi", "VN");
                        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                        tv_phi_truoc_ba.setText(currencyVN.format(gia_ptb));
                    } else {
                        double gia_ptb = ((gia_xe * 3) / 100);
                        Locale localeVN = new Locale("vi", "VN");
                        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                        tv_phi_truoc_ba.setText(currencyVN.format(gia_ptb));
                    }

                    if (where_spin1 == 0) {
                        if (where_spin2 == 0) {
                            double ket_qua;
                            ket_qua = gia_xe + ((gia_xe * 10) / 100) + 1560000 + 794000 + 11000000 + 340000;
                            Locale localeVN = new Locale("vi", "VN");
                            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                            tv_tong_cong.setText(currencyVN.format(ket_qua));
                            tv_tong_cong_2.setText(currencyVN.format(ket_qua));
                        } else {
                            double ket_qua;
                            ket_qua = gia_xe + ((gia_xe * 3) / 100) + 1560000 + 794000 + 3000000 + 340000;
                            Locale localeVN = new Locale("vi", "VN");
                            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                            tv_tong_cong.setText(currencyVN.format(ket_qua));
                            tv_tong_cong_2.setText(currencyVN.format(ket_qua));
                        }
                    } else if (where_spin1 == 1) {
                        if (where_spin2 == 0) {
                            double ket_qua;
                            ket_qua = gia_xe + ((gia_xe * 10) / 100) + 2160000 + 933000 + 11000000 + 540000;
                            Locale localeVN = new Locale("vi", "VN");
                            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                            tv_tong_cong.setText(currencyVN.format(ket_qua));
                            tv_tong_cong_2.setText(currencyVN.format(ket_qua));
                        } else {
                            double ket_qua;
                            ket_qua = gia_xe + ((gia_xe * 3) / 100) + 2160000 + 933000 + 3000000 + 540000;
                            Locale localeVN = new Locale("vi", "VN");
                            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                            tv_tong_cong.setText(currencyVN.format(ket_qua));
                            tv_tong_cong_2.setText(currencyVN.format(ket_qua));
                        }
                    } else if (where_spin1 == 2) {
                        if (where_spin2 == 0) {
                            double ket_qua;
                            ket_qua = gia_xe + ((gia_xe * 10) / 100) + 2160000 + 953000 + 11000000 + 540000;
                            String nani = Double.toString(ket_qua);
                            Locale localeVN = new Locale("vi", "VN");
                            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                            tv_tong_cong.setText(currencyVN.format(ket_qua));
                            tv_tong_cong_2.setText(currencyVN.format(ket_qua));
                        } else {
                            double ket_qua;
                            ket_qua = gia_xe + ((gia_xe * 3) / 100) + 2160000 + 953000 + 3000000 + 540000;
                            String nani = Double.toString(ket_qua);
                            Locale localeVN = new Locale("vi", "VN");
                            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                            tv_tong_cong.setText(currencyVN.format(ket_qua));
                            tv_tong_cong_2.setText(currencyVN.format(ket_qua));
                        }
                    } else {
                    }
                }
            }
        });

    }
}
