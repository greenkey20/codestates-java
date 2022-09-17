package com.codestates.section1.unit6.loop;

// 2022.9.11(일) 23h50
public class Loop17 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            System.out.println("2,147,483,647은 소수인가? = " + isPrime(2_147_483_647)); // int 자료형이 표현할 수 있는 가장 큰 정수 = 2,147,483,647
        }

        long endTime = System.currentTimeMillis();
        long diffTime = endTime - startTime;
        System.out.println("main() 실행 소요 시간 = " + diffTime + "밀리초"); // 내가 처음 작성한 알고리즘은 76036밀리초 소요 vs 약수의 개수에 대한 성질 및 Math.sqrt 활용한 알고리즘은 38밀리초 소요
    }

    /* 입력 = 1 이상의 자연수
    문제 hint = Math(square root/제곱근)를 활용해 불필요한 연산을 줄일 수 있음
     */
    public static boolean isPrime(int num) {
        /* 내가 작성한 방법
        boolean result = false;

        if (num == 1) {
            return result;
        } else if (num == 2) {
            return !result;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return result;
                }
            }

            return !result;
        }
         */

        // 2022.8.31(수) 17h session 강사님 방법
        // 인자로 1을 입력받은 경우 처리 -> 1은 소수가 아님
        if (num == 1) {
            return false;
        }

        // 인자로 2을 입력받은 경우 처리 -> 2는 소수임
        if (num == 2) {
            return true;
        }

        // 인자로 짝수를 입력받은 경우 처리 -> 짝수는 소수가 아님
        if (num % 2 == 0) {
            return false;
        }

        // 그 외 int 자료형으로 표현할 수 있는 정수를 인자로 입력받은 경우 처리
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
