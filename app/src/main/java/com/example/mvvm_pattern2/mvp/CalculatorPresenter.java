package com.example.calculator.mvp;

import com.example.calculator.model.CalculatorModel;

public class CalculatorPresenter implements com.example.calculator.mvp.CalculatorContract.Presenter {

    private com.example.calculator.mvp.CalculatorContract.View view;
    private CalculatorModel model;

    public CalculatorPresenter(com.example.calculator.mvp.CalculatorContract.View view) {
        this.view = view;
        this.model = new CalculatorModel();
    }

    @Override
    public void onCalculateClicked() {
        try {
            // 1. Presenter가 View에게 입력값 요청
            double num1 = Double.parseDouble(view.getNum1Input());
            double num2 = Double.parseDouble(view.getNum2Input());
            String operator = view.getOperatorSelection();

            // 2. Presenter가 Model에게 로직 수행 요청
            double result = model.calculate(num1, num2, operator);

            // 3. Presenter가 View에게 결과 표시를 명령
            view.showResult(String.valueOf(result));

        } catch (NumberFormatException e) {
            view.showError("숫자를 정확히 입력하세요.");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }
}