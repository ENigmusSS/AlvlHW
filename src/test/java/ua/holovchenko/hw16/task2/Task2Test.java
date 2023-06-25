package ua.holovchenko.hw16.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Task2Test {
    @Test
    public void task2Test() {
        ArrayList<String> list = new ArrayList<>();
            list.add("cat");
            list.add("dog");
            list.add("parrot");
        ArrayList<String> check3 = new ArrayList<>();
            check3.add("cat");
            check3.add("dog");
        ArrayList<String> check6 = new ArrayList<>();
            check6.add("parrot");
        HashMap<Integer, ArrayList<String>> check = new HashMap<>();
            check.put(3,check3);
            check.put(6,check6);
        HashMap<Integer, ArrayList<String>> map = Task2.charCount(list);
        Assertions.assertEquals(check, map);
    }
}
