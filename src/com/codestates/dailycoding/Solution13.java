package com.codestates.dailycoding;

public class Solution13 {
    // 2022.9.29(목) 9h50
    public String readVertically(String[] arr) {
        String result = "";

        // arr 배열에 담긴 문자열 중 길이가 가장 긴 문자열의 길이 정보(int 값) 구하기
        int biggestLen = arr[0].length();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > biggestLen) {
                biggestLen = arr[i].length();
            }
        }

        // 종이에 arr를 행렬 모양으로 그려서 반복문 어떻게 돌릴지 생각해봄
		/* e.g. arr = {"hi",
					   "world",
					   "hej"}

		arr를 2차원 행렬의 인덱스로 표현해보면
		[00 01
		 10 11 12 13 14
		 20 21 22]

		각 인덱스가 반환되어야 하는 문자열에 쌓이는 순서 = "00 10 20 01 11 21 12 22 13 14"
		*/

        for (int i = 0; i < biggestLen; i++) { // 문자열 길이 인덱스별(<-arr 배열에 담긴 문자열 중 길이가 가장 긴 문자열의 길이만큼 반복문을 돌면서, i)
            for (int j = 0; j < arr.length; j++) { // arr 배열에 담긴 문자열의 개수만큼 반복문을 돌며(j)
                // 단, j번째 행에 i번째 글자가 없는 경우 arr[j].charAt(i)를 찾으면 예외가 발생할 수 있으므로 별도 처리 필요 -> arr[j].charAt(i)를 찾아야 하는 순서가 되면, arr[j]에서 글자 찾지 말고 arr[j+1]로 넘어가자
                if (i >= arr[j].length()) {
                    continue;
                }

                char ch = arr[j].charAt(i); // j번째 문자열/원소/행의 i번째 글자를 뽑아와서
                result += ch; // result 문자열에 더함
            }
        }

        return result;
    }

    // 2022.9.29(목) 10h20 reference code 읽어서는 이해 잘 안 됨 -> 손 그림 그려가며 이해해보자..
    public String readVerticallyReference(String[] arr) {
        //가장 긴 문자열의 길이를 검색합니다.
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            if (maxLength < arr[i].length()) {
                maxLength = arr[i].length();
            }
        }

        //임시로 해당 길이만큼의 배열을 선언한 뒤,
        String[] temp = new String[maxLength];

        //기존의 배열을 순회합니다.
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            //해당 배열의 요소인 문자열을 순회합니다.
            for (int j = 0; j < str.length(); j++) {
                if (temp[j] == null) { //임시 배열이 비어있다면
                    //문자열의 j번째 char를 String으로 변환후 배열에 삽입 (세로위치 첫 문자열)
                    temp[j] = Character.toString(str.charAt(j));
                } else { //임시 배열이 비어있지 않다면, 임시 배열의 기존 문자열에 현재 j번째 char를 더해줍니다.
                    temp[j] = temp[j] + str.charAt(j);
                }
            }
        }

        //배열을 순회하며 String으로 변환합니다.
        String result = "";
        for (int i = 0; i < temp.length; i++) {
            result = result + temp[i];
        }

        return result;
    }
}
