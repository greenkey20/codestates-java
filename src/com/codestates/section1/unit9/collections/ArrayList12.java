package com.codestates.section1.unit9.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList12 {
    public static int sumAllElements(ArrayList<Integer> arrayList) {
        //TODO..
        // 비어있는 ArrayList를 입력받은 경우, 0을 리턴
        if (arrayList.isEmpty()) {
            return 0;
        }
        else {
            // 비어있지 않은 경우,
            // 모든 요소를 더한 값을 리턴
            int sum = 0;

            Iterator<Integer> it = arrayList.iterator();

            while (it.hasNext()) {
//                System.out.println(it.next().getClass());
                sum += it.next();

            }

            return sum;
        }

    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        for (int i = 0; i < 7; i++) {
            list.add(i);
        }

        System.out.println(sumAllElements(list));
    }
}
