package com.example.jvm;

/**
 * @author Administrator
 * @title: StackDemo
 * @projectName JUC-demo
 * @description: TODO SOF错误
 * @date 2019/9/29 0029上午 10:27
 *
 * 栈管运行，堆管存储
 * 存储：8种基本数据类型 + 对象的引用变量 + 实例方法
 * 栈帧： 本地变量(输入、输出参数，方法内变量) + 栈操作 + 栈帧数据
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class StackDemo {

    public static void method() {
        method();
    }

    public static void main(String[] args) {

        method();
    }
}
