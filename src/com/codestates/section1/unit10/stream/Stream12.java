package com.codestates.section1.unit10.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream12 {
    public boolean isHot(int[] temperature) {
        if (temperature.length != 7) return false;

        IntStream stream = Arrays.stream(temperature);
        long result = stream.filter(i -> i >= 30).count();

        return result >= 3;
    }

    public boolean isHotReference(int[] temperature) {
        // 입력받은 온도 배열의 길이가 7이 아니면 false를 리턴합니다.
        if (temperature.length != 7) {
            return false;
        }
        // 스트림을 이용해서 주어진 정수 배열 중 30 이상인 요소의 갯수를 셉니다.
        long hotDays = Arrays.stream(temperature)
                .filter(temp -> temp >= 30)
                .count();
        // 30 이상인 요소의 갯수가 3개 이상인 경우 true, 아닌 경우 false를 리턴합니다.
        if (hotDays >= 3) {
            return true;
        } else {
            return false;
        }
    }
}
