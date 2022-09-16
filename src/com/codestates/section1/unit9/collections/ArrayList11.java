package com.codestates.section1.unit9.collections;

import java.util.ArrayList;
import java.util.Vector;

// 2022.9.14(수) 오후
public class ArrayList11 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);

        for (int i = list.size() - 1; i >= 0; i--) {
//            list.size()--;
            list.remove(i);
        }

//        list = new ArrayList(0);
        System.out.println(list);

//        Vector

    }
}
