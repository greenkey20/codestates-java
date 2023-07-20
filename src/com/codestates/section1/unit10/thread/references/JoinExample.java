package com.codestates.section1.unit10.thread.references;

// reference codes
public class JoinExample {
    public static void main(String[] args) {
        SumTask sumTask = new SumTask(1000);
        sumTask.start();

        try { sumTask.join(); } catch (InterruptedException e) {}

        System.out.println("1부터 num까지의 합 : " + sumTask.getSum());
    }
}

class SumTask extends Thread {
    private int sum = 0;
    private int num;

    public SumTask(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void run() {
        for (int i = 1; i <= num; sum += i++);
    }
}
