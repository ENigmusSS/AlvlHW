package ua.holovchenko.hw10.task1;

public class Aspirant extends Student{
    @Override
    public String toString() {
        return "Aspirant{" + super.toString() +
                "dissertation='" + dissertation + '\'' +
                "} " ;
    }

    //Поля - определители для .equals переопределены в родительском классе
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
