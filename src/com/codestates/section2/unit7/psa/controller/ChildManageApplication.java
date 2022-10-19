package com.codestates.section2.unit7.psa.controller;

import com.codestates.section2.unit7.psa.model.vo.Infant;
import com.codestates.section2.unit7.psa.model.vo.NewBornBaby;
import com.codestates.section2.unit7.psa.model.vo.Toddler;
import com.codestates.section2.unit7.psa.model.vo.abstraction.Child;

// 2022.10.19(수) 8h50
public class ChildManageApplication {
    public static void main(String[] args) {
        // 하위 클래스 사용 시 자신의 타입/구체화(x) 추상(o) 클래스 변수에 할당해서 접근 -> 클라이언트(여기서는 ChildManageApplication 클래스의 main() 메서드)는 Child 추상클래스만 일관되게 바라보며 하위 클래스의 기능 사용 가능
        Child newBornBaby = new NewBornBaby("신생아"); // 8h55 나의 관찰 = 이렇게 추상클래스 Child 타입으로 객체 대입해두면 멤버들에 대한 접근이 안 된다? vs 학습 자료 코드는 어떻게 실행시킨 것이지?
        Child infant = new Infant();
        Child toddler = new Toddler();

        // 나의 관찰 = 아래와 같이 하위 클래스 사용해서 객체 생성/대입해도 멤버들 접근이 안 됨 -> 멤버 메서드에 대한 접근 권한에 이상이 있을 거라고 생각함; 학습 자료에서는 추상클래스에서 메서드들의 접근 제어자가 protected로 되어있었는데, 나는 패키지 나눠서 구현하고 있으므로 public으로 만듦
//        NewBornBaby newBornBaby = new NewBornBaby("신생아");
//        Infant infant = new Infant();
//        Toddler toddler = new Toddler();

        newBornBaby.sleep(); // 신생아는 거의 하루 종일 자요
        infant.sleep(); // 영아부터는 밤에 잠을 자기 시작해요
        toddler.sleep(); // 유아는 낮잠을 건너뛰고 밤잠만 자요
    }
}
