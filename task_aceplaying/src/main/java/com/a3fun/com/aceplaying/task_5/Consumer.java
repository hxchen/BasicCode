package com.a3fun.com.aceplaying.task_5;


import java.util.concurrent.BlockingQueue;

/**
 * @author haixiangchen
 */
public class Consumer implements Runnable{
    BlockingQueue<Integer> queue;
    private volatile boolean run  = true;
    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (run){
            Integer integer = queue.poll();
            if (integer != null){
                System.out.printf("消费者存取[%d]个金币 \n", integer);
            }
        }
    }
}
