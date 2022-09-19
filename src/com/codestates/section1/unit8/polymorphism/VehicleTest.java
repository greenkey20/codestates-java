package com.codestates.section1.unit8.polymorphism;

// 2022.9.19(월) 7h30
public class VehicleTest {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.giveRide(3); // Car 클래스 고유의 멤버 메서드 사용 가능 -> 다른 사람 3명 태우기
        car1.startEngine(); // 상속받은 상위클래스의 멤버 메서드 사용 가능 -> 시동 걸기=3

        System.out.println(car1 instanceof Object); // true
        System.out.println(car1 instanceof Vehicle); // true
        System.out.println(car1 instanceof Car); // true
//        System.out.println(car1 instanceof Motorbike); // incompatible types 에러 메시지

        // 다형성 적용 예시1)
        Vehicle vehicle1 = /*(Vehicle)*/ car1;
//        vehicle1.giveRide(3); // Car 클래스의 인스턴스 객체 car1을 가리키는 참조변수 vehicle1의 타입 = Vehicle(상위클래스) -> Car 클래스 고유의 멤버 메서드 사용 불가능, 상위클래스의 멤버만 사용 가능
        vehicle1.startEngine(); // 시동 걸기=3

        // 다형성 적용 예시2)
        Car car2 = (Car) vehicle1; // (업캐스팅했던 객체를)다운캐스팅하려면 형 변환 연산자(괄호) 필요
        car2.giveRide(3); // 다른 사람 3명 태우기
        car2.startEngine(); // 시동 걸기=3

        // 다형성 적용 예시3)
        Vehicle vehicle3 = new Vehicle();
        System.out.println(vehicle3 instanceof Object); // true
        System.out.println(vehicle3 instanceof Vehicle); // true

        System.out.println(vehicle3 instanceof Car); // false
//        Car car3 = (Car) vehicle3; // 다운캐스팅 시 형 변환 연산자(괄호) 필요 -> 컴파일 시 에러(에디터 상 빨간줄)는 없어짐 vs prgm 실행하면 런타임 에러 Class Cast Exception 발생 -> 다운캐스팅은 업캐스팅이 선행되어야 함
//        car3.giveRide(5);
//        car3.startEngine();

        // 다형성 적용 예시4)
        Vehicle car4 = new Car(); // Car -> Vehicle 업캐스팅
//        car4.giveRide(1); // Car 클래스의 인스턴스 객체를 Vehicle 타입 참조변수에 담음 -> Car 클래스 고유의 멤버 메서드 사용 불가능, 상위클래스의 멤버만 사용 가능

        System.out.println(car4 instanceof Object); // true
        System.out.println(car4 instanceof Vehicle); // true

        System.out.println(car4 instanceof Car); // true
        Car car5 = (Car) car4; // Vehicle -> Car 다운캐스팅
        car5.giveRide(1); // 다른 사람 1명 태우기

        System.out.println(car4 instanceof Motorbike); // false -> 나의 질문 = 이것의 의미는 정확히 무엇인가? -> 나의 생각 = Car 객체/인스턴스가 Vehicle 타입으로 선언되어있지만, 다형적 표현 방법에 따라 Object, Car 타입으로도 선언될 수 있음; 단 Motorbike 타입으로는 사용 불가능
//        Motorbike motorbike4 = (Motorbike) car4; // 에디터 상에서는 문제 없어 보이나, prgm 실행하면 런타임 에러 Class Cast Exception 발생

        // 다형성 적용 예시5)
//        Motorbike motorbike1 = (Motorbike) car1; // 상속 관계에 있지 않은 클래스들끼리는 형 변환 불가능
    }
}

class Vehicle {
    String model;
    String color;
    int numOfWheels;

    void startEngine() {
        System.out.println("시동 걸기=3");
    }

    void accelerate() {
        System.out.println("속도 올리기");
    }

    void brake() {
        System.out.println("브레이크!");
    }
}

class Car extends Vehicle {
    void giveRide(int numOfGuests) {
        System.out.println("다른 사람 " + numOfGuests + "명 태우기");
    }
}

class Motorbike extends Vehicle {
    void doTricks() {
        System.out.println("묘기 부리기");
    }
}
