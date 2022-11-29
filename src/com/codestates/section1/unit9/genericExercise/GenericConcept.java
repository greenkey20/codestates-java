package com.codestates.section1.unit9.genericExercise;

// 2022.11.29(화) 18h
public class GenericConcept {
    public static void main(String[] args) {
        BasketString basket1 = new BasketString("apple");
//        BasketString basket2 = new BasketString(2);

        Basket<Integer> basket3 = new Basket<>(32);
        Basket<String> basket4 = new Basket<>("teddy bear");
        Basket<Boolean> basket5 = new Basket<>(true);
        Basket<Double> basket6 = new Basket<>(3.14);
        Basket<Fruit> basket7 = new Basket<>(new Fruit("apple", 50.1, "green"));

        // 제네릭 클래스 사용 시 다형성 적용 가능
        Basket<Flower> flowerBasket = new Basket<>(); // Basket의 인스턴스인 flowerBasket의 멤버변수의 타입을 Flower로 지정
        flowerBasket.setItem(new Rose()); // Rose는 Flower를 상속받는, Flower의 하위/자식 클래스 -> flowerBasket의 멤버변수 item으로 할당 가능 -> 다형성 적용해서 이렇게 타입 매개변수로 적용 가능
//        flowerBasket.setItem(new RosePasta()); // RosePasta는 Flower와 아무 관계 없는 클래스 -> flowerBasket 객체에는 RosePasta로 멤버변수를 set하는 setter가 없는 바, 에러
    }

}

// String 타입의 데이터만 저장할 수 있음
class BasketString {
    private String item;

    public BasketString(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}

// 제네릭 클래스 예시1 = 모든 타입의 데이터를 저장할 수 있는 인스턴스 생성 가능
class Basket<T> {
    private T item;

    public Basket() {
    }

    public Basket(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

// 타입 매개변수를 여러 개 사용
// (내가 만들어본)제네릭 클래스 예시2
class Member<K, V> {
    private K info1;
    private V info2;

    public Member(K info1, V info2) {
        this.info1 = info1;
        this.info2 = info2;
    }

    public K getInfo1() {
        return info1;
    }

    public V getInfo2() {
        return info2;
    }

    public void setInfo1(K info1) {
        this.info1 = info1;
    }

    public void setInfo2(V info2) {
        this.info2 = info2;
    }
}

// (학습 자료 조금 더 읽고 다시 만들어본)제네릭 클래스 예시3
class InfoMap<K, V> {
    private K key;
    private V value;
//    static V value;

    public InfoMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

// 타입 매개변수에 치환될 타입으로 사용자 정의 타입/클래스 지정
class Fruit {
    private String name;
    private double weight;
    private String colour;

    public Fruit(String name, double weight, String colour) {
        this.name = name;
        this.weight = weight;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}

// 제네릭 클래스 사용 시 다형성 적용 가능
class Flower {

}

class Rose extends Flower {

}

class RosePasta {

}