package com.codestates.dailycoding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution30 {
    // 2022.10.25(화) 10h5
    public static int rotatedArraySearch(int[] rotated, int target) {
		/* rotated = 부분적으로 오름차순 정렬된 정수의 배열 int[], 중복된 요소는 없음 <- 부분적으로 정렬된 배열 = 배열을 왼쪽 혹은 오른쪽으로 0칸 이상 순환 이동할 경우 완전히 정렬되는 배열
		target = rotated 배열에 있/없는지 찾고자 하는 대상 정수 -> rotated에 target이 없는 경우, -1 리턴

		단순히 처음부터 끝까지 찾아보는 방법, O(N)(x) 다른 방법 O(logN) 탐구해보기, 이진 탐색(binary search)을 약간 변형(o)
		*/
        // rotated 원소 하나하나 순회하면서 다음 원소와의 값의 차가 1이 아닌 경우, 그 다음 원소의 인덱스 저장해두기(int 타입 변수 jump)
        int jump = 0;
        for (int i = 0; i < rotated.length - 1; i++) {
            if (Math.abs(rotated[i] - rotated[i + 1]) != 1) {
                jump = i + 1;
                break;
            }
        }

        // rotated를 오름차순 정렬
        Arrays.sort(rotated);
//        System.out.println(Arrays.toString(rotated));
        // 10h45 코플릿에서 실행 시 이 line에서 문법 오류 발생하는데, 왜 발생하는지 모르겠어서, agora states 질문 올림

        // rotated를 list로 바꿔서 contains() 메서드 사용(daily coding 24번 참고) -> target이 rotated에 없으면 -1 반환 vs target이 rotated에 있으면 현재 index + jump 반환
        List<Integer> rotatedList = Arrays.stream(rotated).boxed().collect(Collectors.toList()); // 10h45 코플릿에서 실행 시 이 line에서도 문법 오류 발생하는데, 왜 발생하는지 모르겠어서, agora states 질문 올림
        Collections.sort(rotatedList);

        if (rotatedList.contains(target)) {
            return rotatedList.indexOf(target) + jump;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output); // 5

        output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);
        System.out.println(output); // -1
    }
}
