package com.codestates.section1.unit6.condition;

// 2023.7.10(월) 14h10
public class Condition12 {
    public char convertScoreToGrade(int score) {
        if (score > 100 || score < 0) return 'X';

        /*
        if (score >= 90) {
          return 'A';
        } else if (score >= 80) {
          return 'B';
        } else if (score >= 70) {
          return 'C';
        } else if (score >= 60) {
          return 'D';
        } else {
          return 'F';
        }
        */

        int num = score / 10;

        switch (num) {
            case 10:
                return 'A';
            case 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C';
            case 6:
                return 'D';
            default:
                return 'F';
        }
    }
}
