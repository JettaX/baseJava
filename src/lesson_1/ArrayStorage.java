package lesson_1;

import java.util.Arrays;

public class ArrayStorage {
    private String[] storage = new String[10000];
    private int size;

    public void save(String resume) {
        storage[size] = resume;
        size++;
    }

    public String get(int index) {
        rangeCheck(index);
        return storage[index];
    }

    public void delete(int index) {
        rangeCheck(index);
        storage[index] = null;
        for (; index <= size; index++) {
            storage[index] = storage[index + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public String[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    private void rangeCheck(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Такого резюме нет.");
        }
    }
}
