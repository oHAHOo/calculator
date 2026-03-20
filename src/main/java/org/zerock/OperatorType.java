package org.zerock;

import java.util.function.BiFunction;

public enum OperatorType {
    ADD((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> a / b);

    private BiFunction<Integer, Integer, Integer> func;

    OperatorType(BiFunction<Integer, Integer, Integer> func) {
        this.func = func;
    }

    public int apply(int a, int b) {
        return func.apply(a, b);
    }
}
