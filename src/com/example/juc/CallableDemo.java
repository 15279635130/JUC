package com.example.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 线程方法一
class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("多线程打印...");
        }
    }
}

// 线程方法二
class MyThread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("多线程打印...");
        }
    }
}

// 线程方法三
class MyThread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable...");
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) {

        //new Thread(new MyThread(), "A").start();

        // Callable调用
        FutureTask futureTask = new FutureTask(new MyThread3());
        new Thread(futureTask, "A").start();
        try {
            Integer result = (Integer) futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
