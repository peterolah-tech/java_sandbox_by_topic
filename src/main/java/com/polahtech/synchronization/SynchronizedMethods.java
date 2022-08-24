package com.polahtech.synchronization;

public class SynchronizedMethods {

    private int sum;

    public SynchronizedMethods() {
        this.sum = 0;
    }

    public void increaseSum(int increment) {
        this.sum += increment;
    }

    public int getSum() {
        return sum;
    }
}
