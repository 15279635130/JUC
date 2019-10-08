package com.example.jobsubject;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @title: TestEqual
 * @projectName JUC-demo
 * @description: TODO
 * @date 2019/9/29 0029下午 5:16
 *
 * ==: 即可比较基本数据类型(值)，也可比较引用类型(内存地址)
 * equal: 比较引用类型
 * 重写 equal时，要同时重写 hashCode方法：
 * 因为只重写 equal表示逻辑相等，违背 “相同对象必须具有相等的散列码”
 */
public class TestEqual {

    public static void main(String[] args) {

        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println(s1 == s2);       // false 地址不同
        System.out.println(s1.equals(s2));  // true String中的 equal方法被覆写过

        Set<String> set01 = new HashSet<>();
        set01.add(s1);
        set01.add(s2);
        System.out.println(set01.size());

        System.out.println("-----------------------");

        Person p1 = new Person("abc");
        Person p2 = new Person("abc");

        System.out.println(p1 == p2);       // false 地址不同
        System.out.println(p1.equals(p2));  // false equal规则没有重写，默认是 ==比较

        Set<Person> set02 = new HashSet<>();
        set02.add(p1);
        set02.add(p2);

        System.out.println(set02.size());
    }
}
