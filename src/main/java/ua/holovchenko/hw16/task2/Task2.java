package ua.holovchenko.hw16.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task2 {
    public static HashMap<Integer, ArrayList<String>> charCount(List<String> list) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (String word:
             list) {
            ArrayList<String> thisLengthList = map.getOrDefault(word.length(), new ArrayList<String>());
            thisLengthList.add(word);
            map.put(word.length(), thisLengthList);
        }
        return map;
    }
}
