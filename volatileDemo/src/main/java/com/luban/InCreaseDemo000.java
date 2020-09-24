package com.luban;

import java.util.concurrent.TimeUnit;

/**
 * @author 小贱
 * @create 2020-09-12 11:51
 */
public class InCreaseDemo000 {
    static volatile int m = 0;

    public static void increase() {
        m++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    increase();
                }
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m);
    }
}
