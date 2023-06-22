package ua.holovchenko.hw15.task3;

import java.util.Comparator;
import java.util.TreeSet;

public class Task3 {


    public static class ZerosFirstDescendingBoxComparator implements Comparator<Box> {
        public int compare(Box a, Box b) {
            if (a.getVolume() == b.getVolume()) return 0;
            if (a.getVolume() == 0) return -1;
            if (b.getVolume() == 0) return 1;
            else return b.getVolume()-a.getVolume();
        }
    }
    public static void main(String[] args) {
        ZerosFirstDescendingBoxComparator comparator = new ZerosFirstDescendingBoxComparator();
        TreeSet<Box> boxSet = new TreeSet<>(comparator);
        Box box7 = new Box(7);
        Box box4 = new Box(4);
        Box box8 = new Box(8);
        Box box0 = new Box(0);
        Box box37 = new Box(37);
        boxSet.add(box7);
        boxSet.add(box4);
        boxSet.add(box8);
        boxSet.add(box0);
        boxSet.add(box37);
        System.out.println(boxSet);
    }
}
