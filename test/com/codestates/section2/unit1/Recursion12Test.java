package com.codestates.section2.unit1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.7.15(토) 10h10
public class Recursion12Test {

    @Test
    void testCase1() {
        // given
        int[] arr = {1, 2, 3, 4};

        // when
        Recursion12 recursion12 = new Recursion12();
        int[] result = recursion12.reverseArrV2(arr); // V1도 테스트 통과

        // then
        assertEquals(result[0], 4);
        assertEquals(result[1], 3);
        assertEquals(result[2], 2);
        assertEquals(result[3], 1);
    }
}
