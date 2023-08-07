package ua.holovchenko.hw32.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    public void task1Test() throws InterruptedException {
        Assertions.assertEquals(250, Task1.multiThreadedIncrement());
    }
}
