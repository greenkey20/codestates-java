package com.codestates.section1.unit10.thread;

// 2023.7.20(목) 17h50
public class ThreadExample3 {
    public static void main(String[] args) {
        // thread 생성 방법3) Runnable 익명 구현 객체 활용
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Get the thread name");
            }
        });

        thread3.start();

        System.out.println("thread3.getName() = " + thread3.getName()); // Thread-0
    }
}
