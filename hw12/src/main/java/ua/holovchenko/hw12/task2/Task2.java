package ua.holovchenko.hw12.task2;

public class Task2 {
    public static void main(String[] args) {
        try {
            f();
        }
        catch (Exception e2) {
            System.out.println(e2.getMessage());
        }
    }

    public static void g() throws Exception  {
        throw new Exception("e1");
    }
    public static void f() throws Exception {
        try {
            g();
        }
        catch (Exception e1){
            System.out.println(e1.getMessage());
            throw new Exception("e2");
        }

    }
 }
