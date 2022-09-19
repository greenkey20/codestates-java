package com.codestates.section1.unit8.polymorphism;

// 2022.9.19(월) 0h30
public class FriendTest {
    public static void main(String[] args) {
        Friend friend1 = new Friend();
        BoyFriend boyfriend = new BoyFriend();
        Friend girlfriend = new GirlFriend(); // 상위클래스 타입(의 참조변수)으로 하위클래스의 객체 참조 가능 = 다형성
//        GirlFriend friend2 = new Friend(); // 하위클래스 타입(의 참조변수)으로 상위클래스의 객체 참조 불가능 <- 참조하고 있는 상위클래스의 인스턴스에 실제로 구현된 기능이 없어 사용 불가능

        friend1.friendInfo();
        boyfriend.friendInfo();
        girlfriend.friendInfo();
    }
}

class Friend {
    public void friendInfo() {
        System.out.println("나는 너의 친구야");
    }
}

class BoyFriend extends Friend {
    public void friendInfo() {
        System.out.println("나는 너의 남자친구야");
    }
}

class GirlFriend extends Friend {
    public void friendInfo() {
        System.out.println("나는 너의 여자친구야");
    }
}
