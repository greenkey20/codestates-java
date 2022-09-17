package com.codestates.section1.unit10.thread;

// 2022.9.16(금) 16h55
public class ThreadExample2 {
    public static void main(String[] args) {
        // Thread 클래스를 직접 인스턴스화하지 않음
        ThreadTask2 thread2 = new ThreadTask2();

    }
}

class ThreadTask12 extends Thread {
    @Override
    public void run() {
//        super.run(); // 이 상속 메서드 자동으로 생겼네..
        for (int i = 0; i < 100; i++) {
            System.out.print("#");
        }
    }
}
