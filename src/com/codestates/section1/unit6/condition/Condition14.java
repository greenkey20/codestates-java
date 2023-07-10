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
            return Math.pow(side1, 2) == Math.pow(side2, 2) + Math.pow(side3, 2) ? true : false;
        } else if (max == side2) {
            return Math.pow(side2, 2) == Math.pow(side1, 2) + Math.pow(side3, 2) ? true : false;
        } else {
            return Math.pow(side3, 2) == Math.pow(side1, 2) + Math.pow(side2, 2) ? true : false;
        }
    }
}
