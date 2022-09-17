package com.codestates.section1.unit10.stream;
import java.util.*;

public class Stream8 {
    public Integer findBiggestNumber(int[] arr) {
        //TODO..
        return Arrays.stream(arr).max().getAsInt();
    }

    public static void main(String[] args) {

    }
}
