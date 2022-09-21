package com.codestates.section2.unit1;

// 2022.9.21(수) 8h10
public class Recursion2 {
    public static boolean isOdd(int num) {
        // 나눗셈, 나머지 연산자 사용 금지
        // 함수 isOdd()의 재귀 호출 횟수는 입력값의 크기의 절반과 비슷해야 함

        // pair programming 시간에 내가 작성한 방법
        /*
        num = Math.abs(num); // 나의 생각 = num이 음수일 때만 처리하면 되는데, 이 코드는 항상 실행되므로 비효율적일 것 같다..

        if (num == 0) {
            return false;
        } else {
            return true;
        }

        return isOdd(num - 2); // Unreachable statement
         */

        if (num < 0) {
            num = -num;
        }

        // 더 이상 쪼갤 수 없는 경우
        if (num == 1) {
            return true;
        }

        // 0은 짝수로 간주
        if (num == 0) {
            return false;
        }

        // 작은 단위로 쪼갤 수 있는 경우
        // 반복문 사용 금지
        /*
        while (num > 1) {
            num -= 2;
        }
         */

        return isOdd(num - 2);
    }

    public static void main(String[] args) {
        System.out.println(isOdd(-11));
    }
}
