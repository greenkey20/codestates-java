package com.codestates.dailycoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution11 {
    // 2022.9.27(화) 10h55
    public static String[] removeExtremes(String[] arr) {
        // 가장 짧은 문자열의 길이와 가장 긴 문자열의 길이가 같은 경우는 없음
        // arr[i].length()는 20 이하 -> int min을 20으로 초기화하고 시작할 수 있음

        // arr 배열을 순회하며 String 타입 요소 각각의 길이를 구해서 배열에 담음
        int[] lengths = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            lengths[i] = arr[i].length();
        }

        // 테스트용 출력문
        // System.out.println("lengths[] 배열 = " + Arrays.toString(lengths));

        /*
        for (String s : arr) {
            lengths[i] = s.length(); // Cannot resolve symbol 'i'
        }
         */

        // 공백을 입력받을 경우 null을 반환
        int sum = 0;
        for (int length : lengths) {
            sum += length;
        }

        if (sum == 0) {
            return null;
        }

        // lengths 배열에 담긴 숫자들 중 가장 큰 숫자와 가장 작은 숫자가 담긴 인덱스 파악
        // 가장 짧은 문자열 또는 가장 긴 문자열이 다수일 경우, 나중에 위치한 문자열을 제거 -> 아래와 같이 for문 안에서 min/maxIndex에 담긴 값 업데이트해 가도 됨
        // 나의 풀이 과정의 문제점 = 내가 충분히 생각을 정리하지 않고 바로 구현하다가, 여기서 각 변수의 초기 값 설정(어떤 값으로 초기화할지), 업데이트 내용 작성에 시간을 너무 많이 씀 ㅠㅠ
        int min = lengths[0];
        int minIndex = 0;

        int max = lengths[0];
        int maxIndex = 0;

        for (int i = 1; i < lengths.length; i++) {
        /*
        int min = 0;
        int minIndex = 0;

        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < lengths.length; i++) {
         */
            if (lengths[i] <= min) {
                min = lengths[i];
                minIndex = i;
            }

            if (lengths[i] >= max) {
                max = lengths[i];
                maxIndex = i;
            }
        }

        // 테스트용 출력문
//        System.out.println("가장 짧은 문자열을 가진 인덱스 = " + minIndex);
//        System.out.println("가장 긴 문자열을 가진 인덱스 = " + maxIndex);

        // 가장 짧은 문자열과 가장 긴 문자열을 제거해서 리턴할 배열 준비
        // 방법1) Stream API 사용 -> IntelliJ에서는 실행되는데 코플릿에서 왜 'error: cannot find symbol' 에러 발생하는지 모르겠음
        /*
         final int minIndexFinal = minIndex;
         final int maxIndexFinal = maxIndex;
         String[] result = IntStream.range(0, arr.length).filter(index -> index != minIndexFinal && index != maxIndexFinal).mapToObj(index -> arr[index]).toArray(String[]::new);
         */
        // return IntStream.range(0, arr.length).filter(index -> index != minIndexFinal && index != maxIndexFinal).mapToObj(index -> arr[index]).toArray(String[]::new);

        // 방법2) 배열을 List로 바꿔서 remove(인덱스)
        List<String> resultList = new ArrayList<>(Arrays.asList(arr));
        // 테스트용 출력문
//        System.out.println(resultList);

        // 그냥 아래와 같이 remove()하면 IndexOutOfBoundsException 발생
//        resultList.remove(minIndex);
//        resultList.remove(maxIndex);

        if (minIndex < maxIndex) {
            resultList.remove(minIndex);
            resultList.remove(maxIndex - 1);
        } else {
            resultList.remove(maxIndex);
            resultList.remove(minIndex - 1);
        }

        String[] result = resultList.toArray(new String[arr.length - 2]);
        return result;
    }

    public static void main(String[] args) {
        // Non-static method 'removeExtremesReference(java.lang.String[])' cannot be referenced from a static context
        String[] output = removeExtremes(new String[]{"a", "b", "c", "def"});
        System.out.println(Arrays.toString(output)); // --> ["a"', "b"] vs 11h15 테스트 시 [b, c] -> 가장 짧은/긴 문자열 구하려고 비교 시작 대상 = lengths[] 배열의 첫번째 요소(o) int 기본 값 0(x)

        output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(Arrays.toString(output)); // --> ["where", "the", "word"] vs 11h15 테스트 시 [is, the, longest]

        output = removeExtremesReference(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(Arrays.toString(output));
    }

    public static String[] removeExtremesReference(String[] arr) {
        // 입력된 문자열이 공백일때 null을 리턴 -> 나의 질문 = 아래 코드는 입력된 문자열이 없을 때 아닌가? ""이 arr 배열의 원소로 있을 때(도) null을 반환해야 한다는 의미로 나는 이해했는데..?! >.<
        if (arr.length == 0) {
            return null;
        }

        // 최대 길이는 20, 최소 길이는 0으로 기본값을 설정합니다 -> 나의 관찰 = 주석 내용과 구현 내용의 불일치(-> 로직 보고 내 코드 수정/반영 시 헷갈렸음 ㅠㅠ)
        // 가장 작은 인덱스와 가장 긴 문자열의 인덱스를 찾기 위해 0으로 기본값을 설정합니다.
        int shortestLen = 20;
        int longestLen = 0;
        int shortestIdx = 0;
        int longestIdx = 0;

        //배열의 길이만큼 순회합니다.
        for (int i = 0; i < arr.length; i++) {
            //해당 요소(문자열)이 longestLen보다 클때
            if (arr[i].length() >= longestLen) {
                //longestLen에 현재 문자열의 길이를 넣어주고, longestIdx에 현재 인덱스를 넣어줍니다.
                longestLen = arr[i].length();
                longestIdx = i;
            }
            //같은 방식으로 최소 문자열과 인덱스를 찾아 대입합니다.
            if (arr[i].length() <= shortestLen) {
                shortestLen = arr[i].length();
                shortestIdx = i;
            }
        }

        // 테스트용 출력문
        System.out.println("가장 짧은 문자열을 가진 인덱스 = " + shortestIdx);
        System.out.println("가장 긴 문자열을 가진 인덱스 = " + longestIdx);

        //결과를 넣어줄 새로운 배열을 선언합니다. 최소 문자열과 최대 문자열을 제외하기 떄문에 -2만큼의 배열을 선언합니다.
        String[] result = new String[arr.length - 2];
        int curIndex = 0;
        //배열을 순회하며 결과를 넣어준 후
        for (int i = 0; i < arr.length; i++) {
            if (i != shortestIdx && i != longestIdx) {
                result[curIndex] = arr[i];
                curIndex++;
            }
        }
        //결과를 리턴합니다.
        return result;
    }
}
