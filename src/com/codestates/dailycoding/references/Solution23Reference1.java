package com.codestates.dailycoding.references;

import java.util.ArrayList;

// 2022.11.20(일) 1h20 파일 분리
public class Solution23Reference1 {
    // reference1 = 코플릿
    // naive solution -> O(2^N) -> 나의 질문 = 재귀 호출의 시간 복잡도는 어떻게 계산하지?
    public int fibonacciNaive(int num) {
        if (num <= 1) return num;
        return fibonacciNaive(num - 1) + fibonacciNaive(num - 2);
    }

    // dynamic with memoization
    /* primitive type (passed by values, values copied and retained in function calls)
    vs reference type (pointers, holding a reference to the object/instance(o) copying the object(x) in function calls) variables
     */
    public int fibonacciReference(int num) {
        ArrayList<Integer> memo = new ArrayList<>();
        memo.add(0);
        memo.add(1);

        return aux(memo, num);
    }

    // suggestion = name the function better/more clearly stating what it does
    // builds the list 'memo' up to the size of 'num' -> returns the 'num'th element of the list 'memo'
    // num - 2
    public int aux(ArrayList<Integer> memo, int num) {
        if (memo.size() <= num) {
            /* index : 0, 1, 2, 3, 4,...
            num: -, -, 2, 3, 4, 5..
            add: -, -, here, here, here, here..

            google "java order of operand evaluation" -> https://stackoverflow.com/questions/6800590/what-are-the-rules-for-evaluation-order-in-java
            two function calls in a line -> Java does not define which one would be called first, as Java has to consider both operands of +
            the outer most = +(addition)
            whole statement and its operations
            the last thing/operation = memo.add()
             */
            memo.add(aux(memo, num - 1) + aux(memo, num - 2)); // 나의 궁금증 = 인자 num-2 또는 num-1인 aux()를 먼저 호출 시 동작에 영향이 있을까? -> 코플릿에서 테스트 시 둘 다 모든 테스트케이스 통과는 함 + 왜 상관 없는지는 정확히 모르겠음
//            memo.add(aux(memo, num - 2) + aux(memo, num - 1));
        }

        return memo.get(num);
    }
}
