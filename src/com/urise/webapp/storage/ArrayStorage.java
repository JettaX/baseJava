package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;

    public void save(Resume resume) {
        if (storage.length == size) {
            System.out.println("You can not create a resume as the memory is over");
            return;
        }

        if (findIndex(resume.getUuid()) >= 0) {
            System.out.println("uuid exists");
            return;
        }

        storage[size++] = resume;
    }

    public void update(Resume resume) {
        int indexResume = findIndex(resume.getUuid());
        if (indexResume < 0) {
            System.out.println("uuid not found");
        } else {
            storage[indexResume] = resume;
        }
    }

    public Resume get(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume < 0) {
            System.out.println("uuid not found");
            return null;
        } else {
            return storage[indexResume];
        }
    }

    public void delete(String uuid) {
        int indexResume = findIndex(uuid);
        int numMoved = size - indexResume - 1;
        if (indexResume < 0) {
            System.out.println("uuid not found");
            return;
        } else if (numMoved > 0) {
            storage[indexResume] = storage[size - 1];
        }
        storage[--size] = null;
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

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}