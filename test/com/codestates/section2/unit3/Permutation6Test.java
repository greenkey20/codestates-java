package com.codestates.section2.unit3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Permutation6Test {

    @Test
    void testCase1() {
        // given
        int[] stuffArr = {1, 10, 11000, 1111};
        int choiceNum = 2;

        // when
        Permutation6 permutation6 = new Permutation6();
        ArrayList<Integer[]> result = permutation6.newChickenRecipe(stuffArr, choiceNum);

        // then
        // 콘솔 출력 결과 확인?
        ArrayList<Integer[]> expected = new ArrayList<>();
        expected.add(new Integer[]{1, 10});
        expected.add(new Integer[]{1, 1111});
        expected.add(new Integer[]{10, 1});
        expected.add(new Integer[]{10, 1111});
        expected.add(new Integer[]{1111, 1});
        expected.add(new Integer[]{1111, 10});

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expected.get(i)[1], result.get(i)[1]);
        }
    }
}
