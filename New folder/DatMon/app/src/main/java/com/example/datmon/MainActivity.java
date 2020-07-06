package com.example.datmon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btntrupizza,btncongpizza,btntruhbg,btnconghbg,btntrubm,btncongbm,btndathang,btnlamlai;
    CheckBox checkTPMpizza,checkgap2phomai,checkgap3phomai,checkTPMhbg,checkthemthitbo,checkthemtrung;
    RadioButton Rddemong,Rddeday,Rddetruyenthong,Rdvienphomai,Rdvienxucxich,Rdopla,Rdthitnguoi,Rdchaca;
    EditText maGiamgia;
    TextView tvSlpizza,tvSlhbg,tvSlbm,tvGiamgia,tvTongtien;
    int dem =0 ,demhbg =0,dembm=0,soluongpz,soluonghbg,soluongbm;
    double giamgia=1,TienTong,TienPizza,TienHBG,TienBM,De=0,Gap=0,Them,Loai,Discount;
    private static final double pizza = 150000;
    private static final double hamberger = 45000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        Discount();
        TienPizza();
        TienHBG();
        TienBM();
        soluong();

        btnlamlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(soluongpz>=1||soluonghbg>=1||soluongbm>=1){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"Mời chọn số lượng sản phẩm cần đặt và thử lại !!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void soluong() {
        btncongpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dem++;
                soluongpz =dem;
                String demkt= String.valueOf(dem);
                tvSlpizza.setText(demkt);
                TienPizza = (pizza + De +Gap)*soluongpz;
                TinhTong();
            }
        });
        btntrupizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dem >0) {
                    dem--;
                    soluongpz = dem;
                    String demkt = String.valueOf(dem);
                    tvSlpizza.setText(demkt);
                    TienPizza = (pizza + De +Gap)*soluongpz;
                    TinhTong();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Số lượng không thể âm",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnconghbg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demhbg++;
                soluonghbg = demhbg;
                String demkthbg= String.valueOf(demhbg);
                tvSlhbg.setText(demkthbg);
                TienHBG = (hamberger+Them)*soluonghbg;
                TinhTong();
            }
        });
        btntruhbg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(demhbg >0) {
                    demhbg--;
                    soluonghbg= demhbg;
                    String demkthbg = String.valueOf(demhbg);
                    tvSlhbg.setText(demkthbg);
                    TienHBG = (hamberger+Them)*soluonghbg;

                    TinhTong();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Số lượng không thể âm",Toast.LENGTH_LONG).show();
                }
            }
        });
        btncongbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Rdopla.isChecked()||Rdthitnguoi.isChecked()||Rdchaca.isChecked())
                {
                    dembm++;
                    soluongbm=dembm;
                    String demktbm= String.valueOf(dembm);
                    tvSlbm.setText(demktbm);
                    TienBM = Loai*soluongbm;
                    TinhTong();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Mời chọn loại bánh mì ",Toast.LENGTH_LONG).show();
                }

            }
        });
        btntrubm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dembm >0) {
                    dembm--;
                    soluongpz= dembm;
                    String demktbm = String.valueOf(dembm);
                    tvSlbm.setText(demktbm);
                    TienBM = Loai*soluongbm;

                    TinhTong();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Số lượng không thể âm",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void Discount(){
        String MaDiscount = maGiamgia.getText().toString();
        if(MaDiscount.length()==0){
            giamgia = 0;
            Discount = TienTong*giamgia;
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str2 = "Tiền Được giảm :"+"\n"+ currencyVN.format(Discount);
            tvGiamgia.setText(str2);
            String str1 = "Tiền Phải trả :"+"\n"+currencyVN.format(TienTong);
            tvTongtien.setText(str1);
        }
        else if(MaDiscount.contains("XYZ")){
            giamgia = 0.1;
            Discount = TienTong*giamgia;
            double Tienphaitra =TienTong-Discount;
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str2 = "Tiền Được giảm :"+"\n"+currencyVN.format(Discount);
            tvGiamgia.setText(str2);
            String str1 = "Tiền Phải trả :"+"\n"+currencyVN.format(Tienphaitra);
            tvTongtien.setText(str1);
        }
        else if(MaDiscount.contains("ABC")){
            giamgia = 0.2;
            Discount = TienTong*giamgia;
            double Tienphaitra =TienTong-Discount;
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str2 = "Tiền Được giảm :"+"\n"+currencyVN.format(Discount);
            tvGiamgia.setText(str2);
            String str1 = "Tiền Phải trả :"+"\n"+currencyVN.format(Tienphaitra);
            tvTongtien.setText(str1);
        }
    }

    private void TienPizza(){
        checkTPMpizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkgap3phomai.setChecked(false);
                checkgap2phomai.setChecked(false);
                if(isChecked)
                {
                    Gap = 10000;
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                    checkTPMpizza.setChecked(true);
                }
                else if(!checkgap3phomai.isChecked()&&!checkgap2phomai.isChecked()&&!checkTPMpizza.isChecked()){
                    Gap =0;
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                }
                else
                {
                    TienPizza = (pizza + De +Gap)*soluongpz;
                    TinhTong();
                }

            }
        });
        checkgap2phomai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkTPMpizza.setChecked(false);
                checkgap3phomai.setChecked(false);
                if(isChecked)
                {
                    Gap = 20000;
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                    checkgap2phomai.setChecked(true);
                }
                else if(!checkgap3phomai.isChecked()&&!checkgap2phomai.isChecked()&&!checkTPMpizza.isChecked()){
                    Gap =0;
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                }
                else
                {
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                }

            }
        });
        checkgap3phomai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkgap2phomai.setChecked(false);
                checkTPMpizza.setChecked(false);
                if(isChecked)
                {
                    Gap= 30000;
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                    Discount();
                    checkgap3phomai.setChecked(true);
                }
                else if(!checkgap3phomai.isChecked()&&!checkgap2phomai.isChecked()&&!checkTPMpizza.isChecked()){
                    Gap =0;
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                }
                else
                {
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                    Discount();
                }

            }
        });
        Rddemong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    De = 5000;
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                    Discount();
                }
                else
                {
                    TienPizza = (pizza + De +Gap)*soluongpz;
                    TinhTong();
                    Discount();
                }
            }
        });
        Rddeday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    De = 8000;
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                    Discount();
                }
                else
                {
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                    Discount();
                }
            }
        });
        Rddetruyenthong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    De = 12000;
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                    Discount();
                }
                else
                {
                    TienPizza = (pizza + De +Gap)*soluongpz;

                    TinhTong();
                    Discount();
                }
            }
        });
    }

    private void TienHBG(){
        checkTPMhbg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkthemthitbo.setChecked(false);
                checkthemtrung.setChecked(false);
                if (isChecked) {
                    Them = 15000;
                    TienHBG = (hamberger+Them)*soluonghbg;
                    TinhTong();
                    checkTPMhbg.setChecked(true);
                }
                else if(!checkTPMhbg.isChecked()&&!checkthemthitbo.isChecked()&&!checkthemtrung.isChecked()){
                    Them = 0;
                    TienHBG = (hamberger+Them)*soluonghbg;
                    TinhTong();
                }
                else {
                    TienHBG = (hamberger+Them)*soluonghbg;
                    TinhTong();
                }
            }

        });
        checkthemthitbo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkTPMhbg.setChecked(false);
                checkthemtrung.setChecked(false);
                if(isChecked)
                {
                    Them = 35000;
                    TienHBG = (hamberger+Them)*soluonghbg;

                    TinhTong();
                    checkthemthitbo.setChecked(true);
                }
                else
                {
                    TienHBG = (hamberger+Them)*soluonghbg;

                    TinhTong();
                }

            }
        });
        checkthemtrung.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkthemthitbo.setChecked(false);
                checkTPMhbg.setChecked(false);
                if(isChecked)
                {
                    Them = 25000;
                    TienHBG = (hamberger+Them)*soluonghbg;

                    TinhTong();
                    checkthemtrung.setChecked(true);
                }
                else
                {
                    TienHBG = (hamberger+Them)*soluonghbg;

                    TinhTong();
                }

            }
        });
    }

    private void TienBM(){
        Rdopla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Loai = 25000;
                    TienBM = Loai*soluongbm;

                    TinhTong();
                    Discount();

                }
                else
                {
                    TienBM = Loai*soluongbm;

                    TinhTong();
                    Discount();
                }
            }
        });
        Rdthitnguoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Loai = 50000;
                    TienBM = Loai*soluongbm;

                    TinhTong();
                    Discount();
                }
                else
                {
                    TienBM = Loai*soluongbm;

                    TinhTong();
                    Discount();
                }
            }
        });
        Rdchaca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Loai = 30000;
                    TienBM = Loai*soluongbm;

                    TinhTong();
                    Discount();
                }
                else
                {
                    TienBM = Loai*soluongbm;

                    TinhTong();
                    Discount();
                }
            }
        });
    }

    private void TinhTong(){
        TienTong = (TienPizza+TienHBG+TienBM);
        Discount();
    }

    private void Anhxa() {
        btncongpizza = (Button) findViewById(R.id.btncongpizza);
        btntrupizza = (Button) findViewById(R.id.btntrupizza);
        btnconghbg = (Button) findViewById(R.id.btncongHbg);
        btntruhbg = (Button) findViewById(R.id.btntruHbg);
        btncongbm = (Button) findViewById(R.id.btncongBm);
        btntrubm = (Button) findViewById(R.id.btntruBm);
        btndathang = (Button) findViewById(R.id.btndathang);
        btnlamlai = (Button) findViewById(R.id.btnlamlai);
        checkTPMpizza = (CheckBox) findViewById(R.id.checkthemphomaipizza);
        checkgap2phomai = (CheckBox) findViewById(R.id.checkgap2phomai);
        checkgap3phomai = (CheckBox) findViewById(R.id.checkgap3phomai);
        checkthemthitbo = (CheckBox) findViewById(R.id.checkthemthitbo);
        checkthemtrung = (CheckBox) findViewById(R.id.checkthemtrung);
        checkTPMhbg = (CheckBox) findViewById(R.id.checkthemphomaihamburger);
        Rddemong = (RadioButton) findViewById(R.id.Rddemong);
        Rddeday = (RadioButton) findViewById(R.id.Rddeday);
        Rddetruyenthong = (RadioButton) findViewById(R.id.Rddetruyenthong);
        Rdvienphomai = (RadioButton) findViewById(R.id.Rdvienphomai);
        Rdvienxucxich = (RadioButton) findViewById(R.id.Rdvienxucxich);
        Rdopla = (RadioButton) findViewById(R.id.Rdbanhmiopla);
        Rdthitnguoi = (RadioButton) findViewById(R.id.Rdbanhthitnguoi);
        Rdchaca = (RadioButton) findViewById(R.id.Rdbanhmichaca);
        maGiamgia = (EditText) findViewById(R.id.EdMagiamgia) ;
        tvGiamgia = (TextView) findViewById(R.id.TvGiamgia);
        tvSlbm = (TextView) findViewById(R.id.tvSlBm);
        tvSlhbg = (TextView) findViewById(R.id.tvSlHbg);
        tvSlpizza = (TextView) findViewById(R.id.tvSlpizza);
        tvTongtien = (TextView) findViewById(R.id.TvTongtien);
    }
}