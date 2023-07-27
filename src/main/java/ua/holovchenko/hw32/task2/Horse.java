package ua.holovchenko.hw32.task2;

import org.jetbrains.annotations.NotNull;

public class Horse implements Comparable<Horse> {
    private int distance = 0;
    private boolean chosen;
    private long result = 0L;

    private HorseRunnable run;

    private boolean finished = false;

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public boolean isChosen() {
        return chosen;
    }

    protected void finish() {
        this.finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    protected void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(@NotNull Horse o) {
        return Long.compare(o.result, this.result);
    }

    public void printResult() {
        System.out.println("Result Time: " + result + " Is your bet: " + chosen);
    }

    public long getResult() {
        return result;
    }

    protected void setResult(long result) {
        this.result = result;
    }

    public void startRun() {
        this.run = new HorseRunnable(this);
        run.run();
    }

    public HorseRunnable getRun() {
        return run;
    }
}
