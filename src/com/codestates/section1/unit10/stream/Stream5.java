package com.codestates.section1.unit10.stream;

import java.util.List;

public class Stream5 {
    public double computeAverageOfMaleMember(List<Member> members) {
        //구현된 Member 클래스의 getName(), getGender(), getAge() 메소드로 해당 Member 클래스의 name, gender, age를 확인할 수 있습니다.
        return members.stream().filter(m -> m.getGender() == "Male").mapToInt(Member::getAge).average().orElse(0);
    }

    public double computeAverageOfMaleMemberReference(List<Member> members) {
        double maleAveg = members.stream()
                .filter(m -> m.getGender().equals("Male")) // 회원의 성별을 받아와서 남자인 경우만 필터링합니다.
                .mapToInt(Member::getAge) // 남자 회원들의 나이를 받아옵니다.
                .average() // 남자 회원들의 나이 평균을 구합니다.
                .orElse(0.0);
        return maleAveg;
    }

    static class Member {
        String name;
        String gender;
        int age;

        public Member(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }
}
