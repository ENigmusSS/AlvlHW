package ua.holovchenko.hw21.task1;

public class A {
    private String id = "123";
    private String name = "A";
    private A() {
    }
    @Override
    public String toString() {
        return "A{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}