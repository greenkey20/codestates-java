package com.codestates.dailycoding;

import java.util.Stack;

public class Solution49 {
    // 2022.11.22(화) 15h50 -> 16h30 제출 시 EmptyStackException
    public static int LIS(int[] arr) {
		/* Longest Increasing Subsequence = 배열(길이는 6만 이하, 원소는 1~100,000 양의 정수)의 연속되지 않는(나의 질문 = 이 문구의 의미는 무엇인가? -> 문자열 'abcd' 예시를 보니 연속될 수도 있고 연속되지 않을 수도 있다?) 부분 배열 중 모든 요소가 엄격하게(동일한 값 요소 없음) 오름차순으로 정렬된 가장 긴 부분 배열
		-> LIS의 길이를 return, LIS가 존재하지 않은 경우는 없음

		sequence = 순서, 서열 -> subsequence = 순서가 있는 데이터(배열, 문자열 등)에서 순서의 대소 관계가 유지되는 모든 부분 배열/문자열/서열
		vs subarray/substring = 연속된 형태의 부분 배열/문자열

		나의 관찰 = arr에서의 순서 바뀌지 않음?

		tips/advanced)
		1. LIS를 계산하는 효율적인 알고리즘(O(N^2))이 존재함 + 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하기
		2. LIS의 길이 대신, LIS 자체를 리턴하는 함수를 구현해보기
		*/
        // 16h45 v2 작성 -> 16h50 입/출력예시2도 의도한 대로 동작하긴 하는데(3 returned), 일반적으로 적용 가능한 코드인지 아직 정확히 모르겠음 -> 코플릿 테스트케이스 9개 중 5개는 통과
        int result = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            Stack<Integer> IS = new Stack<>();
            int current = arr[i];
            IS.push(current);

            for (int j = i + 1; j < arr.length; j++) {
                int next = arr[j];

                if (IS.peek() < next) { // 16h35 나의 생각 = 나의 의도는 stack의 가장 위에 있는 요소의 값을 보고 싶은 거지, 그 값을 빼내는 것이 아니니까, pop(x) peek(o) 메서드를 써보자(아마도 stack에 추가한 요소를 pop하고 그 값을 보려고 하니까 empty stack 예외 발생하는 듯?)
                    IS.push(next);
                }
            }

            if (IS.size() > result) {
                result = IS.size();
            }
        }

//        return IS.size() > 1 ? IS.size() : 1;
//        return Math.max(IS.size(), 1); // IntelliJ의 suggestion에 따라 수정
        return result;
    }

    public static void main(String[] args) {
        int output = LIS(new int[]{3, 2});
        System.out.println(output); // 1 (3 or 2)

        output = LIS(new int[]{3, 10, 2, 1, 20});
        System.out.println(output); // 3 (3, 10, 20) vs 16h40 IS.peek()으로 수정 후 실행은 되나 9
    }
}
