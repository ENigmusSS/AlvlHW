package ua.holovchenko.hw6.task1;

public class Phone {
    int weight;
    String model;
    long number;

    Phone() {
    }

    Phone(long number, String model) {
        this.number = number;
        this.model = model;
    }

    Phone(long number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    void receiveCall(String name) {
        System.out.println(name + " is calling");
    }

    long getNumber() {
        return number;
    }
}
