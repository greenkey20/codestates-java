package com.codestates.section1.unit6.loop;

// 2022.9.17(토) 19h50
public class Loop13 {
    public static String replaceAll(String str, char from, char to) {
        String result = "";

        // 방법1) 문제 요구 사항대로 반복(for)문 사용
        /*
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == from) {
//                result += Character.toString(to); // 페어님과 함께 문제 풀이 시에는 char형 자료 to를 String 자료형으로 바꾸는 메서드 사용함
                result += to; // 문자열에 문자를 + 연산자로 더하면 자동으로 문자열로 형 변환되므로, 위와 같이 메서드 사용할 필요 없음
            } else {
//                result += Character.toString(str.charAt(i));
                result += str.charAt(i);
            }
        }
        */

        // 방법2) 반복문 사용하지 않고, String 클래스의 replace() 메서드 사용 -> for문 사용해야 한다는 조건 외에는 test cases 통과
//        result = str.replaceAll("from", "to"); // 이렇게 작성하면 str에 변화 없이 나옴
        result = str.replaceAll(Character.toString(from), Character.toString(to));

        return result;
    }

    public static void main(String[] args) {
        System.out.println(replaceAll("codestates", 's', 'S'));
    }
}
