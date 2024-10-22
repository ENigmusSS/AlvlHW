package ua.holovchenko.practice2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void bigPriceTest(){
        int[] priceList = {1000,900,400,1750,1250};
        assertEquals(3000, Task1.sumOver1000(priceList));
    }
    @Test
    public void zeroBigPriseTest(){
        int[] priceList = {900, 500, 250, 450, 750};
        assertEquals(0, Task1.sumOver1000(priceList));
    }
}
