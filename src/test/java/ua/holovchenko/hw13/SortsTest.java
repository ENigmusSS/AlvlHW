package ua.holovchenko.hw13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class SortsTest {
    static int[] testUnsorted = {9,6,8,7,5,4,3,6,6,2,1,0,0};
    static int[] testSorted =   {0,0,1,2,3,4,5,6,6,6,7,8,9};
    @Test
    public void bubbleSortTest() {
        assertArrayEquals(Sorts.bubbleSort(testUnsorted), testSorted);
    }
    @Test
    public void quickSortTest() {
        assertArrayEquals(Sorts.quickSort(testUnsorted), testSorted);
    }
    @Test
    public void SortEqualityCheck() {
        assertArrayEquals(Sorts.quickSort(testUnsorted), Sorts.bubbleSort(testUnsorted));
    }
}
