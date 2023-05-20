package com.codestates.section1.unit8.abstraction;

// 2022.9.14(수) 7h55
public interface InterfaceExample1 {
    public static final int ROCK = 1;
    final int SCISSORS = 2;
    static int PAPER = 3;

    public abstract String getPlayingNum();
    void call(); // 접근제어자 및 키워드 생략 가능하며, 생략된 부분은 컴파일러가 자동으로 추가해줌

}
