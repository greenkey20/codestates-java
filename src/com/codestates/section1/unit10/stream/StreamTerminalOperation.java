package com.codestates.section1.unit10.stream;

import java.util.Arrays;

// 2023.7.7(금) 22h35
public class StreamTerminalOperation {
    public static void main(String[] args) {
        // 기본 집계 = sum(), count(), average(), max(), min()

        // matching = 조건식 lambda predicate을 매개변수로 넘겨, 스트림 각 데이터 요소의 특정 조건 충족 여부 검사 -> boolean 값 결과 반환
        int[] intArray2 = {2, 4, 6};

        boolean result = Arrays.stream(intArray2).allMatch(element -> element % 2 == 0);
        System.out.println("요소 모두 2의 배수인가요? = " + result); // true

        result = Arrays.stream(intArray2).anyMatch(element -> element % 3 == 0);
        System.out.println("요소 중 하나라도 3의 배수가 있나요? = " + result); // true

        result = Arrays.stream(intArray2).noneMatch(element -> element % 3 == 0);
        System.out.println("요소 중 3의 배수가 하나도 없나요? " + result); // false

        // reduce()
    }

}
