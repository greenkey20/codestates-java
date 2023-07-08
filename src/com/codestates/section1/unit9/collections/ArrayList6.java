package com.codestates.section1.unit9.collections;

import java.util.ArrayList;

// 2023.7.8(토) 22h15
public class ArrayList6 {
    public ArrayList<String> modifyNthElement(ArrayList<String> arrayList, int index, String str) {
        arrayList.remove(index);
        arrayList.add(index, str);
        return arrayList;
    }
}
