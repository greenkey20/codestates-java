package com.codestates.section1.unit8.abstraction;

// 2023.5.20(토) 22h25
public class InterfaceExample2 {
    public static void main(String[] args) {
        User user = new User();
        user.callProvider(new Provider());
    }

}

class User {
    public void callProvider(Provider provider) {
        provider.call();
    }
}

class Provider {
    public void call() {
        System.out.println("hello Provider~");
    }
}
