package ua.holovchenko.hw4;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void averageAriphTest(){
        int[] test = {5,3,4};
        assertEquals(4.0, Task1.averageAriph(test));
    }
    @Test
    public void averageGeomTest(){
        int[] test = {1,3,9,27, 81};
        assertEquals(9, Task1.averageGeom(test));
    }
    @Test
    public void averageSqrTest(){
        int[] test = {4,4,4,4,4,4};
        assertEquals(4.0, Task1.averageSqr(test));
    }
}
