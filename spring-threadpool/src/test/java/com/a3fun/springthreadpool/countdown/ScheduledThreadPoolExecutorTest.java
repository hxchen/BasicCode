package com.a3fun.springthreadpool.countdown;


import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor
 */
public class ScheduledThreadPoolExecutorTest {
    final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(8);

    /**
     * 定时任务
     */
    public void fixedRateTask() {
        //启动1秒之后，每隔1秒执行一次
        executor.scheduleAtFixedRate((new Runnable() {
            @Override
            public void run() {
                System.out.printf("time = %s: 任务一：1秒1次. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
            }
        }), 1, 1, TimeUnit.SECONDS);
        //启动1秒之后，每隔2秒执行一次
        executor.scheduleAtFixedRate((new Runnable() {
            @Override
            public void run() {
                System.out.printf("time = %s: 任务二：2秒1次. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
            }
        }), 1, 2, TimeUnit.SECONDS);
        //启动1秒之后，每隔3秒执行一次
        executor.scheduleAtFixedRate((new Runnable() {
            @Override
            public void run() {
                System.out.printf("time = %s: 任务三：3秒1次. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
            }
        }), 1, 3, TimeUnit.SECONDS);
        //启动1秒之后，每隔4秒执行一次
        executor.scheduleAtFixedRate((new Runnable() {
            @Override
            public void run() {
                System.out.printf("time = %s: 任务四：4秒1次. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
            }
        }), 1, 4, TimeUnit.SECONDS);
    }

    /**
     * 定时任务
     * 不受任务执行时间影响
     * period（周期）指的是两次成功执行之间的时间
     */
    public void fixedRateTask1() {
        System.out.printf("time = %s: 定时任务，开始. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
        executor.scheduleAtFixedRate((new Runnable() {
            @Override
            public void run() {
                System.out.printf("time = %s: 定时任务，执行. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
            }
        }), 5, 10, TimeUnit.SECONDS);

    }

    /**
     * 延时任务
     * 受任务执行时间影响
     * delay（延时）指的是上次执行终止和下次执行开始之间的延迟
     */
    public void delayTask() {
        System.out.printf("time = %s: 延时任务，开始. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
        executor.scheduleWithFixedDelay((new Runnable() {
            @Override
            public void run() {
                System.out.printf("time = %s: 延时任务，执行. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }), 5, 10, TimeUnit.SECONDS);
    }

    /**
     * 可取消的任务
     */
    public void cancelTask() {
        System.out.printf("time = %s: 定时任务，开始. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
        ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate((new Runnable() {
            @Override
            public void run() {
                System.out.printf("time = %s: 定时任务，执行. poolSize = %s,  maximumPoolSize = %s, corePoolSize = %s. \n", new Date(), executor.getPoolSize(), executor.getMaximumPoolSize(), executor.getCorePoolSize());
            }
        }), 0, 5, TimeUnit.SECONDS);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledFuture.cancel(true);
    }

    public static void main(String[] args) {
        ScheduledThreadPoolExecutorTest scheduledThreadPoolExecutorTest = new ScheduledThreadPoolExecutorTest();
//        scheduledThreadPoolExecutorTest.delayTask();
//        scheduledThreadPoolExecutorTest.fixedRateTask1();
        scheduledThreadPoolExecutorTest.cancelTask();
    }
}
