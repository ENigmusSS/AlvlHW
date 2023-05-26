package ua.holovchenko.hw11.Task2;

import java.util.Objects;

public class Car implements Recovery {
    @Override
    public String toString() {
        return "Car{" +
                "series='" + series + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", fuelCapacity=" + fuelCapacity +
                ", fuelCurrent=" + fuelCurrent +
                ", fuelConsumption=" + fuelConsumption +
                ", distanceMoved=" + distanceMoved +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(series, car.series) && Objects.equals(year, car.year) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(series, year, color);
    }

    public Car(String series, String year, String color, int fuelCapacity, int fuelCurrent, int fuelConsumption, int distanceMoved) {
        this.series = series;
        this.year = year;
        this.color = color;
        this.fuelCapacity = fuelCapacity;
        this.fuelCurrent = fuelCurrent;
        this.fuelConsumption = fuelConsumption;
        this.distanceMoved = distanceMoved;
    }

    protected final String series;
    protected final String year;
    protected final String color;
    protected int fuelCapacity;
    protected int fuelCurrent;
    protected int fuelConsumption;
    protected int distanceMoved;

    public void movement() {
        if (fuelCurrent > fuelConsumption) {
            fuelCurrent -= fuelConsumption;
            distanceMoved++;
            System.out.println("Автомобиль проехал 1км");
        } else System.out.println("Недостаточно топлива!");
    }

    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public void refuel() {
        fuelCurrent = fuelCapacity;
        System.out.println("Заправлен полный бак");
    }
}
