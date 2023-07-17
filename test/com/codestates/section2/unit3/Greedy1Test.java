package com.codestates.section2.unit3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.7.17(월) 9h15
public class Greedy1Test {

    @Test
    void testCase1() {
        // given
        int[] stuff = {70, 50, 80, 50};
        int limit = 100;

        // when
        Greedy1 greedy1 = new Greedy1();
        int result = greedy1.movingStuffV2(stuff, limit);

        // then
        assertEquals(3, result);
    }

    @Test
    void testCase2() {
        // given
        int[] stuff = {60, 80, 120, 90, 130};
        int limit = 140;

        // when
        Greedy1 greedy1 = new Greedy1();
        int result = greedy1.movingStuffV2(stuff, limit);

        // then
        assertEquals(4, result);
    }

    @Test
    void testCase3() {
        // given
        int[] stuff = {42, 25, 60, 73, 103, 167};
        int limit = 187;

        // when
        Greedy1 greedy1 = new Greedy1();
        int result = greedy1.movingStuffV2(stuff, limit);

        // then
        assertEquals(4, result);
    }

    @Test
    void testCase4() {
        // given
        int[] stuff = {60, 73, 80, 87, 103, 109, 119, 123, 128, 129, 136, 146, 153, 168, 182}; // stuffDesc = [182, 168, 153, 146, 136, 129, 128, 123, 119, 109, 103, 87, 80, 73, 60]
        int limit = 200;

        // when
        Greedy1 greedy1 = new Greedy1();
        int result = greedy1.movingStuffV2(stuff, limit);

        // then
        assertEquals(11, result);
    }

    @Test
    void testCase5() {
        // given
        int[] stuff = {60, 80, 120, 135};
        int limit = 140;

        // when
        Greedy1 greedy1 = new Greedy1();
        int result = greedy1.movingStuffV2(stuff, limit);

        // then
        assertEquals(3, result);
    }
}
