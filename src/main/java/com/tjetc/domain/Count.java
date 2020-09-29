package com.tjetc.domain;

public class Count {
    private int num;

    public Count() {
    }

    public Count(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Count{" +
                "num=" + num +
                '}';
    }
}
