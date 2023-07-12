package com.codestates.section2.unit1;

import java.util.Arrays;

// 2023.7.12(수) 9h30
public class Recursion11 {
    public boolean or(boolean[] arr) {
        if (arr.length == 0) {
            return false;
        }

        return arr[0] || or(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public boolean orReference(boolean[] arr) {
        if (arr.length == 0) return false;
        boolean head = arr[0];
        boolean tail = or(Arrays.copyOfRange(arr, 1, arr.length));

        if (head || tail) return true;
        return false;
    }
}
