package com.codestates.section1.unit10.thread;

// 2023.7.20(목) 17h55
public class ThreadExample5 {
    public static void main(String[] args) {
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()); // Thread-0
            }
        });

        thread5.start();
        System.out.println("thread5.getName() = " + thread5.getName()); // Thread-0
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName()); // main
    }
}
