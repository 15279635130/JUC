package com.example.jvm;

/**
 * @author Administrator
 * @title: JMMDemo
 * @projectName JUC-demo
 * @description: TODO JMM(Java内存模型)
 * @date 2019/9/29 0029下午 4:40
 *
 * JMM特性：
 * 可见性(volatile)、原子性、有序性
 */
class MyNumber {
    volatile int number = 10;
    public void changeNum() {
        number = 100;
    }
}

public class JMMDemo {

    public static void main(String[] args) {

        MyNumber myNumber = new MyNumber();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in ....");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNumber.changeNum();
            System.out.println(Thread.currentThread().getName() + " update number, number = " + myNumber.number);
        }, "A").start();

        while (myNumber.number == 10) {
            // 需要某种机制通知主线程，number的值已经进行了修改
        }
        System.out.println(Thread.currentThread().getName() + "is over...");
    }
}
