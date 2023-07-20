package com.codestates.section1.unit10.thread.references;

// reference codes
public class Example {

    // 작업 스레드를 활용한다.
    // 1. Write Code
    // 2. Make Thread
    // 3. Execute Thread

    public static void main(String[] args) {

        Thread thread1 = new Thread(new RunnableTask());
        Thread thread2 = new SubThreadTask();

        thread1.setName("1번 스레드");
        thread2.setName("2번 스레드");
        Thread.currentThread().setName("메인 스레드");

        System.out.println("thread1.getName() = " + thread1.getName());
        System.out.println("thread2.getName() = " + thread2.getName());
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        thread1.start();
        thread2.start();


        for (int i = 0; i < 1000; System.out.print("#"), i++);

    }

}

class RunnableTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; System.out.print("쿵"), i++);
    }
}

class SubThreadTask extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; System.out.print("짝"), i++);
    }
}
