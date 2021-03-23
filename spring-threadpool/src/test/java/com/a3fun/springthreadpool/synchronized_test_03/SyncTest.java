package com.a3fun.springthreadpool.synchronized_test_03;

public class SyncTest {

    public int money = 0;

    public SyncTest(int money) {
        this.money = money;
    }

    public void makeMoney(){
        money++;
    }

    public static void main(String[] args) {
        final SyncTest syncTest = new SyncTest(0);
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    syncTest.makeMoney();
                }
            }
        };
        thread1.start();
        System.out.printf("money = %s \n", syncTest.money);
    }
}
