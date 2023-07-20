package com.codestates.section1.unit10.thread;

// 2023.7.20(목) 20h35
public class InterruptExample2 {
    public static void main(String[] args) {
        // 스레드 생성
        Thread thread1 = new Thread() {
            @Override
            public void run() {
//                super.run();
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Woke up!");
                        e.printStackTrace();
//                        throw new RuntimeException(e);
                    }
                } // while문 끝
            } // run() 종료
        };

        System.out.println("thread1.getState() = " + thread1.getState());

        // 스레드는 실행 대기(runnable) 상태로 만들어짐
        thread1.start();

        System.out.println("thread1.getState() = " + thread1.getState());

        while (true) {
//            System.out.println("while문 안 thread1.getState() = " + thread1.getState());

            if (thread1.getState() == Thread.State.TIMED_WAITING) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }

        // 일시 중지 상태인 스레드를 실행 대기 상태로 복귀시킴
        thread1.interrupt();

        while (true) {
//            System.out.println("while문 안 thread1.getState() = " + thread1.getState());

            if (thread1.getState() == Thread.State.RUNNABLE) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }

        while (true) {
//            System.out.println("while문 안 thread1.getState() = " + thread1.getState());

            if (thread1.getState() == Thread.State.TERMINATED) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }


    }
}
