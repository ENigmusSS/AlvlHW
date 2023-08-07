package ua.holovchenko.hw14.task2;

import java.util.Arrays;

public class GenericUtils {
    public static <V> void printSomething(V value) {
        System.out.println("***{" + value + "}***");
    }

    public <E> void printArray(E[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        String cat = "ଲ(ⓛ ω ⓛ)ଲ";
        Integer limon = 1000000;
        printSomething(cat);
        printSomething(limon);
        GenericUtils gu = new GenericUtils();
        Integer[] ints = {
                4523, 52345, 24, 35735673, 3563, 553
        };
        String[] emoji = {"(￣(00)￣)", "/╲/\\╭(ఠఠ益ఠఠ)╮/\\╱\\", "(* ^ ω ^)", "╰(▔∀▔)╯"};
        gu.printArray(ints);
        gu.printArray(emoji);
    }
}
