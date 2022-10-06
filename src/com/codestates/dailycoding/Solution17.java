package com.codestates.dailycoding;

public class Solution17 {
    public static String computeSquareRoot(int num) {
        /* 최대 소수점 둘째 자리까지 구한(소수점 셋째 자리에서 반올림) 수를 문자열로 변환하여 출력 <- 소수점 처리 <- java 표준 내장 객체인 String("java decimal places limit", "자바 소수점 자리수") 검색
        각 자리수(1, 0.1, 0.01, 0.001)마다 (목표값을 넘지 않는)근사값을 구하는 방식 있음
        바빌로니아 법(=제곱근 구하는 방법)의 점화식(recurrence formula) 활용
        */

        /* 2022.9.30(금) 11h ideation
        for문 i = 1, 2, 3.. i++
        for문이 1번 돌 때마다 1, 4, 9, 16..과 같은 제곱근 리스트 만들 수 있음
        -> num이 리스트의 몇 번째 원소보다 크고 작은지 확인하면, 제곱근이 어떤 자연수 사이에 있는지 알 수 있음(=제곱근의 범위 좁히기)
        -> 소수점을 (문제에서 주어진 소수점 셋째 자리까지) 내리며 근사값 찾아감(해당 근사값/내가 리턴할 값 * 해당 근사값/내가 리턴할 값 < num, num에 최대한 가깝게)

        2022.10.4(화) 바빌로니아 법 공부 -> 10h30 구현
        */
        int precision = 10; // 임의?로 적당히 여러 번 반복
        double squareRoot = 1.0;

        for (int i = 0; i < precision; i++) {
            squareRoot = (squareRoot + num / squareRoot) / 2;
        }

        return String.format("%.2f", squareRoot); // squareRoot 변수(실수/double 자료형)에 담긴 값을 소수점 아래 2자리의 부동소수점 수로 형식 맞추고, String 자료형으로 출력
    }

    // reference code 공부 필요 -> 2022.10.6(목) 23h55 num = 6일 때 반복문 돌며 실행하는 것 한 단계씩 종이/펜 써보고 이해는 함 -> 이런 구현 방법/접근 방식이 있음을 이해하고, 어떻게 적용할 수 있을지, 나의 처음 ideation과 연결지어 생각해보자
    public static String computeSquareRootReference(int num) {
        double[] diffs = new double[]{1, 0.1, 0.01, 0.001}; // 소수점 3자리부터 반올림하기 때문에, 배열에 소수점 자리만큼 double값을 선언, 할당
        double base = 1; // 초기값을 1로 설정

        // 선언한 배열을 순회
        for (int i = 0; i < diffs.length; i++) {
            while (base * base < num) { // 초기값을 곱했을때, 입력된 값보다 작다면
                base = base + diffs[i]; // 기본값에 배열의 인자(소숫점 초기값)을 더해줍니다.
            }

            if (base * base == num) { // 모두 더한 값이 입력된 num과 일치한다면(더이상 낮은 숫자를 비교할 필요가 없을 경우)
                return String.format("%.2f", base); // String.format을 사용하여 소수점 2자리까지의 값을 String값으로 변환하여 리턴
            } else {
                // 기본 값에서 배열의 인자를 제외 <- 제외하여야 배열의 인자가 바뀌고, while문이 정상적으로 순회가 가능
                base = base - diffs[i];
            }
        }

        return String.format("%.2f", base); // String.format을 사용하여 소수점 2자리까지의 값을 String값으로 변환하여 리턴
    }

    public static void main(String[] args) {
        String output = computeSquareRoot(6);
        System.out.println(output); // "2.45" <- 2.449

        output = computeSquareRoot(8);
        System.out.println(output); // "2.83" <- 2.828

        output = computeSquareRoot(9);
        System.out.println(output); // "3.00"
    }
}
