package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityStu extends AppCompatActivity {

    private Button btn班級課表;
    private Button btn聯絡事項;
    private Button btn通知事項;
    private Button btn學生日誌;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu);

        btn班級課表 =  findViewById(R.id.btn學生班級課表);
        btn班級課表.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open學生班級課表();
            }
        });

        btn通知事項 =  findViewById(R.id.btn學生通知事項);
        btn通知事項.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open學生通知事項();
            }
        });

        btn聯絡事項 =  findViewById(R.id.btn學生聯絡事項);
        btn聯絡事項.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              open學生聯絡事項();
            }
        });

        btn學生日誌=  findViewById(R.id.btn學生日誌編輯);
        btn學生日誌.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open學生日誌編輯();
            }
        });


    }

    public void open學生日誌編輯() {
        Intent intent = new Intent(this,ActivityStuDiary.class);
        startActivity(intent);

    }


    public void open學生聯絡事項() {
        Intent intent = new Intent(this,ActivityStuContact.class);
        startActivity(intent);
    }

    public void open學生通知事項() {
        Intent intent = new Intent(this,ActivityStuInfo.class);
        startActivity(intent);

    }

    public void open學生班級課表() {
        Intent intent = new Intent(this,ActivityStuClassSyllabus.class);
        startActivity(intent);

    }
}
