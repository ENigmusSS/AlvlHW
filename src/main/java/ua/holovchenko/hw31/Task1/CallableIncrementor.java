package ua.holovchenko.hw31.task1;

import java.util.concurrent.Callable;

public class CallableIncrementor implements Callable<Boolean> {

    @Override
    public Boolean call() {
        Task1.increment2();
        return true;
    }
}
