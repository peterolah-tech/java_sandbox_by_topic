package com.polahtech.synchronization;

public class SynchronizedMethods {

    private int sumNonSync;
    private int sumSync;


    public SynchronizedMethods() {
        this.sumNonSync = 0;
        this.sumSync = 0;
        }

    public void increaseSumNonSync(int increment) {
        this.sumNonSync += increment;
    }

    public synchronized void increaseSumSync(int increment) {
        this.sumSync += increment;
    }

    public int getSumNonSync() {
        return sumNonSync;
    }

    public int getSumSync() {
        return sumSync;
    }
}
