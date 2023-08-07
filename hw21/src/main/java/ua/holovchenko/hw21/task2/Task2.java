package ua.holovchenko.hw21.task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task2 {

    public static void classScan(List<Class<?>> classList) {
        HashMap<String, Object> map = new HashMap<>();
        for (Class<?> cls : classList) {
            instanceInit(map, cls);
        }
        map.forEach((String name, Object obj) -> {
            Class<?> cls = obj.getClass();
            initMethodScan(obj, cls);
            valueInitScan(obj, cls);
        });
    }

    private static void instanceInit(HashMap<String, Object> map, Class<?> cls) {
        if (cls.isAnnotationPresent(Service.class)) {
            try {
                Object obj;
                try {
                    obj = cls.getDeclaredConstructor().newInstance();
                } catch (IllegalAccessException illAcsEx) {
                    cls.getDeclaredConstructor().setAccessible(true);
                    obj = cls.getDeclaredConstructor().newInstance();
                }
                map.put(cls.getName(), obj);
            } catch (NoSuchMethodException | InstantiationException |
                     IllegalAccessException | InvocationTargetException ex) {
                System.err.println("Instance creation failed / No default constructor:" + cls.getName());
            }
        }
    }

    private static void valueInitScan(Object obj, Class<?> cls) {
        for (Field field:
             cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(Value.class)) {
                try {
                    try {
                        Value valueAnn = field.getAnnotation(Value.class);
                        field.set(obj, valueAnn.initValue());
                    } catch (IllegalAccessException illAcsEx) {
                        field.setAccessible(true);
                        Value valueAnn = field.getAnnotation(Value.class);
                        field.set(obj, valueAnn.initValue());
                    }
                    System.out.println(obj);
                } catch (IllegalAccessException ex) {
                    System.err.println("Field value initialization failed:" + cls.getName() + field.getName());
                }
            }
        }
    }

    private static void initMethodScan(Object obj, Class<?> cls) {
        for (Method method :
                cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                try {
                    try {
                        method.invoke(obj);
                    } catch (IllegalAccessException e) {
                        method.setAccessible(true);
                        method.invoke(obj);
                    }
                } catch (InvocationTargetException | IllegalAccessException e) {
                    System.err.println("Init method call failed:" + cls.getName() + method.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Class<?>> list = new ArrayList<>();
        list.add(Test.class);
        classScan(list);
    }
}

