package ua.holovchenko.hw32.task2;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

//сделать внутренним классом класса Horse?
public class HorseRunnable implements Runnable {
    private final Horse horse;
    ThreadLocalRandom random = ThreadLocalRandom.current();

    public HorseRunnable(Horse horse) {
        this.horse = horse;
    }

    public void run() {
        long start = System.nanoTime();
        while (horse.getDistance() < 1000) {
            horse.setDistance(horse.getDistance() + random.nextInt(100, 200));
            try {
                sleep(random.nextLong(400, 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long finish = System.nanoTime();
        horse.setResult(finish - start);
        horse.finish();
    }
}
