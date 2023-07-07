package com.codestates.section1.unit9.generic;

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

        Basket<String> basket = new Basket<>();
        basket.<Integer>add(10); // 제네릭 메서드 호출 시 제네릭 메서드의 타입 지정
        basket.add("String"); // 타입 지정 생략도 가능


        Basket<Rose> roseBasket = new Basket<>();
        Basket<RosePasta> rosePastaBasket = new Basket<>();
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
// 2023.7.5(수) 15h20 타입 매개변수 선언 시 아래와 같이 코드 작성하면 Basket 클래스 인스턴스화 시 (1) Flower의 하위 클래스 ou (2) 특정 인터페이스를 구현한 클래스만 ou (3) 특정 클래스 상속받으며 특정 인터페이스 구현한 클래스만 타입으로 지정 가능하도록 제한
class Basket<T /*extends Flower & Plant*/> {
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

    // 2023.7.5(수) 18h50 클래스 내부의 특정 메서드만 제네릭으로 선언 = 제네릭 메서드
    public <T> void add(T element) {

    }

    // static 메서드에서도 제네릭 타입 매개변수 사용 가능 <- 메서드에 선언된 제네릭 타입은 지역 변수 선언한 것과 같음, 이 타입 매개변수는 메서드 내에서만 지역적으로 사용됨
    public static <T> int setPrice(T element) {
        return 0;
    }

    public <T> void getPrint(T item) {
        System.out.println(item.equals("Tromm KANG"));
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
//    static V value; // cannot be referenced from a static context = 클래스 변수에 서로 다른 타입 매개변수를 사용해서 인스턴스를 만들게 되면 클래스 변수의 타입이 서로 달라져서 클래스 변수를 통해 같은 변수를 공유하는 게 아닌 것이 됨 -> static 변수에는 타입 매개변수 사용 불가능

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
class Flower implements Plant {

}

class Rose extends Flower implements Plant {

}

class RosePasta {

}

// 2023.7.5(수) 15h20
interface Plant {

}