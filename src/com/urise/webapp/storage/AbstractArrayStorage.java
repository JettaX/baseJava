package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 100000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
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

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void clear() {
        Arrays.fill(storage,0, size, null);
        size = 0;
    }

    protected abstract int findIndex(String uuid);
}
