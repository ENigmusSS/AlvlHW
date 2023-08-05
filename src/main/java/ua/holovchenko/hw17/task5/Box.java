package ua.holovchenko.hw17.task5;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@EqualsAndHashCode
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Box implements Comparable<Box>{
    private int size;
    private List<Item> itemList;

    @Override
    public int compareTo(@NotNull Box o) {
        return this.size-o.size;
    }

    public boolean isSuitable(int minSizeLimit) {
        return (this.size>=minSizeLimit);
    }
}
