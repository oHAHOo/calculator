package org.zerock;

import java.util.function.BiFunction;

public enum OperatorType {
    //enum으로 사칙연산 정의
    ADD((a, b) -> a + b), //덧셈
    SUBTRACT((a, b) -> a - b), //뺄셈
    MULTIPLY((a, b) -> a * b), //곱셈
    DIVIDE((a, b) -> a / b); //나눗셈

    //double로 숫자 2개를 받아서 double로 반환
    private BiFunction<Double, Double, Double> func;

    OperatorType(BiFunction<Double, Double, Double> func) {
        this.func = func;
    }

    //계산 실행
    public double apply(double a, double b) {
        return func.apply(a, b);
    }

}
