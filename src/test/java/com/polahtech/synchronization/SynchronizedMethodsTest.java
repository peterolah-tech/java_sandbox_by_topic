package com.polahtech.synchronization;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedMethodsTest {

    int increment = 1;
    int increaseFrom = 0;
    int increaseUntil = 1000;
    final int executorServiceTimeoutInMs = 1000;

    @Disabled("Created on purpose to test incorrect setup of ExecutorService")
    @Test
    void testInMultiThreadedEnvironmentNoSync() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3); // TODO: move to separate var
        SynchronizedMethods synchronizedMethods = new SynchronizedMethods();

        IntStream.range(increaseFrom, increaseUntil)
                .forEach(count -> executorService.submit(() -> synchronizedMethods.increaseSumNonSync(1)));
        executorService.awaitTermination(executorServiceTimeoutInMs, TimeUnit.MILLISECONDS);

        assertEquals(((increaseUntil - increaseFrom) * increment), synchronizedMethods.getSumNonSync());
    }

    @Test
    void testMultiThreadedEnvironmentSync() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SynchronizedMethods synchronizedMethods = new SynchronizedMethods();

        IntStream.range(increaseFrom, increaseUntil)
                .forEach(count -> executorService.submit(() -> synchronizedMethods.increaseSumSync(increment)));
        executorService.awaitTermination(executorServiceTimeoutInMs, TimeUnit.MILLISECONDS);

        assertEquals(((increaseUntil - increaseFrom) * increment), synchronizedMethods.getSumSync());
    }

}