package com.codestates.section1.unit10.constructorref;

import java.util.function.BiFunction;
import java.util.function.Function;

// 2022.9.16(금) 8h10
public class ConstructorReferences {
    public static void main(String[] args) {
        Function<String, Member> function1 = Member::new;
        Member member1 = function1.apply("tomiqueen");

        BiFunction<String, String, Member> function2 = Member::new;
        Member member2 = function2.apply("tomiqueen", "강토미");
    }
}
