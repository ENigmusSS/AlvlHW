package ua.holovchenko.hw16.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Task1Test {
    @Test
    public void task1Test() {
        String cat = "cat";
        String dog = "dog";
        String parrot = "parrot";
        ArrayList<String> list = new ArrayList<>();
            list.add(cat);
            list.add(dog);
            list.add(parrot);
        HashMap<String, Integer> check = new HashMap<>();
            check.put(cat, 3);
            check.put(dog, 3);
            check.put(parrot, 6);
        HashMap<String, Integer> map = Task1.charCount(list);
        Assertions.assertEquals(check, map);
    }
}
