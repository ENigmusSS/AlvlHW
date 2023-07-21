package ua.holovchenko.hw18.task2;

import java.io.*;


public class JsonParser {
    public static Box boxFromJson(String path) throws FileNotFoundException {
        Box box = new Box();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String temp;
        try {
            while ((temp = bufferedReader.readLine()) != null) {
                JsonUtil.read("\"from\":.\"(.*?)\"", temp, "from", box);
                JsonUtil.read("\"material\":.\"(.*?)\"", temp, "material", box);
                JsonUtil.read("\"color\":.\"(.*?)\"", temp, "color", box);
                JsonUtil.read("\"unit\":.\"(.*?)\"", temp, "unit", box);
                JsonUtil.read("\"value\":.(\\d*)", temp, "max", box);
                JsonUtil.read("\"name\":.\"(.*)\"", temp, "name", box);
                JsonUtil.read("\"class\":.\"(.*)\"", temp, "class", box);
                JsonUtil.read("\"delivery-date\":.\"(.*)\"", temp, "delivery", box);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return box;
    }
}