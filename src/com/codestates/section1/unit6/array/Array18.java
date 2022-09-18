package com.codestates.section1.unit6.array;

import java.util.Arrays;

// 2022.9.18(일) 16h25
public class Array18 {
    public static String createPhoneNumber(int[] arr) {
        /* 0-9 사이의 정수를 요소로 갖는 + 길이는 8(길이가 8인 경우 앞에 [0, 1, 0]이 있다고 가정) 또는 11인 int[] 배열 arr을 입력받음 -> 전화번호 형식의 문자열(String 타입 자료)을 리턴
        반복문(for, while) 사용은 금지
        e.g. arr = 1, 2, 3, 4, 5, 6, 7, 8
        str = (010)
        String str = "(010)xxxx-xxxx"
        */

        // 방법1) 페어님과 함께 작성한 풀이
        /*
        String str = Arrays.toString(arr); // "12345678" "(010)1234-5678" "[2, 4, 3, 1..]"
        str = str.replaceAll(", ", "");
        str = str.replace("[", "");
        str = str.replace("]", ""); // 01012345678

        String phoneNumber = "";

        if (arr.length == 8) {
            phoneNumber = "(010)" + str.substring(0, 4) + "-" + str.substring(4, arr.length);
        } else {
            phoneNumber = "(" + str.substring(0, 3) + ")" + str.substring(3, 7) + "-" + str.substring(7, arr.length);
        }
         */

        // 방법2) 내가 작성해 본 풀이 -> 의도하는 형식의 전화번호가 리턴되나, '반복문 사용 금지'라는 문제 요구 사항 지키지 못함
        /*
        String phoneNumber = "(";

        if (arr.length == 11) { // 길이가 11인 배열이 입력으로 주어진 경우
            for (int i = 0; i < arr.length; i++) { // 배열의 원소들(0~9 범위의 정수)을 앞에서부터 차례대로 순회하면서
                phoneNumber += arr[i]; // 반환할 전화번호 문자열에 하나씩 붙임
                if (i == 2) { // 3번째 숫자까지 붙였을 때
                    phoneNumber += ")"; // 닫는 괄호 붙여줌
                }

                if (i == 6) { // 7번째 숫자까지 붙였을 때
                    phoneNumber += "-"; // -(dash) 기호 붙여줌
                }
            }
        } else { // 길이가 8인 배열이 입력으로 주어진 경우
            phoneNumber += "010)"; // 반환할 전화번호 양식 맨 앞에 010)을 붙여줌

            for (int i = 0; i < arr.length; i++) { // 배열의 원소들(0~9 범위의 정수)을 앞에서부터 차례대로 순회하면서
                phoneNumber += arr[i]; // 반환할 전화번호 문자열에 하나씩 붙임
                if (i == 3) { // 4번째 숫자까지 붙였을 때
                    phoneNumber += "-"; // -(dash) 기호 붙여줌
                }
            }
        }
         */

        // 방법3) '반복문 사용 금지'라는 문제 요구 사항 지키기 + 강사님 해설 참고
        String arrInString = Arrays.toString(arr);
//        System.out.println(arrInString); // [0, 1, 1, 4, 3, 2, 1, 8, 7, 6, 5]

        arrInString = arrInString.replaceAll(", ", "").replace("[", "").replace("]", "");
//        System.out.println(arrInString); // 01143218765

        // 내가 만들어서 반환하려는 문자열의 패턴/형식 = (%s)%s-%s, head, body, tail
        String head = arr.length == 11 ? arrInString.substring(0, 3) : "010";
        String body = arrInString.substring(arrInString.length() - 8, arrInString.length() - 4);
        String tail = arrInString.substring(arrInString.length() - 4); // String 클래스의 substring() 인자로 끝 인덱스 안 쓰면, 인자로 기재한 시작 인덱스부터 문자열 끝까지 얻음

        return String.format("(%s)%s-%s", head, body, tail);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
//        System.out.println(Arrays.toString(arr1));
        System.out.println(createPhoneNumber(arr1)); // (010)1234-5678

        int[] arr2 = {0, 1, 1, 4, 3, 2, 1, 8, 7, 6, 5};
        System.out.println(createPhoneNumber(arr2)); // (011)4321-8765

        System.out.println(createPhoneNumber(new int[]{8, 7, 6, 5, 4, 3, 2, 1})); // (010)8765-4321
    }

    public static String createPhoneNumberReference(int[] arr) {
        String head = "010";

        int len = arr.length;

        // Arrays.copyOfRange(복사 대상 배열 참조변수, 시작 인덱스, 끝 인덱스) -> 배열 일부 복사해서 새로운 배열을 만들어 반환
        String bodyArr = Arrays.toString(Arrays.copyOfRange(arr, len - 8, len - 4));
        String body = bodyArr
                .replaceAll(" ", "")
                .replaceAll(",", "")
                .replace("[", "")
                .replace("]", "");

        String tailArr = Arrays.toString(Arrays.copyOfRange(arr, len - 4, len));
        String tail = tailArr
                .replaceAll(" ", "")
                .replaceAll(",", "")
                .replace("[", "")
                .replace("]", "");

        if (len == 11) {
            String headArr = Arrays.toString(Arrays.copyOfRange(arr, 0, 3));
            head = headArr
                    .replaceAll(" ", "")
                    .replaceAll(",", "")
                    .replace("[", "")
                    .replace("]", "");
        }

        return String.format("(%s)%s-%s", head, body, tail);
    }
}
