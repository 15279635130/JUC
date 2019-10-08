package com.example.jvm;

/**
 * JVM中有四个类加载器：
 * 1.启动类加载器(Bootstrap C++)
 * 2.扩展类加载器(Extension Java)
 * 3.应用程序类加载器(AppClassLoader)[系统类加载器，加载当前应用classpath中的所有类]
 * 4.用户自定义类加载器
 */
public class MyObject {

    public static void main(String[] args) {

        Object object = new Object();
        System.out.println(object.getClass().getClassLoader()); //Bootstrap: null

        System.out.println("==========================");
        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
    }
}
