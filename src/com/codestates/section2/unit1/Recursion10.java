package com.codestates.section2.unit1;

import java.util.Arrays;

// 2023.7.12(수) 9h10
public class Recursion10 {
    public boolean and(boolean[] arr) {
        if (arr.length == 0) {
            return true;
        }

        return arr[0] && and(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public boolean andReference(boolean[] arr) {
        if (arr.length == 0) return true;
        boolean head = arr[0];
        boolean tail = and(Arrays.copyOfRange(arr, 1, arr.length));

        if (!head || !tail) return false;
        return true;
    }
}
