package com.codestates.section1.unit8.inheritance;

// 2023.6.9(금) 16h15 지난 주말 exam에서 틀린 문제
public class ParentChildExample2 {
    public static void main(String[] args) {
        SuperObj s = new SubObj();
        s.show(); // 실행 결과 = SubSuper
    }
}

class SuperObj {
    public void show() {
        print();
    }

    public void print() { // IntelliJ msg = Method 'print()' recurses infinitely, and can only end by throwing an exception
        print(); // 나의 질문 = debugging 해보니 여기에서 자식(sub)클래스의 print()로 가는데, 왜?
        System.out.print("Super");
    }
}

class SubObj extends SuperObj {
    public void show() {
        super.print();
    }

    public void print() {
        System.out.print("Sub");
    }
}
