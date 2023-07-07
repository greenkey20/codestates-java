package com.codestates.section1.unit10.methodref.constructorref;

import java.util.function.BiFunction;
import java.util.function.Function;

// 2023.7.7(금) 20h5
public class ConstructorRef {
    public static void main(String[] args) {
        Function<String, Member> function1 = Member::new;
        Member member1 = function1.apply("Tromm KANG"); // Member(String id) 생성자 실행

        BiFunction<String, String, Member> function2 = Member::new;
        Member member2 = function2.apply("Tromm KANG", "tromm_clean"); // Member(String name, String id) 생성자 실행
    }
}
