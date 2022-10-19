package com.codestates.section2.unit7.psa.model.vo.abstraction;

// 2022.10.19(수) 8h25
// Child(아기)의 일반적인 특징을 추출해서 추상 클래스로 작성
public abstract class Child {
    protected String childType;
    protected double height;
    protected double weight;
    protected String bloodType;
    protected int age;

    public Child() {

    }

    public Child(String childType) {
        this.childType = childType;
    }

    public abstract void smile();

    public abstract void cry();

    public abstract void sleep();

    public abstract void eat();

}
