package com.codestates.section1.unit6.condition;

// 2023.7.10(월) 14h40
public class Condition8 {
    public int miniCalculator(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '%':
                result = num1 % num2;
                break;
        }

        return result;
    }
}
