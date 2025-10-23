package com.example.mvvm_pattern2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.example.mvvm_pattern2.databinding.ActivityMvvmCalculatorBinding;

public class MvvmCalculatorActivity extends AppCompatActivity {

    private CalculatorViewModel viewModel;
    private ActivityMvvmCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_calculator);
        viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        // Spinner 설정 (Data Binding으로 처리할 수 없는 부분)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerOperator.setAdapter(adapter);

        // Spinner 선택 변경 리스너
        binding.spinnerOperator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String operator = parent.getItemAtPosition(position).toString();
                viewModel.onOperatorSelected(operator);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Toast 메시지 관찰 (View 로직)
        viewModel.toastMessageEvent.observe(this, message -> {
            if (message != null) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}package com.example.mvvm_pattern2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.example.mvvm_pattern2.databinding.ActivityMvvmCalculatorBinding;

public class MvvmCalculatorActivity extends AppCompatActivity {

    private CalculatorViewModel viewModel;
    private ActivityMvvmCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_calculator);
        viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        // Spinner 설정 (Data Binding으로 처리할 수 없는 부분)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerOperator.setAdapter(adapter);

        // Spinner 선택 변경 리스너
        binding.spinnerOperator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String operator = parent.getItemAtPosition(position).toString();
                viewModel.onOperatorSelected(operator);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Toast 메시지 관찰 (View 로직)
        viewModel.toastMessageEvent.observe(this, message -> {
            if (message != null) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}