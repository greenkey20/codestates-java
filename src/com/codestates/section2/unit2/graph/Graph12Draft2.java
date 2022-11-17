package com.codestates.section2.unit2.graph;

import java.util.Arrays;
import java.util.Comparator;

// 2022.11.6(일) 23h55
public class Graph12Draft2 {
    public int connectedVertices(int[][] edges) {
        final int[] bigger = {0};

        Arrays.stream(edges).forEach(data -> {
            int currentBigger = Arrays.stream(data).boxed().max(Comparator.comparing(i -> i)).orElse(0);
            if (bigger[0] < currentBigger) bigger[0] = currentBigger;
        });

        int[][] adjArray = new int[bigger[0] + 1][bigger[0] + 1];

        int count = 0;
        return count;
    }
}
