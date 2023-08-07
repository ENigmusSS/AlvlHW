package ua.holovchenko.hw31.task2;

import java.math.BigInteger;
import java.util.List;

public class PrimeCounter extends Thread {
    private final List<Integer> list;
    private int primeCount;

    public PrimeCounter(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        BigInteger checker;
        for (Integer num : list) {
            checker = BigInteger.valueOf(num);
            if (checker.isProbablePrime(10)) primeCount++;
        }
    }
    public int getPrimeCount() {
        return primeCount;
    }
}
