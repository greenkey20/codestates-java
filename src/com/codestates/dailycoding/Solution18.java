package com.codestates.dailycoding;

public class Solution18 {
    // 2022.10.5(수) 9h50
    public static int numberSearch(String str) {
        // 빈 문자열을 입력받은 경우, 0을 리턴
        if (str.isEmpty()) {
            return 0;
        }

        // 주어진 문자열 str에서 숫자 모두 찾기 -> 그 숫자들 더하기 = num1
        int num1 = 0;
        // 숫자(digit)는 연속해서 등장하지 않음 -> 나의 질문 = 하나의 숫자는 str 안에 여러 번 나오지 않는다/1개씩만 들어있다는 의미? -> 8번 테스트 케이스에 따르면 str에는 하나의 숫자가 여러 번 포함되어있을 수 있음
        // 주어진 문자(길이 1의 문자열)이 숫자(digit)인지 판단하는 방법은 여러 가지
        // e.g. 해당 문자가 숫자들의 집합(문자열 또는 배열)에 속하는지를 판단 <- Java String contains, Java String indexOf
        String digits = "0123456789";

        // e.g. str = "Sou2bgPJkS7Lp5r2j6jeWOts8X"
        /* 10h45 수정하며 이 부분 없앰
        for (int j = 0; j < digits.length(); j++) {
            String digit = String.valueOf(digits.charAt(j));
            int digitCount = 0; // 해당 숫자가 str에 몇 번 등장하는지 세기 위한 변수

            if (str.contains(digit)) {
                num1 += Integer.valueOf(digit);
            }
        }
         */

        // str에서 숫자와 공백을 제외한 나머지 문자열의 길이 구하기 = num2
        int num2 = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
//                num1 += Integer.valueOf(ch); // ch 알파벳에 해당하는 ASCII 코드 값이 더해짐
                num1 += Character.getNumericValue(ch);
            }

            if (!Character.isDigit(ch) && ch != ' ') {
                num2++;
            }
        }
//        System.out.println(num1); // 10h25 IntelliJ에서 로그 찍어보니, num2++ 대상 조건식 잘못씀(str 모든 문자에 대해 num2++ 되고 있었음)
//        System.out.println(num2);

        // return 정수로 반올림(num1 / num2) <- Math 클래스의 round() 함수는 실수의 소수점 첫번째 자리를 반올림하여 정수로 리턴
        return (int) Math.round((double) num1 / num2); // 정수끼리 나누면 버림만 됨 -> 나눗셈 연산의 피연산자 중 하나를 실수로 바꿔서 나눗셈하면, 나눗셈 결과는 실수이고, 그걸 반올림하면 의도하는 값 얻을 수 있음
    }

    // ideas
    // str 앞/뒤/안에 있는 모든 공백 없애고 시작

    public static void main(String[] args) {
        int output = numberSearch("Hello6 ");
        System.out.println(output); // 1

        output = numberSearch("Hello6 9World 2,");
        System.out.println(output); // 2

        output = numberSearch("Hello6 9World 2, Nic8e D7ay!");
        System.out.println(output); // 2

        output = numberSearch("Sou2bgPJkS7Lp5r2j6jeWOts8X"); // num1이 30이어야 하는데 10h45 version으로는 28
        System.out.println(output);
    }

    // reference code 공부 필요
    public int numberSearchReference(String str) {
        //찾아야 하는 숫자를 문자열로 모두 선언합니다.
        String digits = "0123456789";

        //입력된 문자열이 공백이라면 0을 리턴합니다.
        if (str.length() == 0) return 0;

        //숫자를 카운트할 변수와, 숫자를 제외한 문자열을 저장할 변수를 선언합니다.
        double sum = 0;
        String pureStr = "";

        //문자열을 순회합니다.
        for (int i = 0; i < str.length(); i++) {
            //digits의 값에서 str[i]의 값이 포함되어 있다면 (indefxOf는 값이 존재하면 해당 인덱스를, 없다면 -1을 리턴합니다)
            if (digits.indexOf(str.charAt(i)) != -1) {
                //숫자를 1 더해줍니다.
                sum = sum + Character.getNumericValue(str.charAt(i));
                //존재하지 않고, 공백이 아니라면
            } else if (str.charAt(i) != ' ') {
                //해당 문자열을 pureStr에 더해줍니다.
                pureStr = pureStr + str.charAt(i);
            }
        }
        //결과를 계산합니다. 계산된 숫자를 문자열의 길이로 나눈 이후,
        double result = sum / pureStr.length();
        //Math.round를 활용하여 소수점으로부터 반올림하여 리턴합니다.
        return (int) Math.round((result * 10) / 10); // 나의 생각 = Math.round()의 동작대로 소수점 아래 첫번째 자리에서 반올림해서 정수 반환하면 되니까, 인자로 그냥 result 주어도 되는 것 아닌가? -> 이렇게 했을 때 테스트 케이스는 모두 통과함
    }
}
