package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    public void save(Resume resume) {
        if (STORAGE_LIMIT == size) {
            System.out.println("You can not create a resume as the memory is over");
            return;
        }

        int key = findIndex(resume.getUuid());
        if (key >= 0) {
            System.out.println("uuid exists");
            return;
        }
        insertElement(resume, key);
        size++;
    }

    @Override
    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("uuid not found");
            return;
        }
        storage[index] = resume;
    }

    @Override
    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("uuid not found");
            return null;
        }
        return storage[index];
    }

    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("uuid not found");
            return;
        }
        deleteElement(index);
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract int findIndex(String uuid);

    protected abstract void insertElement(Resume resume, int indexElement);

    protected abstract void deleteElement(int indexElement);
}
