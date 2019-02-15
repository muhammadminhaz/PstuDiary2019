package com.minhaz.muhammad.pstudiary2019;

import java.util.ArrayList;

public class Parent {
    private String name;
    private ArrayList<Child> list = new ArrayList<Child>();

    public Parent(String name, ArrayList<Child> list)
    {
       // super();
        this.name=name;
        this.list=list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Child> getList() {
        return this.list;
    }

    public void setList(ArrayList<Child> list) {
        this.list = list;
    }
}
