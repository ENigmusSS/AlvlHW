package ua.holovchenko.hw13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SearchTest {
    static int[] array = {0,1,2,3,4,5,6,7,8,9};
    @Test
    public void linearTest() {
        assertEquals(9, Search.linearSearch(array, 9));
    }
    @Test
    public void binaryTest() {
        assertEquals(9, Search.binarySearch(array, 0,array.length-1,9));
    }
    @Test
    public void linearNegativeTest() {
        assertEquals(-1, Search.linearSearch(array, 76));
    }
    @Test
    public void binaryNegativeTest() {
        assertEquals(-1, Search.binarySearch(array, 0, array.length-1, 76));
    }
}
