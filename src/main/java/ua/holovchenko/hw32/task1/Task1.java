package ua.holovchenko.hw32.task1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {
    private static volatile int num = 50;

    public static synchronized void increment2() {
        num +=2;
    }

    public static int multiThreadedIncrement() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ArrayList<CallableIncrementor> incrementors = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            incrementors.add(new CallableIncrementor());
        }
        executorService.invokeAll(incrementors);
        return num;
    }
}
