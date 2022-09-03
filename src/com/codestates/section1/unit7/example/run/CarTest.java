package com.codestates.section1.unit7.example.run;

// 2022.9.2(금) 17h20
public class CarTest {
    public static void main(String[] args) {
        Car bmw = new Car();
        Car tesla = new Car();

        System.out.println(bmw); // com.codestates.section1.unit7.example.run.Car@5a39699c
        System.out.println(tesla); // com.codestates.section1.unit7.example.run.Car@3cb5cdba

        System.out.println(bmw.toString()); // com.codestates.section1.unit7.example.run.Car@5a39699c
        System.out.println(tesla.toString()); // com.codestates.section1.unit7.example.run.Car@3cb5cdba

        bmw.model = "530i"; // 포인트 연산자(.)로 멤버에 접근
        bmw.color = "그린";
        bmw.carNum = 1234;
//        bmw.wheel = 4;

        tesla.model = "model Y";
        tesla.color = "블랙";
        tesla.carNum = 7890;
//        tesla.wheel = 4;

        System.out.println("무민의 차는 BMW인데, 모델은 " + bmw.model + "이고, 색상은 " + bmw.color + "이며, 바퀴는 " + Car.wheel + "개입니다");
        System.out.println("스노크메이든의 차는 Tesla인데, 모델은 " + tesla.model + "이고, 색상은 " + tesla.color + "이며, 바퀴는 " + Car.wheel + "개입니다");

        System.out.println(bmw.carNum);
        System.out.println(bmw.wheel);
        System.out.println(tesla.wheel);

        System.out.println("--BMW의 동작--");
        bmw.drive();
        bmw.stop();
        bmw.bangbang();

        System.out.println("--Tesla의 동작--");
        tesla.drive();
        tesla.stop();
        tesla.bangbang();
    }
}

class Car {
    String model;
    String color;
    int carNum;
//    int wheel;
    static int wheel = 4; // 모든 승용차의 바퀴는 4개라고 가정했을 때 static으로 만들 수 있음

    void stop() {
        System.out.println("차를 세웁니다");
    }

    void drive() {
        System.out.println("차를 움직입니다");
    }

    void bangbang() {
        System.out.println("빵빵! 경적을 울립니다");
    }
}
