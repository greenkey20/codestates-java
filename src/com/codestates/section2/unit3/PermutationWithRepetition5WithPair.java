package com.codestates.section2.unit3;

import java.util.ArrayList;
import java.util.Arrays;

// 2022.9.29(목) 12h15 pair programming
public class PermutationWithRepetition5WithPair {
    ArrayList<String[]> arraylist = new ArrayList<>();

    public ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:
        String[] arr = new String[rounds];
        permutation(0, rounds, arr);
        return arraylist;
    }

    public void permutation(int cnt, int rounds, String[] arr) {
        String[] game = new String[]{"rock", "paper", "scissors"};
        String[] newArr = Arrays.copyOf(arr, arr.length);
        if (cnt == rounds) {
            arraylist.add(newArr);
            return;
        }
        for (int i = 0; i < game.length; i++) {
            arr[cnt] = game[i];
            //System.out.println(cnt);
            permutation(cnt + 1, rounds, arr);
        }
    }
}
