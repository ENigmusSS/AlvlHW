package ua.holovchenko.hw25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SQLReader {

    public static String readSql(String filePath) {
        StringBuilder sqlContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sqlContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlContent.toString();
    }
}
