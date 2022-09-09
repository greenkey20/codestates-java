package com.codestates.section1.unit8.polymorphism;

// 2022.9.7(수) 23h50
public class Polymorphism1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.eat();

        Dancer dancer = new Dancer();
        dancer.eat();
        dancer.dance();
    }
}

class Person {
    String name;
    int age;

    void eat() {
        System.out.println("밥을 먹습니다");
    }

    void sleep() {
        System.out.println("잠을 잡니다");
    }
}

class Dancer extends Person {
    String favoriteBeat;

    void dance() {
        System.out.println("춤을 춥니다");
    }
}
