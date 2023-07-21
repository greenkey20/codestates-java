package com.codestates.section2.unit3;

import java.util.ArrayList;
import java.util.Arrays;

// 2023.7.21(금) 21h45 ~ 22h 코플릿 모든 테스트 통과(그런데 정확한 동작 원리는 이해x.. '순열'문제(6번) 응용해서 푼 것임)
public class PermutationWithRepetition5 {
    public String[] choices = {"rock", "paper", "scissors"};

    public ArrayList<String[]> rockPaperScissors(int rounds) {
        ArrayList<String[]> results = new ArrayList<>();
        String[] output = new String[rounds];

        permutation(0, rounds, output, results);
        return results;
    }

    public void permutation(int depth, int rounds, String[] output, ArrayList<String[]> results) {
        String[] copyOfOutput = Arrays.copyOf(output, output.length);

        if (depth == rounds) {
            results.add(copyOfOutput);
            return;
        }

        for (int i = 0; i < choices.length; i++) {
            output[depth] = choices[i];
            permutation(depth + 1, rounds, output, results);
        }
    }
}
