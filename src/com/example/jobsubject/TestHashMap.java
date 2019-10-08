package com.example.jobsubject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @title: TestHashMap
 * @projectName JUC-demo
 * @description: TODO
 * @date 2019/9/29 0029下午 7:56
 *
 * HashMap: 数组加链表
 * 初始大小: 16
 * 负载因子: 0.75(当存储数据大于 16*0.75时进行扩容)
 * 临界吞吐值: 16 * 0.75 = 12
 * 扩容大小: 原大小一倍(扩容方法 resize)
 * put方法: 使用key的hash值进行比较，如果相同进行key的equal进行比较，如果返回true进行覆盖，如果返回false会形成entry链
 */
public class TestHashMap {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "111");
        map.put("b", "222");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
