package ua.holovchenko.hw32.task2;


import org.jetbrains.annotations.NotNull;

public class Horse implements Comparable<Horse> {
    private int distance = 0;
    private boolean chosen;
    private long result = 0L;

    private int number;

    private int place;

    private HorseRunnable run;

    private boolean finished = false;

    public Horse(int number) {
        this.number = number;
    }

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
        System.out.println("Horse №"+ number + " Result Time: " + result + " Is your bet: " + chosen);
    }

    public long getResult() {
        return result;
    }

    protected void setResult(long result) {
        this.result = result;
    }

    public void startHorseRun() {
        this.run = new HorseRunnable(this);
        run.run();
    }

    public HorseRunnable getRun() {
        return run;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
