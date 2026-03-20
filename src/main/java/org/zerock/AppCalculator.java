package org.zerock;

import java.util.ArrayList;

public class AppCalculator {
    private ArrayList<String> list  = new ArrayList<>();

    public void setList(String result) {
        list.add(result);
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void deleteList(){
        list.remove(list.size()-1);
    }
}

