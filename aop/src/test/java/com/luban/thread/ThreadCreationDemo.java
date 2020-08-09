package com.luban.thread;

import java.util.concurrent.Callable;

/**
 * @author 小贱
 * @create 2020-05-30 21:36
 */
public class ThreadCreationDemo {

    public static void main(String[] args) {

        // 1
        MyThread MyThread = new MyThread();
        MyThread.start();
        //
        MyThread2 MyThread2 = new MyThread2();
        MyThread2.run();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
    }
}

class MyThread2 implements Runnable  {

    @Override
    public void run() {

    }
}

class MyThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return null;

    }
}
