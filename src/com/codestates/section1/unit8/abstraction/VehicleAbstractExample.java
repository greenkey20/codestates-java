package com.codestates.section1.unit8.abstraction;

// 2023.4.23(일) 21h50 from an exam
abstract class Vehicle {
    String name;

    abstract public String getName(String val);

    public String getName() {
        return "Vehicle name: " + name;
    }
}

class Car extends Vehicle {
    public Car(String val) {
        name = super.name = val;
    }

    @Override
    public String getName(String val) {
        return "Car name: " + val;
    }

    public String getName(byte[] val) {
        return "Car name: " + val; // Implicit call to 'toString()' on array 'val'
    }
}

public class VehicleAbstractExample {
    public static void main(String[] args) {
        Vehicle obj = new Car("Spark");
        System.out.println(obj.getName()); // Vehicle name: Spark
    }
}
