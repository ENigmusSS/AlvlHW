package ua.holovchenko.hw17.task3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static boolean yearAnyChecker2023(List<String> list) {
        return list.stream()
                .map(LocalDate::parse)
                .anyMatch((x -> x.getYear() == 2023));
    }

    public static void main(String[] args) {
        ArrayList<String> trueList = new ArrayList<>();
        trueList.add("1997-11-23");
        trueList.add("2004-04-23");
        trueList.add("2023-07-21");
        trueList.add("2012-03-11");
        ArrayList<String> falseList = new ArrayList<>();
        falseList.add("1997-11-23");
        falseList.add("2004-04-23");
        falseList.add("2021-07-21");
        falseList.add("2012-03-11");
        System.out.println(yearAnyChecker2023(trueList));
        System.out.println(yearAnyChecker2023(falseList));
    }
}
