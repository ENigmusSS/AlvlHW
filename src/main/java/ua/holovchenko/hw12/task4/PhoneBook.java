package ua.holovchenko.hw12.task4;

import java.util.Objects;
import java.util.Optional;

public class PhoneBook {
    private static final String[] PHONE_BOOK = new String[3];
    public static void main(String[] args) {
        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";
        System.out.println(findIndexByPhoneNumber("016/161617"));

    }
    public static Optional<Integer> findIndexByPhoneNumber(String phoneNumber){
        for (int i = 0; i < PHONE_BOOK.length; i++) {
            if (Objects.equals(PHONE_BOOK[i], phoneNumber)) return Optional.of(i);
        }
        return Optional.empty();
    }

}

//int index = Arrays.binarySearch(PHONE_BOOK, phoneNumber);
//if (index == -1) return Optional.empty();
//else return Optional.of(index);
// Array to ArrayList .contains() ?