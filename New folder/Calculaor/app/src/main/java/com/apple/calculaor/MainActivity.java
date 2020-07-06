package com.apple.calculaor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {
    Button btnDel, btnNgoac, btnPhanTram, btnChia, btn7, btn8, btn9, btnNhan, btn4, btn5, btn6, btnTru, btn1, btn2, btn3, bntCong, btn0, btnDot, bntBang;
    TextView textViewIn, textViewOut;
    String process;
    boolean check=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.bnt0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        bntCong = findViewById(R.id.bntCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

        btnNgoac = findViewById(R.id.btnNgoac);
        btnDel = findViewById(R.id.btnDel);
        btnDot = findViewById(R.id.bntDot);
        btnPhanTram = findViewById(R.id.btnPhanTram);
        bntBang = findViewById(R.id.bntBang);

        textViewIn = findViewById(R.id.textViewIn);
        textViewOut = findViewById(R.id.textViewOut);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewIn.setText("");
                textViewOut.setText("");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "8");
            }
        })
        ;btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "9");
            }
        });
        bntCong.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "+");
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "-");
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "x");
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "÷");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + ".");
            }
        });
        btnPhanTram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "%");
            }
        });
        bntBang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process = textViewIn.getText().toString();

                process = process.replaceAll("x","*");
                process = process.replaceAll("÷","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalRep = "";
                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalRep = rhino.evaluateString(scriptable, process, "javascript",1,null).toString();
                }catch (Exception e){
                    finalRep="0";
                }
                textViewOut.setText(finalRep);
            }
        });
        btnNgoac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if (check){
                    process = textViewIn.getText().toString();
                    textViewIn.setText(process + ")");
                    check=false;
                }else{
                    process = textViewIn.getText().toString();
                    textViewIn.setText(process + "(");
                    check=true;
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.submenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Lịch sử Fragment", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Chọn giao diện Fragment", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Gửi phản hồi Fragment", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item4:
                Toast.makeText(this, "Trợ giúp Fragment", Toast.LENGTH_LONG).show();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
