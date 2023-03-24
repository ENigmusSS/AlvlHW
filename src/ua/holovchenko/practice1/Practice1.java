package ua.holovchenko.practice1;

public class Practice1 {
    /* Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех его цифр
(заранее не известно сколько цифр будет в числе).*/
    public static void main(String[] args) {
        System.out.println("Hello world!");
        long num = (long) (Math.random() * 1000000000000000000L);
        System.out.println(num);
        System.out.println(evenOddAmount(num));
        System.out.println(digitSum(num));
        System.out.println(digitSumv2(num));
    }

    public static long digitSum(long num) {
        long digitSum = 0;
        do {
            digitSum = digitSum + num % 10;
            num /= 10;

        } while (num > 0);
        return digitSum;
    }

    public static long digitSumv2(long num) {
        long digitSum = 0;
        String numStr = Long.toString(num);

        for (int i = 0; i < numStr.length(); i++) {
            digitSum = digitSum + Character.getNumericValue(numStr.charAt(i));
        }
        return digitSum;
    }

    public static String evenOddAmount(long num) {
        int even = 0;
        int odd = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                even++;
            } else odd++;
            num /= 10;
        }
        return ("even " + even + " Odd " + odd);
    }
}