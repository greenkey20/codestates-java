package com.codestates.section2.unit3;

import java.util.ArrayList;
import java.util.Collections;

// 2023.7.19(수) 23h50
public class Permutation6 {
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        ArrayList<Integer> stuffList = new ArrayList<>();

        ArrayList<Integer[]> results = new ArrayList<>();

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

        for (int i = 0; i < stuffList.size(); i++) {


        }

        return results;
    }
}
