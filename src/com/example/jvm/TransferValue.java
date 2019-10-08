package com.example.jvm;

/**
 * @author Administrator
 * @title: TransferValue
 * @projectName JUC-demo
 * @description: TODO 值传递
 * @date 2019/9/29 0029上午 10:38
 *
 * 在进行值传递中，基本类型数据是 值的复制
 * 引用类型是内存地址的传递
 */

class Person {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class TransferValue {

    // 基本类型的传递
    public static void transValue(int value) {
        value = 30;
    }

    // 对象传递
    public static void transObject(Person person) {
        person.setAge(30);
    }

    // 字符串传递
    public static void transString(String str) {
        str = "hello";
    }

    public static void main(String[] args) {

        int value = 10;
        transValue(value);
        System.out.println("基本数据类型传递：" + value);

        Person person = new Person(10);
        person.setAge(30);
        System.out.println("对象类型传递：" + person.getAge());

        String str = "JVM";
        transString(str);
        System.out.println("字符串类型传递：" + str);
    }
}
