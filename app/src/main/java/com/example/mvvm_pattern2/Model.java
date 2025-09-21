package com.example.mvvm_pattern2;

public class Model {

    public  final static int coffeePrice = 1800;
    private int count = 0;
    private int totalPrice = 0;

    public void add() {
        count ++;
    }

    public void subtract() {
        if(count > 0) count --;
    }

    public int getTotalPrice() {
        return count * coffeePrice;
    }

    public int getCount() {
        return count;
    }
}
