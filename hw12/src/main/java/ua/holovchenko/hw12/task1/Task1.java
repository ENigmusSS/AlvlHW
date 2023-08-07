package ua.holovchenko.hw12.task1;

public class Task1 {
    public static void main(String[] args) {
        try {
            throw new Exception("Столкновение неизбежно");
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Все дороги ведут в Рим");
        }
    }
}
