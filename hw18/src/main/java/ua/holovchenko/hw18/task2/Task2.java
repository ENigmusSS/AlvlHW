package ua.holovchenko.hw18.task2;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        try {
            Box boxOfJson = JsonParser.boxFromJson("Box.json");
            System.out.println(boxOfJson);
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }
}
