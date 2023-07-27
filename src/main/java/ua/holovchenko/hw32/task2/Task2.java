package ua.holovchenko.hw32.task2;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Task2 {
    @SneakyThrows
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount of horses competing");
        int horseAmount = input.nextInt();
        List<Horse> horses = new ArrayList<>(horseAmount);
        int bet;
        boolean validBet = false;
        do {
            System.out.println("Enter your bet");
            bet = input.nextInt() - 1;
            if (bet < horseAmount) validBet = true;
            else System.out.println("Invalid bet: choose existing horse");
        } while (!validBet);
        for (int i = 0; i < horseAmount; i++) {
            horses.add(new Horse());
        }
        Horse chosenHorse = horses.get(bet);
        chosenHorse.setChosen(true);
        horses.forEach(Horse::startRun);
        while (!horses.stream().allMatch(Horse::isFinished)) {
            sleep(1000);
        }
        horses.forEach(Horse::printResult);
        horses = horses.stream().sorted().toList();
        System.out.println("Your bet is finished on place " + (horses.indexOf(chosenHorse)+1));
    }
}
