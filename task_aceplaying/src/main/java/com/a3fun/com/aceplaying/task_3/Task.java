package com.a3fun.com.aceplaying.task_3;

/**
 * @author haixiangchen
 */
public class Task implements Runnable {
    private int taskID;
    public Task(int taskID){
        this.taskID = taskID;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "执行第" + taskID + "次任务");
    }
}



