package com.example.calculator.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.calculator.model.CalculatorModel;

public class CalculatorViewModel extends ViewModel {

    private final CalculatorModel model = new CalculatorModel();

    // View와 양방향 바인딩될 입력 데이터
    public final MutableLiveData<String> num1 = new MutableLiveData<>("");
    public final MutableLiveData<String> num2 = new MutableLiveData<>("");

    // View에 표시될 결과 데이터
    public final MutableLiveData<String> result = new MutableLiveData<>("결과");

    // View에서 Toast를 띄우기 위한 이벤트성 LiveData
    public final MutableLiveData<String> toastMessageEvent = new MutableLiveData<>();

    // Spinner 선택값은 ViewModel 내부에서 관리
    private String selectedOperator = "+";

    // View가 Spinner 선택 변경 시 호출
    public void onOperatorSelected(String operator) {
        this.selectedOperator = operator;
    }

    // View의 버튼 클릭에 의해 호출되는 로직 (XML에서 직접 호출)
    public void calculate() {
        try {
            String num1Str = num1.getValue();
            String num2Str = num2.getValue();

            if (num1Str == null || num1Str.isEmpty() || num2Str == null || num2Str.isEmpty()) {
                throw new NumberFormatException();
            }

            double val1 = Double.parseDouble(num1Str);
            double val2 = Double.parseDouble(num2Str);

            // Model을 통해 계산
            double calculationResult = model.calculate(val1, val2, selectedOperator);

            // ViewModel의 LiveData 업데이트 -> View에 자동 반영
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