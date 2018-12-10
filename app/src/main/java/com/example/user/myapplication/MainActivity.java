package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn校園公告 ;
    private Button btn校園介紹 ;
    private Button btn校園聯絡 ;
    private Button btn登入 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn校園公告 = findViewById(R.id.btn校園公告);
        btn校園公告.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        btn校園介紹 = findViewById(R.id.btn校園介紹);
        btn校園介紹.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        btn校園聯絡 = findViewById(R.id.btn校園聯絡);
        btn校園聯絡.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        btn登入 = findViewById(R.id.btn登入);
        btn登入.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivityLogin();
            }
        });

    }

    public void openActivity2() {
        //校園公告
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
    public void openActivity3() {
        //校園介紹
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void openActivity4() {
        //校園聯絡
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

    public void openActivityLogin() {
        //登入畫面
        Intent intent = new Intent(this, ActivityLogin.class);
        startActivity(intent);
    }

}