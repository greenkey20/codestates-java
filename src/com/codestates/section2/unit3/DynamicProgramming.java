package com.codestates.section2.unit3;

// 2022.11.19(토) 23h55
public class DynamicProgramming {
    public long ocean(int target, int[] type) {
        long[] bag = new long[target + 1];
        bag[0] = 1;
        for (int i = 0; i < type.length; i++) {
            for (int j = 1; j <= target; j++)
                if (type[i] <= j)
                    bag[j] += bag[j - type[i]];
        }
        return bag[target];
    }

}
