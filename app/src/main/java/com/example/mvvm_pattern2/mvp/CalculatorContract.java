package com.example.calculator.mvp;

public interface CalculatorContract {

    // View: Presenter가 View에게 결과를 표시하라고 명령하는 메소드 정의
    interface View {
        String getNum1Input();
        String getNum2Input();
        String getOperatorSelection();
        void showResult(String result);
        void showError(String message);
    }

    // Presenter: View가 Presenter에게 로직을 요청하는 메소드 정의
    interface Presenter {
        void onCalculateClicked();
    }
}