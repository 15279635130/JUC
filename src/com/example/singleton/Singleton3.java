package com.example.singleton;

/**
 * @author Administrator
 * @title: Singleton3
 * @projectName JUC-demo
 * @description: TODO 静态代码块单例模式(初始化数据)
 * @date 2019/9/29 0029下午 9:04
 */
public class Singleton3 {

    private static final Singleton3 INSTANCE;

    static {
        INSTANCE = new Singleton3();
    }

    private Singleton3(){}
}
