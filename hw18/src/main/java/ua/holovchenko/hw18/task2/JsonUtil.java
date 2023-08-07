package ua.holovchenko.hw18.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtil {
    private static Pattern pattern;
    private static Matcher matcher;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static void read(String string, String temp, String type, Box box) {
        pattern = Pattern.compile(string);
        matcher = pattern.matcher(temp);
        while (matcher.find()) {
            switch (type) {
                case ("from") -> box.setFrom(matcher.group(1));
                case ("material") -> box.setMaterial(matcher.group(1));
                case ("color") -> box.setColor(matcher.group(1));
                case ("unit") -> box.getMaxLiftingCapacity().setUnit(matcher.group(1));
                case ("max") -> box.getMaxLiftingCapacity().setValue(Integer.parseInt(matcher.group(1)));
                case ("name") -> box.getCargo().setName(matcher.group(1));
                case ("class") -> box.getCargo().setCargoCls(matcher.group(1));
                case ("delivery") -> box.setDeliveryDate(LocalDateTime.parse(matcher.group(1), formatter));
            }
        }
    }
}