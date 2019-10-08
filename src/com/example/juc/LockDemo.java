package com.example.juc;

/**
 * 8种锁机制：
 * 1.标准访问:
 * 如果资源类中多个方法加锁，访问某个加锁方法时，整个资源类(当前对象 this)被加锁 ——> sendEmail,sendSMS
 *
 * 2.发邮件暂停4秒钟 (TimeUnit.SECONDS.sleep(4);)
 * 原理同上 ——> sendEmail,sendSMS
 *
 * 3.新增普通方法
 * 和同步锁无关 ——> sayHello,sendEmail
 *
 * 4.两部手机
 * 不同锁 ——> sendSMS,sendEmail
 *
 * 5.两个静态同步方法，同一部手机
 * 对于静态同步方法，锁的是当前类的Class对象
 *
 * 6.两个静态同步方法，两部部手机
 * 对于静态同步方法，锁的是当前类的Class对象
 *
 * 7.一个静态方法，一个普通方法，同一部手机
 * 不同对象 ——> sendSMS, sendEmail
 *
 * 8.一个静态方法，一个普通方法，两部手机
 * 不同对象 ——> sendSMS, sendEmail
 */

class Phone {

    public synchronized void sendEmail() {
        //TimeUnit.SECONDS.sleep(4);
        System.out.println("sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("sendSMS");
    }

    public void sayHello() {
        System.out.println("sayHello");
    }
}

public class LockDemo {

    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendEmail();
        }, "A").start();

        new Thread(() -> {
            phone.sendSMS();
        }, "B").start();
    }
}
