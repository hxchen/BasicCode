package com.a3fun.springthreadpool.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass {
    public AtomicInteger line = new AtomicInteger();
    public ReentrantLock reentrantLock = new ReentrantLock(true);
    
}
