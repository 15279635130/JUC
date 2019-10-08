package com.example.singleton;

import java.util.concurrent.*;

/**
 * @author Administrator
 * @title: TestSingleton
 * @projectName JUC-demo
 * @description: TODO
 * @date 2019/9/29 0029下午 9:16
 */
public class TestSingleton {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Singleton4> callable = new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };
        // 线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = pool.submit(callable);
        Future<Singleton4> f2 = pool.submit(callable);

        Singleton4 s1 = f1.get();
        Singleton4 s2 = f2.get();

        System.out.println(s1 == s2);

        pool.shutdown();
    }
}
