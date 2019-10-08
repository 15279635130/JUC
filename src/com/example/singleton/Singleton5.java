package com.example.singleton;

/**
 * @author Administrator
 * @title: Singleton5
 * @projectName JUC-demo
 * @description: TODO
 * @date 2019/9/29 0029下午 9:27
 *
 * 静态内部类不会随着类的加载和初始化而初始化
 */
public class Singleton5 {

    private Singleton5(){}

    private static class Inner {
        private static final Singleton5 INSTENCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return Inner.INSTENCE;
    }
}
