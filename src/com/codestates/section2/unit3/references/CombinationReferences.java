package com.codestates.section2.unit3.references;

// 2022.10.27(목)
public class CombinationReferences {
    // v1(https://gaybee.tistory.com/29)
    /*
    private static void makeCombination(int r, int[] temp, int current, int start) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                makeCombination(r, temp, current + 1, i + 1);
            }
        }
    }

    private static void makeOverlabCombination(int r, int[] temp, int current, int start) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                makeOverlabCombination(r, temp, current + 1, i);
            }
        }
    }

    private static void makeOverlabPermutation(int r, int[] temp, int current) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = 0; i < arr.length; i++) {
                temp[current] = arr[i];
                makeOverlabPermutation(r, temp, current + 1);
            }
        }
    }

    public class AlgorithmStudy {
        public static void permutation(int[] arr, int[] out, int depth, int r) {
            if (depth == r) {
                for (int num : out) System.out.print(num);
                System.out.println();
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                out[depth] = arr[i];
                permutation(arr, out, depth + 1, r);
            }
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3};
            int r = 2;
            permutation(arr, new int[r], 0, r);
        }
    }
     */
}
