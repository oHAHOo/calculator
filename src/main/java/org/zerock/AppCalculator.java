package org.zerock;

import java.util.ArrayList;


//App.java용 계산결과 저장 클래스
public class AppCalculator {

    //결과값을 저장할 리스트 생성
    private ArrayList<String> list  = new ArrayList<>();

    //리스트에 결과 추가
    public void setList(String result) {
        list.add(result);
    }

    //리스트 반환
    public ArrayList<String> getList() {
        return list;
    }

    //가장 최근 결과값 삭제
    public void deleteList(){
        list.remove(list.size()-1);
    }
}

