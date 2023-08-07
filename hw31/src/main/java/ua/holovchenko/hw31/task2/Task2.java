package ua.holovchenko.hw31.task2;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    @SneakyThrows
    public static int biThreadPrimeCounter(List<Integer> list) {
        List<Integer> sublist1 = new ArrayList<>();
        List<Integer> sublist2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i%2 == 0) sublist2.add(list.get(i));
            else sublist1.add(list.get(i));
        }
        PrimeCounter counter1 = new PrimeCounter(sublist1);
        PrimeCounter counter2 = new PrimeCounter(sublist2);
        counter1.start();
        counter2.start();
        counter1.join();
        counter2.join();
        return (counter1.getPrimeCount() + counter2.getPrimeCount());
    }
}
