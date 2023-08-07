package ua.holovchenko.hw15.task1;

import java.util.ArrayList;
import java.util.Iterator;



public class ListIteration {
    public static void forCyclePrint(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static <E> void forEachCyclePrint(ArrayList<E> list) {
        for (E elem : list) {
            System.out.println(elem);
        }
    }

    public static <E> void whileCyclePrint(ArrayList<E> list){
        int index = 0;
        while (list.size() > index) {
            System.out.println(list.get(index++));
        }
        // это же просто костыльный for?? ещё вроде можно сделать ещё более костыльный аналог итератора, но з0чєм?
        // а как сделать "чистый" вайл без внешнего условия, я не представляю, и в презентации обход вайлом не упоминался
    }
    public static <E> void iteratorPrintEach(ArrayList<E> list) {
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            E elem = iterator.next();
            System.out.println(elem);
        }
    }

    public static <E> void printEach(ArrayList<E> list) {
        list.forEach(System.out::println);
    }

    public static <E> void streamPrintEach(ArrayList<E> list) {
        list.stream().forEach(System.out::println);
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
            list.add("a");
            list.add("b");
            list.add("c");
        forCyclePrint(list);
        forEachCyclePrint(list);
        whileCyclePrint(list);
        iteratorPrintEach(list);
        printEach(list);
        streamPrintEach(list);
    }
}
