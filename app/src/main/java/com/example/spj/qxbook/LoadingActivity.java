package com.example.spj.qxbook;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by spj on 2018/5/5.
 */

public class LoadingActivity extends MainActivity{
    private final long SPLASH_LENGTH = 2000;
    Handler handler = new Handler();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        handler.postDelayed(new Runnable() {  //使用handler的postDelayed实现延时跳转

            public void run() {
                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_LENGTH);//2秒后跳转至应用主界面MainActivity

    }
}
