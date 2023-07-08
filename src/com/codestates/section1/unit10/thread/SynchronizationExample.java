package com.codestates.section1.unit10.thread;

public class SynchronizationExample {
    public static void main(String[] args) {

        ThreadTask threadTask = new ThreadTask();

        Thread thread1 = new Thread(threadTask);
        Thread thread2 = new Thread(threadTask);

        thread1.setName("조영현");
        thread2.setName("나태웅");

        thread1.start();
        thread2.start();
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized boolean withdraw(int money) {
        if (balance >= money) {

            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            balance -= money;

            return true;
        }
        else return false;
    }
}

class ThreadTask implements Runnable {

    Account account = new Account();

    public void run() {
        while (account.getBalance() > 0){
            int money = (int) (Math.random() * 3 + 1) * 100;

            boolean succeeded = account.withdraw(money);

            System.out.println(String.format(
                    "WITHDRAW %d₩ BY %s. BALANCE : %d %s",
                    money, Thread.currentThread().getName(),
                    account.getBalance(), succeeded ? "" : "DENIED"
            ));
        }
    }
}