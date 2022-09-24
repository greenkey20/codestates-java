package com.codestates.section2.unit2.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 2022.9.23(금) 10h35
public class Queue4 {
    public static int paveBox(Integer[] boxes) {
        // 나의 처음 idea = ArrayList를 하나 만들어두고, boxes[0]부터 ArrayList에 담는데..
        // e.g. boxes = {5, 1, 4, // 6, 1, 2, 3, // 8, 2, 3} -> return 4
        // boxesList.size() = 10
        // 페어님 ideas = 1. 2중 포문 2. sublist
        ArrayList<Integer> boxesList = new ArrayList<>(Arrays.asList(boxes)); // src/main/com/codestates/coplit/Solution.java:9: error: incompatible types: no instance(s) of type variable(s) T exist so that List<T> conforms to ArrayList<Integer>
        ArrayList<Integer> counts = new ArrayList<>();

        for (int i = 0; i < boxesList.size(); i++) {
            int count = 1;

            for (int j = i + 1; j < boxesList.size(); j++) {
                if (boxesList.get(i) >= boxesList.get(j)) {
                    count++;
                } else {
                    i = j - 1;
                    break;
                }
            }

            counts.add(count);
        }

        return Collections.max(counts);
    }

    public static void main(String[] args) {

    }
}
