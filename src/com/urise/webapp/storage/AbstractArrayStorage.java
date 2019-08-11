package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageExeption;
import com.urise.webapp.exeption.NotExistStorageExeption;
import com.urise.webapp.exeption.StorageExeption;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    public void save(Resume resume) {
        if (STORAGE_LIMIT == size) {
            throw new StorageExeption("Storage overflow ", resume.getUuid());
        }

        int key = findIndex(resume.getUuid());
        if (key >= 0) {
            throw new ExistStorageExeption(resume.getUuid());
        }
        insertElement(resume, key);
        size++;
    }

    @Override
    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageExeption(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageExeption(uuid);
        } else {
            return storage[index];
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageExeption(uuid);
        } else {
            deleteElement(index);
            storage[size - 1] = null;
            size--;
        }
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