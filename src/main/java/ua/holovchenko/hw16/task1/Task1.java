package ua.holovchenko.hw16.task1;

import java.util.HashMap;
import java.util.List;

public class Task1 {
    public static HashMap<String, Integer> charCount(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : list) {
            map.put(word, word.length());
        }
        return map;
    }
}
