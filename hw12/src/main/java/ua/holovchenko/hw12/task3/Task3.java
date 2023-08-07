package ua.holovchenko.hw12.task3;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        try {
            exRoulette();
        }
        catch (Ex1 | Ex2 | Ex3 ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void exRoulette() throws Ex1, Ex2, Ex3 {
        Random rnd = new Random();
        switch (rnd.nextInt(1, 4)) {
            case 1 -> throw new Ex1("Ex1");
            case 2 -> throw new Ex2("Ex2");
            case 3 -> throw new Ex3("Ex3");
        }
    }
}
