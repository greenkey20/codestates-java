package com.codestates.section1.unit6.loop;

// 2022.9.17(토) 22h15
public class Loop6 {
    // 1부터 num(1 이상의 정수)까지의 정수로 구성된 문자열을 리턴
    public String makeDigits2(int num) {
        String result = "";

        int i = 1;
        while (i < num) {
            result += i;
            result += "-";
            i++;
        }

        result += i;
        return result;
    }
}
