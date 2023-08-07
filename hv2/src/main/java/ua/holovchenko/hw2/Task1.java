package ua.holovchenko.hw2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Введіть координати вершин трикутника: x1 y1 x2 y2 x3 y3, в новій строці кожну");
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        double res = triangleS(x1,y1,x2,y2,x3,y3);
        System.out.println(res);
    }
    public static double triangleS(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5*Math.abs((x2-x1)*(y3-y1)-(x3-x1)*(y2-y1));
    }
}