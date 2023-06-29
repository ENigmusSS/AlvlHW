package ua.holovchenko.hw15.task2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {
    public static int getSum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static List<Integer> getOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 1)
                .collect(Collectors.toList());
    }

    public static List<String> convertToStringList(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public static List<String> doubling(List<String> strings) {
        List<String> doubled = new ArrayList<>();
        for (String string : strings) {
            doubled.add(string + string);
        }
        return doubled;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers);
        System.out.println(getSum(numbers));
        List<Integer> odds = getOddNumbers(numbers);
        System.out.println(odds);
        List<String> strings = convertToStringList(odds);
        System.out.println(strings);
        List<String> doubled = doubling(strings);
        System.out.println(doubled);
    }
}
