package com.example.jobsubject;

/**
 * @author Administrator
 * @title: Overide
 * @projectName JUC-demo
 * @description: TODO
 * @date 2019/9/29 0029下午 7:45
 */

class Animal {
    protected String name;

    protected void eat() throws NullPointerException {
        System.out.println("...");
    }
}

class Dog extends Animal {
    @Override
    public void eat() throws NullPointerException {
        super.eat();
    }
}
public class TestOveride {
}
