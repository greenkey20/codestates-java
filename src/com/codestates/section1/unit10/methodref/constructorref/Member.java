package com.codestates.section1.unit10.methodref.constructorref;

// 2023.7.7(금) 20h5
public class Member {
    private String name;
    private String id;

    public Member() {
        System.out.println("Member() 생성자 실행");
    }

    public Member(String id) {
        System.out.println("Member(String id) 생성자 실행");
        this.id = id;
    }

    public Member(String name, String id) {
        System.out.println("Member(String name, String id) 생성자 실행");
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
