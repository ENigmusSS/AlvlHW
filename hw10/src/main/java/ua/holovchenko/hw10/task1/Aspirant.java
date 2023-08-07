package ua.holovchenko.hw10.task1;

import java.util.Objects;

public class Aspirant extends Student{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aspirant aspirant = (Aspirant) o;
        return Objects.equals(dissertation, aspirant.dissertation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dissertation);
    }

    @Override
    public String toString() {
        return "Aspirant{" + super.toString() +
                "dissertation='" + dissertation + '\'' +
                "} " ;
    }


    String dissertation;
    public Aspirant(String firstName, String lastName, String group, double averageMark, String dissertation) {
        super(firstName, lastName, group, averageMark);
        this.dissertation = dissertation;
    }
    @Override
    public int getScholarship(){
        if (averageMark == 5.0) return 200;
        else return 180;
    }
}
