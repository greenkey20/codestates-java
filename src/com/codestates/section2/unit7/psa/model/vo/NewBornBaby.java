package com.codestates.section2.unit7.psa.model.vo;

import com.codestates.section2.unit7.psa.model.vo.abstraction.Child;

// 2022.10.19(수) '신생아'
public class NewBornBaby extends Child {
    // 나의 궁금증 = 아래 메서드들에서 "신생아" 부분을 ChildType 멤버변수 값으로 표현하려면 어떻게 구현해야 할까?
    // 나의 생각 = NewBornBaby 객체 생성 시 childType 멤버변수를 초기화할 수 있게 하고, 그렇게 설정된 값을 사용

    // 생성자 -> 8h50 부모 클래스에 아래와 같은 생성자 만들어서, 여기서는 필요 없을 거라고 생각함 -> controller 작성하다보니 하위 클래스만의 생성자가 필요하다
    public NewBornBaby() {
        super();
    }

    public NewBornBaby(String childType) {
        super();
        this.childType = childType;
    }

    // 메서드
    @Override
    public void smile() {
        System.out.println(childType + "는 가끔 웃어요");
    }

    @Override
    public void cry() {
        System.out.println(childType + "는 자주 울어요");
    }

    @Override
    public void sleep() {
        System.out.println(childType + "는 거의 하루 종일 자요");
    }

    @Override
    public void eat() {
        System.out.println(childType + "는 분유만 먹어요");
    }
}
