package com.example.juc;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * new List的时候，底层是new Object，初始大小为 10，扩容之后是为原来的一半，拷贝利用 copyOf
 * new Set的时候，底层是new HashMap，其中key为传入的值，vale为底层 new Object
 * new Map的时候，底层是new HashMap，初始值为 16，扩容之后为原来的一倍
 * 在多线程中，List、Set、Map都是不安全的
 * <p>
 * 1.故障现象
 * java.util.ConcurrentModificationException
 * <p>
 * 2.导致原因
 * <p>
 * 3.解决方法
 * List<String> list = new Vector<>()
 * List<String> list = Collections.synchronizedList(new ArrayList<>());
 * List<String> list = new CopyOnWriteArrayList<>();   // 写时复制技术
 *
 * Set<String> set = new CopyOnWriteArraySet<>();
 * Map<String, String> map = new ConcurrentHashMap<>();
 * <p>
 * 4.优化建议
 */
public class CollectionNotSafe {

    public static void main(String[] args) {

        ListNotSafe();
        //Set<String> set = new CopyOnWriteArraySet<>();
        //Map<String, String> map = new ConcurrentHashMap<>();
    }

    private static void ListNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {

            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + " -> " + list);
            }, String.valueOf(i)).start();
        }
    }
}
