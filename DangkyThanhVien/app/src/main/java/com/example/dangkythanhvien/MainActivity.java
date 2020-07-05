package com.example.dangkythanhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_NumBer =
            Pattern.compile("^"+
                    "(?=.*[0-9])"+
                    ".{8,}"+
                    "$");
    private static final Pattern PASSWORD_Lower =
            Pattern.compile("^"+
                    "(?=.*[a-z])"+
                    ".{8,}"+
                    "$");
    private static final Pattern PASSWORD_Upper =
            Pattern.compile("^"+
                    "(?=.*[A-Z])"+
                    ".{8,}"+
                    "$");
    private static final Pattern PASSWORD_Special =
            Pattern.compile("^"+
                    "(?=.*[!@#$%^&*()-_=+`~{}|':<.>,?/])"+
                    ".{8,}"+
                    "$");
    private static final Pattern PASSWORD_Specialuser =
            Pattern.compile("^"+
                    "(?=.*[!@#$%^&*()-_=+`~{}|':<.>,?/])"+
                    ".{0,128}"+
                    "$");
    EditText edten,eduser,edpass,edngaysinh;
    RadioButton rbnam,rbnu;
    Spinner spquoctich;
    Button btntao;
    String ten;
    boolean isnull=false,ktuser=false,ktpass=false,gt=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btntao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isnull();
                checkuser();
                checkpass();
                check();
                if(isnull==true&&ktuser==true&&ktpass==true&&gt==true){
                    ten = edten.getText().toString();
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("tenne",ten);
                    startActivity(intent);
                }
            }
        });
    }


    private void check(){
        if(!rbnam.isChecked()&&!rbnu.isChecked())
        {
            Toast.makeText(MainActivity.this,"Mời chọn giới tính",Toast.LENGTH_LONG).show();
        }
        else {
            gt = true;
        }
    }
    private void isnull(){
        if(edten.length()==0||eduser.length()==0||edpass.length()==0||edngaysinh.length()==0){
            Toast.makeText(MainActivity.this,"Mời điền đầy đủ thông tin và thử lại !!",Toast.LENGTH_LONG).show();
            isnull = false;
        }
        else {
            isnull = true;
        }
    }
    private void checkuser(){
        String checkuser = eduser.getText().toString();
        if(checkuser.contains(" ")){
            Toast.makeText(MainActivity.this,"User không được chứa khoảng trống !!",Toast.LENGTH_LONG).show();
            ktuser=false;
        }
        else if(PASSWORD_Specialuser.matcher(checkuser).matches()){
            Toast.makeText(MainActivity.this,"User không được chứa ký tự đặc biệt !!",Toast.LENGTH_LONG).show();
            ktuser=false;
        }
        else if(checkuser.length()>128){
            Toast.makeText(MainActivity.this,"User không được quá dài !!",Toast.LENGTH_LONG).show();
            ktuser=false;
        }
        else {
            ktuser = true;
        }
    }
    private void checkpass(){
        String checkpass = edpass.getText().toString();
        if(checkpass.length()<8) {
            Toast.makeText(MainActivity.this,"PassWord phải có ít nhất 8 kí tự !!",Toast.LENGTH_LONG).show();
            ktpass = false;
        }
        else if(!PASSWORD_Special.matcher(checkpass).matches()){
            Toast.makeText(MainActivity.this,"PassWord phải có ít nhất 1 kí đặc biệt !!",Toast.LENGTH_LONG).show();
            ktpass = false;
        }
        else if(!PASSWORD_Lower.matcher(checkpass).matches()){
            Toast.makeText(MainActivity.this,"PassWord phải có ít nhất 1 chữ thường !!",Toast.LENGTH_LONG).show();
            ktpass = false;
        }
        else if(!PASSWORD_Upper.matcher(checkpass).matches()){
            Toast.makeText(MainActivity.this,"PassWord phải có ít nhất 1 chữ In hoa !!",Toast.LENGTH_LONG).show();
            ktpass = false;
        }
        else if(!PASSWORD_NumBer.matcher(checkpass).matches()){
            Toast.makeText(MainActivity.this,"PassWord phải có ít nhất 1 chữ kí tự số!!",Toast.LENGTH_LONG).show();
            ktpass = false;
        }
        else {
            ktpass = true;
        }
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
}