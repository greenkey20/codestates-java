package com.codestates.dailycoding;

public class Solution14 {
    // 2022.9.29(목) 10h20 -> 10h30 6번 테스트 케이스([-2123, 843, -733, 1156, -919]을(를) 입력받은 경우, false를 리턴해야 함) 통과 못함 vs 2022.9.30(금) 9h55 수정 = int형 변수 sum의 선언 위치
    public static boolean superIncreasing(int[] arr) {
        // 알고리즘 > pseudocode 개념 학습에서 나왔던 예시
        // 각 요소들이 그 이전의 요소들의 합보다 큰지 여부를 리턴
//        int sum = 0;

        // 2022.9.30(금) 10h reference code 보니, 내 코드는 2중 반복문을 사용해서 시간복잡도 비교적 나쁨 vs 내 코드에 중첩 반복문이 보이/사용되면 개선할 방법/로직을 생각해보자
        for (int i = 1; i < arr.length; i++) {
            int sum = 0; // 2022.9.30(금) 9h55 수정

            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }

            if (sum >= arr[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean output = superIncreasing(new int[]{1, 3, 6, 13, 54});
        System.out.println(output); // true

        output = superIncreasing(new int[]{1, 3, 5, 9});
        System.out.println(output); // false

        output = superIncreasing(new int[]{-2123, 843, -733, 1156, -919});
        System.out.println(output); // false
    }
}
