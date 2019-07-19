package com.baseJava.lesson_1;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void save(Resume resume) {
        if (!isStorageFull() || isInStorage(resume)) return;
        storage[size] = resume;
        size++;
    }

    public void update(Resume resume) {
        if (!isInStorage(resume)) return;
        for (int i = 0; i < size; i++) {
            if (resume.toString().equals(storage[i].toString())) {
                storage[i] = resume;
            }
        }
    }

    public Resume get(String uuid) {
        if (!isInStorage(uuid)) return null;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (!isInStorage(uuid)) return;
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

    private boolean isStorageFull() {
        if ((storage.length) == size) {
            System.out.println("Нельзя создать резюме так как закончилась память.");
            return false;
        } else {
            return true;
        }
    }

    private boolean isInStorage(Object resume) {
        for (int i = 0; i < size; i++) {
            if (resume.toString().equals(storage[i].toString())) {
                return true;
            }
        }
        System.out.println("uuid не найден");
        return false;
    }
}
