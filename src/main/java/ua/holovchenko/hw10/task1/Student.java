package ua.holovchenko.hw10.task1;

import java.util.Objects;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group='" + group + '\'' +
                ", averageMark=" + averageMark +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, group);
    }

    String firstName;
    String lastName;
    String group;
    double averageMark;

    public Student(String firstName, String lastName, String group, double averageMark){
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public int getScholarship(){
        if (averageMark == 5.0) return 100;
        else return 80;
    }
}
