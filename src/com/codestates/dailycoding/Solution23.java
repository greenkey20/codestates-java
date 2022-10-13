package com.codestates.dailycoding;

import java.util.ArrayList;

public class Solution23 {
    // 2022.10.13(목) 9h50 -> 10h10 모든 테스트 케이스 통과
    // 나의 질문 = 코플릿에서도 fibonacci() 메서드를 static으로 만들어주지 않으면 '실행 시간을 초과했습니다'로 실행이 제대로 되지 않는데, 왜 그런 걸까?
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
        if (num == 0 || num == 1) return num;

        // 더 작은 단위로 쪼갤 수 있는 경우
        return fibonacci(num - 1) + fibonacci(num - 2);
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

    // naive solution -> O(2^N) -> 나의 질문 = 재귀 호출의 시간 복잡도는 어떻게 계산하지?
    // public int fibonacci(int num) {
    // 	if (num <= 1) return num;
    // 	return fibonacci(num - 1) + fibonacci(num - 2);
    // }

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
    // reference1
    public int fibonacciReference1(int num) {
        ArrayList<Integer> memo = new ArrayList<>();
        memo.add(0);
        memo.add(1);

        return aux(memo, num);
    }

    public int aux(ArrayList<Integer> memo, int num) {
        if (memo.size() <= num) {
            memo.add(aux(memo, num - 1) + aux(memo, num - 2));
        }
        return memo.get(num);
    }

    // reference2
}
