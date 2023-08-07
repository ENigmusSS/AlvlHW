package ua.holovchenko.hw6.task1;

public class Main {
    public static void main(String[] args) {
        Phone[] phones = createPhones();
        Phone phone1 = phones[0];
        Phone phone2 = phones[1];
        Phone phone3 = phones[2];
        typePhoneInformation(phone1);
        typePhoneInformation(phone2);
        typePhoneInformation(phone3);
        System.out.println(phone1.getNumber());
        System.out.println(phone2.getNumber());
        System.out.println(phone3.getNumber());
        phone1.receiveCall("Maria");
        phone2.receiveCall("Jeanne");
        phone3.receiveCall("Sun Hui Chai");
    }

    private static Phone[] createPhones() {
        Phone phone1 = new Phone();
        phone1.weight = 999;
        phone1.model = "Nokia 3310";
        phone1.number = "666131313";

        Phone phone2 = new Phone("951067777", "samsung Galaxy S6");
        phone2.weight = 150;
        Phone phone3 = new Phone("369765513", "xiaomi Redmi note 9 pro", 200);
        return new Phone[]{phone1, phone2, phone3};
    }

    private static void typePhoneInformation(Phone phone) {
        System.out.println(phone.number);
        System.out.println(phone.model);
        System.out.println(phone.weight);
    }

}
