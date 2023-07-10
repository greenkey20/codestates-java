package com.codestates.section1.unit6.condition;

public class Condition13 {
    public String convertScoreToGradeWithPlusAndMinus(int score) {
        String grade = "";

        if (score > 100 || score < 0) {
            return "INVALID SCORE";
        } else if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // 0~2 -> -
        // 8~9 -> +
        // 100+ 99+ 98+ ~ 92 91 90 A
        // 89+ 88+ ~ 82- 81- 80- B
        if (score == 100) {
            grade += "+";
        } else if (!grade.equals("F")) {
            if (score % 10 <= 2) {
                grade += "-";
            } else if (score % 10 >= 8) {
                grade += "+";
            }
        }

        return grade;
    }

    public String convertScoreToGradeWithPlusAndMinusReference(int score) {
        String grade;
        if (score > 100 || score < 0) {
            return "INVALID SCORE";
        }
        if (score == 100) {
            return "A+";
        }
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        if (!grade.equals("F")) {
            int extra = score % 10;
            if (extra <= 2) {
                grade = grade + "-";
            } else if (extra >= 8) {
                grade = grade + "+";
            }
        }

        return grade;
    }
}
