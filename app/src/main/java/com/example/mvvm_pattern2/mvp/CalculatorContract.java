package com.example.mvvm_pattern2.mvp; // 패키지명 수정

public interface CalculatorContract {
    interface View {
        String getNum1Input();
        String getNum2Input();
        String getOperatorSelection();
        void showResult(String result);
        void showError(String message);
    }

    interface Presenter {
        void onCalculateClicked();
    }
}