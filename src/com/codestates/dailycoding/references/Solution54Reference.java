package com.codestates.dailycoding.references;

import java.util.Arrays;
import java.util.Stack;

// 2022.11.29(화) 11h55 참고
// naive solution: O(N) -> 나의 질문 = reference 상 naive라고 되어있는데, naive하지 않은 것 아닌가?
public class Solution54Reference {
    public int largestRectangularArea(int[] histogram) {
        int maxArea = 0;
        int[] tempPLE = new int[histogram.length];
        int[] tempNLE = new int[histogram.length];
        Arrays.fill(tempPLE, -1);
        Arrays.fill(tempNLE, -1);

        int[] PLE = findPLE(tempPLE, histogram);
        int[] NLE = findNLE(tempNLE, histogram);
        for (int i = 0; i < histogram.length; i++) {
            int barsOnLeft = PLE[i] == -1 ? i : i - PLE[i] - 1;
            int barsOnRight = NLE[i] == -1 ? histogram.length - 1 - i : NLE[i] - i - 1;
            int width = barsOnLeft + barsOnRight + 1;
            maxArea = Math.max(maxArea, width * histogram[i]);
        }
        return maxArea;
    }

    public int[] findPLE(int[] PLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < histogram.length; i++) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                PLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return PLE;
    }

    public int[] findNLE(int[] NLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for (int i = histogram.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                NLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return NLE;
    }
}