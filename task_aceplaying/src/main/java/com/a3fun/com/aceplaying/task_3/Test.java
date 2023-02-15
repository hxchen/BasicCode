package com.a3fun.com.aceplaying.task_3;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        //TODO 填写代码
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++){
            executorService.submit(new Task(i));
        }
    }
}
