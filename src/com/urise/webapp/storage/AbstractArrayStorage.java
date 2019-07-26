package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 100000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
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

    protected abstract int findIndex(String uuid);
}
