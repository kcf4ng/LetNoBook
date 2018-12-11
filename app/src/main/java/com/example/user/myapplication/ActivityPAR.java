package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityPAR extends AppCompatActivity {

    private Button btn聯絡事項;
    private Button btn通知事項;
    private Button btn班級課表;
    private Button btn即時聊天;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par);

        btn通知事項 = findViewById(R.id.btn家長通知事項);
        btn通知事項.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open家長通知事項();
            }
        });

        btn聯絡事項 = findViewById(R.id.btn家長聯絡事項);
        btn聯絡事項.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open家長聯絡事項();
            }
        });

        btn班級課表 = findViewById(R.id.btn家長班級課表);
        btn班級課表.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open家長班級課表();
            }
        });

        btn即時聊天 = findViewById(R.id.btn家長即時聊天);
        btn即時聊天.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open家長即時聊天();
            }
        });

    }



    public void open家長即時聊天() {
        Intent intent = new Intent(this, ActivityParChat.class);
        startActivity(intent);
    }

    public void open家長班級課表() {
        Intent intent = new Intent (this, ActivityParSyllabus.class);
        startActivity(intent);
    }

    public void open家長聯絡事項() {
        Intent intent = new Intent(this,ActivityParContact.class);
        startActivity(intent);
    }

    public void open家長通知事項() {
        Intent intent = new Intent(this,ActivityParInfo.class);
        startActivity(intent);
    }
}
