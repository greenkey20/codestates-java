package com.codestates.section1.unit10;

// 2022.9.15(목) 11h20
public class AnnotationExamples {
    public static void main(String[] args) {
        Sub sub1 = new Sub();
//        sub1.rnu();
        sub1.run();

        OldClass oc = new OldClass(10, 11);
        System.out.println(oc.getOldField()); // 11h35 @Deprecated 붙은 대상을 사용하는데, 왜 컴파일 시 관련 별도 메시지가 안 뜰까?
    }
}

// @Override
class Super {
    void run() {
        System.out.println("Super의 run() 메서드");
    }

//    void rnu() {}
}

class Sub extends Super {
    @Override
    void run() {
        System.out.println("Sub이 상위 클래스로부터 overriding하는 run() 메서드");
    }
}

// @Deprecated
//@SuppressWarnings("deprecation")
class OldClass {
    @Deprecated
    int oldField;
    int newField;

    public OldClass() {

    }

    public OldClass(int oldField, int newField) {
        this.oldField = oldField;
        this.newField = newField;
    }

    // getter 자동 작성 시 @Deprecated 인스턴스 변수는 목록에서 취소선이 그어져있지만, 선택하면 getter 만들 수는 있음
    // 단, @Deprecated annotation이 자동으로 붙지는 않음
    @Deprecated
    public int getOldField() {
        return oldField;
    }

    public int getNewField() {
        return newField;
    }
}

