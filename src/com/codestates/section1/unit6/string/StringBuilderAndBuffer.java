package com.codestates.section1.unit6.string;

// 2022.9.10(토) 23h40
public class StringBuilderAndBuffer {
    /* String 클래스와의 차이점
    1. StringBuffer 클래스의 인스턴스는 값 추가/변경/삭제 가능 <- 내부적으로 buffer라는 독립적인 공간(크기 기본 값은 16개 문자 저장; 인스턴스 생성 시 사용자가 설정한 크기보다 16개 문자를 더 저장할 수 있게 여유 있는 크기로 생성됨)을 가짐
    2. StringBuffer 인스턴스 사용해서 문자열 바로 추가 가능 vs + 연산자 이용해서 String 인스턴스 문자열 결합하면 내용이 합쳐진 새로운 String 인스턴스가 생성되어 공간 낭비 및 속도 느려짐
    3. StringBuffer는 thread의 동기화에 의해 성능이 떨어짐; multi-thread로 작성된 프로그램이 아닌 경우 StringBuffer의 동기화는 불필요하게 성능만 떨어뜨림 -> StringBuffer에서 thread의 동기화만 뺀 것 = StringBuilder
     */

    public static void main(String[] args) {
        StringBuffer str1 = new StringBuffer("Java");

        System.out.println("== capacity() 메서드 ==");
        StringBuffer str2 = new StringBuffer();
        StringBuffer str3 = new StringBuffer("Java");
        System.out.println(str2.capacity()); // 16 = 기본적으로 생성되는 버퍼 크기
        System.out.println(str3.capacity()); // 20 = 사용자가 설정한 크기 4 + 16

        System.out.println(str2); // 빈 문자열 ""

        System.out.println("== str1과 str3 비교 ==");
        // StringBuffer는 equals() 메서드가 오버라이딩 되어있지 않음 + 단, toString() 메서드는 오버라이딩 되어있음
        System.out.println(str1 == str3); // false
        System.out.println(str1.equals(str3)); // false
        System.out.println(str1.toString().equals(str3.toString())); // true

        System.out.println("== append() 메서드 ==");
        System.out.println("문자열1 = " + str1); // 문자열1 = Java
        System.out.println(str1.append(" programming")); // Java programming; append() 메서드의 반환 자료형은 StringBuffer로, 자신의 주소를 반환
        System.out.println("append() 메서드 호출 후 문자열1 = " + str1); // append() 메서드 호출 후 문자열1 = Java programming

        System.out.println("== delete() 메서드 ==");
        StringBuffer str4 = new StringBuffer("Java Oracle");
        System.out.println("문자열4 = " + str4); // 문자열4 = Java Oracle
        System.out.println(str4.delete(4, 8)); // Javacle
        System.out.println("delete() 메서드 호출 후 문자열4 = " + str4); // delete() 메서드 호출 후 문자열4 = Javacle
        System.out.println(str4.deleteCharAt(1)); // Jvacle
        System.out.println("deleteCharAt() 메서드 호출 후 문자열4 = " + str4); // deleteCharAt() 메서드 호출 후 문자열4 = Jvacle

        System.out.println("== insert() 메서드 ==");
        System.out.println(str1.insert(4, "Script")); // str1의 인덱스가 4인 위치부터 2번째 매개변수로 전달된 문자열 추가 -> JavaScript programming
        System.out.println("insert(인덱스, 문자열) 메서드 호출 후 문자열1 = " + str1); // insert(인덱스, 문자열) 메서드 호출 후 문자열1 = JavaScript programming
        System.out.println(str1.insert(22, 47)); // 22 = str1.length() -> append() 메서드와 같은 결과 반환 -> JavaScript programming47
        System.out.println("insert(인덱스, 정수) 메서드 호출 후 문자열1 = " + str1); // insert(인덱스, 정수) 메서드 호출 후 문자열1 = JavaScript programming47

//        System.out.println(str2.insert(4, 'e')); // 문자열 길이보다 큰 정수를 인덱스/매개변수로 전달하면 String index out of bounds 예외 발생
//        System.out.println(str3.insert(-1, 12.5678)); // 이 경우도 String index out of bounds 예외 발생
        System.out.println("insert(인덱스, 실수) 메서드 호출 후 문자열3 = " + str3.insert(0, 12.5678)); // insert(인덱스, 실수) 메서드 호출 후 문자열3 = 12.5678Java

        System.out.println("== StringBuilder 실습 ==");
        StringBuilder sb = new StringBuilder();
        sb.append("문자열 ").append("연결 ").append('x').append(' ').append(2.9);
        String str5 = sb.toString();
        System.out.println(sb); // 문자열 연결 x 2.9
        System.out.println(str5); // 문자열 연결 x 2.9
    } // main() 종료
}
