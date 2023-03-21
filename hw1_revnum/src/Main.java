import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int num = getUserNum();
        int revnum = reverse(num);
        System.out.println(revnum);
    }
    public static int getUserNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        return scanner.nextInt();
    }
    public static int reverse (int num) {
        String numst = String.valueOf(num);
        StringBuilder numstb = new StringBuilder(numst);
        String revst = numstb.reverse().toString();
        return Integer.parseInt(revst);
    }
}