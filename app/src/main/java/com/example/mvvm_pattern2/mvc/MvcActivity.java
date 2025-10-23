package com.example.mvvm_pattern2.mvc;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvvm_pattern2.R;
import com.example.mvvm_pattern2.model.CalculatorModel; // Model import

public class MvcActivity extends AppCompatActivity {
    private CalculatorModel model;
    private EditText num1EditText, num2EditText;
    private Spinner operatorSpinner;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_base);

        model = new CalculatorModel();
        num1EditText = findViewById(R.id.edit_text_num1);
        num2EditText = findViewById(R.id.edit_text_num2);
        operatorSpinner = findViewById(R.id.spinner_operator);
        resultTextView = findViewById(R.id.text_view_result);
        Button calculateButton = findViewById(R.id.button_calculate);

        // Controller 역할: 이벤트 처리
        calculateButton.setOnClickListener(v -> handleCalculateClick());
    }

    private void handleCalculateClick() {
        try {
            // 1. Controller가 View에서 데이터 수집
            double num1 = Double.parseDouble(num1EditText.getText().toString());
            double num2 = Double.parseDouble(num2EditText.getText().toString());
            String operator = operatorSpinner.getSelectedItem().toString();

            // 2. Controller가 Model 호출
            double result = model.calculate(num1, num2, operator);

            // 3. Controller가 View에 직접 결과 반영
            resultTextView.setText(String.valueOf(result));

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            resultTextView.setText("오류");
        }
    }
}