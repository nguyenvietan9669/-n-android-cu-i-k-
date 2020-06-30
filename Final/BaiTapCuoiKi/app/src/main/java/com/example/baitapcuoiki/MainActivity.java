package com.example.baitapcuoiki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btntrupizza,btncongpizza,btntruhbg,btnconghbg,btntrubm,btncongbm,btndathang,btnlamlai;
    CheckBox checkTPMpizza,checkgap2phomai,checkgap3phomai,checkTPMhbg,checkthemthitbo,checkthemtrung;
    RadioButton Rddemong,Rddeday,Rddetruyenthong,Rdvienphomai,Rdvienxucxich,Rdopla,Rdthitnguoi,Rdchaca;
    EditText maGiamgia;
    TextView tvSlpizza,tvSlhbg,tvSlbm,tvGiamgia,tvTongtien;
    double congtienpizza,congtienhbg,copngtienbm,tongtien,tienpizza=150000,tienhbg=45000;
    int dem =0 ,demhbg =0,dembm=0,soluongpz,soluonghbg,soluongbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        lamlai();
        check();
        radio();
        soluong();
        String demkt= String.valueOf(dem);
        tvSlpizza.setText(demkt);
        String demktbm = String.valueOf(dembm);
        tvSlbm.setText(demktbm);
        String demkthbg = String.valueOf(demhbg);
        tvSlhbg.setText(demkthbg);
        if(checkTPMhbg.isChecked()||checkgap2phomai.isChecked()||checkgap3phomai.isChecked())
        {}
        else
        {
            congtienpizza = 150000;
        }

        tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
        String tientong = String.valueOf(tongtien);
        tvTongtien.setText(tientong);
    }

    private void soluong() {
        btncongpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dem++;
                soluongpz =dem;
                String demkt= String.valueOf(dem);
                tvSlpizza.setText(demkt);
                tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                String tientong = String.valueOf(tongtien);
                tvTongtien.setText(tientong);
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
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
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
                tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                String tientong = String.valueOf(tongtien);
                tvTongtien.setText(tientong);
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
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
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
                        tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                        String tientong = String.valueOf(tongtien);
                        tvTongtien.setText(tientong);
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
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Số lượng không thể âm",Toast.LENGTH_LONG).show();
                }
            }
        });
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
    private void lamlai()
    {
        btnlamlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTPMpizza.setChecked(false);
                checkgap2phomai.setChecked(false);
                checkgap3phomai.setChecked(false);
                checkTPMhbg.setChecked(false);
                checkthemthitbo.setChecked(false);
                checkthemtrung.setChecked(false);
                Rddemong.setChecked(false);
                Rddeday.setChecked(false);
                Rdchaca.setChecked(false);
                Rddetruyenthong.setChecked(false);
                Rdvienphomai.setChecked(false);
                Rdvienxucxich.setChecked(false);
                Rdopla.setChecked(false);
                Rdthitnguoi.setChecked(false);
                congtienpizza=0;congtienhbg=0;copngtienbm=0;tongtien=0;tienpizza=150000;tienhbg=45000;
                dem =0 ;demhbg =0;dembm=0;soluongpz=0;soluonghbg=0;soluongbm=0;
                tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                String tientong = String.valueOf(tongtien);
                tvTongtien.setText(tientong);
                String demkt= String.valueOf(dem);
                tvSlpizza.setText(demkt);
                String demktbm = String.valueOf(dembm);
                tvSlbm.setText(demktbm);
                String demkthbg = String.valueOf(demhbg);
                tvSlhbg.setText(demkthbg);
            }
        });
    }
    private void check()
    {
        checkTPMpizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkgap3phomai.setChecked(false);
                checkgap2phomai.setChecked(false);
                if(isChecked)
                {
                        congtienpizza = (tienpizza + 10000);
                        tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                        String tientong = String.valueOf(tongtien);
                        tvTongtien.setText(tientong);
                        checkTPMpizza.setChecked(true);
                }
                else
                {
                    congtienpizza = tienpizza;
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
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
                    congtienpizza = (tienpizza + 20000) ;
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                    checkgap2phomai.setChecked(true);
                }
                else
                {
                    congtienpizza = tienpizza ;
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
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
                    congtienpizza = (tienpizza + 30000);
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                    checkgap3phomai.setChecked(true);
                }
                else
                {
                    congtienpizza = tienpizza;
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
            }
        });
        checkTPMhbg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkthemthitbo.setChecked(false);
                checkthemtrung.setChecked(false);
                if (isChecked) {
                    congtienhbg = (tienhbg + 15000);
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                    checkTPMhbg.setChecked(true);
                }
                else {
                    congtienhbg = tienhbg;
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
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
                    congtienhbg = (tienhbg + 35000);
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                    checkthemthitbo.setChecked(true);
                }
                else
                {
                    congtienhbg = tienhbg;
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
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
                    congtienhbg = (tienhbg + 25000);
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                    checkthemtrung.setChecked(true);
                }
                else
                {
                    congtienhbg = tienhbg;
                    tongtien = congtienpizza*soluongpz + congtienhbg*soluonghbg + copngtienbm*soluongbm;
                    String tientong = String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
            }
        });
    }
    private void radio()
    {
        Rddemong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    if(checkTPMpizza.isChecked())
                    {
                        tienpizza+=10000;
                    }
                    if(checkgap2phomai.isChecked())
                    {
                        tienpizza+=20000;
                    }
                    if(checkgap3phomai.isChecked())
                    {
                        tienpizza+=30000;
                    }
                    congtienpizza =tienpizza+ 5000;
                    tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                    String tientong =String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
                else
                {}
            }
        });
        Rddeday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    if(checkTPMpizza.isChecked())
                    {
                        tienpizza+=10000;
                    }
                    if(checkgap2phomai.isChecked())
                    {
                        tienpizza+=20000;
                    }
                    if(checkgap3phomai.isChecked())
                    {
                        tienpizza+=30000;
                    }
                    congtienpizza= tienpizza+8000;
                    tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                    String tientong =String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
                else
                {}
            }
        });
        Rddetruyenthong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    if(checkTPMpizza.isChecked())
                    {
                        tienpizza+=10000;
                    }
                    if(checkgap2phomai.isChecked())
                    {
                        tienpizza+=20000;
                    }
                    if(checkgap3phomai.isChecked())
                    {
                        tienpizza+=30000;
                    }
                    congtienpizza= tienpizza+12000;
                    tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                    String tientong =String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
                else
                {}
            }
        });
        Rdopla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    copngtienbm += 25000;
                    tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                    String tientong =String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
                else
                {
                    copngtienbm-=25000;
                    tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                    String tientong =String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
            }
        });
        Rdthitnguoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    copngtienbm+=50000;
                    tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                    String tientong =String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
                else
                {
                    copngtienbm-=50000;
                    tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                    String tientong =String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
            }
        });
        Rdchaca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    copngtienbm+=30000;
                    tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                    String tientong =String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
                else
                {
                    copngtienbm-=30000;
                    tongtien = congtienpizza * soluongpz + congtienhbg * soluonghbg + copngtienbm * soluongbm;
                    String tientong =String.valueOf(tongtien);
                    tvTongtien.setText(tientong);
                }
            }
        });
    }
}
