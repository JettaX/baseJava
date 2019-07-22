package com.baseJava.lesson_1;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;

    public void save(Resume resume) {
        if (storage.length == size) {
            System.out.println("Нельзя создать резюме так как закончилась память.");
            return;
        }

        if (checkResume(resume) != -1) {
            System.out.println("uuid уж есть");
            return;
        }

        storage[size] = resume;
        System.out.println("Сохранено");
        size++;
    }

    public void update(Resume resume) {
        int i = checkResume(resume);
        if (i == -1) {
            System.out.println("uuid не найден");
        } else {
            storage[i] = resume;
        }
    }

    public Resume get(String uuid) {
        int i = checkResume(uuid);
        if (i == -1) {
            System.out.println("uuid не найден");
            return null;
        } else {
            return storage[i];
        }
    }

    public void delete(String uuid) {
        int i = checkResume(uuid);
        if (i == -1) {
            System.out.println("uuid не найден");
        } else {
            storage[i] = storage[size - 1];
            storage[size] = null;
            size--;
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

    private int checkResume(Object resume) {
        for (int i = 0; i < size; i++) {
            if (resume.toString().equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}