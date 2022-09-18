package com.codestates.section1.unit6.loop;

// 2022.9.17(토) 22h15
public class Loop6 {
    // 1부터 num(1 이상의 정수)까지의 정수로 구성된 문자열을 리턴 <- 반복(while(o) for(x))문을 사용 + 숫자 사이를 '-'로 구분
    public static String makeDigits2(int num) {
        String result = "";

        // 방법1) 페어님과 함께 작성한 풀이
        /*
        int i = 1;
        while (i < num) {
            result += i;
            result += "-";
            i++;
        }

        result += i;
         */

        // 방법2a) 내가 스스로 작성해 본 풀이
        /*
        int intNum = 1;

        while (intNum != num) {
            result = intNum + "-";
            intNum++;
        }

        result += num;

        return result;
         */

        // 방법2b) for문 사용해서 작성해 봄
        String resultFor = "1";

        for (int intNum = 2; intNum <= num; intNum++) {
            resultFor += "-" + intNum;
        }

        return resultFor;

        // 방법3) 다른 학우님의 idea
        /*
        int intNum = 0;

        while (intNum++ < num) {
            result += intNum + "-";
        }

        return result.substring(0, result.length() - 1);
         */
    } // 문제 풀이 메소드 종료

    public static void main(String[] args) {
        System.out.println(makeDigits2(5));
    }
}
