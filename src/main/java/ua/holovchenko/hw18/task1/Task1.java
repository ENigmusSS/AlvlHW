package ua.holovchenko.hw18.task1;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    private static final File csvFile = new File("csvFile.csv");
    public static void main(String[] args) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csvFile));
            writer.writeAll(input());
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }
    public static List<String[]> input() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> totalInput = new ArrayList<>();
        ArrayList<String> nextLine = new ArrayList<>();
        String nextString = "";
        while (!nextString.equals("end")) {
            nextString = scanner.nextLine();
            if (!nextString.equals("end")) {
                if (nextString.equals("next")) {
                    totalInput.add(nextLine.toArray(String[]::new));
                    nextLine = new ArrayList<>();
                }
                else nextLine.add(nextString);
            }
            else totalInput.add(nextLine.toArray(String[]::new));
        }
        return totalInput;
    }
}
