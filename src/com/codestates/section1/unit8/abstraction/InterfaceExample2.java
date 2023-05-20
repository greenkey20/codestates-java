package com.codestates.section1.unit8.abstraction;

// 2023.5.20(토) 22h25
public class InterfaceExample2 {
    public static void main(String[] args) {
        User user = new User();
        user.callProvider(new Provider2()); // 변경 필요
    }

}

/* User 클래스가 의존/사용하고 있는 Provider 클래스에 변경 사항이 발생하면,
User 클래스 코드(전달받는 매개변수의 타입)도 수정 필요 + User 객체 생성하는 곳에서도 매개변수 수정 필요
 */
class User {
    public void callProvider(Provider2 provider) { // 변경 필요
        provider.call();
    }
}

class Provider2 {
    public void call() {
        System.out.println("hello Provider~");
    }
}
