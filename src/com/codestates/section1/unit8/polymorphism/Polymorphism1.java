package com.codestates.section1.unit8.polymorphism;

// 2022.9.7(수) 23h50
public class Polymorphism1 {
    public static void main(String[] args) {
        Person person = new Person();
    }
}

class Person {
    String name;
    int age;

    void eat() {
        System.out.println("밥을 먹습니다");
    }

}
