package com.luban;

import java.util.concurrent.TimeUnit;

/**
 * @author 小贱
 * @create 2020-09-10 22:40
 */
public class VolatileDemo1 {
    final static int MAX = 50;
    static volatile int value = 0;

    public static void main(String[] args) {
        new Thread(()->{
            int int_value = value;
            while (int_value <= MAX) {
                if (int_value != value) {
                    int_value = value;
                    System.out.println("Read " + int_value);
                }
            }
        },"reader").start();

        new Thread(()->{
            while (value <= MAX) {
                System.out.println("Write === " + ++value);
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();



    }

}
