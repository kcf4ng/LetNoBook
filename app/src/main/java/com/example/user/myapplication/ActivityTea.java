package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTea extends AppCompatActivity {

    private Button btn授課課表;
    private Button btn班級課表;
    private Button btn通知事項;
    private Button btn聯絡事項;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);

        btn授課課表 =  findViewById(R.id.btn老師授課課表);
        btn授課課表.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               open老師授課課表();
            }
        });

        btn班級課表 =  findViewById(R.id.btn老師班級課表);
        btn班級課表.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open老師班級課表();
            }
        });

        btn通知事項 =  findViewById(R.id.btn老師通知事項);
        btn通知事項.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open老師通知事項();
            }
        });

        btn聯絡事項 =  findViewById(R.id.btn老師聯絡事項);
        btn聯絡事項.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open老師聯絡事項();
            }
        });

    }

    public void open老師聯絡事項() {
        Intent intent = new Intent(this, ActivityTeaContact.class);
        startActivity(intent);

    }


    public void open老師通知事項() {
        Intent intent = new Intent(this, ActivityTeaInfo.class);
        startActivity(intent);
    }

    public void open老師班級課表() {
        //班級課表
        Intent intent = new Intent(this, ActivityTeaClassSyllabus.class);
        startActivity(intent);

    }

    public void open老師授課課表() {
        //授課課表
        Intent intent = new Intent(this,ActivityTeaOwnSyllabus.class);
        startActivity(intent);
    }
}
