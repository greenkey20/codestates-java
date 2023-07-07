package com.codestates.section1.unit10.thread;

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new InterruptExampleTask();
        thread.start();

        System.out.println("thread.getState() = " + thread.getState());
        
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        thread.interrupt();

        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("thread.getState() = " + thread.getState());
    }
}

class InterruptExampleTask extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("1초에 한 번씩 작업 처리 중...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}

        System.out.println("리소스를 정리합니다.");
        System.out.println("실행을 종료합니다.");
    }
}
