package com.codestates.section1.unit8.inheritance;

// 2023.4.23(일) 21h55 from an exam
class Parent {
    int x = 100;

    Parent() {
        this(500);
        System.out.println("매개변수 없는 부모 생성자, this.x = " + this.x);
    }

    Parent(int x) {
        this.x = x;
        System.out.println("매개변수 있는 부모 생성자, this.x = " + this.x);
    }

    int getX() {
        return x;
    }
}

class Child extends Parent {
    int x = 4000;

    Child() {
        /* 모든 생성자의 첫 줄에는 반드시 this() 또는 super()가 선언되어야 함
        만약 super()가 없는 경우에는 컴파일러가 생성자의 첫 줄에 자동으로 super()를 삽입 + 이 때 상위 클래스에 기본생성자가 없으면 에러 발생 -> 클래스 만들 때 자동으로 기본생성자를 생성하는 것을 습관화하는 것이 좋다

        아래 main() 함수에서 Child 객체 생성 시 생성자들 호출 순서
        매개변수 있는 부모 생성자, this.x = 500
        매개변수 없는 부모 생성자, this.x = 500
        매개변수 있는 자식 생성자, this.x = 5000
        매개변수 없는 자식 생성자, this.x = 5000
         */
        this(5000);
        System.out.println("매개변수 없는 자식 생성자, this.x = " + this.x);
    }

    Child(int x) {
        this.x = x;
        System.out.println("매개변수 있는 자식 생성자, this.x = " + this.x);
    }
}

public class ParentChildExample1 {
    public static void main(String[] args) {
        Child obj = new Child();
        System.out.println(obj.getX()); // 나의 생각은 5000 vs 실제 출력은 500 -> 여전히 이해가 정확히 되지 않는데.. ㅠㅠ 생략된 super()가 컴파일러에 의해 호출되는 건 알겠는데, 왜 getX() 메서드 호출 시 자식(x) 부모(o)의 멤버변수 값을 반환하는 거지?
        // 나는 자식이 부모의 getX() 메서드도 상속받아서 자기 것처럼 사용하고, 그러니까 자식의 멤버변수 값을 반환할 거라고 생각했는데..
    }
}
