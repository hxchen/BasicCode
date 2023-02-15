package com.a3fun.com.aceplaying.task_1;

public class Transfers {
    public static void main(String[] args) throws Exception {
        Record r1 = new Record();
        Record r2 = new Record();
        doTransfer(r1, r2, 5);
        System.out.println("rl = " + r1.get() + ", r2=" + r2.get());
        doTransfer(r2, r1, 2);
        System.out.println("rl = " + r1.get() + ", r2=" + r2.get());
        doTransfer(r1, r2, 1);
        System.out.println("rl = " + r1.get() + ", r2=" + r2.get());
        Thread.sleep(3000);
        System.out.println("rl = " + r1.get() + ", r2=" + r2.get());
    }
    private static void doTransfer(final Record a, final Record b, final int amount) {
        Thread t = new Thread() {
            @Override
            public void run() {
                new Clerk().transfer(a, b, amount);
            }
        };
        t.start();
    }
}
