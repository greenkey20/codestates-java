package com.codestates.section1.unit10.thread;

// 2023.7.20(목) 17h50
public class ThreadExample4 {
    public static void main(String[] args) {
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Set and get the thread name");
            }
        });

        thread4.start();
        System.out.println("thread4.getName() = " + thread4.getName()); // Thread-0

        thread4.setName("Tromm KANG's thread");
        System.out.println("thread4.getName() = " + thread4.getName()); // Tromm KANG's thread
    }
}
