package ua.holovchenko.hw25.entity;

public enum DeviceType {
    SMARTPHONE,
    TV,
    LAPTOP,
    TABLET;

    public static DeviceType forIndex(int index) {
        return switch (index) {
            case 1 -> DeviceType.SMARTPHONE;
            case 2 -> DeviceType.TV;
            case 3 -> DeviceType.LAPTOP;
            case 4 -> DeviceType.TABLET;
            default -> throw new IllegalArgumentException("No such device type");
        };
    }
}
