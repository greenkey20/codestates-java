package com.codestates.section1.unit6.condition;

// 2023.7.10(월) 14h25
public class Condition11 {
    public boolean isEitherEvenAndLessThan9(int num1, int num2) {
        if (num1 % 2 == 0 || num2 % 2 == 0) {
            if (num1 < 9 && num2 < 9){
                return true;
            }
        }

        return false;
    }
}
