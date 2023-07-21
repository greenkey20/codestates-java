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

        Collections.sort(stuffList); // testCase1 = [1,10,1111]
//        System.out.println("stuffList = " + stuffList); // todo

        ArrayList<Integer[]> results = new ArrayList<>(); // [[choiceNum 2 길이의 정수 배열], [길이2 정수 배열], [길이2 정수 배열], ...]
        boolean[] visited = new boolean[stuffList.size()]; // [false, false, false]
        Integer[] output = new Integer[choiceNum]; // choiceNum = 2 -> [0, 0]

        permutation(0, output, stuffList, visited, results); // pm(0, [0, 0], [1,10,1111], [false, false, false], [[1,10], [1,1111], [10,1], [10,1111], [1111,1], [1111,10]])
        return results; // 2023.7.21(금) 1h25 testCase1로 코드 흐름 다 돌고 왔는데, 그래도 이해 정확히 안 됨.. 그냥 이런 공식으로 외워야/습득해야 하나..? ㅠㅠ
        // 가장 이해가 잘 안 되는 건, 재귀 아래에서 return 받아 위로 올라갈/자신을 호출한 곳으로 돌아갈 때 results는 계속 업데이트해서 올려보냈는데, visited, output은 딱히 업데이트 안 해서 올라갔다. 이게 잘못된 것인지, 맞는 것인지, 정확히 모르겠다.. ㅠㅠ
        // reference 강의 마지막에서, 외울 필요는 없고, reference code 흐름 이해하면 된다고 하셨는데..
    }

    public void permutation(int depth, Integer[] output, ArrayList<Integer> stuffList, boolean[] visited, ArrayList<Integer[]> results) {
//        Integer[] output = new Integer[choiceNum];
        Integer[] copyOutput = Arrays.copyOf(output, output.length);

        // 문제를 더 이상 쪼갤 수 없을 때
        if (depth == output.length) {
            results.add(copyOutput);

//            System.out.println("results = " + results);
            for (int i = 0; i < results.size(); i++) {
                System.out.println("copyOutput = " + Arrays.toString(copyOutput)); // todo
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
