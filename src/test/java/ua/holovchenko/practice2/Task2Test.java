package ua.holovchenko.practice2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task2Test {
    @Test
    public void heightsTest() {
        int[] heights = {170, 175, 180, -160, -165, -170};
        assertArrayEquals(new int[] {-165,175}, Task2.getAverage(heights));
    }
}
