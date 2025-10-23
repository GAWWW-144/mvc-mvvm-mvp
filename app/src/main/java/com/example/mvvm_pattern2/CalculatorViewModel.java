package com.example.mvvm_pattern2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvm_pattern2.model.CalculatorModel;

public class CalculatorViewModel extends ViewModel {

    private final CalculatorModel model = new CalculatorModel();

    // LiveData: View와 양방향 바인딩될 입력 데이터
    public final MutableLiveData<String> num1 = new MutableLiveData<>("");
    public final MutableLiveData<String> num2 = new MutableLiveData<>("");

    // LiveData: View에 표시될 결과 데이터
    public final MutableLiveData<String> result = new MutableLiveData<>("결과");

    // LiveData: Toast 메시지를 위한 이벤트성 LiveData
    public final MutableLiveData<String> toastMessageEvent = new MutableLiveData<>();

    private String selectedOperator = "+";

    public void onOperatorSelected(String operator) {
        this.selectedOperator = operator;
    }

    public void calculate() {
        try {
            String num1Str = num1.getValue();
            String num2Str = num2.getValue();

            if (num1Str == null || num1Str.isEmpty() || num2Str == null || num2Str.isEmpty()) {
                throw new NumberFormatException();
            }

            double val1 = Double.parseDouble(num1Str);
            double val2 = Double.parseDouble(num2Str);

            double calculationResult = model.calculate(val1, val2, selectedOperator);

            result.setValue(String.valueOf(calculationResult));
        } catch (NumberFormatException e) {
            toastMessageEvent.setValue("숫자를 정확히 입력하세요.");
            result.setValue("오류");
        } catch (IllegalArgumentException e) {
            toastMessageEvent.setValue(e.getMessage());
            result.setValue("오류");
        }
    }
}