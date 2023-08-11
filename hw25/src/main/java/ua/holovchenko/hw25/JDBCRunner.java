package ua.holovchenko.hw25;

import ua.holovchenko.hw25.entity.Device;
import ua.holovchenko.hw25.entity.DeviceType;
import ua.holovchenko.hw25.entity.Factory;
import ua.holovchenko.hw25.repository.DeviceRepository;
import ua.holovchenko.hw25.repository.FactoryRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class JDBCRunner {
    public static void main(String[] args) {
        try {
            DeviceRepository deviceRepo = new DeviceRepository();
            FactoryRepository factoryRepo = new FactoryRepository();
            factoryRepo.createTable();
            deviceRepo.createTable();
            generateInitialBase(factoryRepo, deviceRepo);

            Scanner scanner = new Scanner(System.in);
            int command;
            do {
            System.out.println("Enter command code");
            System.out.println("factory info: 1");
            System.out.println("device info, update, delete: 2");
            System.out.println("factories summary: 3");
            System.out.println("exit: 0");
            command = scanner.nextInt();
            switch (command) {
                case 1 -> factoryInfo(scanner, factoryRepo, deviceRepo);
                case 2 -> deviceAccess(scanner, deviceRepo);
                case 3 -> factoryRepo.setFactoriesSummary();
            }} while (command != 0);


        } catch (SQLException e) {
            System.err.println(e.getSQLState());
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deviceAccess(Scanner scanner, DeviceRepository deviceRepository ) throws SQLException {
        System.out.println("Enter device ID");
        int id = scanner.nextInt();
        Optional<Device> deviceOptional = deviceRepository.getByID(id);
        if (deviceOptional.isEmpty()) {
            System.out.println("Device with such ID is not exist");
            return;
        }
        Device device = deviceOptional.get();
        System.out.println(device);
        int command;
        do {
            System.out.println("Enter field index to change (0 to delete device, 1 to confirm changes and return, 9 to discard changes and return");
            command = scanner.nextInt();
            switch (command) {
                case 1 -> {deviceRepository.update(id, device); return;}
                case 2 -> {
                    System.out.println("Enter type number: " + Arrays.toString(DeviceType.values()));
                    device.setType(DeviceType.forIndex(scanner.nextInt()));
                }
                case 3 -> device.setModel(scanner.nextLine());
                case 4 -> device.setPrice(BigDecimal.valueOf(scanner.nextInt()));
                case 5 -> {
                    System.out.println("Enter date in format YYYY-MM-DD");
                    device.setProductionDate(Date.valueOf(scanner.nextLine()));
                }
                case 6 -> device.setDescription(scanner.nextLine());
                case 7 -> device.setStored(scanner.nextBoolean());
                case 8 -> device.setFactoryId(scanner.nextInt());
                case 9 -> {return;}
                case 0 -> deviceRepository.remove(id);
            }
            System.out.println(device);

        } while (command != 0 && command != 9);
    }

    private static void factoryInfo(Scanner scanner, FactoryRepository factoryRepo, DeviceRepository deviceRepo) throws SQLException {
        System.out.println("Enter factory ID");
        int id = scanner.nextInt();
        Optional<Factory> factoryOptional = factoryRepo.getByID(id);
        if (factoryOptional.isEmpty()) {
            System.out.println("Factory with such ID is not exist");
            return;
        }
        Factory factory = factoryOptional.get();
        System.out.println(factory);
        deviceRepo.getDevicesByFactory(id);
    }

    private static void generateInitialBase(FactoryRepository factoryRepo, DeviceRepository deviceRepo) throws SQLException {
        factoryRepo.add(new Factory("Samsung", "South Korea"));
        factoryRepo.add(new Factory("Xiaomi", "China"));
        factoryRepo.add(new Factory("Apple", "USA"));
        factoryRepo.add(new Factory("Sigma", "Ukraine"));
        deviceRepo.add(new Device(DeviceType.SMARTPHONE, "X-TREME PQ39 ULTRA", BigDecimal.valueOf(18000), Date.valueOf("2020-04-11"), "Ударо- и водозахищений", true, 4));
        deviceRepo.add(new Device(DeviceType.SMARTPHONE, "iPhone 14 PRO MAX Deep Purple 1TB", BigDecimal.valueOf(100000), Date.valueOf("2022-11-11"), "Коли понты дорожче грошей", true, 3));
        deviceRepo.add(new Device(DeviceType.SMARTPHONE, "Redmi Note 12 Pro+ 5G 8/256 Midnight Black", BigDecimal.valueOf(18000), Date.valueOf("2021-05-12"), "Камерофон, який ти хочеш", true, 2));
        deviceRepo.add(new Device(DeviceType.SMARTPHONE, "Samsung Galaxy S23 Ultra 12/512 BLACK", BigDecimal.valueOf(60000), Date.valueOf("2022-11-11"), "Краще айфона, дешевше айфона", true, 1));
        deviceRepo.add(new Device(DeviceType.TV, "QE98QN100BUXUA", BigDecimal.valueOf(1500000), Date.valueOf("2021-04-04"), "Вирішили відкрити камерный кінотеатр?", true, 1));
        deviceRepo.add(new Device(DeviceType.TV, "Mi TV Q1E 55", BigDecimal.valueOf(20000), Date.valueOf("2020-07-07"), "Просто справжній смарт", true, 2));
        deviceRepo.add(new Device(DeviceType.LAPTOP, "MacBook Pro 16 M2 Pro 1TB MNW93", BigDecimal.valueOf(150000), Date.valueOf("2022-08-16"), "Золоте гімно", true, 3));
        deviceRepo.add(new Device(DeviceType.LAPTOP, "RedmiBook Pro 14 R7/16/512/W11", BigDecimal.valueOf(30000), Date.valueOf("2020-05-17"), "Нуу, якщо у вас вже весь смартхаус від сяомі...", true, 2));
        deviceRepo.add(new Device(DeviceType.TABLET, "iPad Air 2022 Wi-Fi 64GB Space Gray (MM9C3)", BigDecimal.valueOf(33000), Date.valueOf("2022-08-23"), "Ідеально для художників/графіків", true, 3 ));
        deviceRepo.add(new Device(DeviceType.TABLET, "Galaxy Tab S8 Ultra 5G 12/256 (SM-X906BZAESEK) Dark Grey", BigDecimal.valueOf(62000), Date.valueOf("2021-03-28"), "Якщо вам дійсно потрібен планшет, мабуть вам потрібен найкращій планшет", true, 1));
    }
}
