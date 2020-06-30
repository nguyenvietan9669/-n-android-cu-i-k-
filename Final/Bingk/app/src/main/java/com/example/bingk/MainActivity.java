package com.example.bingk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edten,eduser,edpass,edngaysinh;
    RadioButton rbnam,rbnu;
    Spinner spquoctich;
    Button btntao;
    boolean isnull=false,pass=false,user=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();

        btntao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kiemtranull();
                kiemtrauser();
                kiemtrapass();
                String ten = edten.getText().toString();
                if(isnull== false&&pass==false && user==false) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("ten", ten);
                    startActivity(intent);
                }
            }
        });
    }

    private void Anhxa() {
        edten = (EditText) findViewById(R.id.edten);
        eduser = (EditText) findViewById(R.id.eduser);
        edpass = (EditText) findViewById(R.id.edpass);
        edngaysinh = (EditText) findViewById(R.id.edngaysinh);
        rbnam = (RadioButton) findViewById(R.id.gbnam);
        rbnu = (RadioButton) findViewById(R.id.gbnu);
        spquoctich = (Spinner) findViewById(R.id.spquoctich);
        btntao = (Button) findViewById(R.id.btntao);
    }

    private void kiemtranull(){
        if(edten.length()==0||eduser.length()==0||edngaysinh.length()==0){
            Toast.makeText(this,"Thông tin không được trống,mời điền đầy đủ thông tin và thử lại !!",Toast.LENGTH_LONG).show();
            isnull = true;
        }
        else {
            isnull =false;
        }
    }


    private void kiemtrauser(){
        String kiemtra = eduser.getText().toString();
        if(kiemtra.length()>128){
            Toast.makeText(this,"Số lượng ký tự quá lớn,mời nhập lại",Toast.LENGTH_LONG).show();
            user = true;
        }
        else if(kiemtra.contains(" "))
        {
            Toast.makeText(MainActivity.this,"Có khoảng trắng trong user Name",Toast.LENGTH_LONG).show();
            user = true;
        }
        else if(kiemtra.contains("!")||kiemtra.contains("@")||kiemtra.contains("#")
                ||kiemtra.contains("$")||kiemtra.contains("%")||kiemtra.contains("^")
                ||kiemtra.contains("&")||kiemtra.contains("*")||kiemtra.contains("(")
                ||kiemtra.contains(")")||kiemtra.contains("_")||kiemtra.contains("-")
                ||kiemtra.contains("=")||kiemtra.contains("~")||kiemtra.contains("`")
                ||kiemtra.contains("{")||kiemtra.contains("}")||kiemtra.contains("[")
                ||kiemtra.contains("]")||kiemtra.contains(":")||kiemtra.contains(";")
                ||kiemtra.contains("'")||kiemtra.contains("<")||kiemtra.contains(">")
                ||kiemtra.contains(",")||kiemtra.contains(".")||kiemtra.contains("/")
                ||kiemtra.contains("|")||kiemtra.contains("?"))
        {
            Toast.makeText(MainActivity.this,"Có kí tự đặc biệt trong user Name",Toast.LENGTH_LONG).show();
            user = true;
        }
        else {
            user = false;
        }
    }

    private void kiemtrapass(){
        String kiemtra = edpass.getText().toString();
        if(kiemtra.length()<8){
            Toast.makeText(this,"Mật khẩu phải chứa ít nhất 8 ký tự",Toast.LENGTH_LONG).show();
            pass = true;
        }
        if(kiemtra.contains("1")||kiemtra.contains("2")||kiemtra.contains("3")||kiemtra.contains("4")||kiemtra.contains("5")||
                kiemtra.contains("6")||kiemtra.contains("7")||kiemtra.contains("8")||kiemtra.contains("9"))
        {
            pass = false;
        }
        else {
            Toast.makeText(MainActivity.this,"Mật khẩu phải chứa 1 kí tự số",Toast.LENGTH_LONG).show();
            pass = true;
        }
        if(kiemtra.contains("!")||kiemtra.contains("@")||kiemtra.contains("#")
                ||kiemtra.contains("$")||kiemtra.contains("%")||kiemtra.contains("^")
                ||kiemtra.contains("&")||kiemtra.contains("*")||kiemtra.contains("(")
                ||kiemtra.contains(")")||kiemtra.contains("_")||kiemtra.contains("-")
                ||kiemtra.contains("=")||kiemtra.contains("~")||kiemtra.contains("`")
                ||kiemtra.contains("{")||kiemtra.contains("}")||kiemtra.contains("[")
                ||kiemtra.contains("]")||kiemtra.contains(":")||kiemtra.contains(";")
                ||kiemtra.contains("'")||kiemtra.contains("<")||kiemtra.contains(">")
                ||kiemtra.contains(",")||kiemtra.contains(".")||kiemtra.contains("/")
                ||kiemtra.contains("|")||kiemtra.contains("?"))
        {
            pass =false;
        }
        else {
            Toast.makeText(MainActivity.this,"mật khẩu cần có 1 ký tự đặc biệt",Toast.LENGTH_LONG).show();
            pass = true;
        }
        if(kiemtra.contains("Q")||kiemtra.contains("W")||kiemtra.contains("E")
                ||kiemtra.contains("R")||kiemtra.contains("T")||kiemtra.contains("Y")
                ||kiemtra.contains("U")||kiemtra.contains("I")||kiemtra.contains("O")
                ||kiemtra.contains("P")||kiemtra.contains("A")||kiemtra.contains("S")
                ||kiemtra.contains("D")||kiemtra.contains("F")||kiemtra.contains("G")
                ||kiemtra.contains("H")||kiemtra.contains("J")||kiemtra.contains("K")
                ||kiemtra.contains("L")||kiemtra.contains("Z")||kiemtra.contains("X")
                ||kiemtra.contains("C")||kiemtra.contains("V")||kiemtra.contains("B")
                ||kiemtra.contains("N")||kiemtra.contains("M")||kiemtra.contains("Ư")
                ||kiemtra.contains("Ô")||kiemtra.contains("Ơ")||kiemtra.contains("Ê")
                ||kiemtra.contains("Â"))
        {
            pass = false;
        }
        else
        {
            Toast.makeText(MainActivity.this,"Mật khẩu phải chứa 1 kí tự In hoa",Toast.LENGTH_LONG).show();
            pass = true;
        }
        if(kiemtra.contains("q")||kiemtra.contains("w")||kiemtra.contains("e")
                ||kiemtra.contains("r")||kiemtra.contains("t")||kiemtra.contains("y")
                ||kiemtra.contains("u")||kiemtra.contains("i")||kiemtra.contains("o")
                ||kiemtra.contains("p")||kiemtra.contains("a")||kiemtra.contains("s")
                ||kiemtra.contains("d")||kiemtra.contains("f")||kiemtra.contains("g")
                ||kiemtra.contains("h")||kiemtra.contains("j")||kiemtra.contains("k")
                ||kiemtra.contains("l")||kiemtra.contains("z")||kiemtra.contains("x")
                ||kiemtra.contains("c")||kiemtra.contains("v")||kiemtra.contains("b")
                ||kiemtra.contains("n")||kiemtra.contains("m")||kiemtra.contains("ư")
                ||kiemtra.contains("ô")||kiemtra.contains("ơ")||kiemtra.contains("ê")
                ||kiemtra.contains("â"))
        {
            pass =false;
        }
        else
        {
            Toast.makeText(MainActivity.this,"Mật khẩu phải chứa 1 kí tự thường",Toast.LENGTH_LONG).show();
            pass = true;
        }
    }
}