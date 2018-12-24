package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class ActivitySetting extends AppCompatActivity {
    Intent intent;
    //虛擬Bar-返回鍵 : 至首頁
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        intent = new Intent(ActivitySetting.this, MainActivity.class);
        startActivity(intent);
        ActivitySetting.this.finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //繼承AppCompatActivity要用↓達成全屏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}
