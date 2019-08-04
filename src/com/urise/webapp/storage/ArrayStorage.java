package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int indexElement) {
        storage[size] = resume;
    }

    @Override
    protected void deleteElement(int indexElement) {
        int numMoved = size - indexElement - 1;
        if (numMoved > 0) {
            storage[indexElement] = storage[size - 1];
        }
        storage[size] = null;
    }

    @Override
    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}