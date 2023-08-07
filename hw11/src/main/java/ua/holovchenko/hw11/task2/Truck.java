package ua.holovchenko.hw11.task2;

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
        if (this.cargo != null) {
            System.err.println("Нет места, текущий груз: " + this.cargo);
        } else {
            this.cargo = cargo;
            System.out.println(cargo + "погружен.");
        }
    }

    public void unloadCargo() {
        try {
            if (this.cargo == null) {
                throw new NullPointerException();
            } else {
                System.out.println("Выгружен груз:" + this.cargo);
                this.cargo = null;
            }

        } catch (NullPointerException npe) {
            System.err.println("Пусто, нечего выгружать");
        }
    }

    @Override
    public void movement() {
        if (fuelCurrent > (2 * fuelConsumption)) {
            fuelCurrent -= (2 * fuelConsumption);
            distanceMoved++;
            System.out.println("Автомобиль проехал 1км");
        } else System.out.println("Недостаточно топлива!");

    }
}
