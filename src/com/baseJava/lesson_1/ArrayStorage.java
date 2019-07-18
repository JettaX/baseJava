package com.baseJava.lesson_1;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void save(Resume resume) {
        storage[size] = resume;
        size++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i <= size; i++) {
            if (uuid.equals(storage[i].toString())) {
                size--;
                for (; i < size; i++) {
                    storage[i] = storage[i + 1];
                }
            }
        }
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

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
}
