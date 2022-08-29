package com.polahtech.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CalculatingResource {
    private int sum;
    private final Lock lock;

    public CalculatingResource() {
        this.sum = 0;
        this.lock = new ReentrantLock();
    }

    public void increaseSum(int increment) {
        try {
            lock.lock();
            // If another thread has already acquired the lock subsequent calls to lock() pause the current thread
            // until the lock has been unlocked. Only one thread can hold the lock at any given time.
            this.sum += increment;
        } finally {
            lock.unlock();
        }
    }

    public int getSum() {
        return sum;
    }
}
