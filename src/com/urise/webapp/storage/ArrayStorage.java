package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {
        if (STORAGE_LIMIT == size) {
            System.out.println("You can not create a resume as the memory is over");
            return;
        }

        if (findIndex(resume.getUuid()) >= 0) {
            System.out.println("uuid exists");
            return;
        }

        storage[size++] = resume;
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

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}