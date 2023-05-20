package com.codestates.section1.unit8.abstraction;

// 2023.5.20(토) 22h30
// InterfaceExample2 파일에 작성한 내용과 비교해보기
interface Cover {
    public abstract void call();
}


public class InterfaceExample3 {
    public static void main(String[] args) {
        UserWithInterface userWithInterface = new UserWithInterface();
        userWithInterface.callProvider(new Provider()); // Cover 인터페이스의 구현체 객체를 생성해서 해당 메서드 호출 가능
    }
}

// 구현체(x) 인터페이스(o)를 매개변수로 받도록 메서드 정의 -> Provider 클래스의 내용 변경이나 교체가 일어나더라도 User 클래스는 코드 변경하지 않아도 원하는 결과 출력 가능
class UserWithInterface {
    public void callProvider(Cover cover) {
        cover.call();
    }
}

class Provider implements Cover {

    @Override
    public void call() {
        System.out.println("hello Provider~");
    }
}

class Provider3 implements Cover {
    @Override
    public void call() {
        System.out.println("hello Provider3~");
    }
}


