package ua.holovchenko.hw10.task2;

public class Task2Main {
    public static void main(String[] args) {
        Pow pow = (num, pw) -> {
            int res = 1;
            for (int i = 0; i < pw; i++) {
                res *=num;
            }
            return res;
        };
        //лень в Nный раз прописывать консольный инпут операндов... слишком много сделать нужно, а не просто хочется для видимости полезности
        System.out.println("2^10=" + pow.pow(2,10));
    }
}
