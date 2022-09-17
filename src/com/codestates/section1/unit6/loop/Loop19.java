package com.codestates.section1.unit6.loop;

// 2022.9.11(일) 4h40
public class Loop19 {
    public static void main(String[] args) {
        // Java 코드 실행 시간 측정(https://hijuworld.tistory.com/2 참고)
        long beforeTime = System.currentTimeMillis(); // returns the current time in milliseconds

        String output = makePermutationsWithRepetition("0123456789");
        System.out.println(output);

        long afterTime = System.currentTimeMillis();
//        long secDiffTime = (afterTime - beforeTime) / 1000;
        long diffTime = afterTime - beforeTime;
        System.out.println("main() 실행 소요 시간 = " + diffTime + "밀리초"); // String 인스턴스 사용 시 73 vs StringBuilder 인스턴스 사용 시 2밀리초
    }

    public static String makePermutationsWithRepetition(String str) {
        // IntelliJ가 반복문 안에서 String에 대한 + 연산으로 문자열 연결 사용 지양 권고 -> StringBuilder로 반환할 문자열을 만들어 나감
        StringBuilder sb = new StringBuilder();
        String result = sb.toString();

        if (str.length() == 0) {
            return result;
        }

        for (int i = 0; i < str.length(); i++) {
//            sb.append(str.charAt(i));
            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(i)).append(str.charAt(j)).append(",");
            }
        }

        result = sb.toString();
        result = result.substring(0, result.length() - 1);

        return result;

        // 그럼에도 불구하고 String으로 반환할 문자열 만들어 나가보고 성능 비교해보자
        /*
        String result = "";

        if (str.length() == 0) {
            return result;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                result += Character.toString(str.charAt(i)) + Character.toString(str.charAt(j)) + ",";
            }
        }

        return result.substring(0, result.length() - 1);
         */
    }
}
