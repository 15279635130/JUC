package com.example.singleton;

/**
 * @author Administrator
 * @title: Singleton4
 * @projectName JUC-demo
 * @description: TODO
 * @date 2019/9/29 0029下午 9:12
 */
public class Singleton4 {

    private static Singleton4 instance;
    private Singleton4(){}

    public static Singleton4 getInstance() {

        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

}
