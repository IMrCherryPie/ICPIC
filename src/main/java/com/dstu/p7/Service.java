package com.dstu.p7;

public class Service {

    public int[] changeValues(int[] t, int a){

        for (int i = 0; i < t.length; i++) {
            t[i] += a;
        }
        return t;
    }
}
