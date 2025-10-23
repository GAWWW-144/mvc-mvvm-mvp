package com.example.mvvm_pattern2.mvp; // 패키지명 수정

import com.example.mvvm_pattern2.model.CalculatorModel; // Model import 수정

public class CalculatorPresenter implements CalculatorContract.Presenter {

    private CalculatorContract.View view;
    private CalculatorModel model;

    public CalculatorPresenter(CalculatorContract.View view) {
        this.view = view;
        this.model = new CalculatorModel();
    }

    @Override
    public void onCalculateClicked() {
        try {
            // Presenter가 View에게 입력값 요청
            double num1 = Double.parseDouble(view.getNum1Input());
            double num2 = Double.parseDouble(view.getNum2Input());
            String operator = view.getOperatorSelection();

            // Presenter가 Model 호출
            double result = model.calculate(num1, num2, operator);

            // Presenter가 View에게 결과 표시 명령
            view.showResult(String.valueOf(result));

        } catch (NumberFormatException e) {
            view.showError("숫자를 정확히 입력하세요.");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }
}