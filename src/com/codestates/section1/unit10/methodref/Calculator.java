package com.codestates.section1.unit10.methodref;

// 2022.9.16(금) 8h
public class Calculator {
    public static int staticMethod(int x, int y) {
        return x + y;
    }

    public int instanceMethod(int x, int y) {
        return x * y;
    }
}
