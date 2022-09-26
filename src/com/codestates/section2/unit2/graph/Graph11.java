package com.codestates.section2.unit2.graph;

// 2022.9.26(월) 오후 pair activity
public class Graph11 {
    public boolean getDirections(int[][] matrix, int from, int to) {
        /* idea drafts.. T.T
        if (from < to) {
            if (from == to - 1) {
                if (matrix[to - 1][to] == 1) {
                    return true;
                } else {
                    return false;
                }
            }

            return getDirections(, from, to - 1);
        }


        int check = 1;

        if (from < to) {
            if (matrix[from][to] == 1) {
                return true;
            } else {
                matrix[to - 1][to]
                for (int i = 1; i < from - to; i++) {
                    for ()
                        if (matrix[from][from + i] * matrix[from + i][])
                }
            }


            for (int i = from; i <= to; i++) {
                for (int j = i + 1; j <= to; j++) {
                    check *= matrix[i][j];
                }
            }

        } else {

        }
         */

        if (from < to) {
            for (int i = from; i <= to; i++) {
                for (int j = i + 1; j <= to; j++) {
                    if (matrix[from][j] == 1) {
                        check *= matrix[from][j];
                    } else {
                        for (int k = j + 1; k <= to; k++) {
                            check *= matrix[j][k];
                        }
                    }
                }
            }

        }

    }
}
