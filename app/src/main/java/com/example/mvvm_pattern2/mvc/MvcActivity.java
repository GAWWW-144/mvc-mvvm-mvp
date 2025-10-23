package com.example.mvvm_pattern2.mvc;

import android.os.Bundle;
// ... (필요한 import 문) ...
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvvm_pattern2.R; // R 파일 import
import com.example.mvvm_pattern2.model.CalculatorModel; // Model import

public class MvcActivity extends AppCompatActivity {
    private CalculatorModel model;
    // ... (UI 요소 변수 선언) ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.mvvm_pattern2.R.layout.activity_calculator_base); // 레이아웃 연결
        model = new CalculatorModel();
        // ... (findViewById로 UI 요소 연결) ...
        // ... (버튼 클릭 리스너 설정: Model 호출 및 View 직접 업데이트) ...
    }
}