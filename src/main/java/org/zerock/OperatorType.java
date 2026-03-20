package org.zerock;

public enum OperatorType {
    PLUS, MINUS, MULTI, DIVIDE;

    public int apply(int a, int b) {
        switch (this){
            case PLUS:{
                return a + b;
            }
            case MINUS:{
                return a-b;
            }
            case MULTI:{
                return a*b;
            }
            case DIVIDE:{
                if(b==0){
                    return 0;
                }
                return a/b;
            } default:{
                return 0;
            }
        }
    }
}