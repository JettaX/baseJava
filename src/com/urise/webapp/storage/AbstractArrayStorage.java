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
        try {
            int indexResume = doExistedId(resume.getUuid());
            storage[indexResume] = resume;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("uuid not found");
        }
    }

    public Resume get(String uuid) {
        try {
            return storage[doExistedId(uuid)];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("uuid not found");
            return null;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected int doExistedId(String uuid) {
        int searchKey = findIndex(uuid);
        if (searchKey <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return searchKey;
    }

    protected int doNotExistedId(String uuid) {
        int searchKey = findIndex(uuid);
        if (searchKey >= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return searchKey;
    }

    protected abstract int findIndex(String uuid);
}
