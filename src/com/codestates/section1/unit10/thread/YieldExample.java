package com.codestates.section1.unit10.thread;

public class YieldExample {
    public static void main(String[] args) {

        YieldExampleTask yieldExampleTask1 = new YieldExampleTask("ThreadA");
        YieldExampleTask yieldExampleTask2 = new YieldExampleTask("ThreadB");

        Thread threadA = new Thread(yieldExampleTask1);
        Thread threadB = new Thread(yieldExampleTask2);

        threadA.start();
        threadB.start();

        // 메인스레드 3초 정지 -> 스레드 A, B 실행
        try { Thread.sleep(3000); } catch(InterruptedException e) {}
        
        // 스레드 A 작업 정지 -> 스레드 B만 실행
        System.out.println("###### THREAD A WORK : FALSE ######");
        yieldExampleTask1.setWork(false);

        // 메인 스레드 작업 정지 -> 스레드 B만 실행
        try { Thread.sleep(5000); } catch(InterruptedException e) {}
        
        // 스레드 A 작업 재개 -> 스레드 A, B 실행
        System.out.println("@@@@@ THREAD A WORK : TRUE @@@@@");
        yieldExampleTask1.setWork(true);
        
    }


}

class YieldExampleTask implements Runnable {

    private boolean work = true;
    private String name;

    public YieldExampleTask(String name) {
        this.name = name;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        while (true) {
            if (work) System.out.println(getName() + ": Now Working");
            else Thread.yield();
        }
    }
}
