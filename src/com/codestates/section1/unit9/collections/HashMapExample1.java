package com.codestates.section1.unit9.collections;

import java.util.*;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.7.7(금) 15h20
// 15h50 나의 궁금증 = 아래 main() 메서드에서 set 조회 시 같은 순서로 나오는 게 당연한 것인가, 우연인가?
public class HashMapExample1 {
    public static void main(String[] args) {
        // HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        // Entry 객체 저장
        map.put("판다", 82);
        map.put("미피", 95);
        map.put("트롬", 82);
        map.put("해피", 88);
        map.put("토미", 92);
        map.put("루루", 61);

        // 저장된 총 Entry 수
        System.out.println("HashMap에 저장된 총 entry 수 = " + map.size());

        printLine();

        // 객체 찾기 -> key에 해당하는 value 찾기
        System.out.println("트롬 = " + map.get("트롬"));

        printLine();

        // value에 해당하는 key 찾기
        Set<Map.Entry<String, Integer>> entrySet1 = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet1.iterator();

        List<String> list82 = new ArrayList<>();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> entry = iterator1.next();
            if (entry.getValue() == 82) {
                list82.add(entry.getKey());
            }
        }
        System.out.println("82점을 얻은 사람들 list = " + list82);

        printLine();

        // 참여자 명단(key 값들의 집합) 조회
        System.out.println("조사 참여자 = " + map.keySet());

        printLine();

        // value 값들의 집합 조회
        Collection values = map.values();
        System.out.println("조사 참여자들의 점수들 = " + values);

        printLine();

        // value 값들의 평균 계산
        Iterator<Integer> iterator2 = values.iterator();
        int sum = 0;

        while (iterator2.hasNext()) {
            Integer score = iterator2.next();
            sum += score;
        }

        System.out.println("점수의 평균 = " + (float) sum / map.size());

        printLine();

        // value 값들 중 최대 값 구하기
        iterator1 = entrySet1.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> entry = iterator1.next();
            if (entry.getValue() == Collections.max(values)) {
                System.out.println("점수가 가장 높은 사람 = " + entry.getKey());

            }
        }

        printLine();

        // key-value set 조회
        // 방법1)
        Set<Map.Entry<String, Integer>> entrySet2 = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator3 = entrySet2.iterator();
        while (iterator3.hasNext()) {
            Map.Entry entry = iterator3.next();
            System.out.println("이름 = " + entry.getKey() + ", 점수 = " + entry.getValue());
        }

        printLine();

        // 방법2)
        Set<String> keySet = map.keySet();
        Iterator<String> iterator4 = keySet.iterator();
        while (iterator4.hasNext()) {
            String key = iterator4.next();
            Integer value = map.get(key);
            System.out.println("이름 = " + key + ", 점수 = " + value);
        }

        printLine();

        // 15h55 나의 궁금증 = map에 저장된 <사람, 점수> entry들을 점수 내림차순 + 이름 오름차순으로 정렬하는 프로그램?

        // 객체 삭제
        map.remove("루루");
        map.remove("룰루");

        System.out.println("HashMap에 저장된 총 entry 수 = " + map.size());

        printLine();

        // 객체 전체 삭제
        map.clear();
        System.out.println("HashMap에 저장된 총 entry 수 = " + map.size());
    }
}
