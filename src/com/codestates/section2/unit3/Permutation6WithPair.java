package com.codestates.section2.unit3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 2022.9.29 pair programming
public class Permutation6WithPair {
    ArrayList<Integer[]> output = new ArrayList<>();

    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        //순열 - 순서가 중요
        //stuffArr에서 0이 3개인 요소 빼기
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < stuffArr.length; i++) {
            int count = 0;
            String str = String.valueOf(stuffArr[i]);

            for (int j = 0; j < str.length(); j++) {
                if (String.valueOf(str.charAt(j)).equals("0")) {
                    count++;
                }
            }
            //count 3 미만일 때 리스트에 추가
            if (count < 3) {
                list.add(stuffArr[i]);
            }
        }
        // 만약, 사용할 수 있는 재료가 choiceNum보다 작다면 null을 반환
        if (list.size() < choiceNum || list.isEmpty()) {
            return null;
        }

        //사용할 수 있는 재료 리스트 오름차순 정렬
        list.sort(Comparator.naturalOrder());

        //------------------------
        Integer[] result = new Integer[choiceNum];
        boolean[] visited = new boolean[list.size()];

        permutation(0, list, result, visited);

        return output;
    }

    public void permutation(int cnt, List<Integer> list, Integer[] result, boolean[] visited) {
        Integer[] newResult = Arrays.copyOf(result, result.length); // 2023.7.19(수) 0h25 복습 시 이 부분 왜 이렇게 했는지 기억 안 남..

        if (cnt == result.length) {
            output.add(newResult);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                result[cnt] = list.get(i);
                visited[i] = true;
                permutation(cnt + 1, list, result, visited);
                visited[i] = false;
            }
        }
    }
}
