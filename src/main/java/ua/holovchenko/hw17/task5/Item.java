package ua.holovchenko.hw17.task5;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Item implements Comparable<Item>{
    private String name;
    private int cost;

    @Override
    public int compareTo(@NotNull Item o) {
        return this.cost-o.cost;
    }
}
