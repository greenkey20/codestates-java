package com.codestates.section1.unit6.condition;

// 2023.7.9(일) 1h5
public class Condition16 {
    public String addOneSecond1(int hour, int minute, int second) {
        int sec = hour * 60 * 60 + minute * 60 + second + 1;

        // sec / 3600 = 시
        hour = sec / 3600 % 24;

        minute = sec % 3600 / 60;

        second = sec % 3600 % 60;

        return String.format("1초 뒤에 %d시 %d분 %d초 입니다", hour, minute, second);
    }

    public String addOneSecond2(int hour, int minute, int second) {
        // e.g.1) 23:59:59 -> 1초 뒤 = 0:0:0
        // e.g.2) 14:55:56 -> 1초 뒤 = 14:55:57
        if (second == 59) {
            second = 0;
            minute++;
        } else {
            second++;
        }

        if (minute == 60) {
            minute = 0;
            hour++;
        }

        if (hour == 24) {
            hour = 0;
        }

        // 1초 뒤에 {hour}시 {minute}분 {second}초 입니다
        return String.format("1초 뒤에 %d시 %d분 %d초 입니다", hour, minute, second);
    }

    public String addOneSecondReference(int hour, int minute, int second) {
        if (second == 59) {
            minute += 1;
            second = 0;
        } else {
            second += 1;
        }

        if (minute == 60) {
            hour += 1;
            minute = 0;
        }

        if (hour == 24) {
            hour = 0;
        }

        return "1초 뒤에 " + hour + "시 " + minute + "분 " + second + "초 입니다";
    }

    public static void main(String[] args) {
        Condition16 condition16 = new Condition16();

        System.out.println(condition16.addOneSecond2(23, 59, 59));
        System.out.println(condition16.addOneSecond2(14, 55, 56));
    }
}
