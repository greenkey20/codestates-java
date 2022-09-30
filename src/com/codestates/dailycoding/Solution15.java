package com.codestates.dailycoding;

public class Solution15 {
    // 2022.9.30(금) 10h
    public static Integer modulo(int num1, int num2) {
        // 나눗셈(/), 나머지(%) 연산자 사용은 금지 -> 나눗셈 = 뺄셈을 반복했을 때 0과 가장 가까이 남는 자연수
        // 0은 어떤 수로 나누어도 나머지가 0
        // num1, num2는 모두 0 이상의 정수
        // 나의 질문 = modulo() 메서드 반환 자료형이 굳이 Integer로 주어진 이유가 있을까?

        // 어떤 수도 0으로 나눌 수 없음 -> num2가 0인 경우 null 리턴
        if (num2 == 0) {
            return null;
        }

        // 테스트 케이스 몇 개에 대해 반복문이 돌 때 num1, num2, result 변수의 값의 변화를 종이에 써서 동작 확인함
        // 10h30 reference code 보니, result라는 별도 변수 만들 필요 없었음..
        Integer result = new Integer(num1 - num2);

        while (result >= 0) {
            result = num1 - num2;
            num1 = result;
        }

        return result + num2;
    }

    public static void main(String[] args) {
        Integer output = modulo(25, 4);
        System.out.println(output); // 1

        output = modulo(25, 0);
        System.out.println(output); // null

        output = modulo(7, 7);
        System.out.println(output); // 0

        output = modulo(0, 10);
        System.out.println(output); // 0
    }
}
