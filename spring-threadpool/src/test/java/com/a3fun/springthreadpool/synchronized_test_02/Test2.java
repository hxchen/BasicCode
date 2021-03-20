package com.a3fun.springthreadpool.synchronized_test_02;

/**
 * synchronized 修饰静态方法
 */
public class Test2 {
    synchronized static public void mB(String value) {
        for (int i = 0; i < 10; i++) {
            System.out.println(value);
            try {
                Thread.sleep(150);
            } catch (Exception e) {

            }
        }
    }

    synchronized static public void mC(String value) {
        for (int i = 0; i < 10; i++) {
            System.out.println(value);
            try {
                Thread.sleep(150);
            } catch (Exception e) {

            }
        }
    }
}
