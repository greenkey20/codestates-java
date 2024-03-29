package com.codestates.dailycoding.references;

// 2022.12.8(목) 10h15 참고
public class Solution22Reference {
    public int[] swap(int idx1, int idx2, int[] arr) {
        //두 변수를 바꾸는 방법
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

        //XOR 연산을 활용한 방법
        //arr이 reference type이라 가능
//     arr[idx1] ^= arr[idx2];
//     arr[idx2] ^= arr[idx1];
//     arr[idx1] ^= arr[idx2];

        return arr;
    }

    // naive solution
    public int[] bubbleSortNaive(int[] arr) {
        int arrLength = arr.length;

        for (int i = 0; i < arrLength - 1; i++) {
            //매 반복(iteration)마다 i번째로 큰 수가 마지막에서 i번째 위치하게 된다.
            //이미 정렬된 요소는 고려할 필요가 없으므로, 'j < N - 1 - i'만 비교하면 된다 -> 2022.12.9(금) 10h25 나의 질문 = 아래 내부for문에 이 조건이 반영 안 되어있는 것 아닌가?
            for (int j = 0; j < arrLength - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr = swap(j, j + 1, arr);
                }
            }
        }
        return arr;
    }

    // optimized solution
    public int[] bubbleSortOptimized(int[] arr) {
        int arrLength = arr.length;

        for (int i = 0; i < arrLength; i++) {
            // swap 횟수를 기록한다.
            // 어떤 요소도 swap되지 않은 경우, 배열은 정렬된 상태이다.
            int swaps = 0;

            // 매 반복(iteration)마다 i번째로 큰 수가 마지막에서 i번째 위치하게 된다.
            // 이미 정렬된 요소는 고려할 필요가 없으므로, 'j < N - 1 - i'만 비교하면 된다.
            for (int j = 0; j < arrLength - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    arr = swap(j, j + 1, arr);
                }
            }
            if (swaps == 0) {
                break;
            }
        }
        return arr;
    }
}
