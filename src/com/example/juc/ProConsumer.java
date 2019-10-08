package com.example.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 空调类(高内聚、低耦合)
// 判断/干活/通知
// 多线程横向通信调度避免虚假唤醒（不能使用 if, 必须使用 while）[重新过安检]
// 多线程编程套路 +while +新写法(lambda)

/**
 * 维持一个变量，初始值为0，提高一个增加和一个减少方法
 * 两个增加线程，两个减少线程，消费顺序是增加一个消费一个
 */
class Aircondition {

    private int number = 0;

    // lock版
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        
        lock.lock();
        try {
            // 判断
            while (number != 0) {
                //this.wait();
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "——>" + number);
            // 通知
            //this.notifyAll();
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {

        lock.lock();
        try {
            // 判断
            while (number == 0) {
                //this.wait();
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "——>" + number);
            // 通知
            //this.notifyAll();
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // synchronized版
    /*
    public synchronized void increment() throws Exception {
        // 判断
        while (number != 0) {
            this.wait();
        }
        // 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "——>" + number);
        // 通知
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception {
        // 判断
        while (number == 0) {
            this.wait();
        }
        // 干活
        number--;
        System.out.println(Thread.currentThread().getName() + "——>" + number);
        // 通知
        this.notifyAll();
    }
    */
}

public class ProConsumer {

    public static void main(String[] args) {

        Aircondition aircondition = new Aircondition();

        new Thread(() -> {
            for (int i = 1; i <= 10 ; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10 ; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 1; i <= 10 ; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10 ; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();


    }
}
