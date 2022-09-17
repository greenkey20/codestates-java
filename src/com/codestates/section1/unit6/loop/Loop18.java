package com.codestates.section1.unit6.loop;

// 2022.9.11(일) 23h45 + 2022.9.12(월) 23h30
public class Loop18 {
    public static void main(String[] args) {

    }

    // 입력 = 2 이상의 자연수
    public static String listPrimes(int num) {
        /*
        if (num == 2) {
            return "2";
        }
         */

        String result = "";
//        int count = 0;

        for (int i = 2; i <= num; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) { // i가 j로 나누어 떨어지면/j가 i의 약수이면 i는 소수가 아님 -> (i + 1)이 소수인지 검사하러 감
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                result = result + i + "-";
            }
        }

        return result.substring(0, result.length() - 1);
    }
}
