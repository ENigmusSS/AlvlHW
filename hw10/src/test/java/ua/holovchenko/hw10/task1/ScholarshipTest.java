package ua.holovchenko.hw10.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScholarshipTest {
    static Student[] students = {
            new Student("Mycola", "Kovalenko", "BCh3", 5.0),
            new Student("Alexiy", "Kryvoshiyko", "BPh4", 4.1),
            new Aspirant("Dmytriy", "Jabolybov", "BZA1", 3.7, "Rana Esculenta complex"),
            new Aspirant("Volodymir", "Goncharenko", "BPhA2", 5.0, "5-HT -ergic complex")
    };

    @Test
    public void scholarshipStudentPerfectTest() {
        assertEquals(100, students[0].getScholarship());
    }
    @Test
    public void scholarshipStudentUnperfectTest(){
        assertEquals(80, students[1].getScholarship());
    }
    @Test
    public void scholarshipAspirantPerfectTest() {
        assertEquals(200, students[3].getScholarship());
    }
    @Test
    public void scholarshipAspirantUnperfect() {
        assertEquals(180, students[2].getScholarship());
    }
}
