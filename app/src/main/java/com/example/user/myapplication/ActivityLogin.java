package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }

    public void login(View v){
        EditText edUserid = (EditText) findViewById(R.id.userid);
        EditText edPasswd = (EditText) findViewById(R.id.passwd);
        String uid = edUserid.getText().toString();
        String pw = edPasswd.getText().toString();
        if (uid.equals("stu") && pw.equals("stu")){ //登入成功
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ActivityStu.class);
            startActivity(intent);
            finish(); //在第二層主頁點返回鍵，會直接回到主畫面。

        }else if (uid.equals("tea") && pw.equals("tea")){ //登入成功
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ActivityTea.class);
            startActivity(intent);
            finish(); //在第二層主頁點返回鍵，會直接回到主畫面。

        }else if (uid.equals("par") && pw.equals("par")){ //登入成功
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ActivityPAR.class);
            startActivity(intent);
            finish(); //在第二層主頁點返回鍵，會直接回到主畫面。

        }
        else
        { //登入失敗
            new AlertDialog.Builder(this)
                    .setTitle("Atm")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }

    public void cancel(View v){

    }
}
