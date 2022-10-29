package com.codestates.section1.unit9.collections;

import java.util.ArrayList;

// 2022.10.29(토) 12h45 ArrayList의 copy 연습
public class ArrayListCopy {
    public static void main(String[] args) {
        Temp temp1 = new Temp("hat bear", "1");
        Temp temp2 = new Temp("tomi", "2");
        Temp temp3 = new Temp("lori", "3");

        ArrayList<Temp> temps = new ArrayList<>(3);
        temps.add(temp1);
        temps.add(temp2);
        temps.add(temp3);

        ArrayList<Temp> clone = (ArrayList<Temp>) temps.clone(); // Returns a shallow copy of this ArrayList instance + The elements themselves are not copied -> 나의 질문 = 그런데 왜 ArrayList<Temp>로 명시적 형 변환이 필요하지? 메서드 설명 봐서는 잘 이해 안 됨
        clone.remove(2);

        System.out.println("temps = " + temps); // temps = [com.codestates.section1.unit9.collections.Temp@17f6480, com.codestates.section1.unit9.collections.Temp@2d6e8792, com.codestates.section1.unit9.collections.Temp@2812cbfa]
        System.out.println("clone = " + clone); // clone = [com.codestates.section1.unit9.collections.Temp@17f6480, com.codestates.section1.unit9.collections.Temp@2d6e8792]

        clone.get(0).setName("모자곰"); // clone()한 List의 원소 객체의 내용 수정
        System.out.println(temps.get(0).getName()); // 모자곰 = 원본 List의 원소 객체의 내용도 수정되어 있음 -> clone() 메서드는 deep(x) shallow(o) copy
        System.out.println(clone.get(0).getName()); // 모자곰
    }

}

class Temp {
    private String name;
    private String order;

    public Temp() {
    }

    public Temp(String name, String order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public String getOrder() {
        return order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
