package com.codestates.dailycoding;

public class Solution25 {
    // 2022.10.17(월) 13h55 -> 14h15 테스트케이스 1,3,4번 통과 못함
    public static long power1(int base, int exponent) {
		/* 두 수를 입력 받아 거듭제곱 계산해서(base^exponent) 리턴
		계산 결과가 컴퓨터로 나타낼 수 있는 수의 범위를 넘을 수 있기 때문에 실제 계산 결과를 94906249로 나눈 나머지를 long 타입으로 리턴 <- 연산 중간에도 이 범위를 넘을 수 있기 때문에 연산할 때마다 나머지를 구하고 그 결과에 연산을 이어가기
		나의 질문1 = 왜 하필 94906249라는 숫자인가..?
		나의 질문2 = long 타입 오버플로우에 대한 해결책으로써 94906249의 모듈로가 최선인가? 왜 이 방법을 써야 하는 것이지..?
		이 방법으로 하면 base^exponent의 실체와 무관한 값을 반환하게 되는 것 아닌가? 그렇다면 이 메서드는 '거듭제곱을 구하는 기능'을 제대로 한다고 할 수 없지 않나?

		Math.pow(거듭제곱 연산자) 사용 금지
		시간복잡도 O(logN)(e.g. 이진탐색)을 만족해야 함
		reference1) '연산을 거듭할 수록 데이터의 양이 줄어든다'(https://velog.io/@ajt1097/AlgorithmToy-Problem-09 참고) -> 14h40 나의 생각 = while문은 exponent만큼 돌게 되는 바, 반복문 사용하면 안 되는 것 같다
		reference2) exponent만큼 반복/탐색해야 하는 것을 exponent/2, exponent/4, exponent/8..로 줄여나갈 수 있음(https://velog.io/@nninnnin7/logN%EC%9D%98-%EC%8B%9C%EA%B0%84-%EB%B3%B5%EC%9E%A1%EB%8F%84-%ED%8E%8C)
		-> 테스트케이스 4번에 대해 이진트리 형태로 종이에 그려봄 -> 나의 생각 = 트리의 왼쪽 반에 대해서 자료를 저장해두고 조회하는 만큼으로 성능 향상시킬 수 있다? 지난주 향상된 피보나치 수열 함수처럼?
		*/
        long result = 1;

        while (exponent > 0) {
            result *= base;

            /* 14h20 수정
            if (result > 94906249) {
                result = result % 94906249;
                break;
            }
             */

            exponent--;
        }

        if (result > 94906249) result = result % 94906249;

        return result;
    }

    // 재귀로 구현 -> 15h5 코플릿 테스트 시 이것도 효율적인 알고리즘은 아니라고 함
    public static long power2(int base, int exponent) {
        long result = 1;

        if (exponent == 0) return result;

        result = base * power2(base, exponent - 1);

        if (result > 94906249) result = result % 94906249;

        return result;
    }

    public static void main(String[] args) {
        System.out.println("----v1----");
        long output = power1(3, 40);
        System.out.println(output); // 19334827 vs 나의 결과 = -6289078614652622815(코플릿 테스트케이스로 이 케이스가 없어서 제출에는 문제 없는 것 같지만, 나는 문제에서 의도한 값이 안 나옴)

        // 테스트케이스 4번
        // 종이에 while 반복문 돌 때마다 exponent 및 result 값 확인(계산기 사용)해서 내 값이 왜 그렇게 나오는지 확인해봄 -> 4^13으로부터 4^14로 넘어갈 때 거듭제곱 값이 94906249를 넘어가는데,
        // 내 첫번째 로직은 이 때 94906249의 모듈로 구해서 리턴 vs 코플릿 기대 반환 값은 4^15까지 구한 값의 94906249 모듈로 -> 이런 로직으로 코드 수정했더니 14h25 테스트케이스 3,4번 통과함
        output = power1(4, 15);
        System.out.println(output);

        System.out.println("----v2----");
        output = power2(3, 40);
        System.out.println(output); // 19334827

        output = power2(4, 15);
        System.out.println(output); // 29773085
    }
}
