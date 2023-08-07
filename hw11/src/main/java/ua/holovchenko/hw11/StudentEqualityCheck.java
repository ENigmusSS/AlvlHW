package ua.holovchenko.hw11;

import ua.holovchenko.hw10.task1.Aspirant;
import ua.holovchenko.hw10.task1.Student;

public class StudentEqualityCheck {
    public static void main(String[] args) {
        Student[] chessPlayersISemester = {
                new Student("Kostyantin", "Ivanov", "OCh3", 3.6),
                new Student("Illya", "Svyridov", "MM1", 3.7),
                new Aspirant("Volodymir", "Goncharenko", "BPhA2", 5.0, "5-HT -ergic complex"),
                new Aspirant("Oleg", "Shabelnik", "PhTA1", 4.7, "UV-LASERs"),
        };
        Student[] chessPlayersIISemester = {
                new Student("Illya", "Svyridov", "MM1", 3.5),
                new Aspirant("Volodymir", "Goncharenko", "BPhA2", 5.0, "5-HT -ergic complex"),
                new Aspirant("Oleg", "Shabelnik", "PhTA1", 5.0, "UV-LASERs"),
                new Student("Anna", "Koval", "MM1", 5.0)
        };
        for (Student studentIIsemester:
             chessPlayersIISemester) {
            for (Student studentIsemester:
                 chessPlayersISemester) {
                System.out.println(studentIIsemester +" was "+ studentIsemester +" : " + studentIsemester.equals(studentIIsemester));
            }
        }
    }
}
