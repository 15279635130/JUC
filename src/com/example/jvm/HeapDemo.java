package com.example.jvm;

import java.util.Random;

/**
 * @author Administrator
 * @title: HeapDemo
 * @projectName JUC-demo
 * @description: TODO JVM调优设置
 * @date 2019/9/29 0029上午 10:31
 * <p>
 * JVM调优参数: -Xms8m -Xmx8m -XX:+PrintGCDetails
 * 在实际生产环境中，一般将JVM初始大小和最大内存保持一致，防止内存忽高忽低，产生停顿，避免主应用程序和GC争抢内存
 * 元空间数据存储在物理内存
 * 伊甸区:幸存者0区:幸存者1区 ——> 8:1:1 ——> Minor GC
 * 新生区:老年代 ——> 1:2 ——> Full GC
 */
public class HeapDemo {

    public static void main(String[] args) {

        // 计算机核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 获取jvm初始值内存(总内存的 1/64)
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 获取jvm最大内存(总内存的 1/4)
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("-Xms: TOTAL_MEMORY: " + totalMemory / 1024 / 1024 + "MB");
        System.out.println("-Xmx: MAX_MEMORY: " + maxMemory / 1024 / 1024 + "MB");

        // OOM: Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        //byte[] bytes = new byte[10 * 1024 * 1024];

        String str = "Hello World";
        while (true) {
            str += str + new Random().nextInt(8888) + new Random().nextInt(9999);
        }
    }
}
