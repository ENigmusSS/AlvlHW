package ua.holovchenko.hw6.task1;

public class Phone {
    int weight;
    String model;
    String number;

    Phone() {
    }

    Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    Phone(String number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    void receiveCall(String name) {
        System.out.println(name + " is calling");
    }

    String getNumber() {
        return number;
    }
}
