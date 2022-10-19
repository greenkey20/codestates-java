package com.codestates.section2.unit7.psa.model.vo;

import com.codestates.section2.unit7.psa.model.vo.abstraction.Child;

// 2022.10.19(수) 8h45 '1살 ~ 4살 유아'
public class Toddler extends Child {
    // 메서드
    @Override
    public void smile() {
        System.out.println("유아는 웃길 때 웃어요");
    }

    @Override
    public void cry() {
        System.out.println("유아는 화가 나면 울어요");
    }

    @Override
    public void sleep() {
        System.out.println("유아는 낮잠을 건너뛰고 밤잠만 자요");
    }

    @Override
    public void eat() {
        System.out.println("유아는 딱딱한 걸 먹기 시작해요");
    }
}
