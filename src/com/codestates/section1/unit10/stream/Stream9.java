package com.codestates.section1.unit10.stream;
import java.util.*;

public class Stream9 {
    public int findLongestLength(String[] strArr) {
        //TODO..
        //빈 배열을 입력받은 경우 0을 리턴

        //요소의 길이를 기준으로 순회
        return Arrays.stream(strArr).mapToInt(s -> s.length()).max().getAsInt();
    }
}
