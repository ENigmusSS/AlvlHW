package ua.holovchenko.hw11.Task2;

public class Truck extends Car implements Recovery {
    @Override
    public String toString() {
        return "Truck{" + super.toString() +
                "cargo='" + cargo + '\'' +
                "} ";
    }

    public Truck(String series, String year, String color, int fuelCapacity, int fuelCurrent, int fuelConsumption, int distanceMoved, String cargo) {
        super(series, year, color, fuelCapacity, fuelCurrent, fuelConsumption, distanceMoved);
        this.cargo = cargo;
    }

    protected String cargo; //ArrayList <String> ?

    public void loadCargo(String cargo) {
        this.cargo = this.cargo + cargo;
        System.out.println(cargo + "погружен. Текущий груз:" + this.cargo);
    }

    public void unloadCargo() {
        System.out.println("Выгружен груз:" + this.cargo);
        this.cargo = "";
    }

    @Override
    public void movement() {
        if (!cargo.equals("")) {
            if (fuelCurrent > (2 * fuelConsumption)) {
                fuelCurrent -= (2 * fuelConsumption);
                distanceMoved++;
                System.out.println("Автомобиль проехал 1км");
            } else System.out.println("Недостаточно топлива!");
        } else super.movement();
    }
}
