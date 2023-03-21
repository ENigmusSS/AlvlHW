import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the numbers");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int res = minAbs(x,y,z);
        System.out.println(res);
    }
    public static int minAbs(int x, int y, int z){
        int xAbs = x > 0 ? x : -x;
        int yAbs = y > 0 ? y : -y;
        int zAbs = z > 0 ? z : -z;
        int minAbs = xAbs > yAbs ? Math.min(yAbs, zAbs) : Math.min(xAbs, zAbs);
        if (minAbs == xAbs) return x;
        else if (minAbs == yAbs) return y;
        else return z;

    }
}