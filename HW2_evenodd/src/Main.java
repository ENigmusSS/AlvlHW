import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = scanner.nextInt();
        evenOdd(num);
    }
    public static void evenOdd(int num){
        System.out.println(num % 2 == 0 ? "Is Even" : "Is Odd");
    }
}