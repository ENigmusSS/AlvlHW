package ua.holovchenko.hw21.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Task1 {
    public static void main(String[] args) {
        Class<A> aClass = A.class;
        try {
            Constructor<A> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            A a = constructor.newInstance();
            System.out.println(a);
            Field[] fields = aClass.getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(true);
            }
            fields[0].set(a,"987");
            fields[1].set(a, "B");
            System.out.println(a);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
