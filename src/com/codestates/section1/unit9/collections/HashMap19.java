package com.codestates.section1.unit9.collections;
import java.util.*;

// 2022.9.14(수) 오후
public class HashMap19 {

    public static HashMap<String, String> addFullNameEntry(HashMap<String, String> hashMap) {
        // 시도3)
        // fullName 이라는 새 Entry를 HashMap에 저장
        // fullName의 key에 해당하는 value(String 자료형)는 hashMap.get("firstName") + hashMap.get("lastName")와 같이 만듦
        hashMap.put("fullName", hashMap.get("firstName") + hashMap.get("lastName"));

        // 위와 같이 'fullName=__' entry를 추가한 hashMap을 리턴
        return hashMap;

        /* 시도2)
        // fullName 이라는 새 Entry를 HashMap에 저장
        String fullName = hashMap.get("firstName") + hashMap.get("lastName") + "";

        hashMap.put("fullName", hashMap.get("firstName") + hashMap.get("lastName") + "");

        // 위와 같이 'fullName=__' entry를 추가한 hashMap을 리턴
        return hashMap;
         */

    /* 시도1)
    예시: hashMap = (김, 코딩, 박, 해커, 김코딩, 박해커)
    3. firstName의 값 + lastName의 값 = 새로운 문자열 -> fullName
    String firstName = it.next.getValue
    */
        /*
        // 1. hashMap을 set으로 만듦
        Set<Map.Entry<String, String>> set = hashMap.entrySet();

        // 2. set으로 iterator 만들어서,
        Iterator it = set.iterator();

        // it.next()에 하나하나 접근
        while (it.hasNext()) {
            // it.next()의 value가 firstname이면
        }
        */
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("firstName", "김");
        map.put("lastName", "코딩");

        System.out.println(map);

        addFullNameEntry(map);

        System.out.println(map);

    }
}
