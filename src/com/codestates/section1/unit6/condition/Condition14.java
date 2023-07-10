package com.codestates.section1.unit6.condition;

// 2023.7.10(월) 11H35
public class Condition14 {
    public boolean isPythagorean(int side1, int side2, int side3) {
        int max = side1;

        if (max < side2) {
            max = side2;
        }

        if (max < side3) {
            max = side3;
        }

        // side1^2 == side2^2 + side3^2
        if (max == side1) {
            return Math.pow(side1, 2) == Math.pow(side2, 2) + Math.pow(side3, 2);
        } else if (max == side2) {
            return Math.pow(side2, 2) == Math.pow(side1, 2) + Math.pow(side3, 2);
        } else {
            return Math.pow(side3, 2) == Math.pow(side1, 2) + Math.pow(side2, 2);
        }
    }

    public boolean isPythagoreanReference(int side1, int side2, int side3) {
        int pow1 = side1 * side1;
        int pow2 = side2 * side2;
        int pow3 = (int) Math.pow(side3, 2);

        if (pow1 == pow2 + pow3 || pow2 == pow1 + pow3 || pow3 == pow1 + pow2) {
            return true;
        }

        return false;
    }
}
