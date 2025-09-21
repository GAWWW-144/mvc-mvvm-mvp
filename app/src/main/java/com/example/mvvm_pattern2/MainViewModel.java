package com.example.mvvm_pattern2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private Model model = new Model();
    private MutableLiveData<Integer> count = new MutableLiveData<>();
    private  MutableLiveData<Integer> totalPrice = new MutableLiveData<>();

    // 생성자
    public MainViewModel() {
        updateValues();
    }

    // 두 가지 값에 대한 accessor
    public LiveData<Integer> getCount() { return count; }
    public LiveData<Integer> getTotalPrice() { return totalPrice; }

    public void add() {
        model.add();
        updateValues();
    }

    public void subtract() {
        model.subtract();
        updateValues();
    }

    private void updateValues() {
        count.setValue(model.getCount());
        totalPrice.setValue(model.getTotalPrice());
    }

}