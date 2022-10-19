package com.codestates.section2.unit7.psa.model.vo;

import com.codestates.section2.unit7.psa.model.vo.abstraction.Child;

// 2022.10.19(수) 8h40 '2개월 ~ 1살 영아'
public class Infant extends Child {
    // 메서드
    @Override
    public void smile() {
        System.out.println("영아는 많이 웃어요");
    }

    @Override
    public void cry() {
        System.out.println("영아는 종종 울어요");
    }

    @Override
    public void sleep() {
        System.out.println("영아부터는 밤에 잠을 자기 시작해요");
    }

    @Override
    public void eat() {
        System.out.println("영아부터는 이유식을 시작해요");
    }
}
