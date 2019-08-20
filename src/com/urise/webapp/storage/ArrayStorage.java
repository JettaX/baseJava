package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int searchKey) {
        storage[size] = resume;
    }

    @Override
    protected void deleteElement(int searchKey) {
        storage[searchKey] = storage[size - 1];
    }

    @Override
    protected Object findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}