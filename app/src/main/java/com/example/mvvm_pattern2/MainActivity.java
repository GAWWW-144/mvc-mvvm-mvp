package com.example.mvvm_pattern2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvvm_pattern2.mvc.MvcActivity;
import com.example.mvvm_pattern2.mvp.MvpActivity;
import com.example.mvvm_pattern2.R;

// 세 가지 패턴의 계산기 앱을 실행하는 메뉴 Activity 역할을 합니다.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MVVM 계산기는 MvvmCalculatorActivity라는 새로운 Activity를 사용합니다.

        findViewById(R.id.btn_launch_mvc).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MvcActivity.class));
        });

        findViewById(R.id.btn_launch_mvp).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MvpActivity.class));
        });

        findViewById(R.id.btn_launch_mvvm).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MvvmCalculatorActivity.class));
        });
    }
}