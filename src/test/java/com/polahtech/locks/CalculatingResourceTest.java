package com.polahtech.locks;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatingResourceTest {

    @Test
    void testLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CalculatingResource calculatingResource = new CalculatingResource();

        IntStream.range(0, 1000)
                .forEach(count -> executorService.submit(() -> calculatingResource.increaseSum(1)));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, calculatingResource.getSum());
    }

}