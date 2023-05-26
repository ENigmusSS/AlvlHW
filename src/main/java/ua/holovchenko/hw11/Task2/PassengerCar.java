package ua.holovchenko.hw11.Task2;

import java.util.Arrays;

public class PassengerCar extends Car implements Recovery {
    @Override
    public String toString() {
        return "PassengerCar{" + super.toString() +
                "passengers=" + Arrays.toString(passengers) +
                "} ";
    }

    protected final Passenger[] passengers = new Passenger[3];

    public PassengerCar(String series, String year, String color, int fuelCapacity, int fuelCurrent, int fuelConsumption, int distanceMoved) {
        super(series, year, color, fuelCapacity, fuelCurrent, fuelConsumption, distanceMoved);
    }

    public void addPassenger(Passenger passenger) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                System.out.println(passenger.name + "сел на место" + (i + 1));
                break;
            } else System.out.println("Место" + (i + 1) + "занято");
        }
    }
}
