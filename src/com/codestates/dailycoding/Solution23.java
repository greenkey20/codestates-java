package com.codestates.dailycoding;

import java.util.ArrayList;

public class Solution23 {
    // 2022.10.13(목) 9h50 -> 10h10 모든 테스트 케이스 통과
    // 나의 질문 = 코플릿에서도 fibonacci() 메서드를 static으로 만들어주지 않으면 '실행 시간을 초과했습니다'로 실행이 제대로 되지 않는데, 왜 그런 걸까? -> 2022.11.17(목) 14h50 나의 생각/질문 = 내가 현재/처음에 제출한 코드는 문제에서 요구하는 효율적인 알고리즘이 아님 + knou 동적 프로그래밍 피보나치 예제(성능 O(n)) 보다가 memorization과 dynamic programming은 관계가 있는 것인가?
    // google 'memoization vs dynamic programming' -> https://stackoverflow.com/questions/6184869/what-is-the-difference-between-memoization-and-dynamic-programming
    public static int fibonacci(int num) {
        // 피보나치 수열 중 num(0 이상의 정수)번째 항의 수를 리턴
        // 재귀함수를 이용해 구현해야 함, 반복문(for/while) 사용 금지, 함수 fibonacci()가 반드시 재귀함수일 필요는 없음
        // 피보나치 수열을 구하는 효율적인 알고리즘(O(N))이 존재함 -> 재귀함수의 호출을 직접 관찰하여 비효율이 있는지 확인하기
        // 종이/펜으로 흐름 메모해서 로직 짬

        // 문제를 더 이상 쪼갤 수 없는 경우
        /*
        if (num == 0) { // 0번째 피보나치 수는 0
            return 0;
        } else if (num == 1) { // 1번째 피보나치 수는 1 -> 이렇게 else if로 연결해서 쓰지 않아도 됨
            return 1;
        } else { // 더 작은 단위로 쪼갤 수 있는 경우
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
         */

        // 문제를 더 이상 쪼갤 수 없는 경우 = 0번째 피보나치 수는 0, 1번째 피보나치 수는 1
        /*
        if (num == 0 || num == 1) return num;

        // 더 작은 단위로 쪼갤 수 있는 경우
        return fibonacci(num - 1) + fibonacci(num - 2);
         */

        // 2022.11.25(금) 10h25 memoization으로 구현한 dynamic programming 풀이 reference 참고하며 직접 쳐보기
        ArrayList<Integer> memo = new ArrayList<>();
        memo.add(0); // 피보나치 수열의 첫번째 요소 정의
        memo.add(1); // 피보나치 수열의 두번째 요소 정의

        return fibMemoized(memo, num);
    }

    public static int fibMemoized(ArrayList<Integer> memo, int num) {
        if (memo.size() <= num) { // 2022.11.25(금) 10h35 나의 생각 = 여전히 이런 조건은 어떻게 생각해낼 수 있을지 막막하다.. 2022.11.20(일) 새벽에 재귀 흐름 써가며 로직 확인해 봤으나, 여전히 명확히 이해 안 됨/잘 와닿지 않음
            memo.add(fibMemoized(memo, num - 1) + fibMemoized(memo, num - 2));
        }

        return memo.get(num);
    }

    public static void main(String[] args) {
        int output = fibonacci(0);
        System.out.println(output); // 0

        output = fibonacci(1);
        System.out.println(output); // 1

        output = fibonacci(5);
        System.out.println(output); // 5

        output = fibonacci(9);
        System.out.println(output); // 34

        output = fibonacci(10);
        System.out.println(output); // 55

        output = fibonacci(15);
        System.out.println(output); // 610
    }

    /* dynamic with memoization = 이미 해결한 문제의 정답을 따로 기록해두고, 다시 해결하지 않는 기법 -> O(N) -> 나의 질문 = 이 알고리즘의 시간 복잡도는 어떻게 계산하지?
    e.g. fibo(10)
       = fibo(9) + fibo(8)
       = fibo(8) + fibo(7) + fibo(7) + fibo(6)

     references
     1. 피보나치 수열 재귀, DP, loop 방법으로 구현하고 차이 확인 https://wedul.site/421
     2. YouTube 엔지니어대한민국 영상 정리한 '피보나치 수열의 시간 복잡도 완벽히 이해' https://chanos.tistory.com/entry/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98-%EC%88%98%EC%97%B4%EC%9D%98-%EC%8B%9C%EA%B0%84-%EB%B3%B5%EC%9E%A1%EB%8F%84-%EC%99%84%EB%B2%BD%ED%9E%88-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0
     3. 시간복잡도가 O(n)인 재귀함수로 피보나치 수열 구하기 https://baechu-story.tistory.com/9
     4. google 'memoization fibonacci java'
     */
    // reference2
}
