package com.a3fun.com.aceplaying.task_1;

public class Clerk {
    public synchronized void transfer(Record a, Record b, int amount) {
        System.out.printf("transfer from a{%s} to b{%s}, amount = %d \n", a.get(), b.get(), amount);
        synchronized (a) {
            synchronized (b) {
                a.add(-amount);
                b.add(amount);
            }
        }
    }
}
