package com.codestates.section1.unit9.enumExercise;

import java.util.ArrayList;
import java.util.List;

// 2022.11.25(금) 18h40
public class EnumConcept {
    // 상수 = 변하지 않는 값, final 키워드 사용해서 선언, 관례적으로 대문자로 작성
    // 여러 상수를 정의하는 예전 방식 = 각 상수를 구분하기 위해 임의의 정수 값들을 상수에 부여 = 정수 값을 통해 상수 할당
    public static final int SPRING = 1;
    public static final int SUMMER = 2;
    public static final int FALL = 3;
    public static final int WINTER = 4;

    // 위 방식의 문제점 = 상수 이름 중복되는 경우가 발생할 수 있음
    public static final int DJANGO = 1;
    //    public static final int SPRING = 2; // 상수 이름 중복 -> 컴파일 에러 발생
    public static final int NEST = 3;
    public static final int EXPRESS = 4;

    public static void main(String[] args) {
        if (SeasonsInterface.SPRING != FrameworksInterface.SPRING) {
            System.out.println("계절 SPRING과 프레임워크 SPRING을 비교한다..!?");
        }

//        if (SeasonsClass.SPRING instanceof FrameworksClass.SPRING) // SeasonsClass-FrameworksClass가 상속 관계가 아니니까 instanceof로 비교 불가?

        // switch문 example1)
        List<SeasonsClass> seasonsList1 = new ArrayList<>();
        seasonsList1.add(SeasonsClass.SPRING);
        seasonsList1.add(SeasonsClass.FALL);
        seasonsList1.add(SeasonsClass.SUMMER);
        seasonsList1.add(SeasonsClass.WINTER);

        System.out.println(seasonsList1);

        /*
        switch (seasonsList1.get(1)) { // Incompatible types. Found: 'com.codestates.section1.unit9.enumExercise.SeasonsClass', required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'

        }
         */

        // switch문 example2)
        SeasonsClass seasonClass = SeasonsClass.SPRING;
        /*
        switch (season) { // Incompatible types. Found: 'com.codestates.section1.unit9.enumExercise.SeasonsClass', required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'

        }
         */

        // 열거형 이름.상수명 -> 열거형/enum에 선언된 상수에 접근 cf. 클래스의 static 변수 참조하는 것과 동일
        System.out.println(SeasonEnum.SPRING);

        SeasonEnum favouriteSeason = SeasonEnum.SPRING;
        System.out.println(favouriteSeason);

        // switch문 example3)
        List<SeasonEnum> seasonsList2 = new ArrayList<>();
        seasonsList2.add(SeasonEnum.SPRING);
        seasonsList2.add(SeasonEnum.FALL);
        seasonsList2.add(SeasonEnum.WINTER);
        seasonsList2.add(SeasonEnum.WINTER);

        switch (seasonsList2.get(1)) {
            case SPRING:
                System.out.println("이 계절은 봄입니다");
                break;
            case SUMMER:
                System.out.println("이 계절은 여름입니다");
                break;
            case FALL:
                System.out.println("이 계절은 가을입니다");
                break;
            case WINTER:
                System.out.println("이 계절은 겨울입니다");
        } // '이 계절은 가을입니다' 선택됨

        // switch문 example4)
        SeasonEnum seasonEnum = SeasonEnum.SPRING;
        switch (seasonEnum) {
            case SPRING:
                System.out.println("이 계절은 봄입니다");
                break;
            case SUMMER:
                System.out.println("이 계절은 여름입니다");
                break;
            case FALL:
                System.out.println("이 계절은 가을입니다");
                break;
            case WINTER:
                System.out.println("이 계절은 겨울입니다");
        } // '이 계절은 봄입니다' 선택됨

        // enum에서 사용할 수 있는 메서드들
        Level level = Level.MEDIUM;

        Level[] allLevels = Level.values(); // 열거 배열 values() = 모든 열거 객체/상수들을 배열로 리턴
        for (Level lv : allLevels) {
            System.out.printf("%s = %d%n", lv.name(), lv.ordinal());
            /* String name() = 열거 객체가 가지고 있는 문자열/상수명을 리턴
            int ordinal() = 열거 객체의 순번(0부터 시작) 리턴

            allLevels에 담긴 각각의 열거 객체/상수의 이름 및 순번을 format대로 출력
            LOW = 0
            MEDIUM = 1
            HIGH = 2
             */
        }

        // 2022.11.29(화) 17h35 이어서 학습
        Level findLevel1 = Level.valueOf("LOW"); // 열거 타입 valueOf(String name) = 주어진 문자열과 이름이 일치하는 열거 객체/상수 리턴
        System.out.println(findLevel1); // LOW
        System.out.println(Level.LOW == Level.valueOf("LOW")); // true <- valueOf() 호출로부터 반환된 상수가 의도했던 상수와 일치하는지 여부 확인

//        Level findLevel2 = Level.valueOf("MEDIU"); // IllegalArgumentException 예외 발생 <- No enum constant com.codestates.section1.unit9.enumExercise.Level.MEDIU
//        System.out.println(findLevel2);
        // 예외 발생한 라인 이후의 코드들은 실행되지 않음 + Process finished with exit code 1 vs 정상 종료 시 Process finished with exit code 0

        switch (level) {
            case LOW:
                System.out.println("낮은 레벨");
                break;
            case MEDIUM:
                System.out.println("중간 레벨");
                break;
            case HIGH:
                System.out.println("높은 레벨");
                break;
        } // '중간 레벨' 선택됨

        System.out.println(Level.LOW.compareTo(Level.HIGH)); // int compareTo(비교할 열거 객체) = 주어진 매개값과 비교해서 순번 차이를 리턴 -> 0 - 2 = -2 반환
    }
}

// 해결책1 = 인터페이스 사용해서 상수 구분 -> 나의 질문 = 왜 클래스로 구분하지 않고 인터페이스를 사용하지?
// 해결책1의 문제점 = 타입 안정성 문제 = 상수 열거를 위해 각 상수에 임의로 주어진 정수끼리 비교가 가능한데, 어떤 의미가 있는 값이 아닌 바(e.g. Seasons의 SPRING과 Frameworks의 SPRING은 의미적으로 다른 개념), 이 둘을 비교하는 건 타입 안정성이 떨어지는 것임
interface SeasonsInterface {
    int SPRING = 1, SUMMER = 2, FALL = 3, WINTER = 4;
}

interface FrameworksInterface {
    int DJANGO = 1, SPRING = 2, NEST = 3, EXPRESS = 4;
}

// 해결책2 = 각 상수를 서로 다른 객체로 만들어줌 -> 상수 이름 중복 문제 및 타입 안정성 문제 해결
// 해결책2의 문제점 = 코드가 너무 길어짐 + 사용자 정의 타입인 바, switch문에 사용 불가능
class SeasonsClass {
    public static final SeasonsClass SPRING = new SeasonsClass();
    public static final SeasonsClass SUMMER = new SeasonsClass();
    public static final SeasonsClass FALL = new SeasonsClass();
    public static final SeasonsClass WINTER = new SeasonsClass();

    /*
    @Override
    public String toString() {
        return "SeasonsClass{}";
    }
     */
}

class FrameworksClass {
    public static final FrameworksClass DJANGO = new FrameworksClass();
    public static final FrameworksClass SPRING = new FrameworksClass();
    public static final FrameworksClass NEST = new FrameworksClass();
    public static final FrameworksClass EXPRESS = new FrameworksClass();
}

// 해결책3 = enum(열거형)을 활용한 상수 정의 -> 상수 이름 중복x + 타입 안정성 보장 + 간결/단순하고 가독성 좋은 코드 + switch문에서도 사용/작동 가능 + 여러 상수들/변경되지 않는 한정적인 데이터를 보다 편리하게/효과적으로 선언/관리 가능
enum SeasonEnum {
    SPRING, // 각각의 열거 상수 = (열거)객체, 자동적으로 0부터 시작하는 정수 값이 할당되어 각 상수를 가리킴
    SUMMER, // 정수값 1 할당
    FALL,
    WINTER
}

enum FrameworksEnum {
    DJANGO,
    SPRING,
    NEST,
    EXPRESS
}

enum Level {
    LOW, // 0
    MEDIUM, // 1
    HIGH // 2
}

