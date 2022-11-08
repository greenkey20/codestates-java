package com.codestates.dailycoding;

public class Solution40 {
    // 2022.11.8(화) 11h15
    public static int primePassword(int curPwd, int newPwd) {
		/* 4자리인 소수 = 1000 이상 9999 이하인 소수 -> 0011, 0997 등은 입력으로 들어오지 않음 = curPwd(소수), newPwd(나의 질문 = 소수일 수도 있고, 아닐 수도 있는 것인가? 새 비밀번호를 만들 수 없는 경우는 newPwd가 소수가 아니어서 그럴 수도 있는 것인가?)
        비밀번호가 계속 소수를 유지하도록 curPwd의 숫자 한 개씩을 바꿔감 -> 소수 newPwd로 바꿀 때까지 최소 몇 개의 숫자를 변경해야 하는지 return vs 새 비밀번호를 만들 수 없는 경우 return -1
        나의 질문 = 변경 순서는 1의 자리 -> 10의 자리 -> 100의 자리.. 등으로 정해져 있는 것인가? 아니면, 모든 순서의 경우의 수(순열)에 대해 따져봐야 하는가?
        두번째 방법으로 동작하는 프로그램이라면, curPwd의 a번째 숫자를 newPwd의 a번째 숫자로 변경시킨 것의 소수 여부 확인 -> 소수가 아니면(back-tracking) curPwd의 b번째(a와 다른 자리 수) 숫자를 newPwd의 b번째 숫자로 변경시킨 것이 소수인지 확인..
        첫번째 방법으로 동작한다고 생각하고 구현해봄
		 */
        int result = 0;
        // curPwd == newPwd이면 return 0
        if (curPwd == newPwd) return result;

        // curPwd와 newPwd의 각 자리 수를 비교 -> 같은 자리 수는 boolean[]의 해당 인덱스의 값을 true로 바꿔둠
        StringBuilder curPwdSb = new StringBuilder(4);
        curPwdSb.append(curPwd);

        StringBuilder newPwdSb = new StringBuilder(4);
        newPwdSb.append(newPwd);

        final int SIZE = 4;
        boolean[] isSame = new boolean[SIZE];
        for (int i = 0; i < SIZE; i++) {
            if (curPwdSb.charAt(i) == newPwdSb.charAt(i)) {
                isSame[i] = true;
                result++;
            }
        }

        // 인덱스 i = 0 ~ 3을 순회하면서
        for (int i = 0; i < SIZE; i++) {
            // 'bool[i] = false인 경우' = curPwd.charAt(i)와 newPwd.charAt(i)가 다른 경우
            if (!isSame[i]) {
                // curPwd의 1의 자리 숫자를 newPwd의 1의 자리 숫자로 변경시킨 것이 소수인지 확인 + result++
                curPwdSb.deleteCharAt(SIZE - 1 - i);
                curPwdSb.append(newPwdSb.charAt(SIZE - 1));

                // result++;

                int tmpPwd = Integer.valueOf(curPwdSb.toString());

                System.out.println("현재 curPwdSb = " + curPwdSb + " = int " + tmpPwd);

                // 현재까지 임시로 만든 비밀번호/4자리 정수가 소수가 아니면, return -1
                if (!isPrime(tmpPwd)) return -1;
                // 소수이면 다음/10의 자리 숫자 변경 및 확인.. -> 이 작업을 1000의 자리 숫자(i = 3)까지 반복
            }
        }

        // 이 반복문을 다 돌고 빠져나옴 = 새 비밀번호를 만들 수 있음 -> return result 또는 isSame 배열에서 요소의 값이 false인 요소들의 개수
        return result;

        // 처음 ideas
        // curPwd와 newPwd의 각 자리 수를 비교 -> 같은 자리 수는 bool[]의 해당 인덱스의 값을 true로 바꿔둠
        // 인덱스 i = 0 ~ 3을 순회하면서
        // bool[i] == false인 경우
        // curPwd의 1의 자리 숫자를 newPwd의 1의 자리 숫자로 변경시킨 것이 소수인지 확인 + cnt++
        // 소수이면 return cnt vs
        // 소수가 아니면 10의 자리 숫자 변경 및 확인.. -> 이 작업을 1000의 자리 숫자(i = 3)까지 반복
        // 이 반복문을 다 돌고 빠져나왔다면 = 새 비밀번호를 만들 수 없음 -> return -1
    }

    public static boolean isPrime(int tmpPwd) {
        if (tmpPwd == 1) return false;

        if (tmpPwd == 2) return true;

        if (tmpPwd % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(tmpPwd); i++) {
            if (tmpPwd % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int output = primePassword(1033, 1033);
        System.out.println(output); // 0

        output = primePassword(3733, 8779);
        System.out.println(output); // 3 (3733 -> 3739 -> 3779 -> 8779) vs 16h35 1차 제출/테스트 시 -1 -> 내가 문제 잘못 이해한 듯..
        /* 어떤 테스트 케이스에서는 3을 초과하는 정수들이 반환되는데,
        그러면 아마도 curPwd에서 자리 수 하나하나 변경시켜가며(0~9까지 순으로) 그 다음 큰 소수, 그 다음 큰 소수 등등 만들고,
        최종적으로 newPwd에 도달하는지 검사 <- while (tmpPwd < newPwd) -> if (tmpPwd == newPwd) return result vs else return -1

        16h50 reference code 간단히 보니 bfs 문제인 듯.. -> 나는 이렇게 어떤 경우에 어떤 알고리즘을 사용하는 문제인지 아직 파악을 정확히 못하고, 주요 알고리즘 구현 능력 연습도 부족함
         */
    }
}
