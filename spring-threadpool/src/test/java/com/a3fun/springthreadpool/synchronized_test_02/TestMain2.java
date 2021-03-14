package com.a3fun.springthreadpool.synchronized_test_02;

/**
 * 两个对象不能保持同步
 */
public class TestMain2 {
    public static void main(String[] agrs){
        System.out.println("Main 线程 开始运行!");
//        final Test test1 = new Test2();
        final Test2 test1 = new Test2();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                System.out.println("t1 开始运行!");
                test1.mB("HAHA");
                System.out.println("t1 结束运行!");
            }
        };
        t1.start();

//        final Test test2 = new Test2();
        final Test2 test2 = new Test2();
        Thread t2 = new Thread(){
            @Override
            public void run(){
                System.out.println("t2 开始运行!");
                test2.mC("XIXI");
                System.out.println("t2 结束运行!");
            }
        };
        t2.start();
        System.out.println("Main 线程 结束运行!");
    }
}
