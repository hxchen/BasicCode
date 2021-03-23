package com.a3fun.springthreadpool;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedThreadTest {
    class Bank {

        private int account = 0;
        private volatile int extraAccount = 0;
        private ReentrantLock reentrantLock = new ReentrantLock();

        public int getAccount() {
            return account;
        }
        public int getExtraAccount() {
            return extraAccount;
        }

        /**
         * 用同步方法实现
         *
         * @param money
         */
        public synchronized void save(int money) {
            account += money;
            extraAccount += money;
        }

        /**
         * 非同步方法
         * @param money
         */
        public void asyncSave(int money){
            account += money;

        }

        /**
         * 更新 volatile变量
         * @param money
         */
        public void saveExtra(int money){
            extraAccount += money;
        }
        /**
         * 非同步方法但是加锁同步
         * @param money
         */
        public void asyncSaveWithLock(int money){
            reentrantLock.lock();
            account += money;
            reentrantLock.unlock();
        }
        /**
         * 用同步代码块实现
         *
         * @param money
         */
        public void save1(int money) {
            synchronized (this) {
                account += money;
                extraAccount += money;
            }
        }
    }

    class NewThread implements Runnable {
        private Bank bank;

        public NewThread(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 200000; i++) {
//                bank.save(1);
                bank.asyncSave(10);
                bank.saveExtra(10);
//                bank.asyncSaveWithLock(10);
                System.out.printf("线程{%s}, i = %d, account = %d, extraAccount = %d  \n", Thread.currentThread().getName(), i, bank.getAccount(), bank.getExtraAccount());
            }
        }

    }

    /**
     * 建立线程，调用内部类
     */
    public void useThread() {
        Bank bank = new Bank();
        NewThread new_thread = new NewThread(bank);

        System.out.println("线程1");
        Thread thread1 = new Thread(new_thread);
        thread1.start();

        System.out.println("线程2");
        Thread thread2 = new Thread(new_thread);
        thread2.start();
    }

    public static void main(String[] args) {
        SynchronizedThreadTest st = new SynchronizedThreadTest();
        st.useThread();
    }
}
