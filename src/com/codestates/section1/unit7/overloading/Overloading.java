package com.codestates.section1.unit7.overloading;

// 2023.3.7(화) 19h45
public class Overloading {
    public void fn() {
        System.out.println("없음");
    }

    public void fn(int i) {
        System.out.println(i);
    }

    public void fn(double d) {
        System.out.println(d);
    }

    public int fn(int a, int b) {
        return a + b;
    }

    // 'fn(int, int)' is already defined in 'com.codestates.section1.unit7.overloading.overloading'
    /*
    public void fn(int a, int b) {
        System.out.println(a + b);
    }
     */
}

// 2023.3.7(화) 19h50
class Run {
    public static void main(String[] args) {
        Overloading overloading = new Overloading();

        overloading.fn();
        overloading.fn(2);
        overloading.fn(4.5);
        System.out.println(overloading.fn(4, 5));
    }
}
