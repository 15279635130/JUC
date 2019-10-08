package com.example.jobsubject;

/**
 * @author Administrator
 * @title: TestString
 * @projectName JUC-demo
 * @description: TODO
 * @date 2019/9/29 0029下午 7:10
 */
public class TestString {

    public static void main(String[] args) {

        String s1 = new String("abc");  // 生成两个对象: 1.字符串常量池，2.堆
        String s2 = "abc";                      // 没有生成对象， s2引用指向字符串常量池中的abc
        String s3 = new String("abc");  // 生成一个对象，在堆中

        System.out.println(s1 == s2);
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println("----------------");

        System.out.println(s1 == s1.intern()); //s1.intern()在字符串常量池中的地址
        System.out.println(s2 == s1.intern());
        System.out.println(s1.intern() == s2.intern());
        System.out.println("----------------");

        String s4 = "java";
        String s5 = "ja";
        String s6 = "va";
        System.out.println(s4 == "java");
        System.out.println(s4 == (s5 + s6));    // 常量找池，变量找堆(使用 +)
        System.out.println(s4 == "ja" + s6);

    }
}
