package com.example.calculator.mvp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.R;

public class MvpActivity extends AppCompatActivity implements com.example.calculator.mvp.CalculatorContract.View {

    private com.example.calculator.mvp.CalculatorContract.Presenter presenter;

    // View 요소
    private EditText num1EditText;
    private EditText num2EditText;
    private Spinner operatorSpinner;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_base);

        // View 요소 연결
        num1EditText = findViewById(R.id.edit_text_num1);
        num2EditText = findViewById(R.id.edit_text_num2);
        operatorSpinner = findViewById(R.id.spinner_operator);
        resultTextView = findViewById(R.id.text_view_result);
        Button calculateButton = findViewById(R.id.button_calculate);

        // Presenter 초기화 및 View(this) 연결
        presenter = new com.example.calculator.mvp.CalculatorPresenter(this);

        // View 역할: 사용자 액션을 Presenter에 전달
        calculateButton.setOnClickListener(v -> {
            presenter.onCalculateClicked();
        });
    }

    // --- CalculatorContract.View 인터페이스 구현 ---
    @Override
    public String getNum1Input() {
        return num1EditText.getText().toString();
    }

    @Override
    public String getNum2Input() {
        return num2EditText.getText().toString();
    }

    @Override
    public String getOperatorSelection() {
        return operatorSpinner.getSelectedItem().toString();
    }

    @Override
    public void showResult(String result) {
        resultTextView.setText(result);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        resultTextView.setText("오류");
    }
}