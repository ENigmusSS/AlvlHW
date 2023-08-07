package ua.holovchenko.hw31.task2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ua.holovchenko.hw31.task2.Task2.biThreadPrimeCounter;

public class PrimeCounterTest {
    List<Integer> list = Stream.iterate(1, (x -> x+1)).limit(1000).toList();

    @Test
    public void singleThreadTest() throws InterruptedException {
        PrimeCounter primeCounter = new PrimeCounter(list);
        primeCounter.start();
        primeCounter.join();
        assertEquals(168, primeCounter.getPrimeCount());
    }

    @Test
    public void biThreadTest() {
        assertEquals(168, biThreadPrimeCounter(list));
    }
}
