package com.codestates.dailycoding;

public class Solution57 {
    // 2022.12.2(금) 9h25 -> 9h45까지 ideation 했는데, 사실 정확히 무엇을 구현해야 할지 잘 모르겠다 -> 9h55 백준/프로그래머스에서 내 수준에 맞는 문제 풀러 갑니다 >.<
    public String decompression(int[][] image) {
        /* 입/출력 예시 2개와 함께 문제 다시 읽어보니 9h34 문제는 이해가 됨

        두 배열의 길이의 합은 1,000,000 이하 -> 나의 질문 = 어떤 배열 2개에 대한 내용이지?
        어떤 배열 arr의 k번째 요소는 arr[k-1]을 의미 e.g. arr의 1번째 요소 = arr[0]

        image 전체 원소들이 0만 있는지, 아니면 1만 있는지, 확인
        -> image.length / 2 해서 그만큼 크기의 정사각형 4개에 대해 전체 원소들이 0만 있는지, 아니면 1만 있는지, 확인
        -> image.length / 2^2 해서 그만큼 크기의 정사각형 4개에 대해 전체 원소들이 0만 있는지, 아니면 1만 있는지, 확인
        -> 재귀 반복..
        -> 정사각형의 크기가 2가 되면 정사각형 4개에 대해 각 1개 남아있는 원소가 0인지 1인지 확인해서 return

        2차원 배열 image를 상하좌우 반으로 나눈 것을 배열 복사해서 매개변수로 넘김 + 이 때 인덱스 패턴 찾아야 함?
        image.length에 대해 2를 밑으로 하는 로그를 취하면 반복 회수가 나온다?
        이 문제에서도 memoization이 가능하고 필요한가?

        advanced) decompression과 반대로 정사각형으로 표현된 데이터를 압축한 문자열을 입력받아 원래의 사각형을 리턴하는 함수 compression 작성해보기(레퍼런스 코드는 따로 제공하지 않음)
        */
        String result = "";

        /*
        if (image.length == 2) {
          return "" + image[0][0] + image[0][1] + image[1][0] + image[1][1];
        }
        */

        return result;
    }
}
