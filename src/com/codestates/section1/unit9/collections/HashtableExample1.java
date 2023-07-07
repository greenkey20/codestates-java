package com.codestates.section1.unit9.collections;

import java.util.Hashtable;
import java.util.Scanner;

// 2023.7.7(금) 15h55
// Hashtable-HashMap 내부 구조 동일 + 사용 방법 유사
public class HashtableExample1 {
    public static void main(String[] args) {
        Hashtable<String, String> map = new Hashtable<>();
        map.put("Spring", "345");
        map.put("summeR", "678");
        map.put("auTumn", "91011");
        map.put("wiNter", "1212");
        System.out.println("map = " + map);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ID와 비밀번호를 입력해 주세요");
            System.out.print("ID > ");
            String id = scanner.nextLine();

            System.out.print("비밀번호 > ");
            String password = scanner.nextLine();

            if (map.containsKey(id)) {
                if (map.get(id).equals(password)) {
                    System.out.println("성공적으로 로그인 되었습니다!");
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다");
                }
            } else {
                System.out.println("입력하신 ID가 존재하지 않습니다");
            }
        }

    }
}
