package org.zerock;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> list  = new ArrayList<>();

    public void setList(String result) {
        list.add(result);
    }

    public ArrayList<String> getList() {
        return list;
    }
}
