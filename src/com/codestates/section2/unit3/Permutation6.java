package com.codestates.section2.unit3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 2023.7.18(화) 23h50 + 2023.7.19(수) 20h50 references 봐도 이해가 잘 안 가는 바, 작성은 더더욱 안 됨 -> 21h40 reference 보고 테스트는 통과하나, 동작 원리 이해 못함
public class Permutation6 {
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        ArrayList<Integer> stuffList = new ArrayList<>();

        for (int i = 0; i < stuffArr.length; i++) {
            String thisStuff = Integer.toString(stuffArr[i]);
            int numOfZero = 0;

            for (int j = 0; j < thisStuff.length(); j++) {
                if (thisStuff.charAt(j) == '0') {
                    numOfZero++;
                }
            }

            if (numOfZero < 3) {
                stuffList.add(stuffArr[i]);
            }
        }

        if (stuffList.isEmpty() || stuffList.size() < choiceNum) {
            return null;
        }

        Collections.sort(stuffList);

        ArrayList<Integer[]> results = new ArrayList<>();
        boolean[] visited = new boolean[stuffList.size()];
        Integer[] output = new Integer[choiceNum];

        permutation(0, output, stuffList, visited, results);

        return results;
    }

    public void permutation(int depth, Integer[] output, ArrayList<Integer> stuffList, boolean[] visited, ArrayList<Integer[]> results) {
//        Integer[] output = new Integer[choiceNum];
        Integer[] copyOutput = Arrays.copyOf(output, output.length);

        // 문제를 더 이상 쪼갤 수 없을 때
        if (depth == output.length) {
            results.add(copyOutput);

//            System.out.println("results = " + results);
            for (int i = 0; i < results.size(); i++) {
                System.out.println("copyOutput = " + Arrays.toString(copyOutput));
            }
            return;
        }

        // 문제를 더 작은 단위로 나눌 수 있을 때
        for (int i = 0; i < stuffList.size(); i++) {
            if (!visited[i]) {
                output[depth] = stuffList.get(i);
                visited[i] = true;
                permutation(depth + 1, output, stuffList, visited, results);
                visited[i] = false;
            }
        }
    }
}
