package ua.holovchenko.hw5;

import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    public void positiveResultTest() {
        int[] notRaising = {9, 8, 7, 6, 5};
        assert Task2.isNotRaising(notRaising);
    }

    @Test
    public void negativeResultTest() {
        int[] mixed = {9, 4, 6, 8, 4, 2};
        assert !Task2.isNotRaising(mixed);
    }
}
