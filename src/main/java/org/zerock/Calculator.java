package org.zerock;

import java.util.ArrayList;

//결과값을 저장하는 클래스
public class Calculator {

    //결과값을 저장할 리스트 생성
    private ArrayList<Double> list  = new ArrayList<>();

    //리스트에 결과 추가
    public void setList(Double result) {
        list.add(result);
    }

    //리스트 반환
    public ArrayList<Double> getList() {
        return list;
    }

    //가장 먼저 저장된 값 삭제
    public void deleteList(){
        list.remove(0);
    }
}
