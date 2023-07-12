package com.codestates.section2.unit1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 2023.7.12(수) 9h15
public class Recursion10Test {

    @Test
    void testAndCase1() {
        // given
        boolean[] arr = new boolean[]{true, false, false};

        // when
        Recursion10 recursion10 = new Recursion10();
        boolean result = recursion10.and(arr);

        // then
        assertFalse(result);
    }

    @Test
    void testAndCase2() {
        // given
        boolean[] arr = new boolean[]{true, true, true};

        // when
        Recursion10 recursion10 = new Recursion10();
        boolean result = recursion10.and(arr);

        // then
        assertTrue(result);
    }

    @Test
    void testAndCase3() {
        // given
        boolean[] arr = new boolean[]{false, false, false};

        // when
        Recursion10 recursion10 = new Recursion10();
        boolean result = recursion10.and(arr);

        // then
        assertFalse(result);
    }

}
