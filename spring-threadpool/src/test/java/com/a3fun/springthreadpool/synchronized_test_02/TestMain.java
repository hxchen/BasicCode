package com.a3fun.springthreadpool.synchronized_test_02;

public class TestMain {
    public static void main(String[] agrs){
        System.out.println("Main 线程 开始运行!");
        final Test test1 = new Test();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                System.out.println("t1 开始运行!");
                test1.mB("HAHA");
                System.out.println("t1 结束运行!");
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run(){
                System.out.println("t2 开始运行!");
                test1.mC("XIXI");
                System.out.println("t2 结束运行!");
            }
        };
        t2.start();

        System.out.println("Main 线程 结束运行!");
    }
}
