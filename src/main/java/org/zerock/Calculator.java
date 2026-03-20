package org.zerock;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Double> list  = new ArrayList<>();

    public void setList(Double result) {
        list.add(result);
    }

    public ArrayList<Double> getList() {
        return list;
    }

    public void deleteList(){
        list.remove(list.size()-1);
    }
}
