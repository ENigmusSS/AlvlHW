package ua.holovchenko.hw18.task2;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Box {
    private String from;
    private String material;
    private String color;
    private Cargo cargo = new Cargo();
    private MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
    private LocalDateTime deliveryDate;
}