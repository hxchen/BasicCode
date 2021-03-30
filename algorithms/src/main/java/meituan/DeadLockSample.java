package meituan;

/**
 * @author haixiangchen
 */
public class DeadLockSample {

    private final Object obj1 = new Object();
    private final Object obj2 = new Object();

    public static void main(String[] args) {
        DeadLockSample test = new DeadLockSample();
        test.testDeadlock();
    }

    private void testDeadlock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calLock_Obj1_First();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calLock_Obj2_First();
            }
        });
        t1.start();
        t2.start();
    }

    private void calLock_Obj1_First() {
        synchronized (obj1) {
            sleep();
            synchronized (obj2) {
                sleep();
            }
        }
    }

    private void calLock_Obj2_First() {
        synchronized (obj2) {
            sleep();
            synchronized (obj1) {
                sleep();
            }
        }
    }

    /**
     * 为了便于让两个线程分别锁住其中一个对象，
     * 一个线程锁住obj1，然后一直等待obj2，
     * 另一个线程锁住obj2，然后一直等待obj1，
     * 然后就是一直等待，死锁产生
     */
    private void sleep() {
        try {
            System.out.println(Thread.currentThread().getName()+" sleep");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
