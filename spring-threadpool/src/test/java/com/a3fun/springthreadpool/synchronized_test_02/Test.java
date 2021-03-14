package com.a3fun.springthreadpool.synchronized_test_02;

/**
 * 修饰普通方法的时候，锁的是当前对象。
 */
public class Test {
    synchronized public void mB(String value) {
        for (int i = 0; i < 10; i++) {
            System.out.println(value);
            try{
                Thread.sleep(150);
            }catch(Exception e){

            }
        }
    }

    synchronized public void mC(String value) {
        for (int i = 0; i < 10; i++) {
            System.out.println(value);
            try{
                Thread.sleep(150);
            }catch(Exception e){

            }
        }
    }

}
