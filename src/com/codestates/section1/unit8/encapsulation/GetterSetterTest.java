package com.codestates.section1.unit8.encapsulation;

// 2022.9.19(월) 0h10
public class GetterSetterTest {
    public static void main(String[] args) {
        Worker w1 = new Worker();

//        w1.name = "강미피";
        w1.setName("강미피");
        w1.setId("miffi_smart");
        w1.setAge(0);
        w1.setWorkHours(16.5);

//        System.out.println("w1의 이름 = " + w1.name);
        System.out.println("w1의 이름 = " + w1.getName());
        System.out.println("w1의 나이 = " + w1.getAge());
        System.out.println("w1의 id = " + w1.getId());
    }
}

class Worker {
    private String name;
    private String id;
    private int age;
    private double workHours;

    public Worker() {
    }

    public Worker(String name, String id, int age, double workHours) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.workHours = workHours;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        if (age < 1) {
            return;
        }
        this.age = age;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }
}
