package ua.holovchenko.hw15.task3;

import java.util.Objects;

public class Box {
    public Box(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Box{" +
                "volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return volume == box.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume);
    }

    public int getVolume() {
        return volume;
    }


    private final int volume;
}
