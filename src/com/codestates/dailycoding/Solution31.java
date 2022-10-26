package com.codestates.dailycoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Solution31 {
    // 2022.10.26(수) 9h55 -> 11h5 1차 테스트 시 테스트케이스 하나도 통과 못함
    public ArrayList<String> powerSet(String str) {
		/* 입력받은 str = 하나의 집합을 의미하는, 공백 없는, 알파벳 소문자 문자열(입/출력 예시에 따르면 중복 알파벳 있을 수 있음)
    -> str에 포함된 각 문자를 가지고 만들 수 있는 모든 부분집합/경우의 수(중복된 원소 없음, 빈 문자열 포함)를, 알파벳 순서/오름차순으로 정렬된 ArrayList<String> 타입으로 return
       ArrayList의 요소 = 각 부분집합의 원소로 구성된 문자열
    */
        // 입력받은 str에 등장하는 알파벳들 중복 없이 + 알파벳 순서대로(오름차순) TreeSet에 담기
        Set<String> alphabets = new TreeSet<>();

        for (int i = 0; i < str.length(); i++) {
            String alphabet = String.valueOf(str.charAt(i));
            if (!alphabets.contains(alphabet)) {
                alphabets.add(alphabet);
            } else {
                continue;
            }
        }

        // alphabets 집합 잘 만들어졌나 확인
//        System.out.println(alphabets);

        // return할 ArrayList<String> 참조변수 선언 및 초기화
        ArrayList<String> result = new ArrayList<>();
        result.add("");

        // alphabets의 요소의 개수(alphabets.size()) 중 1 ~ alphabets.size()개를 중복 없이 + 순서 중요하지 않게 선택하는 '조합'들을 만들어 result에 담음
        int n = alphabets.size();
        for (int i = 1; i <= n; i++) {
            combination(n, i, 1, alphabets);
        }

        // result에 담긴 요소들을 오름차순 정렬하고, return
        Collections.sort(result);
        return result;
    }

    public ArrayList<String> combination(int n, int r, int num, Set<String> alphabets) {
        ArrayList<String> subsets = new ArrayList<>();

        if (r == num) {
            return subsets;
        }

        return combination(n, r, num + 1, alphabets);
    }
}
