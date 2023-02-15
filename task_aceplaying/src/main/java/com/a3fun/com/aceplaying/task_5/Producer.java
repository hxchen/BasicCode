package com.a3fun.com.aceplaying.task_5;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author haixiangchen
 */
public class Producer implements Runnable{
    BlockingQueue<Integer> queue;
    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            int coin = new Random().nextInt(100);
            System.out.printf("生产者挖到了[%d]个金币 \n", coin);
            try {
                queue.put(coin);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
