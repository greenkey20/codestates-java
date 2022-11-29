package com.codestates.dailycoding;

public class Solution54 {
    // 2022.11.29(화) 10h50 -> 11h50 입/출력 예시2 보며 내가 생각한 로직대로 구현해보고 테스트 해 봤으나 실패
    public int largestRectangularArea(int[] histogram) {
		/* 임의의 히스토그램 내에서 가장 큰 직사각형의 면적(int 값)을 리턴
		histogram.length = x축 값의 개수 = 100,000 이하
		histogram[i]의 값 = y축 값, i번째 x값에 대한 빈도 = 1 ~ 100,000 양의 정수

		히스토그램에서 i번째 x값이 만들 수 있는 더 큰 직사각형은 인접한 x축(i - 1 또는 i + 1)의 y값이 나와 같거나 클 때 가능해짐
		vs 인접한 x축(i - 1 및 i + 1)의 y값이 나보다 작을 때 최대 직사각형은 나의 y값

		i번째 x축 값마다 만들어지는 직사각형의 넓이를 더해간다

		tips/advanced
		1. 임의의 히스토그램에서 가장 큰 직사각형의 넓이를 계산하는 효율적인 알고리즘(O(N * logN))이 존재 -> 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하기
		2. Stack을 사용하여 PLE(previous less element), NLE(next less element) 알고리즘을 구현하여 해결

		2022.11.29(화) 12h 나의 생각 = 나의 사고 현재 진행 상황에서 stack 활용 방안을 조금만 더 생각해보고, references 공부하자 >.<
		*/
        int min = histogram[0];
        int sequence = 1;

        int[] areas = new int[histogram.length];
        areas[0] = 2 * Math.min(histogram[0], histogram[1]);

        for (int i = 1; i < histogram.length - 1; i++) {
            if (histogram[i] < min) min = histogram[i];
            if (histogram[i + 1] < min) min = histogram[i + 1];

            if (histogram[i] < histogram[i - 1] && histogram[i] < histogram[i + 1]) {
                sequence = 1;
                areas[i] = (i + 1) * min;
                continue;
            } else {
                sequence++;

                int height = histogram[i - 1];
                if (height > histogram[i]) height = histogram[i];
                areas[i] = Math.max((i + 1) * min, sequence * histogram[i]);
            }
        }

        int result = 0;
        for (int i = 0; i < histogram.length; i++) {
            if (areas[i] > result) result = areas[i];
        }

        return result;
    }
}
