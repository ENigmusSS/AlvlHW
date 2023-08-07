package ua.holovchenko.hw31.task1;

import lombok.SneakyThrows;

public class CountDown extends Thread {
    private final int myNum;

    public CountDown(int myNum) {
        this.myNum = myNum;
    }

    @SneakyThrows
    @Override
    public void run() {
        if (myNum != 49) {
            CountDown countDown = new CountDown(myNum+1);
            countDown.start();
            countDown.join();
        }
        System.out.println("Hello from thread:" + myNum);
    }
}
