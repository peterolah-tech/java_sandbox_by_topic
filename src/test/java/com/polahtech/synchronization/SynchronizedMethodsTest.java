package com.polahtech.synchronization;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedMethodsTest {

    @Test
    void testInMultiThreadedEnvironmentNoSync() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3); // TODO: move to separate var
        SynchronizedMethods synchronizedMethods = new SynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> executorService.submit(() -> synchronizedMethods.increaseSum(1)));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, synchronizedMethods.getSum());
    }

}