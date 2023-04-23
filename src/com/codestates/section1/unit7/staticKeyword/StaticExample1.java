package com.codestates.section1.unit7.staticKeyword;

// 2023.4.23(일) 21h45 from an exam
class Static {
    public int a = 20;
    static int b = 0;
}

public class StaticExample1 {
    public static void main(String[] args) {
        int a;
        a = 10;
        Static.b = a;
        Static st = new Static();

        System.out.println(Static.b++); // 10
        System.out.println(st.b); // 11
        System.out.println(a); // 10
        System.out.println(st.a); // 20
    }
}
