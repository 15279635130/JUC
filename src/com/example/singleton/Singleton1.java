package com.example.singleton;

/**
 * @author Administrator
 * @title: Singleton1
 * @projectName JUC-demo
 * @description: TODO 饿汉式单例模式
 * @date 2019/9/29 0029下午 9:01
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){}
}
