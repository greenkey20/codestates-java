package com.codestates.section1.unit10.thread;

// 2022.9.16(금) 16h45
public class ThreadExample1 {
    public static void main(String[] args) {
        Runnable task1 = new ThreadTask1();

        // thread 생성 방법1) Runnable 인터페이스를 구현한 객체를 인자로 전달하면서 Thread 클래스를 인스턴스화
        Thread thread1 = new Thread(task1);
        ThreadTask2 thread2 = new ThreadTask2();

        // start() 메서드 호출해서 thread 실행 -> run() 내부 코드 실행
        thread1.start();


        // 반복문 추가
        for (int i = 0; i < 10000; i++) {
            System.out.print("@");
        }

        /* main() 실행 결과
        1. ####################################################################################################@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        2. ####################################################################################################@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        왜 내 실행 결과에는 메인/작업 threads가 동시에 병렬로 실행되지 않지..? ㅠㅠ -> 17h20 나의 발견 = thread1.start() 대신 thread1.run()으로 작성했었음
         */
    }}

class ThreadTask1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print("#");
        }
    }
}

class ThreadTask2 extends Thread {
    @Override
    public void run() {
//        super.run(); // 이 상속 메서드 자동으로 생겼네..
        for (int i = 0; i < 100; i++) {
            System.out.print("#");
        }
    }
}
