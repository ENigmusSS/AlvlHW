package ua.holovchenko.hw25.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Factory {
    private int id;
    private String name;
    private String country;

    public Factory(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
