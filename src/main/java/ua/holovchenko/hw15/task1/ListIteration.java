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
        for (E elem:
             list) {
            System.out.println(elem);
        }
    }
    //public static <E> void whileCyclePrint(ArrayList<E> list){while ()}
    public static <E> void iteratorPrintEach(ArrayList<E> list){
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()){
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
}
