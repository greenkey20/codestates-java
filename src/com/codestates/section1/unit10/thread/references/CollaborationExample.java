package com.codestates.section1.unit10.thread.references;

// reference codes
public class CollaborationExample {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();

        ThreadA threadA = new ThreadA(sharedObject);
        ThreadB threadB = new ThreadB(sharedObject);

        threadA.start();
        threadB.start();


				// 아래는 비필수 -> 프로세스 종료를 위해 잔여 스레드 종료시킴. 
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("-----AFTER INTERRUPT-----");
        System.out.println("threadA.getState() = " + threadA.getState());
        System.out.println("threadB.getState() = " + threadB.getState());
        System.out.println("Thread.currentThread().getState() = " + Thread.currentThread().getState());

        threadB.interrupt();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("-----AFTER INTERRUPT-----");
        System.out.println("threadA.getState() = " + threadA.getState());
        System.out.println("threadB.getState() = " + threadB.getState());
        System.out.println("Thread.currentThread().getState() = " + Thread.currentThread().getState());

    }
}

class SharedObject {
    public synchronized void methodA() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "-> Method A Work Completed");
        notify();
        try { wait(); } catch (InterruptedException e) {}
    }

    public synchronized void methodB() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "-> Method B Work Completed");
        notify();
        try { wait(); } catch (InterruptedException e) {}
    }
}

class ThreadA extends Thread {
    private SharedObject sharedObject;

    public ThreadA(SharedObject sharedObject) {
        setName("ThreadA");
        this.sharedObject = sharedObject;
    }

    public void run() {
        for (int i = 0; i < 10; i++) sharedObject.methodA();
    }
}

class ThreadB extends Thread {
    private SharedObject sharedObject;

    public ThreadB(SharedObject sharedObject) {
        setName("ThreadB");
        this.sharedObject = sharedObject;
    }

    public void run() {
        for (int i = 0; i < 10; i++) sharedObject.methodB();
    }
}
