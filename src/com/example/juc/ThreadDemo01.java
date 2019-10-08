package com.example.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：三个售票员 卖出 30张票
 *
 * 多线程代码：
 * 在高内聚、低耦合的情况下，线程 操作 资源类
 */

// 资源类(票) = 实例变量 + 实例方法
class Ticket {

    private int number = 30;

    // 可重入锁
    Lock lock = new ReentrantLock();

    public void sale() {

        lock.lock();
        try {

            if (number > 0) {
                System.out.println(Thread.currentThread().getName()
                        + "\t卖出第 " +(number--) + "张票，还剩 " + number + "张票");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadDemo01 {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();}, "A").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();}, "B").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();}, "C").start();

        /*
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "C").start();
        */
    }
}
