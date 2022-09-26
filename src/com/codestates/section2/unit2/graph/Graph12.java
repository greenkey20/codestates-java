package com.codestates.section2.unit2.graph;

import java.util.ArrayList;
import java.util.HashSet;

// 2022.9.26(월) 15h20
public class Graph12 {
    public static int connectedVertices(int[][] edges) {
        ArrayList<HashSet<Integer>> list = new ArrayList<>();

        // version1) 테스트 케이스 0개 통과
        /*
        HashSet<Integer> set1 = new HashSet<Integer>();
        list.add(set1);

        for (int i = 0; i < edges.length; i++) {
            if (list.isEmpty()) {
                set1.add(edges[0][0]);
                set1.add(edges[0][1]);
            } else {
                if (set1.contains(edges[i][0]) || set1.contains(edges[i][1])) {
                    set1.add(edges[i][0]);
                    set1.add(edges[i][1]);
                } else {
                    HashSet<Integer> newSet = new HashSet<Integer>();
                    newSet.add(edges[i][0]);
                    newSet.add(edges[i][1]);

                    list.add(newSet);
                }
            }
        }
         */

        // version2)
        for (int i = 0; i < edges.length; i++) {
            list.add(new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == 0) {
                list.get(i).add(edges[0][0]);
                list.get(i).add(edges[0][1]);
            } else {
                for (int j = 0; j <= i; j++) {
                    if (list.get(j).contains(edges[i][0]) || list.get(j).contains(edges[i][1])) {
                        list.get(j).add(edges[i][0]);
                        list.get(j).add(edges[i][1]);
                        list.remove(i);
                    } else {
                        list.get(i).add(edges[i][0]);
                        list.get(i).add(edges[i][1]);
                    }
                }
            }
        }

        return list.size();
    } // 내 답안 메서드 종료

    public static void main(String[] args) {
        int result = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5},
        });
        System.out.println(result); // 2
    }
}
