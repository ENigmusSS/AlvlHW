package ua.holovchenko.hw14.task1;

public class MySet<E> {
    private E[] set;
    private int size;

    public MySet(int initialSize) {
        set = (E[]) new Object[initialSize];
        size = 0;
    }

    public boolean add(E element) {
        if (contains(element)) {
            System.err.println("Already exists in set!");
            return false;
        }

        if (size == set.length) {
            System.err.println("Set is full");
            return false;
        }

        set[size] = element;
        size++;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            System.err.println("Invalid index: " + index);
            return null;
        }
        return set[index];
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (set[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(set[i]).append(", ");
        }
        sb.append(set[size - 1]).append("]");
        return sb.toString();
    }
}
