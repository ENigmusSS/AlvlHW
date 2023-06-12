package ua.holovchenko.hw10.task1;

public class Task1Main {
    public static void main(String[] args) {
        Student[] students =
                {
                        new Student("Mycola", "Kovalenko", "BCh3", 5.0),
                        new Student("Alexiy", "Kryvoshiyko", "BPh4", 4.1),
                        new Aspirant("Dmytriy", "Jabolybov", "BZA1", 3.7, "Rana Esculenta complex"),
                        new Aspirant("Volodymir", "Goncharenko", "BPhA2", 5.0, "5-HT -ergic complex")
                };
        for (Student student: students) {
            System.out.println(student.getScholarship());
        }
    }
}
