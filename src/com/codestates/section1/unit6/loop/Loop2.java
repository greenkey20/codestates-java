package com.codestates.section1.unit6.loop;

// 2022.9.18(일) 1h50
public class Loop2 {
    public static boolean isOdd(int num) {
        /* 조건문을 사용하여 짝수인 경우 return false를, 홀수인 경우 return true를 작성
        반복(while)문을 사용, for문 사용은 금지
        나눗셈(/), 나머지(%) 연산자 사용은 금지
        0은 짝수로 간주 -> num이 0인 경우 false 반환/return
         */

        // 방법1) 페어님과 함께 작성한 풀이
        /*
        boolean flag = false;

        int i = 0;
        while (i != Math.abs(num)) {
            flag = !flag;
            i++;
        }

//        num = 4
//        i = 0 -> true
//        i = 1 -> false
//        i = 2 -> true
//        i = 3 -> false

        return flag;
         */

        // 방법2) 내가 작성한 풀이 <- 종이에 간단한 예제(num이 3인 경우)에 대해 i번째 반복 돌 때 flag 및 i의 값 변화 적어가며 확인함
        /*
        boolean flag = false;
        int i = 0;
        while (i < Math.abs(num)) {
            flag = !flag;
            i++;
        }

        return flag;
         */

        // 방법3) reference 코드, 방법2보다 반복 회수 반으로(n/2회 반복) 줄일 수 있는 듯..
        if (num < 0) {
            num = -num;
        }

        while (num > 0) {
            if (num == 1) {
                return true;
            }

            num -= 2;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isOdd(11));
        System.out.println(isOdd(-4));
    }
}
