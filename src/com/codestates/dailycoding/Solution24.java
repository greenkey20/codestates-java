package com.codestates.dailycoding;

public class Solution24 {
    // 2022.10.14(금) 10h10 -> 10h25 모든 테스트 케이스 통과
    public boolean isSubsetOf(int[] base, int[] sample) {
        // int형 자료를 요소로 갖는 배열 sample이 배열 base의 부분집합인지 여부를 리턴
        // base 및 sample의 요소의 최대 개수 = 50,000개
        // base, sample 내에 중복되는 요소는 없다고 가정 -> 나의 생각 = '집합'처럼.. 만약 중복되는 요소가 있었다면 특정 숫자의 출현 횟수도 같은지 확인해야 함
        // base 및 sample을 오름차순으로 정렬 vs 다음 단계 처리들 생각해보니 굳이 정렬할 필요는 없을 듯

        // sample.length 크기로 만든 별도의 배열 flags -> sample의 특정 요소가 base에 존재하는지 여부를 저장하기 위한 용도
        int[] flags = new int[sample.length];

        // sample의 요소를 하나하나 순회하면서
        for (int i = 0; i < sample.length; i++) {
            int check = sample[i];

            // sample[i] 요소/check가 base[j]와 같은지 확인
            for (int j = 0; j < base.length; j++) {
                if (check == base[j]) { // 같은 경우
                    flags[i] = 1; // sample.length 크기로 만든 별도의 배열 flags의 i번째 요소를 1로 바꿈
                    break; // 내부 반복문 더 돌릴 필요 없이, 외부 반복문으로 나가서 외부 반복문 순회 계속함
                }
            }
        }

        // sample의 요소 모두에 대해 같으면 = flags의 요소들의 값의 합이 sample.length와 같으면, true 반환 vs 그렇지 않으면 false 반환
        int sum = 0;
        for (int flag : flags) {
            sum += flag;
        }

        if (sum == sample.length) {
            return true;
        } else {
            return false;
        }
    }

    /* 문제 풀이 과정 회고
    1. 코플릿 에디터 초기화 상태를 보면 stream 패키지가 import 되어있음 -> stream을 사용할 수 있는 문제임을 유추할 수 있었음 vs 나는 처음 문제 풀 때는 못 봄
    2. '어떤 요소를 포함한다'는 문구/컨셉/개념으로부터 'contains()'를(또는 적어도 contains라는 키워드라도) 떠올렸으면 좋았을 것임 -> 개인적으로 contains() 활용을 덜 해 봐서 그런 듯
    3. sample 요소 중에 하나라도 base에 없는 경우 반복을 멈춤으로써 연산/반복을 줄이는 방법을 생각했으면 좋았을 것임 vs 나는 첫번째 ideation 따르다가 괜히 모든 sample 요소에 대해 체크하는 코드를 씀
    4. 너무 급하게 첫번째 ideation대로 문제 풀었음 vs 몇 가지 테스트 케이스를 연구해서 추상화하고 패턴을 조금 더 고민했다면, 더 나은/효율적인/간단한 코드를 짤 수 있었을 것 같음
     */
}
