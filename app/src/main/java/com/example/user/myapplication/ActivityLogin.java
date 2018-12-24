package com.example.user.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {
    //虛擬Bar-返回鍵 : 至首頁
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        intent = new Intent(ActivityLogin.this, MainActivity.class);
        startActivity(intent);
        ActivityLogin.this.finish();
    }

    //宣告全域變數
    EditText txt帳號;
    EditText txt密碼;
    CheckBox ckb記帳密;
    Button btn忘記密碼;
    Button btn登入;
    Button btn取消登入;
    Intent intent;
    String uId ;
    String uPw;
    SharedPreferences sharedPref;
    SharedPreferences.Editor user;
    Boolean isRemember = false;

    //元件初始化
    private void InitialComponent() {
        txt帳號 = findViewById(R.id.txtId);
        txt密碼 = findViewById(R.id.txtPw);
        ckb記帳密 = findViewById(R.id.ckbRmbIdPw);
        btn忘記密碼 = findViewById(R.id.btnForgotIdPw);
        btn忘記密碼.setOnClickListener(btn忘記密碼_click);
        btn登入 = findViewById(R.id.btnLogin);
        btn登入.setOnClickListener(btn登入_click);
        btn取消登入 = findViewById(R.id.btnExit);
        btn取消登入.setOnClickListener(btn取消登入_click);
        sharedPref = getSharedPreferences(CDictionary.LoginAct_userIdPw,MODE_PRIVATE);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //繼承AppCompatActivity要用↓達成全屏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("LottieDemo2","LoginAct設全屏");
        setContentView(R.layout.activity_login);
        Log.d("LottieDemo2","LoginAct初始化");
        InitialComponent();


        ckb記帳密.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged
                    (CompoundButton buttonView, boolean isChecked) {
                isRemember = isChecked;
            }
        });
        SharedPreferences table = getSharedPreferences(CDictionary.LoginAct_userIdPw,MODE_PRIVATE);
        SharedPreferences.Editor row = table.edit();
        txt帳號.setText(table.getString(CDictionary.LoginAct_userId, null));
        txt密碼.setText(table.getString(CDictionary.LoginAct_userPw, null));
        ckb記帳密.setChecked(table.getBoolean("Remember", true));
        if(ckb記帳密.isChecked()){
            txt帳號.setText(table.getString(CDictionary.LoginAct_userId, null));
            txt密碼.setText(table.getString(CDictionary.LoginAct_userPw, null));
        }else{
            txt帳號.setText(null);
            txt密碼.setText(null);
        }
        Log.d("LottieDemo2","LoginAct載入帳密(若使用者有選擇記住帳密)");

    }
    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences table = getSharedPreferences(CDictionary.LoginAct_userIdPw, MODE_PRIVATE);
        SharedPreferences.Editor row = table.edit();

        String userId = txt帳號.getText().toString();
        String userPw = txt密碼.getText().toString();
        row.putString(CDictionary.LoginAct_userId, userId);
        row.putString(CDictionary.LoginAct_userPw, userPw);
        row.putBoolean("Remember", isRemember);
        row.commit();
    }

    private View.OnClickListener btn登入_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("LottieDemo2","LoginAct_btn登入_click");
            checkIdPw();
            Log.d("LottieDemo2","LoginAct_核對帳密");

        }
    };

    private View.OnClickListener btn取消登入_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("LottieDemo2","LoginAct_btn取消登入_click");
            intent = new Intent(ActivityLogin.this, MainActivity.class);
            Log.d("LottieDemo2","從登入頁返回首頁");
            startActivity(intent);
            ActivityLogin.this.finish();
            Log.d("LottieDemo2","登入頁finish");
        }
    };
    private View.OnClickListener btn忘記密碼_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("LottieDemo2","LoginAct_btn忘記密碼_click");
            if(uId!=""){
                intent = new Intent(ActivityLogin.this, ActivityGetPw.class);
                Log.d("LottieDemo2","從登入頁至忘記密碼頁");
                startActivity(intent);
                ActivityLogin.this.finish();
                Log.d("LottieDemo2","登入頁finish");
            }else{
                Toast.makeText(getApplicationContext()
                        , "請先輸入帳號"
                        , Toast.LENGTH_SHORT).show();
                Log.d("LottieDemo2","Toast : 請輸入帳號");
            }


        }
    };

    //帳密比對資料庫
    private void checkIdPw(){
        uId = txt帳號.getText().toString();
        uPw = txt密碼.getText().toString();

        if((uId!=null) && (uPw!=null)){
            if(uId.equals("s01")){
                if(uPw.equals("s01")){
                    Toast.makeText(ActivityLogin.this,
                            "歡迎 " + uId + "登入",
                            Toast.LENGTH_SHORT).show();
                    intent = new Intent(ActivityLogin.this, ActivityStu.class);
                    startActivity(intent);
                    ActivityLogin.this.finish();

                }else {
                    Toast.makeText(ActivityLogin.this,
                            "密碼錯誤",
                            Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(ActivityLogin.this,
                        "沒有登入權限",
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(ActivityLogin.this,
                    "請輸入帳號密碼",
                    Toast.LENGTH_SHORT).show();
        }

        if(ckb記帳密.isChecked()){
            SharedPreferences table = getSharedPreferences(CDictionary.LoginAct_userIdPw,MODE_PRIVATE);
            SharedPreferences.Editor row = table.edit();
            row.putString(CDictionary.LoginAct_userId,uId);
            row.putString(CDictionary.LoginAct_userPw,uPw);
            row.commit();
        }

    }
}
