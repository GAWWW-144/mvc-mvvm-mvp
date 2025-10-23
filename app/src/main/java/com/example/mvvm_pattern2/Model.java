package com.example.calculator.model;

/**
 * Model: 데이터와 비즈니스 로직(계산)을 담당합니다.
 * Android 프레임워크에 대한 의존성이 전혀 없습니다.
 */
public class CalculatorModel {

    // 비즈니스 로직: 사칙연산 수행
    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
    }
}