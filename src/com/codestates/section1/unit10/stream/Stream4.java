package com.codestates.section1.unit10.stream;

import java.util.List;

public class Stream4 {
    public long computeCountOfFemaleMember(List<Member> members) {
        //구현된 Member 클래스의 getName(), getGender() 메소드로 해당 Member 클래스의 name, gender를 확인할 수 있습니다.
        return members.stream().filter(m -> m.getGender().equals("Female")).count();
    }

    public long computeCountOfFemaleMemberReference(List<Member> members) {
        long count = members.stream()
                .filter(m -> m.getGender().equals("Female")) // 각 회원의 성별을 받아와 성별이 여성인 멤버만 필터링합니다.
                .count(); // 필터로 걸러진 여성 멤버의 수를 구합니다.
        return count;
    }

    static class Member {
        String name;
        String gender;

        public Member(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

    }
}
