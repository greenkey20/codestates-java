package com.codestates.section2.unit1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 2023.7.12(수) 9h15
public class Recursion11Test {

    @Test
    void testAndCase1() {
        // given
        boolean[] arr = new boolean[]{true, false, false};

        // when
        Recursion11 recursion11 = new Recursion11();
        boolean result = recursion11.or(arr);

        // then
        assertTrue(result);
    }

    @Test
    void testAndCase2() {
        // given
        boolean[] arr = new boolean[]{true, true, true};

        // when
        Recursion11 recursion11 = new Recursion11();
        boolean result = recursion11.or(arr);

        // then
        assertTrue(result);
    }

    @Test
    void testAndCase3() {
        // given
        boolean[] arr = new boolean[]{false, false, false};

        // when
        Recursion11 recursion11 = new Recursion11();
        boolean result = recursion11.or(arr);

        // then
        assertFalse(result);
    }

}
