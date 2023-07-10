package com.codestates.section1.unit6.condition;

public class Condition10 {
    public String followingDay(String day) {
        String nextDay = "";

        switch (day) {
            case "월요일":
                nextDay = "화요일";
                break;
            case "화요일":
                nextDay = "수요일";
                break;
            case "수요일":
                nextDay = "목요일";
                break;
            case "목요일":
                nextDay = "금요일";
                break;
            case "금요일":
                nextDay = "토요일";
                break;
            case "토요일":
                nextDay = "일요일";
                break;
            case "일요일":
                nextDay = "월요일";
                break;
            default:
                nextDay = "올바른 요일이 아닙니다";
                break;
        }

        return nextDay;
    }
}
